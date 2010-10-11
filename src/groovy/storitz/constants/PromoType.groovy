package storitz.constants

public enum PromoType {
    AMOUNT_OFF,
    PERCENT_OFF,
    FIXED_RATE;

  static list() {
    [AMOUNT_OFF, PERCENT_OFF, FIXED_RATE]
  }

  static public PromoType getEnumFromId(String value) {
        return PromoType.valueOf(value)
    }

}