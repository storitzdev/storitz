package com.storitz

class ContactUsNote {

  static belongsTo = ContactUs

  static constraints = {
    note(widget: 'textarea', nullable: true, size: 2..2000, markup: true)
  }

  String note
  String initials
  Date entered
}