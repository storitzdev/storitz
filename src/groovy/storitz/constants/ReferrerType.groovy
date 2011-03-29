package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Oct 29, 2010
 * Time: 10:20:39 AM
 * To change this template use File | Settings | File Templates.
 */
public enum ReferrerType {
  BLOG("blog.storitz.com", "blog.storitz.com"),
  RELOCATION("relocation.com", "relocation.com"),
  GOOGLE("google.com", "google.com"),
  GOOGLECN("googlecn", "Google Content Network"),
  YAHOO("yahoo.com", "yahoo.com"),
  BING("bing.com", "bing.com"),
  YELP("yelp.com", "yelp.com"),
  WESTSIDE_RENTALS("westsiderentals.com", "westsiderentals.com"),
  HOTPADS("hotpads.com", "hotpads.com"),
  APARTMENTGUIDE("apartmentguide.com", "apartmentguide.com"),
  RENTALS("rentals.com", "rentals.com"),
  RETIREMENTHOMES("retirementhomes.com", "retirementhomes.com"),
  FORRENT("forrent.com", "forrent.com"),
  HOMES("homes.com", "homes.com"),
  SENIOROUTLOOK("senioroutlook.com", "senioroutlook.com"),
  CORPORATE_HOUSING("corporatehousing.com", "corporatehousing.com"),
  RENTALHOUSES("rentalhouses.com", "rentalhouses.com"),
  RENT("rent.com", "rent.com")

  final String display
  final String id

  public ReferrerType(String id, String display) {
    this.id = id
    this.display = display
  }

  static list() {
    [BLOG, RELOCATION, GOOGLE, GOOGLECN, YAHOO, BING, YELP, WESTSIDE_RENTALS, HOTPADS, APARTMENTGUIDE,
            RENTALS, RETIREMENTHOMES, FORRENT, HOMES, SENIOROUTLOOK, CORPORATE_HOUSING, RENTALHOUSES, RENT]
  }

  static public ReferrerType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) {
      return ReferrerType.valueOf(value)
    }
    return ret
  }

}