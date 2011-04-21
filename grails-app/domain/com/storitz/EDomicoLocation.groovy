package com.storitz

class EDomicoLocation {

    static belongsTo = [edomico : EDomico]

    static constraints = {
        siteID (nullable:false, unique:true)
        siteName (nullable: false)
        address1 (nullable: false)
        city (nullable: false)
        state (nullable: false)
        zipcode (nullable: false)
        site (nullable: true)
    }

    String siteID
    String siteName
    String address1
    String city
    String state
    String zipcode
    StorageSite site
}
