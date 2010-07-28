package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Apr 2, 2010
 * Time: 4:20:20 PM
 * To change this template use File | Settings | File Templates.
 */
public enum State {
  NONE("--"),
  ALABAMA("AL"),
  ALASKA("AK"),
  AMERICAN_SAMOA("AS"),
  ARIZONA("AZ"),
  ARKANSAS("AR"),
  CALIFORNIA("CA"),
  COLORADO("CO"),
  CONNECTICUT("CT"),
  DELAWARE("DE"),
  DISTRICT_OF_COLUMBIA("DC"),
  FEDERATED_STATES_OF_MICRONESIA("FM"),
  FLORIDA("FL"),
  GEORGIA("GA"),
  GUAM("GU"),
  HAWAII("HI"),
  IDAHO("ID"),
  ILLINOIS("IL"),
  INDIANA("IN"),
  IOWA("IA"),
  KANSAS("KS"),
  KENTUCKY("KY"),
  LOUISIANA("LA"),
  MAINE("ME"),
  MARSHALL_ISLANDS("MH"),
  MARYLAND("MD"),
  MASSACHUSETTS("MA"),
  MICHIGAN("MI"),
  MINNESOTA("MN"),
  MISSISSIPPI("MS"),
  MISSOURI("MO"),
  MONTANA("MT"),
  NEBRASKA("NE"),
  NEVADA("NV"),
  NEW_HAMPSHIRE("NH"),
  NEW_JERSEY("NJ"),
  NEW_MEXICO("NM"),
  NEW_YORK("NY"),
  NORTH_CAROLINA("NC"),
  NORTH_DAKOTA("ND"),
  NORTHERN_MARIANA_ISLANDS("MP"),
  OHIO("OH"),
  OKLAHOMA("OK"),
  OREGON("OR"),
  PALAU("PW"),
  PENNSYLVANIA("PA"),
  PUERTO_RICO("PR"),
  RHODE_ISLAND("RI"),
  SOUTH_CAROLINA("SC"),
  SOUTH_DAKOTA("SD"),
  TENNESSEE("TN"),
  TEXAS("TX"),
  UTAH("UT"),
  VERMONT("VT"),
  VIRGIN_ISLANDS("VI"),
  VIRGINIA("VA"),
  WASHINGTON("WA"),
  WEST_VIRGINIA("WV"),
  WISCONSIN("WI"),
  WYOMING("WY"),
  Armed_Forces_Africa("AE"),
  Armed_Forces_Americas("AA"),
  Armed_Forces_Canada("AE"),
  Armed_Forces_Europe("AE"),
  Armed_Forces_Middle_East("AE"),
  Armed_Forces_Pacific("AP");

  final String display

  State(String display) { this.display = display }

  String getValue() {
    return this.display;
  }

  static list() {
    [
            NONE, ALABAMA, ALASKA, AMERICAN_SAMOA, ARIZONA, ARKANSAS, CALIFORNIA, COLORADO,
            CONNECTICUT, DELAWARE, DISTRICT_OF_COLUMBIA, FEDERATED_STATES_OF_MICRONESIA,
            FLORIDA, GEORGIA, GUAM, HAWAII, IDAHO, ILLINOIS, INDIANA, IOWA,
            KANSAS, KENTUCKY, LOUISIANA, MAINE, MARSHALL_ISLANDS, MARYLAND,
            MASSACHUSETTS, MICHIGAN, MINNESOTA, MISSISSIPPI, MISSOURI, MONTANA,
            NEBRASKA, NEVADA, NEW_HAMPSHIRE, NEW_JERSEY, NEW_MEXICO, NEW_YORK,
            NORTH_CAROLINA, NORTH_DAKOTA, NORTHERN_MARIANA_ISLANDS, OHIO,
            OKLAHOMA, OREGON, PALAU, PENNSYLVANIA, PUERTO_RICO, RHODE_ISLAND,
            SOUTH_CAROLINA, SOUTH_DAKOTA, TENNESSEE, TEXAS, UTAH, VERMONT,
            VIRGIN_ISLANDS, VIRGINIA, WASHINGTON, WEST_VIRGINIA, WISCONSIN,
            WYOMING, Armed_Forces_Africa, Armed_Forces_Americas,
            Armed_Forces_Canada, Armed_Forces_Europe, Armed_Forces_Middle_East,
            Armed_Forces_Pacific
    ]
  }

  public static State fromText(String key) {
    return list().find{ it.getValue() == key }
  }

}