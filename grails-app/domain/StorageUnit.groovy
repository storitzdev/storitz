class StorageUnit {

    static belongsTo = [ site: StorageSite]
  
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
    StorageSize unitsize
    Boolean isAvailable
}
