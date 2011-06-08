package com.storitz

class ServiceMap {

    static constraints = {
        serviceName(nullable: false, unique: true)
        serviceHandler(nullable:false, unique: true)
    }

    String serviceName
    String serviceHandler
}
