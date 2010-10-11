package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Aug 18, 2010
 * Time: 2:08:17 PM
 * To change this template use File | Settings | File Templates.
 */
public enum CommissionType {
    FIXED("Fixed"),
    PERCENTAGE("Percentage");

    final String display

    CommissionType(display) {
      this.display = display
    }

    def getValue() { return display }

    static list() { [FIXED, PERCENTAGE] }

  static public CommissionType getEnumFromId(String value) {
        list().find {it.display == value }
    }

}