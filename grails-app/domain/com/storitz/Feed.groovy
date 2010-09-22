package com.storitz

import storitz.constants.FeedType

class Feed {
  static hasMany = [sites: StorageSite]


  static constraints = {
    manager(nullable:true)
    operatorName(nullable:true)
  }

  FeedType feedType
  User manager
  String operatorName

}
