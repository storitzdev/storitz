package com.storitz

import storitz.constants.UnitType

class StorageUnit {

    static belongsTo = StorageSite
  
    static constraints = {
      description(nullable:true)
      startAvail(nullable:true)
      unitName(nullable:true)
      unitNumber(nullable:true)
      taxRate(nullable:true)
    }

    String description
    String unitNumber
    String unitName
    UnitType unitType
    Boolean isSecure
    Boolean isTempControlled
    Boolean isAlarm
    Boolean isPowered
    Date startAvail
    BigDecimal price
    BigDecimal pushRate
    StorageSize unitsize    // used for searching
    String displaySize
    Boolean isAvailable
    Integer unitCount
    BigDecimal taxRate

}
