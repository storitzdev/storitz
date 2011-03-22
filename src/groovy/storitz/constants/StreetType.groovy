package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Apr 2, 2010
 * Time: 4:13:21 PM
 * To change this template use File | Settings | File Templates.
 */
public enum StreetType {
  STREET("St."),
  AVENUE("Ave."),
  BOULEVARD("Blvd."),
  DRIVE("Dr."),
  ROAD("Rd."),
  PLACE("Pl."),
  LANE("Ln."),
  PARKWAY("Pkwy."),
  ROUTE("Rte."),
  JUNCTION("Jct."),
  HIGHWAY("Hwy."),
  EXPRESSWAY("Expy."),
  MOTORWAY("Mtry."),
  PIKE("Pike"),
  TERRACE("Ter."),
  HEIGHTS("Hgts."),
  WAY("Way");

  final String display;

  StreetType(String display) {
    this.display = display;
  }

  String getValue() {
    return this.display;
  }

  static list() {
    [STREET, AVENUE, BOULEVARD, DRIVE, ROAD, PLACE, LANE, PARKWAY, ROUTE, JUNCTION, HIGHWAY, EXPRESSWAY, MOTORWAY, PARKWAY, TERRACE, HEIGHTS, WAY]
  }

  static public StreetType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return StreetType.valueOf(value)
    return ret
  }

}