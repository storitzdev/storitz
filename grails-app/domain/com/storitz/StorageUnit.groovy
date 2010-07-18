package com.storitz
class StorageUnit {

    static belongsTo = StorageSite
  
    static constraints = {
      description(nullable:true)
      startAvail(nullable:true)
    }

    String description
    String unitNumber
    Boolean isUpper
    Boolean isDriveup
    Boolean isInterior
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

    public String getUnitType() {
      if (isUpper) return "Upper"
      if (isDriveup) return "Drive up"
      if (isInterior) return "Interior"
      return "Unknown"
    }

    public void setUnitType(newType) {
      if (newType == "Upper") {
        isUpper = true
      } else if (newType == "Interior") {
        isInterior = true
      } else if (newType == "Driveup" || newType == "Drive up") {
        isDriveup = true
      }
    }
}
