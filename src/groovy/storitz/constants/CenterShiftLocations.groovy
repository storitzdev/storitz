package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Aug 30, 2010
 * Time: 2:23:41 PM
 * To change this template use File | Settings | File Templates.
 */
public enum CenterShiftLocations {
  SLC("Salt Lake City", "https://host01slc.centershift.com/pxi/kiosks/csKiosk.WSDL", "https://host05slc.centershift.com/DoD_CallCenter/csCallCenterService.asmx"),
  DEN("Denver", "https://host02den.centershift.com/pxi/kiosks/csKiosk.wsdl", "https://host02den.centershift.com/pxi/DODCallCenter/csCallCenterService.asmx");

  final String display
  final String kioskUrl
  final String webUrl

  CenterShiftLocations(String display, String kioskUrl, String webUrl) {
    this.display = display
    this.kioskUrl = kioskUrl
    this.webUrl = webUrl
  }

  public getValue() { return display; }

  static list() {
    [SLC, DEN]
  }

  static public CenterShiftLocations getEnumFromId(String value) {
        list().find {it.display == value }
    }

}