package storitz

import storitz.constants.TopMetro;
import storitz.constants.State;
import com.storitz.GeoLookup;
import storitz.constants.SearchType;
import storitz.constants.QueryMode
import storitz.constants.GeoType
import com.storitz.StoritzUtil
import com.storitz.yelp.Yelp
import com.storitz.yelp.YelpReview
import grails.converters.JSON
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import com.storitz.StorageSite

class SearchController {

    def mapService
    def geocodeService
    def searchService
    def unitSize
    def unitType
    def amenities
    def resultsModel = ['action':"${ConfigurationHolder.config.grails.serverURL}/search"]

    double lat
    double lng
    def address
    def city
    def state
    def zip
    def geoType
    def yelpReviews = []
    def sponsored_site

    def index = {
      def queryTerm = params.where;
      def geoResult = geocodeService.geocode(queryTerm)
      def searchType = params.searchType;
      def searchResult;

      if (handleGeocode(geoResult)) { // N.B, sets a bunch of instance variables
        SearchCriteria criteria = new SearchCriteria();
        criteria.searchType = searchType ? SearchType.getEnumFromId(params.searchType) : SearchType.STORAGE;
        criteria.queryMode = QueryMode.FIND_UNITS;
        criteria.geoType = geoType;
        criteria.centroid.lat = lat;
        criteria.centroid.lng = lng;
        criteria.zip_code = zip;
        criteria.city = city;
        criteria.state = State.fromText(state);
        criteria.searchSize = 0 // Default. Overridden below.

        def sz = searchService.getUnitSize(params.unit_size, criteria.searchType)
        if (sz) {
          unitSize = params.unit_size
          criteria.searchSize = sz.id
        }

        def tp = searchService.getUnitType(params.unit_type)
        if (tp) {
          unitType = params.unit_type
          criteria.unitType = tp
        }

        def am = storitz.StoritzGroovyUtil.parseAmenities(params.amenity)
        if (am.size()) {
          amenities = am
          Boolean t = new Boolean(true);
          for (a in am) {
            if (a.value) criteria.amenities.put(a.key,t)
          }
        }

        searchResult = searchService.findClientSites(criteria);
        genReviews(searchResult.sites);

        //temp code for sponsored site.
        //sponsored_site = StorageSite.get(1732); //placeholder extraspace site.

        resultsModel['where'] = queryTerm
        resultsModel['searchType'] = criteria.searchType
      }
      else {
        resultsModel['where'] = "Unable to determine location"
        searchResult = [sites:[], moveInPrices:[:]]
      }

      [queryTerm: queryTerm, clientSites: searchResult.sites, siteMoveInPrice:searchResult.moveInPrices, lat: lat, lng: lng, unitSize: unitSize, unitType: unitType, amenities: amenities, resultsModel: resultsModel, yelpReviews:yelpReviews]
    }

    def metro = {
      // TODO: Fix to look up city name using seoCity value of StorageSite table; calls to
      // params.city.replaceAll("-", " ") will fail if the city name includes any punctuation
        def aMetro =TopMetro.fromText(params.city + "-" + params.state) // TODO: string-mangling is artifact of when we just passed in params.metro. finish refactoring TopMetro interface to match new 2-param style.
        def queryTerm;
        if (aMetro != null) {
          queryTerm = "${aMetro.city}, ${aMetro.stateCode}"
        }
        else {
          queryTerm = StoritzUtil.titleize(params.city.replaceAll("-", " ")) + ", " + params.state.toUpperCase();
        }
        params.where = queryTerm // required for subsequent searches using from _results.gsp
        def seoDecodedCity = params.city.replaceAll("-", " ").toLowerCase();
        def geoLookup = GeoLookup.findByCityAndState(seoDecodedCity, params.state)
        if (geoLookup) {
            city = geoLookup.city
            state = geoLookup.state
            zip = geoLookup.zip
            lat = geoLookup.lat
            lng = geoLookup.lng

        } else {
            def geoResult = geocodeService.geocode("${seoDecodedCity}, ${params.state}")
            if (handleGeocode(geoResult)) {
                new GeoLookup(lat: lat, lng: lng, city: city, state: state, zip: zip).save(flush: true)
            }
        }
        SearchCriteria criteria = new SearchCriteria();
//        criteria.searchType = SearchType.STORAGE;
        criteria.searchType = params.searchType ? SearchType.getEnumFromId(params.searchType) : SearchType.STORAGE;
        criteria.queryMode = QueryMode.FIND_SITES;
        criteria.geoType = GeoType.CITY;
        criteria.centroid.lat = lat;
        criteria.centroid.lng = lng;
        criteria.city = seoDecodedCity;
        criteria.state = State.fromText(params.state);
        def searchResult = searchService.findClientSites(criteria);
        genReviews(searchResult.sites);

        resultsModel['where']=queryTerm
        [queryTerm: queryTerm, clientSites: searchResult.sites, siteMoveInPrice:searchResult.moveInPrices, lat: lat, lng: lng, unitSize: '', unitType: null, amenities: [:], resultsModel: resultsModel, yelpReviews:yelpReviews]
    }

    def results = {
        render template:"results", contentType: "text/html", model:[queryTerm:"blank", clientSites:[], yelpReviews:yelpReviews]
    }

    // helper function
    private boolean handleGeocode (geoResult) {
      def out = [:]
      def res = searchService.handleGeocode(servletContext,request,geoResult,out)
      if (out['lng'])     lng=out['lng']
      if (out['lat'])     lat=out['lat']
      if (out['city'])    city=out['city']
      if (out['state'])   state=out['state']
      if (out['zip'])     zip=out['zip']
      if (out['address']) address=out['address']
      if (out['type'])    geoType=out['type']
      return res
    }

    private genReviews(results) {
      for (int i=0; i < results.size(); i++) {    //start the yelp request (local search)
        Yelp yelp = Yelp.newInstance();
        def request = yelp.search(results[i].lat, results[i].lng, "")
        def searchResponse = JSON.parse(request)
        def bizTotal = searchResponse.total
        def newResponse
        def review = 0

        if (bizTotal > 0) {   //do a business search
          def bizId = searchResponse.businesses[0].id
          def bizRequest = yelp.search(results[i].lat, results[i].lng, bizId)
          newResponse = JSON.parse(bizRequest)
          review = new YelpReview()
          review.reviewCount = newResponse.review_count
          review.starUrl = newResponse.rating_img_url
        }
        yelpReviews[i] = review
      }
    }
}
