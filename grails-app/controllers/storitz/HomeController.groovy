package storitz

import grails.converters.JSON
import java.math.RoundingMode
import storitz.constants.SearchType
import com.storitz.*
import com.storitz.service.CostTotals
import storitz.constants.TopMetro

class HomeController extends SearchController {

  def searchCity

  def index = {
      // get IP to geo
      def loc = mapService.getGeoIp(servletContext, request)

      if (loc) {
          lat = loc.latitude
          lng = loc.longitude
          zip = loc.postalCode
          city = loc.city
          state = loc.region

          if (!zip) {
              BigDecimal qLat = new BigDecimal(lat).setScale(10, RoundingMode.HALF_UP)
              BigDecimal qLng = new BigDecimal(lng).setScale(10, RoundingMode.HALF_UP)
              def geoLookup = GeoLookup.findByLatAndLng(qLat, qLng)
              if (geoLookup) {
                  zip = geoLookup.zip
              } else {
                  def geoResult = geocodeService.geocode(lat, lng)
                  if (handleGeocode(geoResult) && city && state) {
                      new GeoLookup(lat: qLat, lng: qLng, city: city, state: state, zip: zip).save(flush: true)
                  }
              }
          }
      }
      def c = StorageSite.createCriteria()
      def states = []
      def stateCounts = c.list {
        projections {
           groupProperty("state")
           rowCount()
         }
         order("state")
      }
      stateCounts.each { pair ->
          def name = pair[0].fullName
          states << [label: name, path: name.replaceAll(' ', '-').toLowerCase()]
      }
      // TODO: retrieve top metros from database, just like states, once we
      // figure out how to execute this query via GORM/Hibernate:
      //     select city, state from storage_site
      //     group by city, state
      //     having count(1) > 5  -- this is the part i don't know how to do
      //     order by city, state;
      def metros = TopMetro.list()
      [ipGeolocation: loc, states: states, statesPerColumn: StoritzUtil.partition(states, 6, 7), metros: metros, metrosPerColumn: StoritzUtil.partition(metros, 6, 7)]
  }

    // JM 2011-05-10
    // We're getting incoming traffic with address set to null
    // I.E. /?address=null, /?address=null,null, /?address=null%20null, etc
    // This is causing two problems: 1) it looks ugly to see null in the title of the page,
    // and 2) it causes google maps to redirect us to Farmingham, New Mexico, or to Mumbai, India!
    // Scan for 'null' address (not blank, but actually the word 'null) and correct here.
    def removeNullAddress(params) {
        def address = params.address

        // we're good
        if (!address) {
            return params
        }

        // Observed values
        // /?address=null
        // /?address=null,null
        // /?address=null+null
        // /?address=null,null,null
        // /home/alt?address=null,null
        // /home/geoCode?address=null%2Cnull
        // /home/geoCode?address=null%2Cnull%2Cnull
        // /home/geoCode?address=null+null
        // /home/updateMetro?address=null%2Cnull
        // /home/updateMetro?address=null%2Cnull%2Cnull
        // /home/updateMetro?address=null+null

        // %2C translates to ','
        if ('null,null,null'.contains(address)) {
            params.address=null
        }

        // %20 and + translate to ' '
        // Note: I haven't seen this use case except in testing
        if ('null null null'.contains(address)) {
            params.address=null
        }

        return params
    }



  def alt = {
    session['style'] = 'monthly'

    redirect(action:"index")
  }

  def updateMetro = {
    def tempParams = removeNullAddress(params)  // params are read-only!

    def address = tempParams.address
    if (address && address.class.isArray()) {
      address = address.join(' ');
    }

    def geoResult = null
    if (address) {
        geoResult = geocodeService.geocode(address)
    }
    handleGeocode(geoResult)

    def neighborhoodList = null
    def metro

    def metroEntry
    def neighborhood
    if (zip) {
      def entryList = MetroEntry.findAllByZipcode(zip)
      metroEntry = entryList.find { it.city == city }
      if (!metroEntry) {
        metroEntry = entryList.size() > 0 ? entryList[0] : null
      }
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
      neighborhoodList = MetroEntry.findAllByMetro(metro, [sort: "city", order: "asc"]).unique(new MetroEntryComparator())

      List resList = Metro.createCriteria().list() {
        and {
          eq('isNeighborhood', true)
          eq('city', city)
          eq('state', metroEntry.state)
        }
      }
      if (resList.size() > 0) {
        neighborhood = resList.get(0)
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
    render(status: 200, contentType: "application/json", text: "{ \"metro\":${metro as JSON}, \"neighborhoodList\": ${neighborhoodList as JSON}, \"neighborhood\":${neighborhood as JSON} }")

  }

  def changeSearchType = {
    def searchType = params.searchType ? SearchType.getEnumFromId(params.searchType) : SearchType.STORAGE
    def sizeList = StorageSize.createCriteria().list(params) {
      or {
        eq("id", 1L)
        eq("searchType", searchType)
      }
    }

    JSON.use("default")
    render(status: 200, contentType: "application/json", text: sizeList as JSON)
  }

  def geoCode = {
    def tempParams = removeNullAddress(params)   // params are read-only!

    if (tempParams.address) {
      render(status: 200, contentType: "application/json", text: geocodeService.geocode(tempParams.address))
    } else if (params.lat && params.lng) {
      render(status: 200, contentType: "application/json", text: geocodeService.geocode(params.lat as double, params.lng as double))
    }
    render(status: 200, contentType: "application/json", text: '')
  }

  def redirectGeo = {
    // /self-storage-$zip-$city-$state
    response.status = 301
    response.setHeader("Location", g.createLink(mapping: 'geo2', params: [state: params.state, city: StoritzUtil.seoEncode(params.city), zip: params.zip]) as String)
    render("")
    return false
  }

  def redirectMetro = {
    // /self-storage-$city-$state
    response.status = 301
    response.setHeader("Location", g.createLink(mapping: 'metro2', params: [state: params.state, city: StoritzUtil.seoEncode(params.city)]) as String)
    render("")
    return false
  }

}
