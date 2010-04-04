import storagetech.constants.IdType

class RentalTransaction {

  Contact contactPrimary
  Contact contactSecondary
  IdType idType
  String idLocale
  String idNumber
  String unit_choice
  StorageSite site
  Boolean priceDriveup
  Boolean priceInterior
  Boolean priceUpper
  Boolean priceTempControlled
  Integer searchSize

  static constraints = {
  }

  static transients = ['priceDriveup', 'priceInterior', 'priceUpper', 'priceTempControlled', 'searchSize']  
}
