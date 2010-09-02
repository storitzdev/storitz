package com.storitz

class SiteImage {

  static belongsTo = [ site: StorageSite]

  static constraints = {
    imgOrder(nullable:true)
  }

  Integer imgOrder
  Boolean isCover
  Boolean isLogo
  Boolean hasThumbnail
  String fileLocation
  String basename

  def thumbnail() {
    return basename + "thumb_" + fileLocation.encodeAsURL().replace("+", "%20")
  }

  def mid() {
    return basename + "mid_" + fileLocation.encodeAsURL().replace("+", "%20")
  }

  def src() {
    return basename +  fileLocation.encodeAsURL().replace("+", "%20")
  }
}
