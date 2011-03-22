package com.storitz

class Invoice {

  static hasMany = [transactions: RentalTransaction]

  static constraints = {
  }

  Feed feed
  Date issued

  String getInvoiceId() {
    return "${issued.format('yyyyMMdd')}${id}"
  }

  void setInvoiceId(String id) {}
}
