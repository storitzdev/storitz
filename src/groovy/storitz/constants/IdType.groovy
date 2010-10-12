package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Apr 2, 2010
 * Time: 4:34:52 PM
 * To change this template use File | Settings | File Templates.
 */
public enum IdType {
  DRIVERSLICENSE("Drivers License"),
  PASSPORT("Passport");

  final String display;

  IdType(String display) { this.display = display; }

  String getValue() { return this.display }

  static list() {
    [DRIVERSLICENSE, PASSPORT]
  }

  static public IdType getEnumFromId(String value) {
        def ret = list().find {it.display == value }
        if (!ret) return IdType.valueOf(value)
        return ret
    }

}