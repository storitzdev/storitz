package com.storitz

import storitz.constants.State

class Metro {

  static constraints = {
    note(widget:'textarea', nullable:true, size:2..3000)
  }

  String note
  String city
  State state
  Boolean isNeighborhood = false

}
