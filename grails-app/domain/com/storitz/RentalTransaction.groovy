package com.storitz

import storitz.constants.IdType
import storitz.constants.State
import storitz.constants.Country
import storitz.constants.RentalUse
import storitz.constants.TransactionStatus
import storitz.constants.CreditCardType

class RentalTransaction {

  static hasMany = [notes: TransactionNote]
  
  Contact contactPrimary
  Contact contactSecondary
  Contact billingAddress
  IdType idType
  State idState
  Country idCountry
  String idNumber             // move in transaction identifier
  String tenantId             // tenant identifier
  Boolean reserveTruck
  Boolean activeMilitary
  RentalUse rentalUse
  TransactionStatus status
  String transactionId        // credit card authorization number
  String accessCode           // possible gate code
  Long unitId
  Long promoId

  Long insuranceId
  StorageSite site
  Date bookingDate
  Date moveInDate
  Date achTransferDate
  Date paidThruDate
  Date dateOfBirth
  BigDecimal cost
  BigDecimal commission
  ReferralCode referralCode
  Boolean isCallCenter

  // Transient members
  Integer searchSize
  Boolean insuranceTerms
  Boolean hazardousMaterials
  Boolean terms
  Date ccExpDate
  CreditCardType cardType
  String ccNum
  String cvv2

  static constraints = {
    billingAddress(nullable:true)
    referralCode(nullable:true)
    transactionId(nullable:true)
    paidThruDate(nullable:true)
    cost(nullable:true)
    dateOfBirth(nullable:true)
    tenantId(nullable:true)
    accessCode(nullable:true)
    reserveTruck(nullable:true)
    contactSecondary(nullable: true)
    idCountry(nullable: true)
    idNumber(nullable: true)
    idState(nullable: true)
    idType(nullable: true)
    commission(nullable: true)
    achTransferDate(nullable: true)
  }

  static transients = ['searchSize', 'terms', 'hazardousMaterials', 'insuranceTerms', 'ccExpDate', 'ccNum',
          'cardType', 'cvv2']  
}
