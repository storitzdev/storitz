package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Oct 29, 2010
 * Time: 10:20:39 AM
 * To change this template use File | Settings | File Templates.
 */
public enum ReferrerType {
  RELOCATION("relocation.com", "relocation.com"),
  GOOGLE("google.com", "google.com"),
  GOOGLECN("googlecn", "Google Content Network"),
  YAHOO("yahoo.com", "yahoo.com"),
  BING("bing.com", "bing.com"),
  YELP("yelp.com", "yelp.com"),
  WESTSIDE_RENTALS("westsiderentals.com", "westsiderentals.com")

  final String display
  final String id

  public ReferrerType(String id, String display) {
    this.id = id
    this.display = display
  }

  static list() {
    [RELOCATION, GOOGLE, GOOGLECN, YAHOO, BING, YELP, WESTSIDE_RENTALS]
  }

  static public ReferrerType getEnumFromId(String value) {
      def ret = list().find {it.display == value }
      if (!ret) {
        return ReferrerType.valueOf(value)
      }
      return ret
  }
  
}