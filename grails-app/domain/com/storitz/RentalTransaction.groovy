package com.storitz

import storitz.constants.IdType
import storitz.constants.State
import storitz.constants.Country
import storitz.constants.RentalUse
import storitz.constants.TransactionStatus
import com.storitz.Contact

class RentalTransaction {

  Contact contactPrimary
  Contact contactSecondary
  IdType idType
  State idState
  Country idCountry
  String idNumber
  Boolean reserveTruck
  Boolean activeMilitary
  RentalUse rentalUse
  TransactionStatus status
  Long unitId
  Long promoId
  Long insuranceId
  StorageSite site
  Boolean priceDriveup
  Boolean priceInterior
  Boolean priceUpper
  Boolean priceTempControlled
  Integer searchSize
  Date bookingDate
  Date moveInDate

  static constraints = {
  }

  static transients = ['priceDriveup', 'priceInterior', 'priceUpper', 'priceTempControlled', 'searchSize', 'reserveTruck',
    'terms', 'hazardousMaterials', 'insuranceTerms']  
}
