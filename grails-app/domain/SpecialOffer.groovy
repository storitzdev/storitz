class SpecialOffer {

  static belongsTo = StorageSite
  static hasMany = [sites: StorageSite]

    static constraints = {
    }

  User manager
  String code
  String description
}
