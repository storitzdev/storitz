package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Oct 8, 2010
 * Time: 12:05:25 PM
 * To change this template use File | Settings | File Templates.
 */
public enum UnitType {
  UNDEFINED("Undefined"),
  INTERIOR("Interior"),
  UPPER("Upper"),
  DRIVEUP("Drive Up")

  final String display

  public UnitType(String display) {
    this.display = display
  }

  static list() {
    [UNDEFINED, INTERIOR, UPPER, DRIVEUP]
  }

  static public UnitType getEnumFromId(String value) {
        list().find {it.display == value }
    }
}