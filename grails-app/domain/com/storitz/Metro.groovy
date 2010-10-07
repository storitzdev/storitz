package com.storitz

import storitz.constants.State

class Metro {

  static constraints = {
    note(widget:'textarea', nullable:true, size:2..3000, markup:true)
  }

  String note
  String city
  String metro
  State state

}
