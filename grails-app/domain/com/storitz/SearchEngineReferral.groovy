package com.storitz

class SearchEngineReferral {

    String sem_id
    String ts_code
    String match_type
    Integer location_id
    String ad_id
    String keyword

    Date landingDate
    Date bookingDate
    BigDecimal commission

    static constraints = {
      location_id(nullable:true)
    }
}
