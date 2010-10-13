package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 2:23:37 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ReportOutputType {
  XLS("Excel", "XLS"),
  PDF("Adobe PDF", "PDF"),
  HTML("HTML", "HTML")

  final String display
  final String outputType

  ReportOutputType(display, outputType) {
    this.display = display
    this.outputType = outputType
  }

  public getValue() { return outputType }

  public getDisplay() { return display }

  static list() {
    [XLS, PDF, HTML]
  }

  static public ReportOutputType getEnumFromId(String value) {
        def ret = list().find {it.display == value }
        if (!ret) return ReportOutputType.valueOf(value)
        return ret
    }

}