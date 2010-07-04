package com.storitz
class SiteLink {

  static hasMany = [sites: StorageSite]

  static constraints = {
    manager(nullable:true)
    corpCode(blank:false, unique:true)
    userName(blank:false)
    password(blank:false)
  }

  User manager
  String corpCode
  String userName
  String password

}
