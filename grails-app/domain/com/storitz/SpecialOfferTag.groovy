package com.storitz

class SpecialOfferTag {

    static belongsTo = SpecialOffer

    static constraints = {
      tag(nullable:false, unique:true)
    }

    String tag
    Date dateCreated
    Date lastUpdated

}
