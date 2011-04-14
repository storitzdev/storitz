package com.storitz

class EDomicoLocation {

    static belongsTo = [edomico : EDomico]

    static constraints = {
        siteID (nullable:false, unique:true)
        siteName (nullable: false)
        address1 (nullable: false)
        city (nullable: false)
        zipcode (nullable: false)
    }

    String siteID
    String siteName
    String address1
    String city
    String zipcode
}
