package com.storitz

class PressRelease {

    static constraints = {
      pdfLocation(nullable:true)
    }

    Date release
    String title
    String blurb
    String body
    String tags
    String pdfLocation
}
