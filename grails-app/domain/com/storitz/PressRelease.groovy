package com.storitz

class PressRelease {

  static constraints = {
    pdfLocation(nullable: true)
    blurb(size: 2..2000)
    body(size: 2..65535)
    tags(nullable: true, size: 1..512)
  }

  Date releaseDate
  String title
  String blurb
  String body
  String tags
  String pdfLocation
}
