package storitz

/**
 * Wraps a latitude/longitude.
 */
class Point {
    public BigDecimal lat;
    public BigDecimal lng;

    public Point(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
