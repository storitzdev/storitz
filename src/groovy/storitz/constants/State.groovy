package storitz.constants

public enum State {
  NONE("--", "--"),
  ALABAMA("AL", "Alabama"),
  ALASKA("AK", "Alaska"),
  AMERICAN_SAMOA("AS", "American Samoa"),
  ARIZONA("AZ", "Arizona"),
  ARKANSAS("AR", "Arkansas"),
  CALIFORNIA("CA", "California"),
  COLORADO("CO", "Colorado"),
  CONNECTICUT("CT", "Connecticut"),
  DELAWARE("DE", "Delaware"),
  DISTRICT_OF_COLUMBIA("DC", "District of Columbia"),
  FEDERATED_STATES_OF_MICRONESIA("FM", "Federated States of Micronesia"),
  FLORIDA("FL", "Florida"),
  GEORGIA("GA", "Georgia"),
  GUAM("GU", "Guam"),
  HAWAII("HI", "Hawaii"),
  IDAHO("ID", "Idaho"),
  ILLINOIS("IL", "Illinois"),
  INDIANA("IN", "Indiana"),
  IOWA("IA", "Iowa"),
  KANSAS("KS", "Kansas"),
  KENTUCKY("KY", "Kentucky"),
  LOUISIANA("LA", "Louisiana"),
  MAINE("ME", "Maine"),
  MARSHALL_ISLANDS("MH", "Marshall Islands"),
  MARYLAND("MD", "Maryland"),
  MASSACHUSETTS("MA", "Massachusetts"),
  MICHIGAN("MI", "Michigan"),
  MINNESOTA("MN", "Minnesota"),
  MISSISSIPPI("MS", "Mississippi"),
  MISSOURI("MO", "Missouri"),
  MONTANA("MT", "Montana"),
  NEBRASKA("NE", "Nebraska"),
  NEVADA("NV", "Nevada"),
  NEW_HAMPSHIRE("NH", "New Hampshire"),
  NEW_JERSEY("NJ", "New Jersey"),
  NEW_MEXICO("NM", "New Mexico"),
  NEW_YORK("NY", "New York"),
  NORTH_CAROLINA("NC", "North Carolina"),
  NORTH_DAKOTA("ND", "North Dakota"),
  NORTHERN_MARIANA_ISLANDS("MP", "Northern Mariana Islands"),
  OHIO("OH", "Ohio"),
  OKLAHOMA("OK", "Oklahoma"),
  OREGON("OR", "Oregon"),
  PALAU("PW", "Palau"),
  PENNSYLVANIA("PA", "Pennsylvania"),
  PUERTO_RICO("PR", "Puerto Rico"),
  RHODE_ISLAND("RI", "Rhode Island"),
  SOUTH_CAROLINA("SC", "South Carolina"),
  SOUTH_DAKOTA("SD", "South Dakota"),
  TENNESSEE("TN", "Tennessee"),
  TEXAS("TX", "Texas"),
  UTAH("UT", "Utah"),
  VERMONT("VT", "Vermont"),
  VIRGIN_ISLANDS("VI", "Virgin Islands"),
  VIRGINIA("VA", "Virgina"),
  WASHINGTON("WA", "Washington"),
  WEST_VIRGINIA("WV", "West Virginia"),
  WISCONSIN("WI", "Wisconsin"),
  WYOMING("WY", "Wyoming"),
  Armed_Forces_Africa("AE", "Armed Forces Africa"),
  Armed_Forces_Americas("AA", "Armed Forces Americas"),
  Armed_Forces_Canada("AE", "Armed Forces Canada"),
  Armed_Forces_Europe("AE", "Armed Forces Europe"),
  Armed_Forces_Middle_East("AE", "Armed Forces Middle East"),
  Armed_Forces_Pacific("AP", "Armed Forces Pacific");

  final String display
  final String fullName

  State(String display, String fullName) {
    this.display = display
    this.fullName = fullName
  }

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

  static listSeo() {
    [
            ALABAMA, ALASKA, AMERICAN_SAMOA, ARIZONA, ARKANSAS, CALIFORNIA, COLORADO,
            CONNECTICUT, DELAWARE, DISTRICT_OF_COLUMBIA, FEDERATED_STATES_OF_MICRONESIA,
            FLORIDA, GEORGIA, GUAM, HAWAII, IDAHO, ILLINOIS, INDIANA, IOWA,
            KANSAS, KENTUCKY, LOUISIANA, MAINE, MARSHALL_ISLANDS, MARYLAND,
            MASSACHUSETTS, MICHIGAN, MINNESOTA, MISSISSIPPI, MISSOURI, MONTANA,
            NEBRASKA, NEVADA, NEW_HAMPSHIRE, NEW_JERSEY, NEW_MEXICO, NEW_YORK,
            NORTH_CAROLINA, NORTH_DAKOTA, NORTHERN_MARIANA_ISLANDS, OHIO,
            OKLAHOMA, OREGON, PALAU, PENNSYLVANIA, PUERTO_RICO, RHODE_ISLAND,
            SOUTH_CAROLINA, SOUTH_DAKOTA, TENNESSEE, TEXAS, UTAH, VERMONT,
            VIRGIN_ISLANDS, VIRGINIA, WASHINGTON, WEST_VIRGINIA, WISCONSIN,
            WYOMING
    ]
  }

  public static State fromText(String key) {
    // JM: 2011-05-31
    // A proper match is something like key = 'FL', which matches against the
    // 2 character display value above. If we get a non alpha character we'll
    // simply strip it out before attempting our search.
    def ret = list().find { it.display.toUpperCase() == key.replaceAll("[\\W]*","").toUpperCase() }

    // However, what if we get something like key = 'West Virginia'? In this case
    // we attempt to match that against the full name. We strip out non alphas on
    // both sides and convert to uppercase to facilitate the matching process.
    if (!ret) ret = list().find { it.fullName.replaceAll("[\\W]*","").toUpperCase() == key.replaceAll("[\\W]*","").toUpperCase() }

    // If that fails too, then we compare the key value to the enumerated value
    if (!ret) ret = State.valueOf(key.toUpperCase())

    return ret
  }

  public static State fromPathParam(String key) {
    return list().find { it.fullName.replaceAll(" ", "-").equalsIgnoreCase(key) }
  }

  public static State getEnumFromId(String value) {
    return State.fromText(value);
  }

}
