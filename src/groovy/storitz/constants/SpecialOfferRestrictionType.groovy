package storitz.constants

public enum SpecialOfferRestrictionType {
  UNIT_TYPE("Unit Type"),
  OCCUPANCY_RATE("Occupancy Rate"),
  MINIMUM_AVAILABLE("Minimum Available")

  final String display;

  SpecialOfferRestrictionType(String display) { this.display = display; }


  static list() {
      [UNIT_TYPE, OCCUPANCY_RATE, MINIMUM_AVAILABLE]
  }

  static public SpecialOfferRestrictionType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return SpecialOfferRestrictionType.valueOf(value)
    return ret
  }

}