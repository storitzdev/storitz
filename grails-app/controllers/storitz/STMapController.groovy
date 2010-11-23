package storitz

import com.storitz.StorageSite
import grails.converters.JSON
import com.storitz.StorageSize

class STMapController {

    def webUtilService
    def mapService
    def costService

    def index = { }

    def countSites = {

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
            def unitType = unit.unitType
            if (!unitMap[unitType] || unitMap[unitType].price > unit.price) {
              unitMap[unitType] = unit
            }
          }
          unitMap.eachWithIndex{ unitEntry, j ->
            def unit = unitEntry.value
            sw << "{ \"unitsize\":{\"id\":\"${unit.unitsize.id}\"}, \"id\":\"${unit.id}\", \"price\":${unit.price}, \"unitType\":\"${unit.unitType}\", \"unitTypeDisplay\":\"${unit.unitType.display}\" }"
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

    def mapresults = {

      def results = mapService.getSites(params.searchSize as Integer, params.swLat as BigDecimal, params.swLng as BigDecimal, params.neLat as BigDecimal, params.neLng as BigDecimal)

      double lat = params.lat as double
      double lng = params.lng as double

      results.sort( {a,b -> mapService.calcDistance(lat, a.lat as double, lng, a.lng as double) <=> mapService.calcDistance(lat, b.lat as double, lng, b.lng as double) } as Comparator)

      def unitMap = [:]

      def unitSize
      if (params?.searchSize != 1) {
        unitSize = StorageSize.get(params.size)
      }
      Date  moveInDate
      if (params.date && params.date instanceof Date) {
        moveInDate = params.date
      } else {
        if (params.date) {
          moveInDate = Date.parse('MM/dd/yy', params.date)
        } else {
          moveInDate = new Date()
        }
      }

      def sw = new StringWriter()
      sw << "[ "
      def row = 0
      for (site in results) {
        row++;
        sw << "{ \"index\":${row}, \"id\": \"${site.id}\", \"address\":\"${site.address}\", \"address2\":\"${site.address2}\", \"city\":\"${site.city}\", \"state\":\"${site.state.display}\", \"zipcode\":\"${site.zipcode}\", \"lat\":${site.lat}, \"lng\":${site.lng}, \"title\":\"${site.title}\", \"requiresInsurance\":${site.requiresInsurance}, \"boxesAvailable\":${site.boxesAvailable}, \"freeTruck\":\"${site.freeTruck}\", \"isGate\":${site.isGate}, \"isCamera\":${site.isCamera}, \"isKeypad\":${site.isKeypad}, \"isUnitAlarmed\":${site.isUnitAlarmed}, \"isManagerOnsite\":${site.isManagerOnsite}, \"hasElevator\":${site.hasElevator}, \"coverImg\":\"${site.coverImage() ? site.coverImage().thumbnail() : ""}\", \"logo\":\"${site.logo ? resource(file:site.logo.src()) : ""}\", "

        def bestUnit
        def unitSiz
        def monthly
        def moveInCost = 100000
        def promoId
        def promoName
        def paidThruDate
        def sizeDescription
        def unitType

        if (unitSize) {
          bestUnit = site.units.findAll{ it.unitsize.id == unitSize.id }.min{ it.price }
        } else {
          bestUnit = site.units.min{ it.price }
        }
        if (bestUnit) {
          if (site.featuredOffers().size() == 0) {
            def totals = costService.calculateTotals(site, bestUnit, null, null, moveInDate)
            monthly = bestUnit.pushRate ? bestUnit.pushRate : bestUnit.price
            unitType = bestUnit?.unitType.display
            sizeDescription = bestUnit?.unitsize.description
            promoId = null
            promoName = null
            moveInCost = totals['moveInTotal']
            paidThruDate = totals['paidThruDate']

          } else {
            for (promo in site.featuredOffers()) {
              def totals = costService.calculateTotals(site, bestUnit, promo, null, moveInDate)
              if (moveInCost > totals['moveInCost']) {
                monthly = bestUnit.pushRate ? bestUnit.pushRate : bestUnit.price
                unitType = bestUnit?.unitType.display
                sizeDescription = bestUnit?.unitsize.description
                promoId = promo.id
                promoName = promo.promoName
                moveInCost = totals['moveInTotal']
                paidThruDate = totals['paidThruDate']
              }
            }
          }
        }
        sw << "\"monthly\": ${monthly}, \"moveInCost\": ${moveInCost}, \"promoId\": ${promoId}, \"promoName\":\"${promoName}\", \"paidThruDate\":\"${paidThruDate}\", \"unitType\":\"${unitType}\", \"sizeDescription\":\"${sizeDescription}\" }"

        if (row < results.size() && row < 20) {
          sw << ","
        }
        if (row >= 20) break
      }
      sw << "]"
      webUtilService.nocache(response)
      render (status: 200, contentType:"application/json", text:"{ \"siteCount\": ${results.size()}, \"features\": ${sw.toString()} }")
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
