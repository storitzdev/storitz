package com.storitz

import storitz.constants.State

/* Can't make this class link to Contact since Contact is subordinated to Rental Transaction... */
class OrganizerContest {

    static constraints = {
        firstName(nullable:false, blank:false)
        lastName(nullable:false, blank:false)
        phone(nullable:false, blank:false)
        email(nullable:false, blank:false, email:true)
        twitterName(nullable:true, blank:true)
        address1(nullable:false, blank:false)
        address2(nullable:true, blank:true)
        city(nullable:false, blank:false)
        state(nullable:false, blank:false)
        zipcode(nullable:false, blank:false)
        referralSource(nullable:true, blank:true)
        essayWhyStorage(nullable:false, blank:false, maxSize: 2000)
        readTermsAndConditions(nullable:false, blank:false, validator: { entry -> entry == true } )
        dontSendMeUpdates(nullable:true, blank:true)
    }

    String firstName
    String lastName
    String phone
    String email
    String twitterName
    String address1
    String address2
    String city
    State  state
    String zipcode
    String referralSource
    String essayWhyStorage
    Boolean readTermsAndConditions
    Boolean dontSendMeUpdates

}
