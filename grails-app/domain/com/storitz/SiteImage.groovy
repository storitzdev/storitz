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
    return basename + "thumb_" + fileLocation.replace(" ", "%20").encodeAsURL()
  }

  def mid() {
    return basename + "mid_" + fileLocation.replace(" ", "%20").encodeAsURL()
  }

  def src() {
    return basename +  fileLocation.replace(" ", "%20").encodeAsURL()
  }
}
