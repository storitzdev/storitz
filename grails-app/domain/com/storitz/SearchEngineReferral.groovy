package com.storitz

import storitz.constants.ReferrerType

class SearchEngineReferral {

  String sem_id
  String ts_code
  String match_type
  Integer location_id
  String ad_id
  String keyword
  Boolean isPaid
  ReferrerType referrer
  String referrerUrl

  Date landingDate
  Date bookingDate
  BigDecimal commission

  static constraints = {
    location_id(nullable: true)
    sem_id(nullable: true)
    match_type(nullable: true)
    ts_code(nullable: true)
    ad_id(nullable: true)
    commission(nullable: true)
    bookingDate(nullable: true)
    referrerUrl(nullable: true)
    referrer(nullable: true)
    keyword(nullable: true)
  }
}
