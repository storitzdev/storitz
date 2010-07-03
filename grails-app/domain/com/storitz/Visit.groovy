package com.storitz

class Visit {

    static constraints = {
    }

    Date dateCreated

    def beforeInsert() {
       dateCreated = new Date()
    }
}
