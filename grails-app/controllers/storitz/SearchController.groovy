package storitz

import storitz.constants.TopMetro
import com.storitz.GeoLookup
import storitz.constants.SearchType
import com.storitz.Insurance

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
        def aMetro = TopMetro.fromText(params.metro)
        def geoLookup = GeoLookup.findByCityAndState(aMetro.city, aMetro.stateCode)
        if (geoLookup) {
            city = geoLookup.city
            state = geoLookup.state
            zip = geoLookup.zip
            lat = geoLookup.lat
            lng = geoLookup.lng

        } else {
            def geoResult = geocodeService.geocode("${city}, ${state}")
            if (handleGeocode(geoResult)) {
                new GeoLookup(lat: lat, lng: lng, city: city, state: state, zip: zip).save(flush: true)
            }
        }
        def searchResult = findClientSites(SearchType.STORAGE, lat, lng)

        [aMetro:aMetro, clientSites:searchResult.sites, siteMoveInPrice:searchResult.moveInPrices, lat: lat, lng: lng]
    }

    def findClientSites(SearchType searchType, double lat, double lng) {
        // optimize zoom level
        Long searchSize = 1
        def zoom = mapService.optimizeZoom(searchSize, searchType, lat, lng, 617, 284)
        def dim = mapService.getDimensions(zoom, lat, lng, 617, 284)
        def sites = mapService.getSites(searchSize, searchType, dim.swLat, dim.swLng, dim.neLat, dim.neLng).sort { mapService.calcDistance(lat, it.lat, lng, it.lng)} as List

        def moveInPrices = [:]
        def sitesToRemove = []
        Date moveInDate = new Date()

        // TODO: collect result statistics (# found, avg distance, min/max price, etc) to be reported to GA, pass to view (somehow), so browser can send to GA as CustomVars
        for (site in sites) {
            Insurance ins = null
            if (site.noInsuranceWaiver) {
                ins = site.insurances.findAll { it.active }.min { it.premium }
            }
            def availableUnitsMap = [:] // using a map because I don't know how to use a set, and I don't want to do linear search thru an ArrayList
            site.units.findAll { it.unitCount > site.minInventory }.each { unit ->
                availableUnitsMap[unit.id] = unit
            }
            // find all college specials for the facility; then find all available units that are valid for the special
            def collegeOffersMap = [:] // maps units to lists of special offers
            if (availableUnitsMap.size()) { // premature optimization: don't bother looking for specials if the site has no inventory
                def collegeOffers = site.specialOffers().findAll { it.tags.any { it.tag.equals("college_special_2011") } }
                for (offer in collegeOffers) {
                    for (validUnit in offerFilterService.getValidUnitsForOffer(site, offer)) { // we may find many units that are valid for the offer
                        if (availableUnitsMap.getAt(validUnit.id)) {
                            if (!collegeOffersMap.getAt(validUnit)) {
                                collegeOffersMap[validUnit] = []
                            }
                            collegeOffersMap[validUnit] << offer
                        }
                    }
                }
            }
            else {
                // TODO: Emit warnings here?
            }

            // if we found any units to which college specials are valid, select the "best unit" from those
            def collegeUnits = collegeOffersMap.keySet()
            log.info("${site.title} - found ${collegeUnits.size()} units with college specials")
            def unitList = collegeUnits.size() ? collegeUnits : availableUnitsMap.values();
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

                // if there's a college special available for the unit, use it
                def featuredOffers = collegeOffersMap.getAt(bestUnit)
                if (!featuredOffers) {
                    featuredOffers = offerFilterService.getValidFeaturedOffers(site, bestUnit)
                }
                if (featuredOffers.size() == 0) {
                    def totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
                    moveInPrices[site.id] = [cost: totals['moveInTotal'], promo: null, promoName: null, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
                } else {
                    def totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
                    moveInPrices[site.id] = [cost: totals['moveInTotal'], promo: null, promoName: null, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
                    def oldMoveInCost = moveInPrices[site.id].cost
                    moveInPrices[site.id].cost = 100000
                    for (promo in featuredOffers) {
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
            } else {
                sitesToRemove << site
            }
            sitesToRemove.each { s -> sites.remove(s) }
        }
        return [sites:sites, moveInPrices:moveInPrices]
    }

    boolean handleGeocode(geoResult) {
        if (geoResult && geoResult.status == "OK") {
            lng = geoResult.results[0].geometry.location.lng
            lat = geoResult.results[0].geometry.location.lat
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
