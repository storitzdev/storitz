package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 2:23:37 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ReportName {
  BALK("Balk"),
  MOVEIN("Move Ins"),
  PENDING("Pending Move Ins"),
  ACTIVITY("All New Activity"),
  CORP_TRANSACTION("Corporate Commission"),
  CORP_PAYMENT("Corporate Payment"),
  INVOICE("Storitz Invoice")

  final String display
  final String outputType

  ReportName(display) {
    this.display = display
  }

  public getDisplay() { return display }

  static list() {
    [BALK, MOVEIN, PENDING, ACTIVITY, CORP_TRANSACTION, CORP_PAYMENT, INVOICE]
  }

  static public ReportName getEnumFromId(String value) {
        def ret = list().find {it.display == value }
        if (!ret) return ReportName.valueOf(value)
        return ret
    }

}