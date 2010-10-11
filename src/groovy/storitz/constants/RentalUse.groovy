package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Apr 4, 2010
 * Time: 9:12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public enum RentalUse {
  PERSONAL("Personal"),
  BUSINESS("Business");

  final String display

  RentalUse(String display) { this.display = display }

  String getValue() { return this.display }

  static list() {
    [PERSONAL, BUSINESS]
  }

  static labels() {
    [PERSONAL.display, BUSINESS.display]
  }

  static public RentalUse getEnumFromId(String value) {
        list().find {it.display == value }
    }
}