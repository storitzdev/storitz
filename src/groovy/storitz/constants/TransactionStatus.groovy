package storitz.constants

public enum TransactionStatus {
  BEGUN("Begun"),
  XID_CHECK_FAILED("XID check failure"),
  UNIT_UNAVAILABILITY_FAILED("Unit not availabile"),
  DATA_VALIDATION_FAILED("Data validation failure"),
  CREDIT_CARD_FAILED("Credit card failure"),
  PAID("Paid"),
  CANCELED("Canceled"),
  COMPLETE("Complete");

  public final String name;

  TransactionStatus(String name) { this.name = name; }


  static list() {
    [BEGUN, XID_CHECK_FAILED, UNIT_UNAVAILABILITY_FAILED, DATA_VALIDATION_FAILED, CREDIT_CARD_FAILED, PAID, CANCELED, COMPLETE]
  }

  static public TransactionStatus getEnumFromId(String value) {
    list().find {it.name == value }
  }

}