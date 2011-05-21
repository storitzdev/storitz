package storitz

class SearchController {

    def mapService
    def geocodeService
    def costService
    def offerFilterService

    double lat
    double lng
    def zip
    def city
    def state

    boolean handleGeocode(geoResult) {
        if (geoResult && geoResult.status == "OK") {
            lng = geoResult.results[0].geometry.location.lng
            lat = geoResult.results[0].geometry.location.lat
            for (comp in geoResult.results[0].address_components) {
                switch (comp.types[0]) {
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
            return true
        } else {
            def loc = mapService.getGeoIp(servletContext, request)

            lat = loc.latitude
            lng = loc.longitude
            zip = loc.postalCode
            //what was the rationale for not updating city and state too?
            //if (!city) city = loc.city
            //if (!state) state = loc.region
            city = loc.city
            state = loc.region
        }
        return false
    }

}
