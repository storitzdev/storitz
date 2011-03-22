package com.storitz

class SiteLink extends Feed {

  static constraints = {
    corpCode(blank: false, unique: true)
    userName(blank: false)
    password(blank: false)
  }

  String corpCode
  String userName
  String password
}
