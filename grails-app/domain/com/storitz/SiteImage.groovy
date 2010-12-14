package com.storitz

class SiteImage {

  static belongsTo = [ site: StorageSite]

  static constraints = {
    imgOrder(nullable:true)
    caption(nullable:true, size:2..1000)
    tags(nullable:true, size:2..1000)
  }

  Integer imgOrder
  Boolean isCover
  Boolean isLogo
  Boolean hasThumbnail
  String fileLocation
  String basename
  String caption
  String tags

  def thumbnail() {
    return basename + "thumb-" + fileLocation.encodeAsURL().replace("+", "%20")
  }

  def thumbnailOld() {
    return basename + "thumb_" + fileLocation.encodeAsURL().replace("+", "%20")
  }

  def mid() {
    return basename + "mid-" + fileLocation.encodeAsURL().replace("+", "%20")
  }

  def midOld() {
    return basename + "mid_" + fileLocation.encodeAsURL().replace("+", "%20")
  }

  def src() {
    return basename +  fileLocation.encodeAsURL().replace("+", "%20")
  }
}
