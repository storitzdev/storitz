package storitz

import com.storitz.StorageSite
import com.storitz.geoip.GeoIp
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import org.hibernate.FetchMode
import storitz.constants.SearchType
import com.storitz.StorageUnit

class MapService {
  def geoIp;

  boolean transactional = false

  // use the following for the default zoom level on a Google map
  def defaultZoom = 12

  // Any zoom less than this will result in radically large map areas
  // with (potentially) correspondingly large site selection volumes.
  final int zoomMin = 7

  final double R = 3958.761; // mi

  // this is the number of degrees of latitude per pixel at zoom 12
  final BigDecimal constLatPerPixel = 5.992112452678278E-6
  final BigDecimal constLngPerPixel = 0.0003433227539063

  def gundInv(BigDecimal latitude) {
    def radPerDeg = Math.PI / 180.0
    double sin = Math.sin(latitude * radPerDeg)
    return (Math.log((1.0 + sin) / (1.0 - sin)) / 2.0)
  }

  def gund(BigDecimal posy) {
    return Math.atan(Math.sinh(posy)) * (180.0 / Math.PI)
  }

  def calcDistance(lat1, lat2, lng1, lng2) {
    def d = Math.acos(Math.sin(lat1 / 57.2958) * Math.sin(lat2 / 57.2958) +
            Math.cos(lat1 / 57.2958) * Math.cos(lat2 / 57.2958) *
            Math.cos(lng2 / 57.2958 - lng1 / 57.2958)) * R;
    return Math.round(100 * d) / 100;
  }

  def getDimensions(Integer zoom, BigDecimal lat, BigDecimal lng, Integer width, Integer height) {
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

    def latInv = gundInv(lat)
    swLat = gund(latInv - (height / 2) * scale * constLatPerPixel)
    swLng = lng - (width / 2) * scale * constLngPerPixel
    neLat = gund(latInv + (height / 2) * scale * constLatPerPixel)
    neLng = lng + (width / 2) * scale * constLngPerPixel

    return [swLat: swLat, swLng: swLng, neLat: neLat, neLng: neLng]
  }

  def countSites(Long searchSize, SearchType searchType, BigDecimal swLat, BigDecimal swLng, BigDecimal neLat, BigDecimal neLng) {

    def sites = StorageSite.createCriteria()

    return sites.get {
      projections {
        countDistinct("id")
      }
      and {
        between("lat", swLat, neLat)
        between("lng", swLng, neLng)
        eq("disabled", false)
      }
      if (searchSize && searchSize != 1) {
        fetchMode('units', FetchMode.EAGER)
        units {
          unitsize {
            eq("id", new Long(searchSize))
          }
        }
      } else {
        fetchMode('units', FetchMode.EAGER)
        units {
          unitsize {
            eq("searchType", searchType)
          }
        }
      }
    }

  }

  def getSites(Long searchSize, SearchType searchType, BigDecimal swLat, BigDecimal swLng, BigDecimal neLat, BigDecimal neLng) {

    def sites = StorageSite.createCriteria()

    def storageSites = sites.listDistinct {
      and {
        between("lat", swLat, neLat)
        between("lng", swLng, neLng)
        eq("disabled", false)
      }
      //Note: maxResults won't work when combined with FetchMode.EAGER
      //Our goal is to find 20 good matches. We throttle at 50 here to
      //account for sites without applicable units. Note: 50 is almost
      //certainly overkill.
      maxResults(50)

      //fetchMode('units', FetchMode.EAGER)
      //fetchMode('specialOffers', FetchMode.EAGER)
    }

    // We now have all of the sites in this rectangle. Now we need to filter
    // out the ones that do not contain applicable inventory.
    def results = []
    storageSites.each { site ->
        site.units.find { unit ->
            def foundit = false
            if (searchSize && searchSize != 1 && unit.unitsize.id == searchSize && unit.unitCount > 0) {
                results.add(site);
                foundit = true
            }
            else if (unit.unitsize.searchType == searchType && unit.unitCount > 0) {
                results.add(site);
                foundit = true
            }
            foundit // breaks the find loop when true
        }
    }

    return results.unique();
  }

  def getGeoIp(ServletContext servletContext, HttpServletRequest request) {
    def geoLoc

    if (!geoIp) {
      geoIp = new GeoIp(servletContext)
    }

    return geoIp.getLocation(request.getRemoteAddr())

  }

  def optimizeZoom(Long searchSize, SearchType searchType, BigDecimal lat, BigDecimal lng, Integer width, Integer height) {
    def zoom = 11

    def dim = getDimensions(zoom, lat, lng, width, height)
    def count = countSites(searchSize, searchType, dim.swLat, dim.swLng, dim.neLat, dim.neLng)
    if (count > 20) {
      // loop and shrink
      while (count > 20) {
        zoom++
        dim = getDimensions(zoom, lat, lng, width, height)
        count = countSites(searchSize, searchType, dim.swLat, dim.swLng, dim.neLat, dim.neLng)
      }
    } else if (count == 0) {
      // grow
      while (zoom > zoomMin && count == 0) {
        zoom--
        dim = getDimensions(zoom, lat, lng, width, height)
        count = countSites(searchSize, searchType, dim.swLat, dim.swLng, dim.neLat, dim.neLng)
      }
      if (count == 0) {
        zoom = 11
      }
    } else if (count <= 3) {
      // grow up to a couple of notches
      def targetZoom = zoom - 3
      while (zoom > targetZoom && count <= 3) {
        zoom--
        dim = getDimensions(zoom, lat, lng, width, height)
        count = countSites(searchSize, searchType, dim.swLat, dim.swLng, dim.neLat, dim.neLng)
      }
      if (count == 1) {
        zoom = 11
      }
    }
    return zoom
  }

}
