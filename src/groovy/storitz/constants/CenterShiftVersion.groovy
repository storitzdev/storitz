package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 12, 2010
 * Time: 12:02:28 PM
 * To change this template use File | Settings | File Templates.
 */
public enum CenterShiftVersion {
    CS3(3, "3.x"),
    CS4(4, "4.x");

    private final int value
    private final String description

    public CenterShiftVersion(value, description) {
      this.value = value
      this.description = description
    }

    String getDisplay() { return description }
    String getValue() { return value }

    static list() {
      [CS3, CS4]
    }

  static public CenterShiftVersion getEnumFromId(String value) {
        list().find {it.display == value }
    }

}