package storitz

import static groovyx.net.http.ContentType.JSON
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET

class GeocodeService {

  boolean transactional = false

  def geocode(String address) {
    log.info "looking up geocode location foraddress: $address"
    String results = getLocation([address: address, sensor: 'true'])
    return grails.converters.JSON.parse(results)
  }

  def geocode(double lat, double lng) {
    log.info "looking up geocode location for cordinates: $lat, $lng"
    String results = getLocation([latlng: "$lat,$lng", sensor: 'true'])
    return grails.converters.JSON.parse(results)
  }

  /**
   * Use of the Google Geocoding API is subject to a query limit of 2,500 geolocation requests per day
   * For more information, visit: http://code.google.com/apis/maps/documentation/geocoding/
   * @param address
   * @return
   */
  def getLocation(Map query) {
    def http = new HTTPBuilder("http://maps.googleapis.com")
    try {
      http.request(GET, JSON) {
        uri.path = '/maps/api/geocode/json'
        uri.query = query

        response.success = {resp, json ->
          if(json.status == 'OK') {
            return json
          } else {
            log.warn "google could not find location with query: $query"
            return null
          }
        }
        response.failure = { resp ->
          log.error "location lookup failed for params $query, with response: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
          return null
        }
      }
    } catch(Exception ex) {
      log.error("Exception trying to lookup location using google maps", ex)
    }
  }
}
