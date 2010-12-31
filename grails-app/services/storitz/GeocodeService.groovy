package storitz

import grails.converters.JSON

class GeocodeService {

  boolean transactional = false

  def key = 'ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA'


  def geocode(String address) {

    def uri = 'http://maps.googleapis.com/maps/api/geocode/json?address=' + URLEncoder.encode(address, "UTF-8") +
            '&sensor=false'

    JSON.use("deep")
    def url = new URL(uri)
    return JSON.parse(url.text)
  }

  def geocode(double lat, double lng) {
    def uri = "http://maps.googleapis.com/maps/api/geocode/json?latlng=${lat},${lng}&sensor=false"

    JSON.use("deep")
    def url = new URL(uri)
    return JSON.parse(url.text)
  }
}
