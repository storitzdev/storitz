package storitz

import storitz.constants.SearchType
import storitz.constants.State
import storitz.constants.QueryMode
import storitz.constants.GeoType

/**
 * Represents a search for available inventory; contains convenience method for adjusting
 * bounds to match map's zoom level & width/height
 */

class SearchCriteria {
    public SearchType searchType;
    public Long searchSize; // TODO: Make this an enum
    public Point centroid;
    public Bounds bounds;
    public String userQuery;
    public String featuredOfferTag;
    public String neighborhood;
    public String zip_code;
    public String city;
    public State state;
    public QueryMode queryMode;
    public GeoType geoType;

    public SearchCriteria() {
      // defaults
      this.queryMode = QueryMode.FIND_UNITS;
      this.searchType = SearchType.STORAGE;
      // we'll just re-use these pseudo-singletons
      this.centroid = new Point(null, null);
      this.bounds = new Bounds(new Point(null, null), new Point(null, null));
    }

    public void setBounds(Integer zoom, Integer width, Integer height) {
        BigDecimal swLat
        BigDecimal swLng
        BigDecimal neLat
        BigDecimal neLng

        def scale = Math.pow(2, defaultZoom - zoom)

        // JM 2011-05-24
        // Zoom level can get insane if, for example, the user decides to view the
        // entire continent. Add a little sanity check here before moving forward
        if (scale > 32) {
            scale = 32;
        }

        BigDecimal latInv = gundInv(this.centroid.lat)
        swLat = gund(latInv - (height / 2) * scale * constLatPerPixel)
        swLng = this.centroid.lng - (width / 2) * scale * constLngPerPixel
        neLat = gund(latInv + (height / 2) * scale * constLatPerPixel)
        neLng = this.centroid.lng + (width / 2) * scale * constLngPerPixel

        this.bounds.sw.lat = swLat;
        this.bounds.sw.lng = swLng;
        this.bounds.ne.lat = neLat;
        this.bounds.ne.lng = neLng;
    }

    // use the following for the default zoom level on a Google map
    private final int defaultZoom = 12

    // this is the number of degrees of latitude per pixel at zoom 12
    final BigDecimal constLatPerPixel = 5.992112452678278E-6
    final BigDecimal constLngPerPixel = 0.0003433227539063

    private BigDecimal gundInv(BigDecimal latitude) {
        def radPerDeg = Math.PI / 180.0
        double sin = Math.sin(latitude * radPerDeg)
        return (Math.log((1.0 + sin) / (1.0 - sin)) / 2.0)
    }

    private BigDecimal gund(BigDecimal posy) {
        return Math.atan(Math.sinh(posy)) * (180.0 / Math.PI)
    }

}

