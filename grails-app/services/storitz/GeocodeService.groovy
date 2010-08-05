package storitz

import grails.converters.JSON

class GeocodeService {

  boolean transactional = false

  def key = 'ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA'


  def geocode(String address) {

    def uri = 'http://maps.google.com/maps/geo?q=' + URLEncoder.encode(address, "UTF-8") +
            '&sensor=false&output=json' +
            '&key=' + key

    JSON.use("deep")
    def url = new URL(uri)
    return JSON.parse(url.text)
  }
}
