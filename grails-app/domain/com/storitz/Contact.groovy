package com.storitz

import storitz.constants.StreetType;
import storitz.constants.PhoneType;
import storitz.constants.State;
import storitz.constants.Country;

class Contact {

    String firstName
    String lastName
    String suffixName
    String address1
    String address2
    String city
    State state
    String province
    String zipcode
    Country country
    String phone
    PhoneType phoneType
    String email

    static constraints = {
      email(email:true, nullable: true)
      zipcode(size:5..10)
      suffixName(nullable:true)
      province(nullable:true)
      country(nullable:true)
      address2(nullable:true)
    }

    static belongsTo = [rental:RentalTransaction]
}
