package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 21, 2010
 * Time: 2:26:50 PM
 * To change this template use File | Settings | File Templates.
 */
public enum FeedType {
  SITELINK("SiteLink"),
  CENTERSHIFT("Centershift"),
  QUIKSTOR("QuikStor"),
  EDOMICO("EDomico"),
  UNCLEBOBS("UncleBobs"),
  STORAGEMART("StorageMart")

  final display

  public FeedType(String display) {
    this.display = display
  }

  static list() {
    [SITELINK, CENTERSHIFT, QUIKSTOR, EDOMICO, UNCLEBOBS, STORAGEMART]
  }

  static public FeedType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return FeedType.valueOf(value)
    return ret
  }

}