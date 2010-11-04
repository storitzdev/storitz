package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Jun 21, 2010
 * Time: 11:17:37 PM
 * To change this template use File | Settings | File Templates.
 */
public enum TransactionStatus {
  BEGUN("Begun"),
  PAID("Paid"),
  CANCELED("Canceled"),
  COMPLETE("Complete");

  final String display;

  TransactionStatus(String display) { this.display = display; }


  static list() {
      [BEGUN, PAID, COMPLETE]
  }

  static public TransactionStatus getEnumFromId(String value) {
        list().find {it.display == value }
    }

}