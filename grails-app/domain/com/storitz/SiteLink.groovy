package com.storitz
class SiteLink {

  static hasMany = [sites: StorageSite]

  static constraints = {
    manager(nullable:true)
    corpCode(blank:false, unique:true)
    userName(blank:false)
    password(blank:false)
    operatorName(nullable:true)
  }

  User manager
  String corpCode
  String userName
  String password
  String operatorName

}
