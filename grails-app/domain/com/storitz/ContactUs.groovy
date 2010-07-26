package com.storitz

import storitz.constants.ContactType

class ContactUs {

  static hasMany = [notes: ContactUsNote]

  ContactType contactType
  String userEmail
  String message
  Date entered
  Boolean serviced

  static constraints = {
    message(nullable:false, size:2..2000)
    userEmail(nullable:false, email:true)
  }
}
