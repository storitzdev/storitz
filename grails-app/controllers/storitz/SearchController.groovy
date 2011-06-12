package storitz

import storitz.constants.TopMetro;
import storitz.constants.State;
import com.storitz.GeoLookup;
import storitz.constants.SearchType;
import com.storitz.Insurance;
import storitz.constants.QueryMode
import storitz.constants.GeoType
import com.storitz.StoritzUtil;

class SearchController {

    def mapService
    def geocodeService
    def costService
    def offerFilterService

    double lat
    double lng
    def zip
    def city
    def state

    def index = {
    }

    def metro = {
        def aMetro =TopMetro.fromText(params.city + "-" + params.state) // TODO: string-mangling is artifact of when we just passed in params.metro. finish refactoring TopMetro interface to match new 2-param style.
        def queryTerm;
        if (aMetro != null) {
          queryTerm = "${aMetro.city}, ${aMetro.stateCode}"
        }
        else {
          queryTerm = StoritzUtil.titleize(params.city) + ", " + params.state;
        }
        def seoDecodedCity = params.city.replaceAll("-", " ").toLowerCase();
        def geoLookup = GeoLookup.findByCityAndState(seoDecodedCity, params.state)
        if (geoLookup) {
            city = geoLookup.city
            state = geoLookup.state
            zip = geoLookup.zip
            lat = geoLookup.lat
            lng = geoLookup.lng

        } else {
            def geoResult = geocodeService.geocode("${seoDecodedCity}, ${params.state}")
            if (handleGeocode(geoResult)) {
                new GeoLookup(lat: lat, lng: lng, city: city, state: state, zip: zip).save(flush: true)
            }
        }
        SearchCriteria criteria = new SearchCriteria();
        criteria.searchType = SearchType.STORAGE;
        criteria.queryMode = QueryMode.FIND_SITES;
        criteria.geoType = GeoType.CITY;
        criteria.centroid.lat = lat;
        criteria.centroid.lng = lng;
        criteria.city = seoDecodedCity;
        criteria.state = State.fromText(params.state);
        def searchResult = findClientSites(criteria);
        [queryTerm: queryTerm, clientSites: searchResult.sites, siteMoveInPrice:searchResult.moveInPrices, lat: lat, lng: lng]
    }

    def results = {
        render template:"results", contentType: "text/html", model:[queryTerm:"blank", clientSites:[]]
    }

    /**
     * Finds all sites that provide the specified type of product (STORAGE or PARKING) near lat/lng; prefers
     * offers matching `featuredOfferTag` when selecting special offers. Note that passing in a tag may change the
     * list of available units, because some units featured be available, but not combineable with the featured offer.
     * If _no_ units are combineable with the preferred offer, we return the lowest-rent unit, and find the best
     * available offer for that unit. By default, returns sites with at least 1 unit available. To see all sites,
     * set the value of criteria.queryMode to FIND_SITES.
     *
     * @param criteria
     * @returnMap containing the list of sites, plus another map identifying the "best available unit" for the site
     */
    def findClientSites(SearchCriteria criteria) {
        // optimize zoom level

        def checkpoint1 = System.currentTimeMillis();
        def start = System.currentTimeMillis();
        def sites = mapService.getSites(criteria).sort { mapService.calcDistance(lat, it.lat, lng, it.lng)} as List
        def checkpoint2 = System.currentTimeMillis();
        log.info("mapService.getSites completed: " + (checkpoint2 - checkpoint1));
        checkpoint1 = checkpoint2;

        def moveInPrices = [:]
        def sitesToRemove = []
        Date moveInDate = new Date()

        // TODO: collect result statistics (# found, avg distance, min/max price, etc) to be reported to GA, pass to
        // view (somehow), so browser can send to GA as CustomVars
        for (site in sites) {
            log.info("processing site " + site.id)
            def availableUnitsMap = [:] // using a map because I don't know how to use a set, and I don't want to do linear search thru an ArrayList
            site.units.each { unit ->
                availableUnitsMap[unit.id] = unit
            }
            def featuredOffersMap = [:] // maps units to lists of featured special offers
            if (criteria.queryMode == QueryMode.FIND_UNITS && availableUnitsMap.size() == 0) {
              throw new Error("QueryMode.FIND_UNITS but site ${site.id} has no available units!")
            }
            if (criteria.featuredOfferTag != null) {
                // Find all featured specials for the facility; then find all available units that are
                // valid for any of the featured specials.  Store result in a map that ties units
                // to the list of featured offers that can be applied to them; we will select one of
                // the offers in the for(promo in featuredOffers) loop below.
                def featuredOffers = site.specialOffers().findAll { it.tags.any { it.tag.equals(criteria.featuredOfferTag) } }
                for (offer in featuredOffers) {
                    for (validUnit in offerFilterService.getValidUnitsForOffer(site, offer)) {
                        if (availableUnitsMap.getAt(validUnit.id)) {
                            if (!featuredOffersMap.getAt(validUnit)) {
                                featuredOffersMap[validUnit] = []
                            }
                            featuredOffersMap[validUnit] << offer
                        }
                    }
                }
                checkpoint2 = System.currentTimeMillis();
                log.info("featuredOfferTag retrieval completed: " + (checkpoint2 - checkpoint1));
                checkpoint1 = checkpoint2;
            }
            def featuredUnits = featuredOffersMap.keySet()
            if (criteria.featuredOfferTag != null) {
                log.info("${site.title} - found ${featuredUnits.size()} units with " + criteria.featuredOfferTag + " specials");
            }
            // if we found any available units for which featured special offers are valid, then select the "best unit"
            // from those; if not, then select the best unit from the full list of available units
            def unitList = featuredUnits.size() ? featuredUnits : availableUnitsMap.values();
            def bestUnit = unitList.min { site.allowPushPrice ? it.pushRate : it.price }
            if (bestUnit) {
                def yourPrice = null
                def listPrice = null
                log.info("${site.title} - allowPushPrice: ${site.allowPushPrice} (bestUnit -  pushRate: ${bestUnit.pushRate} bestUnit listPrice: ${bestUnit.price})")

                if (site.allowPushPrice) {
                    yourPrice = bestUnit.pushRate
                    if (bestUnit.pushRate < bestUnit.price) {
                        listPrice = bestUnit.price
                    }
                }
                else {
                    yourPrice = bestUnit.price
                }

                // if there's a featured special offer available for the unit, use it
                def promos = featuredOffersMap.getAt(bestUnit)
                if (!promos) {
                    promos = offerFilterService.getValidFeaturedOffers(site, bestUnit)
                }
                Insurance ins = null
                if (site.noInsuranceWaiver) {
                    ins = site.insurances.findAll { it.active }.min { it.premium }
                }
                if (promos.size() == 0) {
                    def totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
                    moveInPrices[site.id] = [cost: totals['moveInTotal'], promo: null, promoName: null, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
                } else {
                    def totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
                    moveInPrices[site.id] = [cost: totals['moveInTotal'], promo: null, promoName: null, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
                    def oldMoveInCost = moveInPrices[site.id].cost
                    moveInPrices[site.id].cost = 100000
                    for (promo in promos) {
                        if (!(promo.promoName ==~ /(?i).*(military|senior).*/)) {
                            totals = costService.calculateTotals(site, bestUnit, promo, ins, moveInDate)
                            if (moveInPrices[site.id].cost > totals['moveInTotal']) {
                                moveInPrices[site.id] = [cost: totals['moveInTotal'], promo: promo.id, promoName: promo.promoName, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
                            }
                        }
                    }
                    if (moveInPrices[site.id].cost == 100000) {
                        moveInPrices[site.id].cost = oldMoveInCost
                    }
                }
            }
            else {
                moveInPrices[site.id] = null;
            }
            checkpoint2 = System.currentTimeMillis();
            log.info("Best unit calcs completed: " + (checkpoint2 - checkpoint1));
            checkpoint1 = checkpoint2;
        }
        sitesToRemove.each { s -> sites.remove(s) }
        log.info("findClientSites completed: " + (System.currentTimeMillis() - start));
        return [sites: sites, moveInPrices: moveInPrices]
    }

    boolean handleGeocode(geoResult) {
        if (geoResult && geoResult.status == "OK") {
            lng = geoResult.results[0].geometry.location.lng
            lat = geoResult.results[0].geometry.location.lat
            log.info("geocoder says: " + lat + "," + lng);
            for (comp in geoResult.results[0].address_components) {
                switch (comp.types[0]) {
                    case "locality":
                        city = comp.long_name
                        break
                    case "administrative_area_level_1":
                        state = comp.short_name
                        break
                    case "postal_code":
                        zip = comp.long_name
                        break
                }
            }
            return true
        } else {
            def loc = mapService.getGeoIp(servletContext, request)

            lat = loc.latitude
            lng = loc.longitude
            zip = loc.postalCode
            //what was the rationale for not updating city and state too?
            //if (!city) city = loc.city
            //if (!state) state = loc.region
            city = loc.city
            state = loc.region
        }
        return false
    }

}
