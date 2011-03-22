package com.storitz

class Nacha {

  static hasMany = [transactions: RentalTransaction]

  // NACHA requires tracking the date of the file and the sequence on a given day for multiple processing
  String daySent
  Integer seq
  String filePath
  Date generatedDate

  static constraints = {
  }
}
