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
    def unitSizeService
    def unitSize
    def unitType
    def amenities

    double lat
    double lng
    def address
    def city
    def state
    def zip

    def index = {
      def queryTerm = params.where;
      def geoResult = geocodeService.geocode(queryTerm)

      handleGeocode(geoResult)
      params.address = address
      params.city = city
      params.state = state
      params.zip = zip

      SearchCriteria criteria = new SearchCriteria();
      criteria.searchType = SearchType.STORAGE;
      criteria.queryMode = QueryMode.FIND_UNITS;
      criteria.geoType = GeoType.CITY;
      criteria.centroid.lat = lat;
      criteria.centroid.lng = lng;
      criteria.city = params.city;
      criteria.state = State.fromText(params.state);
      criteria.searchSize = 0 // Default. Overridden below.

      def sz = getUnitSize(params.unit_size)
      if (sz) {
        unitSize = params.unit_size
        criteria.searchSize = sz.id
      }

      def tp = getUnitType(params.unit_type)
      if (tp) {
        unitType = params.unit_type
        //TODO: Make search criteria aware of unit type!
      }

      def am = getAmenities(params.amenity)
      if (am.size()) {
        amenities = am
        //TODO: Make search criteria aware of amenities
      }

      def searchResult = findClientSites(criteria);

      [queryTerm: queryTerm, clientSites: searchResult.sites, siteMoveInPrice:searchResult.moveInPrices, lat: lat, lng: lng, unitSize: unitSize, unitType: unitType, amenities: amenities]
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
        // TODO: Fix to look up city name using seoCity value of StorageSite table;
        // this will fail if the city name includes any punctuation
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
        [queryTerm: queryTerm, clientSites: searchResult.sites, siteMoveInPrice:searchResult.moveInPrices, lat: lat, lng: lng, unitSize: '', unitType: null, amenities: [:]]
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
                if (unit.unitCount > site.minInventory && criteria.searchSize <= unit.unitsize.id) {
                  availableUnitsMap[unit.id] = unit
                }
            }
            def featuredOffersMap = [:] // maps units to lists of featured special offers
            if (criteria.queryMode == QueryMode.FIND_UNITS && availableUnitsMap.size() == 0) {
              // JM: Don't panic. If the user asks for 10x30 (for example) and one or more of the
              //     sites in their region has no 10x30, then simply remove that site. Tossing an
              //     exception here causes the entire query for all sites to fail.
              //throw new Error("QueryMode.FIND_UNITS but site ${site.id} has no available units!")
              sitesToRemove.add(site)
              continue;
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
            def street_number = ""
            def route = ""
            lng = geoResult.results[0].geometry.location.lng
            lat = geoResult.results[0].geometry.location.lat
            log.info("geocoder says: " + lat + "," + lng);
            for (comp in geoResult.results[0].address_components) {
                switch (comp.types[0]) {
                    case "street_number":
                        street_number = comp.long_name
                        break
                    case "route":
                        route = comp.long_name
                        break
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
            if (street_number && route) {
              address = "${street_number} ${route}"
            }
            // JM: It makes sense to show only street, if the user gives us that
            // it does not make sense to give only address sans street
            else if (route) {
              address = route
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

  def getUnitSize(sz) {
    if (!sz) {
      return null
    }

    def sza = sz.split("x")
    def width = sza[0] as int
    def length = sza[1] as int

    return unitSizeService.getUnitSize(width,length,SearchType.STORAGE)
  }

  def getUnitType (tp) {
    if (!tp) {
      return null
    }

    //  select distinct unit_type from storage_unit where unitsize_id in (
    //    select id from storage_size where search_type like 'STORAGE');
    if (tp == 'interior') return 'INTERIOR'
    if (tp == 'upper') return 'UPPER'
    if (tp == 'drive-up') return 'DRIVEUP'

    return null
  }

  def getAmenities (amenity) {
    if (!amenity) {
      return [:]
    }

    def amen = [:]

    for (a in amenity) {
      amen[a]=true
    }

    return amen
  }

}
