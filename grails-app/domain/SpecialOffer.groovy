import storagetech.constants.PromoType

class SpecialOffer {

  static hasMany = [sites: StorageSite]
  static belongsTo = StorageSite

  static constraints = {
    code(nullable: true)
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
  Boolean active
}
