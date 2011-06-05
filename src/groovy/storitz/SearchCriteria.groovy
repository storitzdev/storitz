package storitz

import storitz.constants.SearchType
import storitz.constants.State
import storitz.constants.QueryMode

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
    public String city;
    public State state;
    public QueryMode queryMode;

    public SearchCriteria() {
        // we'll just re-use these pseudo-singletons
        this.centroid = new Point(null, null);
        this.bounds = new Bounds(new Point(null, null), new Point(null, null));
    }

    /**
     * Used to determine the minimum number of available units that a site must
     * have to be included in the result set. This is done based on the "query mode":
     * When we are in "browse" mode (used esp on the site browse tree, e.g.
     * storitz.com/chino-ca-self-storage or storitz.com/new-york-ny-10036-self-storage
     * then we want to display all facilities); when we are in "search mode"
     * we only care about sites that actually have at least 1 rentable unit.
     *
     * TODO: Decide if this method really belongs here. It seems out of place.
     */
    public Integer minInventory() {
      Integer minInventory;
      switch (queryMode) {
        case QueryMode.BROWSE_CITY:
        case QueryMode.BROWSE_NEIGHBORHOOD:
        case QueryMode.BROWSE_ZIP:
          minInventory = 0;
          break;
        default:
          minInventory = 1;
      }
      return minInventory;
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

    // Any zoom less than this will result in radically large map areas
    // with (potentially) correspondingly large site selection volumes.
    private final int zoomMin = 7

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

