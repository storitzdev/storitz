package com.storitz

import storitz.constants.CenterShiftLocation

class CenterShift {

  static hasMany = [sites: StorageSite]

  static constraints = {
    manager(nullable:true)
    userName(blank:false, unique:true)
    pin(blank:false)
    cshiftVersion(nullable:true)
  }

  User manager
  String userName
  String pin
  CenterShiftLocation location = CenterShiftLocation.SLC
  String cshiftVersion
}
