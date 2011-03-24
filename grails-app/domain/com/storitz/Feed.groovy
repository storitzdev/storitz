package com.storitz

import storitz.constants.FeedType
import storitz.constants.State

class Feed {
  static hasMany = [sites: StorageSite]


  static constraints = {
    manager(nullable: true)
    operatorName(nullable: true)
    address1(nullable: true)
    address2(nullable: true)
    city(nullable: true)
    state(nullable: true)
    zipcode(nullable: true)
    transactionBoxLink(size: 1..255, nullable: true)
    transactionBoxBody(size: 1..2000, nullable: true)
    dateCreated(nullable:true)
    lastUpdated(nullable:true)
  }

  FeedType feedType
  User manager
  String operatorName
  String address1
  String address2
  String city
  State state
  String zipcode
  String transactionBoxLink
  String transactionBoxBody
  Date dateCreated
  Date lastUpdated

  CommissionSchedule commissionSchedule

}
