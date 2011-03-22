package com.storitz

class GeoLookup {

  BigDecimal lat
  BigDecimal lng
  String city
  String state
  String zip

  static constraints = {
    zip(nullable: true)
  }
}
