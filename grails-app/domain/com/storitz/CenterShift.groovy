package com.storitz
class CenterShift {

  static hasMany = [sites: StorageSite]

  static constraints = {
    manager(nullable:true)
    userName(blank:false, unique:true)
    pin(blank:false)
  }

  User manager
  String userName
  String pin
}
