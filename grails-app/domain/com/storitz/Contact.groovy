package com.storitz

import storitz.constants.Country
import storitz.constants.PhoneType
import storitz.constants.State

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
    email(email: true, nullable: true)
    zipcode(size: 5..10)
    suffixName(nullable: true)
    province(nullable: true)
    country(nullable: true)
    address2(nullable: true)
    phoneType(nullable: true)
    phone(blank: false)
    state(blank: false, validator: { val -> val != State.NONE })
    firstName(blank: false)
    lastName(blank: false)
    address1(blank: false)
    city(blank: false)
    zipcode(blank: false)
  }

  static belongsTo = [rental: RentalTransaction]

  def fullName() {
    "${firstName} ${lastName}${suffixName ? ' ' + suffixName : ''}"
  }

  def fullAddress() {
    "${address1}${address2 ? ' ' + address2 : ''}, ${city}, ${state.display} ${zipcode}"
  }
}
