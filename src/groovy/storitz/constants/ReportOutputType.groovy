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

  static list() {
    [XLS, PDF, HTML]
  }
}