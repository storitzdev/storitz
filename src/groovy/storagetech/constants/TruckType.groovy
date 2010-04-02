package storagetech.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Apr 2, 2010
 * Time: 4:07:21 PM
 * To change this template use File | Settings | File Templates.
 */
public enum TruckType {
  FREE("Free"),
  RENTAL("Rental"),
  NONE("None");

  final String display;

  TruckType(String display) { this.display = display; }


  static list() {
      [FREE, RENTAL, NONE]
  }

}