package com.storitz

import storitz.constants.UnitType

class EDomicoAmenitiesMap extends UnitTypeLookup {

    static constraints = {
      secure(nullable: true)
      powered(nullable: true)
      alarmed(nullable: true)
      irregular(nullable: true)
    }

    Boolean secure
    Boolean alarmed
    Boolean powered
    Boolean irregular

}
