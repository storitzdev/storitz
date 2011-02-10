package storitz.constants

public enum TransactionType {
  RENTAL("Rental"),
  RESERVATION("Reservation")

  final String display;

  TransactionType(String display) { this.display = display; }

  String getValue() {
    return this.display;
  }

  static list() {
      [RENTAL, RESERVATION]
  }

  static public TransactionType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return SpecialOfferRestrictionType.valueOf(value)
    return ret
  }
}