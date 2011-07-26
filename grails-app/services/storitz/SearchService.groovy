package storitz

import com.storitz.StorageSite
import com.storitz.StorageUnit
import com.storitz.Insurance
import storitz.constants.TruckType
import storitz.constants.QueryMode
import com.storitz.StoritzUtil
import storitz.constants.SearchType

class SearchService {

    def mapService
    def costService
    def offerFilterService
    def unitSizeService

  static transactional = true

  // reverse boolean logic...
  // returns TRUE if the site/unit in question FAILS to have the required amenities
  def doesNotHaveRequiredAmenities (StorageSite site, StorageUnit unit, HashMap<String,Boolean> amenities) {
    def cc    = amenities.get("cc")
    def hr24  = amenities.get("24hr")
    def alarm = amenities.get("alarm")
    def truck = amenities.get("truck")

    if (cc && !unit.isTempControlled) return true
    if (hr24 && !site.isTwentyFourHour) return true
    if (alarm && !unit.isAlarm) return true
    if (truck && !(site.freeTruck == TruckType.FREE)) return true

    return false
  }

  def getAmenities (amenity) {
    if (!amenity) {
      return [:]
    }

    def amen = [:]

    if (amenity instanceof String) {
      amenity = [amenity]
    }

    for (a in amenity) {
      amen[a]=true
    }

    return amen
  }

  def getUnitType (tp) {
    if (!tp) {
      return null
    }

    //  select distinct unit_type from storage_unit where unitsize_id in (
    //     select id from storage_size where search_type like 'STORAGE');
    if (tp == 'interior')  return storitz.constants.UnitType.getEnumFromId("INTERIOR")
    if (tp == 'upper')     return storitz.constants.UnitType.getEnumFromId("UPPER")
    if (tp == 'drive-up')  return storitz.constants.UnitType.getEnumFromId("DRIVEUP")

    return null
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
    def sites = mapService.getSites(criteria).sort { mapService.calcDistance(criteria.centroid.lat, it.lat, criteria.centroid.lng, it.lng)} as List
    def checkpoint2 = System.currentTimeMillis();
    log.info("mapService.getSites completed: " + (checkpoint2 - checkpoint1));
    checkpoint1 = checkpoint2;

    def moveInPrices = [:]
    def sitesToRemove = []
    Date moveInDate = new Date()

    if (criteria.unitType || criteria.searchSize || criteria.amenities) {
      criteria.queryMode = QueryMode.FIND_UNITS
    }

    // TODO: collect result statistics (# found, avg distance, min/max price, etc) to be reported to GA, pass to
    // view (somehow), so browser can send to GA as CustomVars
    for (site in sites) {
      log.info("processing site " + site.id)
      def availableUnitsMap = [:] // using a map because I don't know how to use a set, and I don't want to do linear search thru an ArrayList

      for (unit in site.units) {
        // filter here
        if (unit.unitCount < site.minInventory) continue;
        if (criteria.searchSize > unit.unitsize.id) continue
        if (criteria.unitType && criteria.unitType != unit.unitType) continue
        if (doesNotHaveRequiredAmenities(site,unit,criteria.amenities)) continue

        // whatever gets through is good
        availableUnitsMap[unit.id] = unit
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
      def bestUnit = unitList.min { it.bestUnitPrice }
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
          moveInPrices[site.id] = [cost: totals['moveInTotal'], promo: null, promoName: null, bestUnit: bestUnit, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
        } else {
          def totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
          moveInPrices[site.id] = [cost: totals['moveInTotal'], promo: null, promoName: null, bestUnit: bestUnit, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
          def oldMoveInCost = moveInPrices[site.id].cost
          moveInPrices[site.id].cost = StoritzUtil.BOGUS_MOVE_IN_COST
          for (promo in promos) {
            if (!(promo.promoName ==~ /(?i).*(military|senior).*/)) {
              totals = costService.calculateTotals(site, bestUnit, promo, ins, moveInDate)
              if (moveInPrices[site.id].cost > totals['moveInTotal']) {
                moveInPrices[site.id] = [cost: totals['moveInTotal'], promo: promo.id, promoName: promo.promoName, bestUnit: bestUnit, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
              }
            }
          }
          if (moveInPrices[site.id].cost == StoritzUtil.BOGUS_MOVE_IN_COST) {
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

  boolean handleGeocode(servletContext,request,geoResult, out) {
      if (geoResult && geoResult.status == "OK") {
          def street_number = ""
          def route = ""
          out['lng'] = geoResult.results[0].geometry.location.lng
          out['lat'] = geoResult.results[0].geometry.location.lat
          log.info("geocoder says: " + out['lat'] + "," + out['lng']);
          for (comp in geoResult.results[0].address_components) {
              switch (comp.types[0]) {
                  case "street_number":
                      street_number = comp.long_name
                      break
                  case "route":
                      route = comp.long_name
                      break
                  case "locality":
                      out['city'] = comp.long_name
                      break
                  case "administrative_area_level_1":
                      out['state'] = comp.short_name
                      break
                  case "postal_code":
                      out['zip'] = comp.long_name
                      break
              }
          }
          if (street_number && route) {
            out['address'] = "${street_number} ${route}"
          }
          // JM: It makes sense to show only street, if the user gives us that
          // it does not make sense to give only address sans street
          else if (route) {
            out['address'] = route
          }
          return true
      } else {
          def loc = mapService.getGeoIp(servletContext, request)
          if (loc) {
            out['lat'] = loc.latitude
            out['lng'] = loc.longitude
            out['zip'] = loc.postalCode
            //what was the rationale for not updating city and state too?
            //if (!city) city = loc.city
            //if (!state) state = loc.region
            out['city'] = loc.city
            out['state'] = loc.region
          }
        return false
      }
  }


}
