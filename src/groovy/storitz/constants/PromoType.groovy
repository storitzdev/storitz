package storitz.constants

public enum PromoType {
    AMOUNT_OFF,
    PERCENT_OFF,
    FIXED_RATE;

  static list() {
    [AMOUNT_OFF, PERCENT_OFF, FIXED_RATE]
  }

  static public TruckType getEnumFromId(String value) {
        list().find {it.value == value }
    }

}