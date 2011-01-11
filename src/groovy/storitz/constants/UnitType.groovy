package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Oct 8, 2010
 * Time: 12:05:25 PM
 * To change this template use File | Settings | File Templates.
 */
public enum UnitType {
  UNDEFINED("Undefined", null),
  INTERIOR("Interior", SearchType.STORAGE),
  UPPER("Upper", SearchType.STORAGE),
  DRIVEUP("Drive Up", SearchType.STORAGE),
  COVERED("Covered", SearchType.PARKING),
  UNCOVERED("Uncovered", SearchType.PARKING)

  final String display
  final SearchType searchType

  public UnitType(String display, SearchType searchType) {
    this.display = display
    this.searchType = searchType
  }

  static list() {
    [UNDEFINED, INTERIOR, UPPER, DRIVEUP, COVERED, UNCOVERED]
  }

  static public List getUnitTypeBySearchType(SearchType searchType) {
    return list().findAll{ it.searchType == searchType }
  }

  static public UnitType getEnumFromId(String value) {
        def ret = list().find {it.display == value }
        if (!ret) {
          return UnitType.valueOf(value)
        }
        return ret
    }
}