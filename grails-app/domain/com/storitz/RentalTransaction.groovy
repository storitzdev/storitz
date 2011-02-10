package com.storitz

import storitz.constants.*

class RentalTransaction {

  static hasMany = [notes: TransactionNote]
  def static reportable = [:]
  
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
  String feedUnitId           // for centershift to identify specific unit
  String feedUnitNumber       // for email, etc.
  Long promoId
  String promoName

  Long insuranceId
  String insuranceName
  StorageSite site
  Date bookingDate
  Date moveInDate
  Date achTransferDate
  Invoice invoice
  Date paidThruDate
  Date dateOfBirth
  BigDecimal cost
  BigDecimal moveInCost
  BigDecimal discount
  BigDecimal insuranceCost
  BigDecimal feedMoveInCost
  BigDecimal commission
  BigDecimal monthlyRate
  BigDecimal duration
  BigDecimal achAmount
  Integer durationDays
  Integer durationMonths
  BigDecimal fees
  BigDecimal tax
  BigDecimal deposit
  ReferralCode referralCode
  SearchEngineReferral searchEngineReferral
  Boolean isCallCenter
  String cleanCCNum
  String paymentString
  UnitType unitType
  StorageSize searchSize
  String displaySize
  Integer reservationPeriod
  String reservationId
  BigDecimal reservationCost
  Boolean reserved
  Boolean checkIssued
  Boolean invoiced
  String contactId // used for Centershift

  // Transient members
  Boolean insuranceTerms
  Boolean hazardousMaterials
  Boolean terms
  Date ccExpDate
  CreditCardType cardType
  String ccNum
  String cvv2

  TransactionType transactionType

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
    promoId(nullable:true)
    searchEngineReferral(nullable: true)
    cleanCCNum(nullable:true)
    feedUnitId(nullable:true)
    feedUnitNumber(nullable:true)
    moveInCost(nullable:true)
    reservationPeriod(nullable:true)
    reserved(nullable:true)
    reservationId(nullable:true)
    reservationCost(nullable:true)
    contactId(nullable:true)
    feedMoveInCost(nullable:true)
    monthlyRate(nullable:true)
    discount(nullable:true)
    duration(nullable:true)
    insuranceCost(nullable:true)
    promoName(nullable:true)
    insuranceName(nullable:true)
    fees(nullable:true)
    tax(nullable:true)
    deposit(nullable:true)
    durationDays(nullable:true)
    durationMonths(nullable:true)
    checkIssued(nullable:true)
    invoiced(nullable:true)
    invoice(nullable:true)
    achAmount(nullable:true)
    displaySize(nullable:true)
  }

  static transients = ['terms', 'hazardousMaterials', 'insuranceTerms', 'ccExpDate', 'ccNum',
          'cardType', 'cvv2', 'paymentString']
}
