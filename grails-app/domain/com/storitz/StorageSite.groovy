package com.storitz

import storitz.constants.State
import storitz.constants.TransactionType
import storitz.constants.TruckType

class StorageSite {

  static hasMany = [
          units: StorageUnit,
          specialOffers: SpecialOffer,
          images: SiteImage,
          users: SiteUser,
          insurances: Insurance,
          visits: Visit,
          securityItems: Bullet,
          convenienceItems: Bullet,
          amenityItems: Bullet
  ]

  static mapping = {
    units cascade: "all,delete-orphan"
    specialOffers cascade: "all,delete-orphan"
    images cascade: "all,delete-orphan"
    insurances cascade: "all,delete-orphan"
    visits cascade: "all,delete-orphan"
    securityItems cascade: "all,delete-orphan"
    convenienceItems cascade: "all,delete-orphan"
    amenityItems cascade: "all,delete-orphan"
  }

  static fetchMode = []

  static constraints = {
    description(widget: 'textarea', nullable: true, size: 2..2000)
    feed(nullable: true)
    logo(nullable: true)
    zipcode(nullable: true)
    phone(nullable: true)
    url(nullable: true)
    source(nullable: true)
    sourceId(nullable: true)
    sourceLoc(nullable: true)
    address2(nullable: true)
    adminFee(nullable: true)
    lockFee(nullable: true)
    freeTruck(nullable: false)
    openMonday(nullable: true)
    openTuesday(nullable: true)
    openWednesday(nullable: true)
    openThursday(nullable: true)
    openFriday(nullable: true)
    openSaturday(nullable: true)
    openSunday(nullable: true)
    startMonday(nullable: true)
    endMonday(nullable: true)
    startTuesday(nullable: true)
    endTuesday(nullable: true)
    startWednesday(nullable: true)
    endWednesday(nullable: true)
    startThursday(nullable: true)
    endThursday(nullable: true)
    startFriday(nullable: true)
    endFriday(nullable: true)
    startSaturday(nullable: true)
    endSaturday(nullable: true)
    startSunday(nullable: true)
    endSunday(nullable: true)
    startMondayGate(nullable: true)
    endMondayGate(nullable: true)
    startTuesdayGate(nullable: true)
    endTuesdayGate(nullable: true)
    startWednesdayGate(nullable: true)
    endWednesdayGate(nullable: true)
    startThursdayGate(nullable: true)
    endThursdayGate(nullable: true)
    startFridayGate(nullable: true)
    endFridayGate(nullable: true)
    startSaturdayGate(nullable: true)
    endSaturdayGate(nullable: true)
    startSundayGate(nullable: true)
    endSundayGate(nullable: true)
    bankAccount(nullable: true)
    rentalAgreement(nullable: true)
    taxRateRental(nullable: true)
    taxRateInsurance(nullable: true)
    taxRateMerchandise(nullable: true)
    useProrating(nullable: true)
    dateCreated(nullable: true)
    lastChange(nullable: true)
    prorateStart(nullable: true)
    prorateCutoff(nullable: true)
    prorateSecondMonth(nullable: true)
    seoCity(nullable: true)
    isTwentyFourHour(nullable: true)
    //seoTitle(unique:true)
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

  String seoCity
  //String seoTitle
  // Data source -
  //    SL - SiteLink
  //    CS3 - CenterShift 3.x
  //    CS4 - Centershift 4.x
  String source             // data source
  String sourceId           // id from data source
  String sourceLoc          // location name

  // site offers
  Boolean requiresInsurance = false
  Boolean noInsuranceWaiver = false
  Boolean boxesAvailable = true
  TruckType freeTruck

  // site security
  Boolean isGate
  Boolean isKeypad
  Boolean isCamera
  Boolean isUnitAlarmed
  Boolean isManagerOnsite
  Boolean hasElevator
  Boolean isTwentyFourHour

  // Fees
  BigDecimal adminFee = 0
  BigDecimal lockFee = 0
  BigDecimal deposit = 0
  BigDecimal rentalFee = 0

  // Proration cutoff (SiteLink)
  Integer prorateStart = 5
  Integer prorateCutoff = 24
  Boolean prorateSecondMonth = false

  // Operation Hours
  Boolean openMonday
  Boolean openTuesday
  Boolean openWednesday
  Boolean openThursday
  Boolean openFriday
  Boolean openSaturday
  Boolean openSunday
  Date startMonday
  Date endMonday
  Date startTuesday
  Date endTuesday
  Date startWednesday
  Date endWednesday
  Date startThursday
  Date endThursday
  Date startFriday
  Date endFriday
  Date startSaturday
  Date endSaturday
  Date startSunday
  Date endSunday
  Date startMondayGate
  Date endMondayGate
  Date startTuesdayGate
  Date endTuesdayGate
  Date startWednesdayGate
  Date endWednesdayGate
  Date startThursdayGate
  Date endThursdayGate
  Date startFridayGate
  Date endFridayGate
  Date startSaturdayGate
  Date endSaturdayGate
  Date startSundayGate
  Date endSundayGate
  Boolean extendedHours

  BigDecimal taxRateRental
  BigDecimal taxRateInsurance
  BigDecimal taxRateMerchandise
  Boolean useProrating

  TransactionType transactionType

  // data feeds
  Feed feed
  Long lastUpdate
  Boolean disabled = false
  Integer minInventory = 0
  Integer maxReserveDays = 60

  Boolean netCommission = false
  Boolean allowPushPrice = true

  // bank account
  BankAccount bankAccount

  RentalAgreement rentalAgreement

  Date dateCreated
  Date lastChange

  def users() {
    return users.collect {it.user}
  }

  def siteImages() {
    return images.findAll { !it.isLogo }.sort { it.imgOrder }
  }

  def coverImage() {
    def coverImg = images.find { it.isCover }

    if (coverImg) {
      return coverImg
    }
    return siteImages().size() > 0 ? siteImages().getAt(0) : null
  }

  def featuredOffers() {
    return specialOffers.findAll { it.active && it.featured}.sort { it.id }
  }

  def specialOffers() {
    return (specialOffers.findAll { it.active }.sort { it.id } as List)
  }

  def nonFeaturedOffers() {
    return specialOffers.findAll { it.active && !it.featured }.sort { it.id }
  }

  def rentableUnits() {
    return units.collect {it.unitCount}.sum()
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

  def getTextDescription() {
    return description.replaceAll(/<!--.*?-->/, '').replaceAll(/<.*?>/, '')
  }

  def getManager() {
    def siteUser = SiteUser.find("from SiteUser as su where su.site = :site and su.user in (select ur.user from UserRole as ur, Role as r, User as u where ur.user = su.user and u.username != 'admin' and ur.user = u and ur.role = r and r.authority = :authority)", [site: this, authority: 'ROLE_MANAGER'])
    return siteUser?.user
  }

  def beforeInsert = {
    seoCity = StoritzUtil.seoEncode(city);
    //seoTitle = StoritzUtil.seoEncode(title);
  }

  def beforeUpdate = {
    seoCity = StoritzUtil.seoEncode(city);
    //seoTitle = StoritzUtil.seoEncode(title);
  }

//  private void setSeoTitle() { // TODO: Finish this thing (needs to work for both insert and update cases, needs to check that "twin" isn't self
//    String title = StoritzUtil.seoEncode(title);
//    int twins = StorageSite.countBySeoTitle(title);
//    if (twins > 0) {
//      for (int i = twins; i < 10; i++) {
//          title = StoritzUtil.seoEncode(title + "-" + i);
//          if (StorageSite.countBySeoTitle(title) == 0) {
//              break;
//          }
//      }
//      title = StoritzUtil.seoEncode(title + "-" + zipcode);
//    }
//    seoTitle = title;
//  }
}
