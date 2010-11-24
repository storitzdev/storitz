package storitz

import com.storitz.Metro
import com.storitz.MetroEntry
import com.storitz.StorageSize

class HomeController {

  def mapService
  def geocodeService
  def costService

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
          if (params.city) {
            city = params.city
          }
          if (params.state) {
            state = params.state
          }
        } else if (params.address) {
          def address = params.address
          if (params.address.class.isArray()) {
            address = params.address.join(' ');
          }
          geoResult = geocodeService.geocode(address)
        } else {
          geoResult = geocodeService.geocode("${params.city}, ${params.state}")
          city = params.city
          state = params.state

        }

        if (geoResult.Placemark) {
          lng = geoResult.Placemark[0].Point.coordinates[0]
          lat = geoResult.Placemark[0].Point.coordinates[1]
          if (geoResult.Placemark[0].AddressDetails?.Country?.AdministrativeArea?.Locality?.DependentLocality) {
            if (!zip) zip = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.Locality.DependentLocality?.PostalCode?.PostalCodeNumber
            if (!state) state = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.AdministrativeAreaName
            if (!city) city = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.Locality.DependentLocality.DependentLocalityName
          } else if (geoResult.Placemark[0].AddressDetails?.Country?.AdministrativeArea?.SubAdministrativeArea?.Locality) {
            if (!state) state = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.AdministrativeAreaName
            if (!city) city = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality.LocalityName
            if (!zip) zip = geoResult.Placemark[0].AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality?.PostalCode?.PostalCodeNumber
          }

        } else {
          def loc = mapService.getGeoIp(servletContext, request)

          lat = loc.latitude
          lng = loc.longitude
          zip = loc.postalCode
          if (!city) city = loc.city
          if (!state) state = loc.region
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


    def neighborhoodList = null
    def metro

    def metroEntry
    if (zip) {
      metroEntry = MetroEntry.findByZipcode(zip)
    } else if (city && state) {
      def myState
      try {
        myState = storitz.constants.State.getEnumFromId(state)
        metroEntry = MetroEntry.findByCityAndState(city, myState)
      } catch (Exception e) {
        try {
          myState = storitz.constants.Province.getEnumFromId(state)
          metroEntry = MetroEntry.findByCityAndState(city, myState)
        } catch (Exception e2) {}
      }
    }
    if (metroEntry) {
      if (!city) city = metroEntry.city
      if (!state) state = metroEntry.state.display
      metro = metroEntry.metro
      neighborhoodList = MetroEntry.findAllByMetro(metro, [sort:"city", order:"asc"]).unique (new MetroEntryComparator())
    } else {
      if (city && state) {
        def myState
        try {
          myState = storitz.constants.State.getEnumFromId(state)
          metro = Metro.findByCityAndState(city, myState)
        } catch (Exception e) {
          try {
            myState = storitz.constants.Province.getEnumFromId(state)
            metro = Metro.findByCityAndState(city, myState)
          } catch (Exception e2) {}
        }
      }
    }

    def title = "Storitz self-storage search results in ${params.address ? params.address : city + ', ' + state}${zip ? ' postal code ' + zip : ''}"
    // optimize zoom level
    def zoom = mapService.optimizeZoom((params.size ? params.size as Integer : 1), lat, lng, 617, 284)

    def dim = mapService.getDimensions(zoom, lat, lng, 617, 284)

    def searchSize = (params.searchSize && params.searchSize.isNumber() ? params.searchSize as Integer : 1)

    def sites = mapService.getSites(searchSize, dim.swLat, dim.swLng, dim.neLat, dim.neLng).sort{ mapService.calcDistance(lat, it.lat, lng, it.lng)} as List

    def siteMoveInPrice = [:]

    def unitSize
    if (params?.size != 1) {
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
    for (site in sites) {
      def bestUnit
      if (unitSize) {
        bestUnit = site.units.findAll{ it.unitsize.id == unitSize.id }.min{ it.price }
      } else {
        bestUnit = site.units.min{ it.price }
      }
      if (bestUnit) {
        if (site.featuredOffers().size() == 0) {
          def totals = costService.calculateTotals(site, bestUnit, null, null, moveInDate)
          siteMoveInPrice[site.id] = [cost:totals['moveInTotal'], promo:null, promoName:null, monthly:bestUnit?.pushRate, paidThruDate:totals['paidThruDate'], sizeDescription: bestUnit?.unitsize?.description, unitType:bestUnit?.unitType?.display]
        } else {
          for (promo in site.featuredOffers()) {
            def totals = costService.calculateTotals(site, bestUnit, promo, null, moveInDate)
            if (!siteMoveInPrice[site.id] || siteMoveInPrice[site.id].cost > totals['cost']) {
              siteMoveInPrice[site.id] = [cost:totals['moveInTotal'], promo:promo.id, promoName:promo.promoName, monthly:bestUnit?.pushRate, paidThruDate:totals['paidThruDate'], sizeDescription: bestUnit?.unitsize?.description, unitType:bestUnit?.unitType?.display]
            }
          }
        }
      }
    }

    [ sizeList: StorageSize.list(params), title:title, city:city, state:state, zip:zip, neighborhoodList:neighborhoodList, metro:metro, zoom:zoom, lat:lat, lng:lng, searchSize: (params.size? params.size: 1), sites: sites, siteMoveInPrice:siteMoveInPrice]
  }

}