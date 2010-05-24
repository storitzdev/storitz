import storagetech.constants.TruckType;

class StorageSite {

    static hasMany = [ units:StorageUnit, specialOffers:SpecialOffer, images:SiteImage, users:SiteUser, contacts:SiteContact, insurances:Insurance ]
    static fetchMode = []

    static constraints = {
      description(widget:'textarea', nullable:true)
      logo(nullable:true)
      zipcode(nullable:true)
      phone(nullable:true)
      url(nullable:true)
      source(nullable:true)
      sourceId(nullable:true)
      sourceLoc(nullable:true)
      address2(nullable:true)
      adminFee(nullable:true)
      lockFee(nullable:true)
      freeTruck(nullable:false)
      openWeekday(nullable:true)
      openSaturday(nullable:true)
      openSunday(nullable:true)
      startWeekday(nullable:true)
      endWeekday(nullable:true)
      startSaturday(nullable:true)
      endSaturday(nullable:true)
      startSunday(nullable:true)
      endSunday(nullable:true)
      siteLink(nullable:true)
      centerShift(nullable:true)
    }
  
    String title
    String description
    SiteImage logo
    BigDecimal lat
    BigDecimal lng
    String address
    String address2
    String city
    String state
    String zipcode
    String url
    String phone
    String source             // data source
    String sourceId           // id from data source
    String sourceLoc          // location name

  // site offers
    Boolean requiresInsurance
    Boolean boxesAvailable
    TruckType freeTruck

  // site security
    Boolean isGate
    Boolean isKeypad
    Boolean isCamera
    Boolean isUnitAlarmed

  // Fees
    BigDecimal adminFee
    BigDecimal lockFee

  // Operation Hours
    Boolean openWeekday
    Boolean openSaturday
    Boolean openSunday
    Date startWeekday
    Date endWeekday
    Date startSaturday
    Date endSaturday
    Date startSunday
    Date endSunday

  // data feeds
    SiteLink siteLink
    CenterShift centerShift
    Long lastUpdate

  def users() {
      return users.collect{it.user}
  }


}
