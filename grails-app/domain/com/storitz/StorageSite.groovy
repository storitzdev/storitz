package com.storitz

import storitz.constants.TruckType
import java.util.regex.Pattern

class StorageSite {

    static hasMany = [ units:StorageUnit, specialOffers:SpecialOffer, images:SiteImage, users:SiteUser, contacts:SiteContact, insurances:Insurance, visits:Visit ]
    static fetchMode = []

    static constraints = {
      description(widget:'textarea', nullable:true, size:2..2000, markup:true)
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
      bankAccount(nullable:true)
      rentalAgreement(nullable:true)
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
    def imgs = images.findAll{ it.isCover }

    if (imgs.size() > 0) return imgs[0]
    else return siteImages().getAt(0)
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

  def getFullAddress() {
    return "${address}, ${city}, ${state} ${zipcode}"
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
