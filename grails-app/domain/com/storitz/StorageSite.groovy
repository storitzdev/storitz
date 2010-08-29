package com.storitz

import storitz.constants.TruckType
import storitz.constants.State

class StorageSite {

    static hasMany = [
            units:StorageUnit,
            specialOffers:SpecialOffer,
            images:SiteImage,
            users:SiteUser,
            insurances:Insurance,
            visits:Visit,
            securityItems: Bullet,
            convenienceItems: Bullet,
            amenityItems: Bullet
    ]
  
    static mapping = {
      units cascade:"all,delete-orphan"
      specialOffers cascade:"all,delete-orphan"
      images cascade:"all,delete-orphan"
      insurances cascade:"all,delete-orphan"
      visits cascade:"all,delete-orphan"
      securityItems cascade:"all,delete-orphan"
      convenienceItems cascade:"all,delete-orphan"
      amenityItems cascade:"all,delete-orphan"
    }

    static fetchMode = []

    static constraints = {
      description(widget:'textarea', nullable:true, size:2..2000)
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
      startGate(nullable:true)
      endGate(nullable:true)
      startSundayGate(nullable:true)
      endSundayGate(nullable:true)
      siteLink(nullable:true)
      centerShift(nullable:true)
      bankAccount(nullable:true)
      rentalAgreement(nullable:true)
      taxRateRental(nullable:true)
      taxRateInsurance(nullable:true)
    }
  
    String title
    String description
    SiteImage logo
    BigDecimal lat
    BigDecimal lng
    String address
    String address2
    String city
    State state
    String zipcode
    String url
    String phone
    // Data source -
    //    SL - SiteLink
    //    CS3 - CenterShift 3.x
    //    CS4 - Centershift 4.x
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
    Boolean isManagerOnsite
    Boolean hasElevator

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
    Date startGate
    Date endGate
    Date startSundayGate
    Date endSundayGate
    Boolean extendedHours

    BigDecimal taxRateRental
    BigDecimal taxRateInsurance

  // data feeds
    SiteLink siteLink
    CenterShift centerShift
    Long lastUpdate

  // bank account
    BankAccount bankAccount

    RentalAgreement rentalAgreement

  def users() {
      return users.collect{it.user}
  }

  def siteImages() {
    return images.findAll{ !it.isLogo }.sort{ it.imgOrder }
  }

  def coverImage() {
    def coverImg = images.find{ it.isCover }

    if (coverImg) {
      return coverImg
    }
    return siteImages().size() > 0 ? siteImages().getAt(0) : null
  }

  def featuredOffers() {
    return specialOffers.findAll{ it.active && it.featured}.sort{ it.id }
  }

  def specialOffers() {
    return specialOffers.findAll{ it.active }.sort{ it.id }
  }

  def nonFeaturedOffers() {
    return specialOffers.findAll{ it.active && !it.featured }.sort{ it.id }
  }

  def rentableUnits() {
    return units.collect{it.unitCount}.sum()
  }

  def getFullAddress() {
    return "${address}${address2 ? ' ' + address2 : ''}, ${city}, ${state.display} ${zipcode}"
  }

  def getSiteTitle() {

    // TODO: Replace the regex in home/index.gsp with a value provided by the JSON response (STMap.jsonp).
    // The current version doesn't deal with regex specials in the city name and there are too many cross-browser
    // variations in regex to trust an escape routine coded here.
    // Plus we don't want to allow for deviation between server and client sides.

    // This should match what is in home/index.gsp and really that should get this value via JSON.
    return title.replaceFirst(/(?i) ?[-\/]? ?${city} ?[-\/]? ?/, '')
  }

  def getStateName() {
    return stateNamesByCode[state] ?: state
  }

  def getManager() {
    def siteUser = SiteUser.find("from SiteUser as su where su.site = :site and su.user in (select ur.user from UserRole as ur, Role as r, User as u where ur.user = su.user and u.username != 'admin' and ur.user = u and ur.role = r and r.authority = :authority)", [site: this, authority: 'ROLE_MANAGER'])
    return siteUser?.user
  }

  // All of the official USPS 2-letter state (and territory) codes.
  static def stateNamesByCode = [
          AL:"Alabama",
          AK:"Alaska",
          AZ:"Arizona",
          AR:"Arkansas",
          CA:"California",
          CO:"Colorado",
          CT:"Connecticut",
          DE:"Delaware",
          DC:"District of Columbia",
          FL:"Florida",
          GA:"Georgia",
          HI:"Hawaii",
          ID:"Idaho",
          IL:"Illinois",
          IN:"Indiana",
          IA:"Iowa",
          KS:"Kansas",
          KY:"Kentucky",
          LA:"Louisiana",
          ME:"Maine",
          MD:"Maryland",
          MA:"Massachusetts",
          MI:"Michigan",
          MN:"Minnesota",
          MS:"Mississippi",
          MO:"Missouri",
          MT:"Montana",
          NE:"Nebraska",
          NV:"Nevada",
          NH:"New Hampshire",
          NJ:"New Jersey",
          NM:"New Mexico",
          NY:"New York",
          NC:"North Carolina",
          ND:"North Dakota",
          OH:"Ohio",
          OK:"Oklahoma",
          OR:"Oregon",
          PA:"Pennsylvania",
          RI:"Rhode Island",
          SC:"South Carolina",
          SD:"South Dakota",
          TN:"Tennessee",
          TX:"Texas",
          UT:"Utah",
          VT:"Vermont",
          VA:"Virginia",
          WA:"Washington",
          WV:"West Virginia",
          WI:"Wisconsin",
          WY:"Wyoming",
          AS:"American Samoa",
          GU:"Guam",
          MP:"Northern Mariana Islands",
          PR:"Puerto Rico",
          VI:"Virgin Islands",
          FM:"Federated States of Micronesia",
          MH:"Marshall Islands",
          PW:"Palau",
  ]

}
