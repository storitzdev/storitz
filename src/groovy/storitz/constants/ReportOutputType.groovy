package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 24, 2010
 * Time: 2:23:37 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ReportOutputType {
  XLS("Excel", "XLS", "application/vnd.ms-excel"),
  PDF("Adobe PDF", "PDF", "application/pdf"),
  HTML("HTML", "HTML", "text/html")

  final String display
  final String outputType
  final String contentType

  ReportOutputType(display, outputType, contentType) {
    this.display = display
    this.outputType = outputType
    this.contentType = contentType
  }

  public getValue() { return outputType }

  public getDisplay() { return display }

  public getContentType() { return contentType }

  static list() {
    [XLS, PDF, HTML]
  }

  static public ReportOutputType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return ReportOutputType.valueOf(value)
    return ret
  }

}