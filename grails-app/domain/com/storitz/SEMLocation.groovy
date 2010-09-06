package com.storitz

import storitz.constants.State

class SEMLocation {

    Integer locationId
    String city
    State state
    Date created
    Date updated

    static mapping = {
        cache true
    }

    static constraints = {
      locationId(unique:true)
    }
}
