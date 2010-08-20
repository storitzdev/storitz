package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Aug 19, 2010
 * Time: 10:37:51 AM
 * To change this template use File | Settings | File Templates.
 */
public enum CommissionSourceType {
  WEBSITE("Storitz Website"),
  WHITE_LABEL("White Label Product");

  final String display

  CommissionSourceType(display) {
    this.display = display
  }

  def getValue() { return display }

  static list() { [WEBSITE, WHITE_LABEL] }
}