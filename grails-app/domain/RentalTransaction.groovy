import storitz.constants.IdType
import storitz.constants.State
import storitz.constants.Country
import storitz.constants.RentalUse
import storitz.constants.TransactionStatus

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
  TransactionStatus status
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
