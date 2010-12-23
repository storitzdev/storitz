package com.storitz

import storitz.constants.PromoType

class SpecialOffer {

  static belongsTo = StorageSite

  static constraints = {
    code(nullable: true)
    concessionId(nullable: true)
    prepay(nullable: true)
    promoQty(nullable: true)
    waiveAdmin(nullable: true)
    endDate(nullable:true)
    promoSize(nullable:true)
    unitType(nullable:true)
  }

  String code
  Integer concessionId
  String promoName
  String description
  Boolean prepay
  BigDecimal promoQty
  PromoType promoType
  Integer prepayMonths
  Integer inMonth
  Integer expireMonth
  Boolean active
  Boolean featured
  Boolean waiveAdmin

  Date endDate
  StorageSize promoSize
  String unitType        // this helps associate a given offer with a particular unit type
}
