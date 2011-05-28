package storitz.constants

public enum TopMetro {

    ALBUQUERQUE("Albuquerque", "NM"),
    ATLANTA("Atlanta", "GA"),
    AUSTIN("Austin", "TX"),
    BAKERSFIELD("Bakersfield", "CA"),
    BALTIMORE("Baltimore", "MD"),
    BRONX("Bronx", "NY"),
    BROOKLYN("Brooklyn", "NY"),
    CHICAGO("Chicago", "IL"),
    COLUMBUS("Columbus", "OH"),
    CORDOVA("Cordova", "TN"),
    CORONA("Corona", "CA"),
    DALLAS("Dallas", "TX"),
    DENVER("Denver", "CO"),
    EL_PASO("El Paso", "TX"),
    FORT_MYERS("Fort Myers", "FL"),
    FORT_WORTH("Fort Worth", "TX"),
    FREDERICKSBURG("Fredericksburg", "VA"),
    GARDENA("Gardena", "CA"),
    HIALEAH("Hialeah", "FL"),
    HONOLULU("Honolulu", "HI"),
    HOUSTON("Houston", "TX"),
    INDIANAPOLIS("Indianapolis", "IN"),
    KNOXVILLE("Knoxville", "TN"),
    LAS_VEGAS("Las Vegas", "NV"),
    LONG_BEACH("Long Beach", "CA"),
    LOS_ANGELES("Los Angeles", "CA"),
    LOUISVILLE("Louisville", "KY"),
    MEMPHIS("Memphis", "TN"),
    MESA("Mesa", "AZ"),
    MIAMI("Miami", "FL"),
    NAPLES("Naples", "FL"),
    NASHVILLE("Nashville", "TN"),
    NORFOLK("Norfolk", "VA"),
    OAKLAND("Oakland", "CA"),
    ORLANDO("Orlando", "FL"),
    PHILADELPHIA("Philadelphia", "PA"),
    PHOENIX("Phoenix", "AZ"),
    PITTSBURGH("Pittsburgh", "PA"),
    RENO("Reno", "NV"),
    RICHMOND("Richmond", "VA"),
    RIVERSIDE("Riverside", "CA"),
    SACRAMENTO("Sacramento", "CA"),
    SAN_ANTONIO("San Antonio", "TX"),
    SAN_BERNARDINO("San Bernardino", "CA"),
    SAN_DIEGO("San Diego", "CA"),
    SAN_FRANCISCO("San Francisco", "CA"),
    STONE_MOUNTAIN("Stone Mountain", "GA"),
    TAMPA("Tampa", "FL"),
    TUCSON("Tucson", "AZ"),
    VANCOUVER("Vancouver", "WA"),
    VIRGINIA_BEACH("Virginia Beach", "VA"),
    WEST_PALM_BEACH("West Palm Beach", "FL"),


    final String city
    final String stateCode

    TopMetro(String city, String stateCode) {
        this.city = city
        this.stateCode = stateCode
  }

    String getPathParam() {
        return this.city.replaceAll(" ", "-").toLowerCase() + "-" + this.stateCode;
    }

    static list() {
        [
                ALBUQUERQUE,
                ATLANTA,
                AUSTIN,
                BAKERSFIELD,
                BALTIMORE,
                BRONX,
                BROOKLYN,
                CHICAGO,
                COLUMBUS,
                CORDOVA,
                CORONA,
                DALLAS,
                DENVER,
                EL_PASO,
                FORT_MYERS,
                FORT_WORTH,
                FREDERICKSBURG,
                GARDENA,
                HIALEAH,
                HONOLULU,
                HOUSTON,
                INDIANAPOLIS,
                KNOXVILLE,
                LAS_VEGAS,
                LONG_BEACH,
                LOS_ANGELES,
                LOUISVILLE,
                MEMPHIS,
                MESA,
                MIAMI,
                NAPLES,
                NASHVILLE,
                NORFOLK,
                OAKLAND,
                ORLANDO,
                PHILADELPHIA,
                PHOENIX,
                PITTSBURGH,
                RENO,
                RICHMOND,
                RIVERSIDE,
                SACRAMENTO,
                SAN_ANTONIO,
                SAN_BERNARDINO,
                SAN_DIEGO,
                SAN_FRANCISCO,
                STONE_MOUNTAIN,
                TAMPA,
                TUCSON,
                VANCOUVER,
                VIRGINIA_BEACH,
                WEST_PALM_BEACH
        ]
    }

    public static TopMetro fromText(String key) {
        return list().find { it.getPathParam() == key.toLowerCase() }
    }

}