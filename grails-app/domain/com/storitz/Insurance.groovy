package com.storitz

class Insurance {

  Integer insuranceId
  BigDecimal totalCoverage
  BigDecimal premium
  BigDecimal percentTheft
  String provider
  Boolean active

  static constraints = {
  }

  static belongsTo = StorageSite
}
