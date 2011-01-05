package storitz

import com.storitz.Metro
import com.storitz.MetroEntry
import com.storitz.StorageSize
import grails.converters.JSON

class HomeController {

  def mapService
  def geocodeService
  def costService
  def lat
  def lng
  def zip
  def searchCity
  def city
  def state

  def index = {


    def geoResult
    def zipSearch = (params.zip || params.zipSearch)

    if (params.zip || params.address || (params.city && params.state)) {

        if (params.zip) {
          geoResult = geocodeService.geocode(params.zip)
          zip = params.zip
          if (params.city) {
            city = params.city.replaceAll('-', ' ')
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
          searchCity = city = params.city.replaceAll('-', ' ')
          state = params.state

        }
        handleGeocode(geoResult)

    } else {
      // get IP to geo
      def loc = mapService.getGeoIp(servletContext, request)

      if (loc) {
        lat = loc.latitude
        lng = loc.longitude
        zip = loc.postalCode
        city = loc.city
        state = loc.region

        if (!zip) {
          geoResult = geocodeService.geocode(lat as double,lng as double)
          handleGeocode(geoResult)
        }
      }
    }
    if (!lat || !lng) {
      lat = 39.8333333
      lng = -98.5833333
    }


    def neighborhoodList = null
    def metro

    def metroEntry
    def neighborhood
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
      if (!zip) zip = metroEntry.zipcode
      
      metro = metroEntry.metro
      neighborhoodList = MetroEntry.findAllByMetro(metro, [sort:"city", order:"asc"]).unique (new MetroEntryComparator())

      neighborhood = Metro.createCriteria().get() {
        and {
          eq('isNeighborhood', true)
          eq('city', metroEntry.city)
          eq('state', metroEntry.state)
        }
      }

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

    def title = "${searchCity && searchCity != city ? searchCity + ' near ' : ''}${params.address ? params.address : city + ', ' + state} Rent Best Price Guaranteed Self Storage - Storitz"
    // optimize zoom level
    def zoom = mapService.optimizeZoom((params.size ? params.size as Integer : 1), lat, lng, 617, 284)

    def dim = mapService.getDimensions(zoom, lat, lng, 617, 284)

    Long searchSize = (params.size && params.size.isNumber() ? params.size as Long : 1)

    def sites = mapService.getSites(searchSize, dim.swLat, dim.swLng, dim.neLat, dim.neLng).sort{ mapService.calcDistance(lat, it.lat, lng, it.lng)} as List

    def siteMoveInPrice = [:]

    def unitSize = null
    if (searchSize != 1) {
      unitSize = StorageSize.get(searchSize)
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
      if (searchSize != 1 && unitSize) {
        bestUnit = site.units.findAll{ it.unitsize.id == unitSize.id && it.unitCount > 0 }.min{ it.price }
      } else {
        bestUnit = site.units.findAll{ it.unitCount > 0 }.min{ it.price }
      }
      if (bestUnit) {
        if (site.featuredOffers().size() == 0) {
          def totals = costService.calculateTotals(site, bestUnit, null, null, moveInDate)
          siteMoveInPrice[site.id] = [cost:totals['moveInTotal'], promo:null, promoName:null, monthly:bestUnit?.price, pushRate:bestUnit?.pushRate, paidThruDate:totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType:bestUnit?.unitType?.display]
        } else {
          def totals = costService.calculateTotals(site, bestUnit, null, null, moveInDate)
          siteMoveInPrice[site.id] = [cost:totals['moveInTotal'], promo:null, promoName:null, monthly:bestUnit?.price, pushRate:bestUnit?.pushRate, paidThruDate:totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType:bestUnit?.unitType?.display]
          for (promo in site.featuredOffers()) {
            totals = costService.calculateTotals(site, bestUnit, promo, null, moveInDate)
            if (siteMoveInPrice[site.id].cost > totals['moveInTotal']) {
              siteMoveInPrice[site.id] = [cost:totals['moveInTotal'], promo:promo.id, promoName:promo.promoName, monthly:bestUnit?.price, pushRate:bestUnit?.pushRate, paidThruDate:totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType:bestUnit?.unitType?.display]
            }
          }
        }
      }
    }

    [ sizeList: StorageSize.list(params), title:title, city:city, searchCity:searchCity, state:state, zip:zip, neighborhoodList:neighborhoodList, metro:metro, neighborhood:neighborhood, zoom:zoom, lat:lat, lng:lng, searchSize: searchSize, sites: sites, siteMoveInPrice:siteMoveInPrice, zipSearch:zipSearch]
  }

  def updateMetro = {

    def geoResult


    def address = params.address
    if (params.address && params.address.class.isArray()) {
      address = params.address.join(' ');
    }

    geoResult = geocodeService.geocode(address)

    handleGeocode(geoResult)

    def neighborhoodList = null
    def metro

    def metroEntry
    def neighborhood
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

      neighborhood = Metro.createCriteria().get() {
        and {
          eq('isNeighborhood', true)
          eq('city', metroEntry.city)
          eq('state', metroEntry.state)
        }
      }

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
    JSON.use("default")
    render (status: 200, contentType:"application/json", text:"{ \"metro\":${metro as JSON}, \"neighborhoodList\": ${neighborhoodList as JSON}, \"neighborhood\":${neighborhood as JSON} }")

  }

  private handleGeocode(geoResult) {
    if (geoResult.results) {
      lng = geoResult.results[0].geometry.location.lng
      lat = geoResult.results[0].geometry.location.lat
      for(comp in geoResult.results[0].address_components) {
        switch(comp.types[0]) {
          case "locality":
            city = comp.long_name
            break
          case "administrative_area_level_1":
            state = comp.short_name
            break
          case "postal_code":
            zip = comp.long_name
            break
        }
      }
    } else {
      def loc = mapService.getGeoIp(servletContext, request)

      lat = loc.latitude
      lng = loc.longitude
      zip = loc.postalCode
      if (!city) city = loc.city
      if (!state) state = loc.region
    }
  }

  def redirectGeo = {
    // /self-storage-$zip-$city-$state
    response.status = 301
    response.setHeader("Location", g.createLink(mapping:'geo2', params:[city:params.city.replaceAll(' ','-'), state:params.state, zip:params.zip]) as String)
    render("")
    return false
  }

  def redirectMetro = {
    // /self-storage-$city-$state
    response.status = 301
    response.setHeader("Location", g.createLink(mapping:'metro2', params:[state:params.state, city:params.city.replaceAll(' ','-')]) as String)
    render("")
    return false
  }

}
