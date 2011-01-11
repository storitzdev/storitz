package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Oct 8, 2010
 * Time: 12:05:25 PM
 * To change this template use File | Settings | File Templates.
 */
public enum SearchType {
  UNDEFINED("Undefined"),
  STORAGE("Storage"),
  PARKING("Parking"),
  LOCKER("Locker")

  final String display

  public SearchType(String display) {
    this.display = display
  }

  static list() {
    [UNDEFINED, STORAGE, PARKING, LOCKER]
  }

  static public SearchType getEnumFromId(String value) {
        def ret = list().find {it.display == value }
        if (!ret) {
          return SearchType.valueOf(value)
        }
        return ret
    }
}