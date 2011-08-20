package com.storitz

import storitz.constants.PromoType

class SpecialOfferLookup {

    static constraints = {
      name (nullable:false)
      type (nullable:true)
      amount (nullable:true)
      startMonth (nullable:true)
      expireMonth (nullable:true)
      prepayMonths (nullable:true)
    }

  String name             // unique key (per feed)
  PromoType type          // SpecialOffer.promoType
  Double amount           // SpecialOffer.promoQty
  Integer startMonth      // SpecialOffer.inMonth
  Integer expireMonth     // SpecialOffer.expireMonth
  Integer prepayMonths		// SpecialOffer.prepayMonths

  // all fields must be set or we'll consider this new
  def isNew() {
      type == null || amount == null || startMonth == null || expireMonth == null || prepayMonths == null
  }

}
