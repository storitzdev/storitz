package com.storitz

import storitz.constants.CenterShiftLocations

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
  CenterShiftLocations location = CenterShiftLocations.SLC
  String cshiftVersion
}
