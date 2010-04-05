import storagetech.constants.IdType
import storagetech.constants.State
import storagetech.constants.Country
import storagetech.constants.RentalUse

class RentalTransaction {

  Contact contactPrimary
  Contact contactSecondary
  IdType idType
  State idState
  Country idCountry
  String idNumber
  Boolean reserveTruck
  Boolean activeMilitary
  Boolean terms
  RentalUse rentalUse
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
