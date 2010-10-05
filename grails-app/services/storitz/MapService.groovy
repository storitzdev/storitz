package storitz

import com.storitz.StorageSite
import org.hibernate.FetchMode
import com.storitz.geoip.GeoIp
import javax.servlet.http.HttpServletRequest
import javax.servlet.ServletContext

class MapService {
    def geoIp;


    boolean transactional = false

  // use the following for the default zoom level on a Google map
    def defaultZoom = 12

  // this is the number of degrees of latitude per pixel at zoom 12
    def constLatPerPixel = 3.4332275390624615384615384615385e-4
    def constLngPerPixel = 2.8456457721952647975077881619938e-4

    def getDimensions(Integer zoom, BigDecimal lat, BigDecimal lng, Integer width, Integer height) {
        def swLat
        def swLng
        def neLat
        def neLng

        def scale = Math.pow(2, defaultZoom - zoom)
        swLat = lat - (width / 2)*scale*constLatPerPixel
        swLng = lng - (height / 2)*scale*constLngPerPixel
        neLat = lat + (width / 2)*scale*constLatPerPixel
        neLng = lng + (height / 2)*scale*constLngPerPixel

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

    def getSites(Integer searchSize, BigDecimal swLat, BigDecimal swLng, BigDecimal neLat, BigDecimal neLng) {
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
              eq("id", new Long(searchSize))
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
