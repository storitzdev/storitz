package com.storitz

import storitz.constants.State

class MetroEntry {

  static constraints = {
    metro(nullable:true)
  }

  Metro metro
  String zip
  String city
  State state

}
