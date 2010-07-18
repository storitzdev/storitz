package com.storitz

class BankAccount {

    static belongsTo = StorageSite

    static constraints = {
    }

  String routeCode
  String acctNo
  String bankName
  Contact bankContact
}
