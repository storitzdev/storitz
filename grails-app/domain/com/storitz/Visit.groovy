package com.storitz

class Visit {

  static constraints = {
    dateCreated(nullable: false)
    site(nullable: false)
    remoteAddr(nullable: false)
    searchAddress(nullable: true)
    unitSize(nullable: true)
    searchDate(nullable: true)
    referralCode(nullable: true)
    cookie(nullable: true)
  }

  static belongsTo = StorageSite

  Date dateCreated

  StorageSite site

  String remoteAddr
  String searchAddress
  StorageSize unitSize
  Date searchDate

  String referralCode
  String cookie

// To use this the field must be nullable.  Otherwise it fails validation.  
//    def beforeInsert() {
//       dateCreated = new Date()
//    }
}
