package storitz

import com.storitz.StorageSize

class HomeController {

    def mapService
    def geocodeService


    def index = {

      def lat
      def lng

      if (params.address) {
        def geoResult = geocodeService.geocode(params.address)

        if (geoResult.Placemark) {
          lng = geoResult.Placemark[0].Point.coordinates[0]
          lat = geoResult.Placemark[0].Point.coordinates[1]
        } else {
          def loc = mapService.getGeoIp(servletContext, request)

          lat = loc.latitude
          lng = loc.longitude
        }

      } else {
        // get IP to geo
        def loc = mapService.getGeoIp(servletContext, request)

        lat = loc.latitude
        lng = loc.longitude
      }
      
      // optimize zoom level
      def zoom = mapService.optimizeZoom(params.searchSize as Integer, lat, lng, 650, 321)

      def dim = mapService.getDimensions(zoom, lat, lng, 650, 321)

      def sites = mapService.getSites(params.searchSize as Integer, dim.swLat, dim.swLng, dim.neLat, dim.neLng)

      println "searchSize = ${params.searchSize}, zoom=${zoom}, lat = ${lat}, lng = ${lng}, site=${sites.dump()}"

      // get results for the set

      [ sizeList: StorageSize.list(params), title:"Storitz self-storage search results${params.address ? ' in ' + params.address : ''}", zoom:zoom, lat:lat, lng:lng, searchSize: (params.searchSize ? params.searchSize : 1), sites: sites]
    }
}
