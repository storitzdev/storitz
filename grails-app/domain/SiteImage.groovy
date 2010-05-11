import StorageSite

class SiteImage {

  static belongsTo = [ site: StorageSite]

  static constraints = {
    imgOrder(nullable:true)
  }

  Integer imgOrder
  Boolean isCover
  Boolean isLogo
  String fileLocation
  String basename

  def thumbnail() {
    return basename + "/thumb_" + fileLocation
  }

  def src() {
    if (isLogo) {
      return basename + "/logo_" + fileLocation
    }
    return basename + "/" + fileLocation
  }
}
