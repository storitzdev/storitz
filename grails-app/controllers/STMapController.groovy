import grails.converters.deep.*
import com.storagetech.geoip.*;
import com.maxmind.geoip.Location;

class STMapController {

    def geoIp;

    def index = { }

    def jsonp = {

      def sites = StorageSite.createCriteria()
      def results = sites.listDistinct {
        and {
          between("lat", new java.math.BigDecimal(params.swLat), new java.math.BigDecimal(params.neLat))
          between("lng", new java.math.BigDecimal(params.swLng), new java.math.BigDecimal(params.neLng))
        }
      }
      render (status: 200, contentType:"application/json", text:"{ features: ${results as JSON} }")
    }

  def iplocate = {

    def geoLoc

    if (!geoIp) {
      geoIp = new GeoIp(servletContext)
    }

    def loc = geoIp.getLocation(request.getRemoteAddr())

    if (!loc) {
    }
    render (status:200, contentType:"application/json", text:"${loc as JSON}")
  }

  def nomatchjsonp = {

    def sites = StorageSite.createCriteria()
    def results = sites.listDistinct {
      and {
        between("lat", new java.math.BigDecimal(params.swLat), new java.math.BigDecimal(params.neLat))
        between("lng", new java.math.BigDecimal(params.swLng), new java.math.BigDecimal(params.neLng))
      }
      units {
        size {
          ne("id", new Long(params.sizeId))
        }
      }
    }
    render (status: 200, contentType:"application/json", text:"{ features: ${results as JSON} }")
  }

}
