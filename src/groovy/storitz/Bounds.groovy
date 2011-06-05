package storitz

/**
 * Wraps a pair of Points representing the southwest and northeast corners of a bounding box.
 */
class Bounds {
    public Point sw;
    public Point ne;

    public Bounds(Point sw, Point ne) {
        this.sw = sw;
        this.ne = ne;
    }
    public static Bounds fromDimensions(LinkedHashMap<String, BigDecimal> dimensions) {
        return new Bounds(new Point(dimensions.get("swLat"), dimensions.get("swLng")),
                          new Point(dimensions.get("neLat"), dimensions.get("neLng")));
    }

}
