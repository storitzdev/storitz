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
    return basename + "thumb_" + fileLocation
  }

  def mid() {
    return basename + "mid_" + fileLocation
  }

  def src() {
    return basename +  fileLocation
  }
}
