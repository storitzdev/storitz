package storitz

import com.storitz.StorageSize
import com.storitz.MetroEntry

class HomeController {

    def mapService
    def geocodeService


  def index = {

    def lat
    def lng
    def zip
    def city
    def state

    def geoResult

    if (params.zip || params.address || (params.city && params.state)) {

        if (params.zip) {
          geoResult = geocodeService.geocode(params.zip)
          zip = params.zip
        } else if (params.address) {
          geoResult = geocodeService.geocode(params.address)
        } else {
          geoResult = geocodeService.geocode("${params.city}, ${params.state}")
        }

        if (geoResult.Placemark) {
          lng = geoResult.Placemark[0].Point.coordinates[0]
          lat = geoResult.Placemark[0].Point.coordinates[1]
          if (!zip) {
            if (geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.Locality) {
              zip = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.Locality.DependentLocality.PostalCode.PostalCodeNumber
              state = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.AdministrativeAreaName
              city = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.Locality.DependentLocality.DependentLocalityName
            } else if (geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality) {
              state = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.AdministrativeAreaName
              city = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality.LocalityName
              zip = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality?.PostalCode?.PostalCodeNumber
            }
          }

        } else {
          def loc = mapService.getGeoIp(servletContext, request)

          lat = loc.latitude
          lng = loc.longitude
          zip = loc.postalCode
          city = loc.city
          state = loc.region
        }

    } else {
      // get IP to geo
      def loc = mapService.getGeoIp(servletContext, request)

      if (loc) {
        lat = loc.latitude
        lng = loc.longitude
        zip = loc.postalCode
        city = loc.city
        state = loc.region
      }
    }
    if (!lat || !lng) {
      lat = 39.8333333
      lng = -98.5833333
    }

    def title = "Storitz self-storage search results in ${params.address ? params.address : city + ', ' + state}"

    def neighborhoodList
    def metro

    def metroEntry
    if (zip) {
      metroEntry = MetroEntry.findByZipcode(zip)
    } else {
      metroEntry = MetroEntry.findByCityAndState(city, storitz.constants.State.getEnumFromId(state))
    }
    if (metroEntry) {
      city = metroEntry.city
      state = metroEntry.state.display
      metro = metroEntry.metro
      neighborhoodList = MetroEntry.findAllByMetro(metro, [sort:"city", order:"asc"]).unique (new MetroEntryComparator())
    }

    // optimize zoom level
    def zoom = mapService.optimizeZoom(params.searchSize as Integer, lat, lng, 650, 321)

    def dim = mapService.getDimensions(zoom, lat, lng, 650, 321)

    def sites = mapService.getSites(params.searchSize as Integer, dim.swLat, dim.swLng, dim.neLat, dim.neLng).sort{ mapService.calcDistance(lat, it.lat, lng, it.lng)} as List

    [ sizeList: StorageSize.list(params), title:title, city:city, state:state, neighborhoodList:neighborhoodList, metro:metro, zoom:zoom, lat:lat, lng:lng, searchSize: (params.searchSize ? params.searchSize : 1), sites: sites]
  }
}
