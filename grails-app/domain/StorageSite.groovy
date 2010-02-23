
class StorageSite {

    static hasMany = [ units:StorageUnit, specialOffers:SpecialOffer, images:SiteImage, users:SiteUser, contacts:SiteContact ]
    static fetchMode = [units:'eager',specialOffers:'eager']

    static constraints = {
      description(nullable:true)
      logoUrl(nullable:true)
      zipcode(nullable:true)
      phone(nullable:true)
      url(nullable:true)
      source(nullable:true)
      sourceId(nullable:true)
    }
  
    String title
    String description
    String logoUrl
    BigDecimal lat
    BigDecimal lng
    String address
    String city
    String state
    String zipcode
    String url
    String phone
    String source             // data source
    String sourceId           // id from data source

  // site offers
    Boolean requiresInsurance
    Boolean boxesAvailable
    Boolean freeTruck

  // site security
    Boolean isGate
    Boolean isKeypad
    Boolean isCamera
    Boolean isUnitAlarmed

  def users() {
      return users.collect{it.user}
  }


}
