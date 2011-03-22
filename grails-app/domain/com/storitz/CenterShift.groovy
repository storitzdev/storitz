package com.storitz

import storitz.constants.CenterShiftLocations
import storitz.constants.CenterShiftVersion

class CenterShift extends Feed {

  static constraints = {
    userName(blank: false, unique: true)
    pin(blank: false)
    cshiftVersion(nullable: true)
    orgId(nullable: true)
  }

  String userName
  String pin
  CenterShiftLocations location = CenterShiftLocations.SLC
  Long orgId
  CenterShiftVersion cshiftVersion
}
