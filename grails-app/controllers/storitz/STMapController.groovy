package storitz

import com.storitz.StorageSite
import com.storitz.geoip.GeoIp
import grails.converters.JSON
import org.hibernate.FetchMode

class STMapController {

    def webUtilService
    def mapService

    def index = { }

    def countSites = {

      println "zoom = ${params.zoom}, center lat: ${params.lat}, center lng: ${params.lng}, swLat: ${params.swLat}, swLng: ${params.swLng}, neLat: ${params.neLat}, neLng: ${params.neLng}, diff lat: ${(params.lat as BigDecimal) - (params.swLat as BigDecimal)}, diff lng: ${(params.lng as BigDecimal) - (params.swLng as BigDecimal)}"

      def siteCount = mapService.countSites(params.searchSize as Integer, params.swLat as BigDecimal, params.swLng as BigDecimal, params.neLat as BigDecimal, params.neLng as BigDecimal)
      webUtilService.nocache(response)
      render (status: 200, contentType:"application/json", text:"{ siteCount: ${siteCount} }")
    }

    def jsonp = {

      def results = mapService.getSites(params.searchSize as Integer, params.swLat as BigDecimal, params.swLng as BigDecimal, params.neLat as BigDecimal, params.neLng as BigDecimal)

      def unitMap = [:]

      def sw = new StringWriter()
      sw << "[ "
      if (results.size() < 20) {
        results.eachWithIndex { site, i ->
          sw << "{ \"id\": \"${site.id}\", \"address\":\"${site.address}\", \"address2\":\"${site.address2}\", \"city\":\"${site.city}\", \"state\":\"${site.state.display}\", \"zipcode\":\"${site.zipcode}\", \"lat\":${site.lat}, \"lng\":${site.lng}, \"title\":\"${site.title}\", \"requiresInsurance\":${site.requiresInsurance}, \"boxesAvailable\":${site.boxesAvailable}, \"freeTruck\":\"${site.freeTruck}\", \"isGate\":${site.isGate}, \"isCamera\":${site.isCamera}, \"isKeypad\":${site.isKeypad}, \"isUnitAlarmed\":${site.isUnitAlarmed}, \"isManagerOnsite\":${site.isManagerOnsite}, \"hasElevator\":${site.hasElevator}, \"coverImg\":\"${site.coverImage() ? site.coverImage().thumbnail() : ""}\",\"specialOffers\":["
          site.specialOffers().eachWithIndex{ offer, j ->
            sw << "{\"promoName\":\"${offer.promoName}\" }"
            if (j < site.specialOffers().size() - 1) {
              sw << ","
            }
          }
          sw << "], \"featuredOffers\":["
            site.featuredOffers().eachWithIndex{ offer, j ->
              sw << "{\"promoName\":\"${offer.promoName}\" }"
              if (j < site.featuredOffers().size() - 1) {
                sw << ","
              }
          }
          sw << "], \"units\":["
          unitMap.clear()
          site.units.each { unit ->
            def unitType = unit.getUnitTypeLower()
            if (!unitMap[unitType] || unitMap[unitType].price > unit.price) {
              unitMap[unitType] = unit
            }
          }
          unitMap.eachWithIndex{ unitEntry, j ->
            def unit = unitEntry.value
            sw << "{ \"unitsize\":{\"id\":\"${unit.unitsize.id}\"}, \"id\":\"${unit.id}\", \"price\":${unit.price}, \"unitType\":\"${unit.getUnitTypeLower()}\" }"
            if (j < unitMap.size() - 1) {
              sw << ","
            }
          }
          sw << "] }"
          if (i < results.size() - 1) {
            sw << ","
          }
        }
      }
      sw << "]"
      webUtilService.nocache(response)
      render (status: 200, contentType:"application/json", text:"{ siteCount: ${results.size()}, features: ${sw.toString()} }")
    }

  def iplocate = {

    def loc = mapService.getGeoIp(servletContext, request)

    JSON.use("deep")
    render (status:200, contentType:"application/json", text:"${loc as JSON}")
  }

  def nomatchjsonp = {

    def sites = StorageSite.createCriteria()
    def results = sites.listDistinct {
      and {
        between("lat", params.swLat as BigDecimal, params.neLat as BigDecimal)
        between("lng", params.swLng as BigDecimal, params.neLng as BigDecimal)
      }
      units {
        size {
          ne("id", params.sizeId as Long)
        }
      }
    }
    JSON.use("deep")
    render (status: 200, contentType:"application/json", text:"{ features: ${results as JSON} }")
  }

}
