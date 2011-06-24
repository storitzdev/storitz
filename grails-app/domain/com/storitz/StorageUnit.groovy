package com.storitz

import storitz.constants.UnitType

class StorageUnit {

  static belongsTo = StorageSite

  static constraints = {
    description(nullable: true)
    startAvail(nullable: true)
    unitName(nullable: true)
    unitNumber(nullable: true)
    taxRate(nullable: true)
    unitInfo(nullable: true)
    totalUnits(nullable: true)
    deposit(nullable: true)
    dateCreated(nullable:true)
    lastUpdated(nullable: true)
    bestUnitPrice(nullable: true)
  }

  String description
  String unitNumber
  String unitName
  UnitType unitType
  Boolean isSecure
  Boolean isTempControlled
  Boolean isAlarm
  Boolean isPowered
  Boolean isIrregular
  Date startAvail
  BigDecimal price
  BigDecimal pushRate
  BigDecimal bestUnitPrice // price or pushRate. Used for finding BestUnit *only*
  StorageSize unitsize     // used for searching
  String displaySize
  Boolean isAvailable
  Integer unitCount
  Integer totalUnits
  BigDecimal taxRate
  BigDecimal deposit
  String unitInfo   // centershift original size
  String unitSizeInfo // used by special offer filter
  String unitTypeInfo // used by special offer filter
  Date dateCreated
  Date lastUpdated
}
