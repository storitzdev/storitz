package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Jun 21, 2010
 * Time: 11:17:37 PM
 * To change this template use File | Settings | File Templates.
 */
public enum SoftwareType {
  CENTERSHIFT("Centershift"),
  SITELINK("SiteLink"),
  SELF_STORAGE_MANAGER("Self Storage Manager"),
  DOMICO("Domico"),
  QUIKSTOR("QuikStor"),
  STORMAN("Storman"),
  OTHER("Other")

  final String display;

  SoftwareType(String display) { this.display = display; }


  static list() {
      [CENTERSHIFT, SITELINK, SELF_STORAGE_MANAGER, DOMICO, QUIKSTOR, STORMAN, OTHER]
  }

  static public SoftwareType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return SoftwareType.valueOf(value)
    return ret
  }

}