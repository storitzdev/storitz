package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 2:23:37 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ReportName {
  MOVEIN("Move Ins"),
  PENDING("Pending Move Ins"),
  ACTIVITY("All New Activity")

  final String display
  final String outputType

  ReportName(display) {
    this.display = display
  }

  public getDisplay() { return display }

  static list() {
    [MOVEIN, PENDING, ACTIVITY]
  }

  static public ReportName getEnumFromId(String value) {
        def ret = list().find {it.display == value }
        if (!ret) return ReportName.valueOf(value)
        return ret
    }

}