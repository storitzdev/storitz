package com.storitz

import storitz.constants.State

/* Can't make this class link to Contact since Contact is subordinated to Rental Transaction... */
class OrganizerContest {

    static constraints = {
        firstName(nullable:false, blank:false)
        lastName(nullable:false, blank:false)
        phone(nullable:false, blank:false)
        email(nullable:false, blank:false, email:true)
        twitterName(nullable:true, blank:true) //change back nullable:true
//        address1(nullable:false, blank:false)
//        address2(nullable:true, blank:true)
//        city(nullable:false, blank:false)
//        state(nullable:false)
        zipcode(nullable:false, blank:false)
        zipcode2(nullable:false, validator: { entry -> entry >= 90001 && entry <= 96162 } )
        referralSource(nullable:true, blank:true)  //change back nullable:true
        essayWhyStorage(nullable:false, blank:false, maxSize: 2000)
        readTermsAndConditions(nullable:false, validator: { entry -> entry == true } )
        sendMeUpdates(nullable:true)
    }

    String firstName
    String lastName
    String phone
    String email
    String twitterName
//    String address1
//    String address2
//    String city
//    State  state
    String zipcode
    Integer zipcode2
    String referralSource
    String essayWhyStorage
    Boolean readTermsAndConditions
    Boolean sendMeUpdates

}
