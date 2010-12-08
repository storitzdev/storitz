package storitz

import com.storitz.StorageSite
import com.storitz.geoip.GeoIp
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import org.hibernate.FetchMode

class MapService {
    def geoIp;

    boolean transactional = false

  // use the following for the default zoom level on a Google map
    def defaultZoom = 12
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
      def d = Math.acos(Math.sin(lat1/57.2958)*Math.sin(lat2/57.2958) +
                  Math.cos(lat1/57.2958)*Math.cos(lat2/57.2958) *
                  Math.cos(lng2/57.2958-lng1/57.2958)) * R;
      return Math.round(100 * d) / 100;
    }

    def getDimensions(Integer zoom, BigDecimal lat, BigDecimal lng, Integer width, Integer height) {
        BigDecimal swLat
        BigDecimal swLng
        BigDecimal neLat
        BigDecimal neLng

        def scale = Math.pow(2, defaultZoom - zoom)
        def latInv = gundInv(lat)
        swLat = gund(latInv - (height/2)*scale*constLatPerPixel)
        swLng = lng - (width / 2)*scale*constLngPerPixel
        neLat = gund(latInv + (height / 2)*scale*constLatPerPixel)
        neLng = lng + (width / 2)*scale*constLngPerPixel

        return [swLat:swLat, swLng:swLng, neLat:neLat, neLng:neLng]
    }

    def countSites(Integer searchSize, BigDecimal swLat, BigDecimal swLng, BigDecimal neLat, BigDecimal neLng) {

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
          }
        }

    }

    def getSites(Long searchSize, BigDecimal swLat, BigDecimal swLng, BigDecimal neLat, BigDecimal neLng) {
      def sites = StorageSite.createCriteria()
      return sites.listDistinct {
        and {
          between("lat", swLat, neLat)
          between("lng", swLng, neLng)
          eq("disabled", false)
        }
        if (searchSize && searchSize != 1) {
          fetchMode('units', FetchMode.EAGER)
          units {
            unitsize {
              eq("id", searchSize)
            }
          }
        }
        fetchMode('specialOffers', FetchMode.EAGER)
      }

    }

    def getGeoIp(ServletContext servletContext, HttpServletRequest request) {
      def geoLoc

      if (!geoIp) {
        geoIp = new GeoIp(servletContext)
      }

      return geoIp.getLocation(request.getRemoteAddr())

    }

    def optimizeZoom(Integer searchSize, BigDecimal lat, BigDecimal lng, Integer width, Integer height) {
      def zoom = 12

      def dim = getDimensions(zoom, lat, lng, width, height)
      def count = countSites(searchSize, dim.swLat, dim.swLng, dim.neLat, dim.neLng)
      if (count > 20) {
        // loop and shrink
        while (count > 20) {
          zoom++
          dim = getDimensions(zoom, lat, lng, width, height)
          count = countSites(searchSize, dim.swLat, dim.swLng, dim.neLat, dim.neLng)
        }
      } else if (count == 0) {
        // grow
        while (zoom > 3 && count == 0) {
          zoom--
          dim = getDimensions(zoom, lat, lng, width, height)
          count = countSites(searchSize, dim.swLat, dim.swLng, dim.neLat, dim.neLng)
        }
        if (count == 0) {
          zoom = 12
        }
      } else if (count == 1) {
        // grow up to a couple of notches
        def targetZoom = zoom - 3
        while(zoom > targetZoom && count == 1) {
          zoom--
          dim = getDimensions(zoom, lat, lng, width, height)
          count = countSites(searchSize, dim.swLat, dim.swLng, dim.neLat, dim.neLng)
        }
        if (count == 1) {
          zoom = 12
        }
      }
      return zoom
    }

}
