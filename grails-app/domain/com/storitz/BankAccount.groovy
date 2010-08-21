package com.storitz

class BankAccount {

    static belongsTo = StorageSite

    static constraints = {
      routeCode(validator: { return (it ==~ /\d{9}/) })
      acctNo(validator: { return (it ==~ /\d+/) })
      accountName(blank:false, maxSize:22)
    }

  String routeCode
  String acctNo
  String accountName
  String bankName
}
