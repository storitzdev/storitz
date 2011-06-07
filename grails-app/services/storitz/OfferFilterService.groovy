package storitz

import com.storitz.SpecialOffer
import com.storitz.StorageSite
import com.storitz.StorageUnit
import storitz.constants.FeedType
import storitz.constants.SpecialOfferRestrictionType

class OfferFilterService {

  static transactional = false

  def getValidUnitsForOffer(StorageSite site, SpecialOffer offer) {
      def units = []
      def candidate_offers = []
      site.units.each { unit ->
          candidate_offers << offer
          filterOffer([offer], site, unit)
          if (candidate_offers.size()) {
              units << unit
          }
          candidate_offers.clear()
      }
      units
  }
  def getValidOffers(StorageSite site, StorageUnit unit) {
    List results = site.specialOffers()
    filterOffer(results, site, unit)
    return results
  }

  def getValidFeaturedOffers(StorageSite site, StorageUnit unit) {
    List results = site.featuredOffers()
    filterOffer(results, site, unit)
    return results
  }

  def getValidNonFeaturedOffers(StorageSite site, StorageUnit unit) {
    List results = site.nonFeaturedOffers()
    filterOffer(results, site, unit)
    return results
  }

  public filterOffer(List results, StorageSite site, StorageUnit unit) {
    for (Iterator iter = results.iterator(); iter.hasNext();) {
      SpecialOffer offer = iter.next();
      boolean valid = false
      int n = offer.restrictions.size(); // .size() selects all rows from special_offer_special_offer_restriction join table (1 query)
      if (n > 0) {
        // .findAll() selects all rows, one at a time, from special_offer_restriction join table (n queries)
        def validUnitType = (offer.restrictions.findAll {it.type == SpecialOfferRestrictionType.UNIT_TYPE}.size() == 0)
        def validUnitSize = (offer.restrictions.findAll {it.type == SpecialOfferRestrictionType.UNIT_SIZE}.size() == 0)
        def validOccupancyRate = (offer.restrictions.findAll {it.type == SpecialOfferRestrictionType.OCCUPANCY_RATE}.size() == 0)
        def validMinimumAvailable = (offer.restrictions.findAll {it.type == SpecialOfferRestrictionType.MINIMUM_AVAILABLE}.size() == 0)
        def validUnitArea = (offer.restrictions.findAll {it.type == SpecialOfferRestrictionType.UNIT_AREA}.size() == 0)
        //println "In offer filter validUnitType=${validUnitType}, validUnitSize=${validUnitSize}, validOccupancyRate=${validOccupancyRate}, validMinimumAvailable=${validMinimumAvailable}"
        for (restriction in offer.restrictions) {
          switch (restriction.type) {
            case SpecialOfferRestrictionType.UNIT_TYPE:
              //println "UnitType filter ${unit.unitTypeInfo} restriction ${restriction.restrictionInfo}"
              if (unit.unitTypeInfo == restriction.restrictionInfo) {
                validUnitType = true
              }
              break
            case SpecialOfferRestrictionType.UNIT_SIZE:
              //println "UnitSize filter ${unit.unitSizeInfo} restriction ${restriction.restrictionInfo}"
              if (unit.unitSizeInfo == restriction.restrictionInfo) {
                validUnitSize = true
              }
              break
            case SpecialOfferRestrictionType.OCCUPANCY_RATE:
              def unitCount = unit.unitCount
              if (site.feed.feedType == FeedType.SITELINK) {
                unitCount = site.units.findAll { it.unitTypeInfo == unit.unitTypeInfo}.size()
              }
              BigDecimal currentRate = ((unitCount * 100) / unit.totalUnits)
              //println "Occupancy rate filter ${restriction.minRange} <= ${currentRate} <= ${restriction.maxRange}"
              if (restriction.minRange <= currentRate && currentRate <= restriction.maxRange) {
                validOccupancyRate = true
              }
              break
            case SpecialOfferRestrictionType.MINIMUM_AVAILABLE:
              def unitCount = unit.unitCount
              if (site.feed.feedType == FeedType.SITELINK) {
                unitCount = site.units.findAll { it.unitTypeInfo == unit.unitTypeInfo}.size()
              }
              //println "Minimum available filter ${restriction.minRange} <= ${unitCount} <= ${restriction.maxRange}"
              if (restriction.minRange <= unitCount && unitCount <= restriction.maxRange) {
                validMinimumAvailable = true
              }
              break
            case SpecialOfferRestrictionType.UNIT_AREA:
              def sm = unit.displaySize =~ /(\d+?)\s*X\s*(\d+)/
              if (sm.getCount()) {
                BigDecimal width = sm[0][1] as BigDecimal
                BigDecimal length = sm[0][2] as BigDecimal
                BigDecimal area = width * length
                if (restriction.minRange <= area && area <= restriction.maxRange) {
                  validUnitArea = true
                }
              }
              break
          }
        }
        //println "Leaving filter validUnitType=${validUnitType}, validUnitSize=${validUnitSize}, validOccupancyRate=${validOccupancyRate}, validMinimumAvailable=${validMinimumAvailable}"
        if (!(validUnitType && validUnitSize && validOccupancyRate && validMinimumAvailable && validUnitArea)) {
          //println "Special Offer ${offer.promoName} removed"
          iter.remove()
        }
      }
    }
  }
}
