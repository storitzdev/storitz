package storitz

import grails.converters.JSON
import java.math.RoundingMode
import storitz.constants.SearchType
import com.storitz.*
import com.storitz.service.CostTotals

class HomeController extends SearchController {

    def searchCity

    def doIndex(params, title) {
       params = removeNullAddress(params)

        def geoResult
        def zipSearch = (params.zip || params.zipSearch)

        if (params.zip || params.address || (params.city && params.state)) {

            if (params.zip) {
                def geoLookup = GeoLookup.findByZip(params.zip)
                if (geoLookup) {
                    if (!params.city || !params.state) {
                        city = geoLookup.city.replaceAll('-', ' ')
                        state = geoLooup.state
                    } else {
                        city = params.city.replaceAll('-', ' ')
                        state = params.state
                    }
                    zip = params.zip
                    lat = geoLookup.lat
                    lng = geoLookup.lng
                } else {
                    geoResult = geocodeService.geocode(params.zip)
                    zip = params.zip
                    if (params.city) {
                        searchCity = city = params.city.replaceAll('-', ' ')
                    }
                    if (params.state) {
                        state = params.state
                    }
                    if (handleGeocode(geoResult)) {
                        new GeoLookup(lat: lat, lng: lng, city: city, state: params.state, zip: zip).save(flush: true)
                    }
                }
            } else if (params.address) {
                def address = params.address
                if (params.address.class.isArray()) {
                    address = params.address.join(' ');
                }
                geoResult = geocodeService.geocode(address)
                handleGeocode(geoResult)
            } else {

                searchCity = city = params.city.replaceAll('-', ' ')
                state = params.state

                def geoLookup = GeoLookup.findByCityAndState(city, state)
                if (geoLookup) {
                    city = geoLookup.city
                    state = geoLookup.state
                    zip = geoLookup.zip
                    lat = geoLookup.lat
                    lng = geoLookup.lng

                } else {
                    geoResult = geocodeService.geocode("${city}, ${state}")
                    if (handleGeocode(geoResult)) {
                        new GeoLookup(lat: lat, lng: lng, city: searchCity, state: state, zip: zip).save(flush: true)
                    }
                }
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

                if (!zip) {
                    BigDecimal qLat = new BigDecimal(lat).setScale(10, RoundingMode.HALF_UP)
                    BigDecimal qLng = new BigDecimal(lng).setScale(10, RoundingMode.HALF_UP)
                    def geoLookup = GeoLookup.findByLatAndLng(qLat, qLng)
                    if (geoLookup) {
                        zip = geoLookup.zip
                    } else {
                        geoResult = geocodeService.geocode(lat, lng)
                        if (handleGeocode(geoResult) && city && state) {
                            new GeoLookup(lat: qLat, lng: qLng, city: city, state: state, zip: zip).save(flush: true)
                        }
                    }
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
            if (!zip) zip = metroEntry.zipcode

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

        def displayTitle
        if (title) {
           displayTitle = title
        }
        else {
           displayTitle = "${searchCity && searchCity != city ? searchCity + ' near ' : ''}${params.address ? params.address : city + ', ' + state}${zipSearch ? ' zip code ' + params.zip : ''} Rent Best Price Guaranteed Self Storage - Storitz"
            if (displayTitle.size() > 70) {
                displayTitle = "${searchCity && searchCity != city ? searchCity + ' near ' : ''}${params.address ? params.address : city + ', ' + state}${zipSearch ? ' zip code ' + params.zip : ''} Self Storage - Storitz"
            }
        }

        def sizeList
        def searchType = SearchType.STORAGE
        if (params.searchType) {
            searchType = SearchType.getEnumFromId(params.searchType)
        }
        sizeList = StorageSize.createCriteria().list(params) {
            or {
                eq("id", 1L)
                eq("searchType", searchType)
            }
        }

        // optimize zoom level
        Long searchSize = (params.size && params.size.isNumber() ? params.size as Long : 1)

        def zoom = mapService.optimizeZoom(searchSize, searchType, lat, lng, 617, 284)

        def dim = mapService.getDimensions(zoom, lat, lng, 617, 284)

        def sites = mapService.getSites(searchSize, searchType, dim.swLat, dim.swLng, dim.neLat, dim.neLng).sort { mapService.calcDistance(lat, it.lat, lng, it.lng)} as List

        def siteMoveInPrice = [:]

        def unitSize = null
        if (searchSize != 1) {
            unitSize = StorageSize.get(searchSize)
        }
        Date moveInDate
        if (params.date && params.date instanceof Date) {
            moveInDate = params.date
        } else {
            if (params.date) {
                moveInDate = Date.parse('MM/dd/yy', params.date)
            } else {
                moveInDate = new Date()
            }
        }

        def today = new Date()
        def moveInDays = moveInDate - today

        /*
        logic:
          find all units with inventory
          for each unit, find the lowest monthly cost
          find the valid offers for that unit
          for each valid offer, find the one that produces the lowest move-in cost
         */

        for (site in sites) {
            if (site.maxReserveDays >= moveInDays) {
                def bestUnit
                Insurance ins = null
                if (site.noInsuranceWaiver) {
                    ins = site.insurances.findAll { it.active }.min { it.premium }
                }
                if (searchSize != 1 && unitSize) {
                    bestUnit = site.units.findAll { it.unitsize.id == unitSize.id && it.unitCount > site.minInventory }.min { it.price }
                } else {
                    bestUnit = site.units.findAll { it.unitCount > site.minInventory }.min { it.price }
                }
                if (bestUnit) {
                    def featuredOffers = offerFilterService.getValidFeaturedOffers(site, bestUnit)
                    if (featuredOffers.size() == 0) {
                        CostTotals totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
                        siteMoveInPrice[site.id] = [cost: totals.moveInTotal, promo: null, promoName: null, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals.paidThruDateString, sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display]
                    } else {
                        CostTotals totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
                        siteMoveInPrice[site.id] = [cost: totals.moveInTotal, promo: null, promoName: null, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals.paidThruDateString, sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display]
                        def oldMoveInCost = siteMoveInPrice[site.id].cost
                        siteMoveInPrice[site.id].cost = 100000
                        for (promo in featuredOffers) {
                            if (!(promo.promoName ==~ /(?i).*(military|senior).*/)) {
                                totals = costService.calculateTotals(site, bestUnit, promo, ins, moveInDate)
                                if (siteMoveInPrice[site.id].cost > totals.moveInTotal) {
                                    siteMoveInPrice[site.id] = [cost: totals.moveInTotal, promo: promo.id, promoName: promo.promoName, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals.paidThruDateString, sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display]
                                }
                            }
                        }
                        if (siteMoveInPrice[site.id].cost == 100000) {
                            siteMoveInPrice[site.id].cost = oldMoveInCost
                        }
                    }
                }
            }
        }

        [sizeList: sizeList, title: displayTitle, city: city, searchCity: searchCity, state: state, zip: zip, neighborhoodList: neighborhoodList, metro: metro, neighborhood: neighborhood, zoom: zoom, lat: lat, lng: lng, searchSize: searchSize, sites: sites, siteMoveInPrice: siteMoveInPrice, zipSearch: zipSearch]
    }

  def index = {
     doIndex(params, null)
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
    response.setHeader("Location", g.createLink(mapping: 'geo2', params: [city: params.city.replaceAll(' ', '-'), state: params.state, zip: params.zip]) as String)
    render("")
    return false
  }

  def redirectMetro = {
    // /self-storage-$city-$state
    response.status = 301
    response.setHeader("Location", g.createLink(mapping: 'metro2', params: [state: params.state, city: params.city.replaceAll(' ', '-')]) as String)
    render("")
    return false
  }

}
