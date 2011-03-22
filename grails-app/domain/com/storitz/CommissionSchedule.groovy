package com.storitz

class CommissionSchedule {

  static hasMany = [entries: Commission]

  static fetchMode = [entries: 'eager']

  static constraints = {
  }

  static mapping = {
    entries cascade: "all,delete-orphan"
  }

  String scheduleName
}
