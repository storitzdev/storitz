import StorageSite
import com.storagetech.geoip.GeoIp
import grails.converters.JSON
import org.hibernate.FetchMode as FM

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
        if (params.searchSize) {
          fetchMode('units', FM.EAGER)
          units {
            unitsize {
              eq("id", Long.parseLong(params.searchSize))
            }
          }
        }
        fetchMode('specialOffers', FM.EAGER)
        maxResults(100)
      }

      def sw = new StringWriter()
      sw << "["
      results.eachWithIndex { site, i ->
        sw << "{ \"id\": \"${site.id}\", \"address\":\"${site.address}\", \"address2\":\"${site.address2}\", \"city\":\"${site.city}\", \"state\":\"${site.state}\", \"zipcode\":\"${site.zipcode}\", \"lat\":${site.lat}, \"lng\":${site.lng}, \"title\":\"${site.title}\", \"requiresInsurance\":${site.requiresInsurance}, \"boxesAvailable\":${site.boxesAvailable}, \"freeTruck\":${site.freeTruck}, \"isGate\":${site.isGate}, \"isCamera\":${site.isCamera}, \"isKeypad\":${site.isKeypad}, \"isUnitAlarmed\":${site.isUnitAlarmed}, \"specialOffers\":["
        site.specialOffers.eachWithIndex{ offer, j ->
          sw << "{\"description\":\"${offer.description}\" }"
          if (j < site.specialOffers.size() - 1) {
            sw << ","
          }
        }
        sw << "], \"units\":["
        site.units.eachWithIndex{ unit, j ->
          sw << "{ \"unitsize\":{\"id\":\"${unit.unitsize.id}\"}, \"id\":\"${unit.id}\", \"price\":${unit.price}, \"isUpper\":${unit.isUpper}, \"isDriveup\":${unit.isDriveup}, \"isTempControlled\":${unit.isTempControlled}, \"isInterior\":${unit.isInterior} }"
          if (j < site.units.size() - 1) {
            sw << ","
          }
        }
        sw << "] }"
        if (i < results.size() - 1) {
          sw << ","
        }
      }
      sw << "]"
      render (status: 200, contentType:"application/json", text:"{ features: ${sw.toString()} }")
    }

  def iplocate = {

    def geoLoc

    if (!geoIp) {
      geoIp = new GeoIp(servletContext)
    }

    def loc = geoIp.getLocation(request.getRemoteAddr())

    if (!loc) {
    }
    JSON.use("deep")
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
    JSON.use("deep")
    render (status: 200, contentType:"application/json", text:"{ features: ${results as JSON} }")
  }

}
