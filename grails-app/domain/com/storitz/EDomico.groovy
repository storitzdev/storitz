package com.storitz


class EDomico extends Feed {

    static hasMany = [locations: EDomicoLocation]

    static mapping = {
        locations cascade: "all-delete-orphan"
    }

    static constraints = {
        edomicoClientID (nullable: true, unique: true)
        edomicoWebServicesKey (nullable: true, unique: true)
    }


    int edomicoClientID
    String edomicoWebServicesKey

}
