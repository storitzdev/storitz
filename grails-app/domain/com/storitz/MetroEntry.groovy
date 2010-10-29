package com.storitz

import storitz.constants.State

class MetroEntry {

  static constraints = {
    metro(nullable:true)
    zipcode(blank:false)
    city(blank:false)
    state(blank:false)
  }

  Metro metro
  String zipcode
  String city
  State state

}
