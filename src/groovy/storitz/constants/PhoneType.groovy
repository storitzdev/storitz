package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Apr 2, 2010
 * Time: 4:33:03 PM
 * To change this template use File | Settings | File Templates.
 */
public enum PhoneType {
  HOME("Home"),
  MOBILE("Mobile"),
  OFFICE("Office");

  final String display;

  PhoneType(String display) { this.display = display; }

  String getValue() { return this.display }

  static list() {
    [HOME, MOBILE, OFFICE]
  }

  static public PhoneType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return PhoneType.valueOf(value)
    return ret
  }

}