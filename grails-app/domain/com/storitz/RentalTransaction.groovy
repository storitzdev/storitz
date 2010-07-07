package com.storitz

import storitz.constants.IdType
import storitz.constants.State
import storitz.constants.Country
import storitz.constants.RentalUse
import storitz.constants.TransactionStatus

class RentalTransaction {

  Contact contactPrimary
  Contact contactSecondary
  Contact billingAddress
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
  ReferralCode referralCode

  static constraints = {
    billingAddress(nullable:true)
    referralCode(nullable:true)
  }

  static transients = ['priceDriveup', 'priceInterior', 'priceUpper', 'priceTempControlled', 'searchSize', 'reserveTruck',
    'terms', 'hazardousMaterials', 'insuranceTerms']  
}