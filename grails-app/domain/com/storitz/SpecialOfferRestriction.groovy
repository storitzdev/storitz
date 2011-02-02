package com.storitz

import storitz.constants.SpecialOfferRestrictionType

class SpecialOfferRestriction {

    static belongsTo = SpecialOffer

    SpecialOfferRestrictionType type
    Date startDate
    Date endDate
    Integer occupancyPercentage
    Integer occupancyUnits
    Integer sizeType
    String restrictionInfo
    String description

    static constraints = {
      startDate(nullable:true)
      endDate(nullable:true)
      occupancyPercentage(nullable:true)
      occupancyUnits(nullable:true)
      sizeType(nullable:true)
      restrictionInfo(nullable:true)
      description(nullable:true)
    }
}
