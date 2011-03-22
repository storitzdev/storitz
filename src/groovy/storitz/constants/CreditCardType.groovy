package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Aug 10, 2010
 * Time: 8:46:44 AM
 * To change this template use File | Settings | File Templates.
 */
public enum CreditCardType {

  MASTERCARD("Master Card", 5),
  VISA("Visa", 6),
  AMERICAN_EXPRESS("American Express", 7),
  DISCOVER("Discover", 8),
  DINERSCLUB("Diners Club", 9);


  public String display
  public int siteLinkValue

  CreditCardType(display, siteLinkValue) {
    this.display = display
    this.siteLinkValue = siteLinkValue
  }

  public getKey() { return display; }

  static list() {
    [MASTERCARD, VISA, AMERICAN_EXPRESS, DISCOVER, DINERSCLUB]
  }

  public static CreditCardType fromText(String key) {
    return list().find { it.getKey() == key }
  }

  static public CreditCardType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return CreditCardType.valueOf(value)
    return ret
  }

}