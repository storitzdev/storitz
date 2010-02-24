class SpecialOffer {

  static hasMany = [sites: StorageSite]
  static belongsTo = StorageSite

  static constraints = {
    manager(nullable: true)
    code(nullable: true)
  }

  User manager
  String code
  String description
}
