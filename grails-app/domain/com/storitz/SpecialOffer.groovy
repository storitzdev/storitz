package com.storitz

import storitz.constants.PromoType

class SpecialOffer {

  static hasMany = [
          restrictions: SpecialOfferRestriction,
          tags: SpecialOfferTag
  ]

  static constraints = {
    code(nullable: true)
    concessionId(nullable: true)
    prepay(nullable: true)
    promoQty(nullable: true)
    waiveAdmin(nullable: true)
    endDate(nullable: true)
    startDate(nullable: true)
    promoSize(nullable: true)
    unitType(nullable: true)
  }

  static fetchMode = [restrictions:"eager"]

  static mapping = {
    restrictions cascade: "all,delete-orphan"
    tags cascade: "all,delete-orphan"
  }

  String code
  Long concessionId
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
  StorageSite site

  Date startDate
  Date endDate
  StorageSize promoSize  // TODO: Delete, unused
  String unitType        // TODO: Delete, unused

  public void deleteRestrictions() {
    try {
      Iterator iter = this.restrictions.iterator()
      SpecialOfferRestriction r;
      while (iter.hasNext()) {
        r = iter.next();
        iter.remove()
        r.delete (flush:true);
      }
    } catch (Throwable t) {
      log.info ("Unable to delete special offer restriction!",t)
    }
  }
}
