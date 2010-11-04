package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Apr 2, 2010
 * Time: 4:20:20 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Province {
  NONE("--", "--"),
  ALBERTA("AB", "Alberta"),
  BRITISH_COLUMBIA("BC", "British Columbia"),
  MANITOBA("MB", "Manitoba"),
  NEW_BRUNSWICK("NB", "New Brunswick"),
  NEW_FOUNDLAND_AND_LABRADOR("NL", "New Foundland and Labrador"),
  NORTHWEST_TERRITORIES("NT", "Northwest Territories"),
  NOVA_SCOTIA("NS", "Nova Scotia"),
  NUNAVUT("NU", "Nunavut"),
  ONTARIO("ON", "Ontario"),
  PRINCE_EDWARD_ISLAND("PE", "Prince Edward Island"),
  QUEBEC("QC", "Quebec"),
  SASKATCHEWAN("SK", "Saskatchewan"),
  YUKON_TERRITORY("YT", "Yukon Territory")

  final String display
  final String fullName

  Province(String display, String fullName) { 
    this.display = display
    this.fullName = fullName
  }

  String getValue() {
    return this.display;
  }

  static list() {
    [
            NONE, ALBERTA, BRITISH_COLUMBIA, MANITOBA, NEW_BRUNSWICK, NEW_FOUNDLAND_AND_LABRADOR,
            NORTHWEST_TERRITORIES, NOVA_SCOTIA, NUNAVUT, ONTARIO, PRINCE_EDWARD_ISLAND, QUEBEC,
            SASKATCHEWAN, YUKON_TERRITORY
    ]
  }

  public static Province fromText(String key) {
    def ret = list().find {it.display == key }
    if (!ret) return Province.valueOf(key)
    return ret
  }

  public static Province getEnumFromId(String value) {
      def ret = list().find {it.display == value }
      if (!ret) return Province.valueOf(value)
      return ret
  }

}