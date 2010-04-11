import storagetech.constants.PromoType

class SpecialOffer {

  static hasMany = [sites: StorageSite]
  static belongsTo = StorageSite

  // TODO - make this work for demo
  static constraints = {
    code(nullable: true)
    concessionId(nullable: true)
    prepay(nullable: true)
    promoQty(nullable: true)
  }

  String code
  Integer concessionId
  String name
  String description
  Boolean prepay
  BigDecimal promoQty
  PromoType promoType
  Integer prepayMonths
  Integer inMonth
  Integer expireMonth
  Boolean active
}
