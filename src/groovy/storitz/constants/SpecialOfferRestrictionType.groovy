package storitz.constants

public enum SpecialOfferRestrictionType {
  UNIT_TYPE("Unit Type"),
  UNIT_SIZE("Unit Size"),
  OCCUPANCY_RATE("Occupancy Rate"),
  UNIT_AREA("Square Footage"),
  MINIMUM_AVAILABLE("Minimum Available")

  final String display;

  SpecialOfferRestrictionType(String display) { this.display = display; }


  static list() {
      [UNIT_TYPE, UNIT_SIZE, OCCUPANCY_RATE, UNIT_AREA, MINIMUM_AVAILABLE]
  }

  static public SpecialOfferRestrictionType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return SpecialOfferRestrictionType.valueOf(value)
    return ret
  }

}