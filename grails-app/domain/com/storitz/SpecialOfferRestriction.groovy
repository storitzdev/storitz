package com.storitz

import storitz.constants.SpecialOfferRestrictionType

class SpecialOfferRestriction {

  SpecialOfferRestrictionType type
  Date startDate
  Date endDate
  BigDecimal minRange
  BigDecimal maxRange
  Boolean restrictive
  Integer sizeType
  String restrictionInfo
  String description
  SpecialOffer specialOffer

  static constraints = {
    startDate(nullable: true)
    endDate(nullable: true)
    minRange(nullable: true)
    maxRange(nullable: true)
    restrictive(nullable: true)
    sizeType(nullable: true)
    restrictionInfo(nullable: true)
    description(nullable: true)
  }
}
