import javax.servlet.http.Cookie

import storitz.CookieCodec
import com.storitz.SEMLocation
import com.storitz.SearchEngineReferral
import storitz.constants.ReferrerType

class GlobalFilters {

   def filters = {
       // Match anywhere for now.  There are some we could ignore (like AJAX and /admin).
       landingCookie(uri:'/**') {
           before = {
               Cookie landingCookie = CookieCodec.getCookie(request, CookieCodec.LANDING_COOKIE_NAME)

               if (landingCookie == null) {

                   def ser = new SearchEngineReferral()
                   ser.landingDate = new Date()
                   ser.isPaid = (params.ref || params.sem_id)
                   // check for sem_id
                   if (params.sem_id) {
                     ser.properties = params
                   }
                   if (params.ref) {
                     // handle paid references
                     ser.referrer = ReferrerType.getEnumFromId(params.ref)
                   } else if (request.getHeader('Referer')) {
                     // handle organic referrer

                     def uri = new URI(request.getHeader('Referer'))
                     def myMap = [:]
                     if (uri.getQuery()) {
                       uri.getQuery().split('&').each{ qp ->
                           def arr = qp.split("=")
                           if (arr.size() > 1) {
                             myMap[(arr[0])] =  arr[1]
                           }
                       }
                       if (uri.getHost().contains('yahoo')) {
                        ser.keyword = myMap['p']
                       } else {
                        ser.keyword = myMap['q']
                       }
                     }
                   }
                   ser.referrerUrl = request.getHeader('Referer')
                   ser.save()

                   // request.forwardURI is the browser's original request URI (before forwarding etc).
                   Map ingredients = [landing:request.forwardURI, time:ser.landingDate, serId: ser.id]

                   landingCookie = CookieCodec.bakeLandingCookie(ingredients)

                   response.addCookie(landingCookie)
               }

               if (params.sem_id) {
                 def locationId = SEMLocation.get(params.location_id as Long)
                 def address = ''
                 if (locationId) {
                   address = "${locationId.city}, ${locationId.state.display}"
                   // Search for "location_id" which will be something like "city, ST" or a zip code.
                 } else if (params.location_id?.size() == 5) {
                   address = params.location_id
                 }
                 // println "Have SEM parameters supplied.  Redirecting to home... address = ${address}"
                 redirect(controller:'home', action:'index', params:[address:address])

                 return false
               }

               return true
           }
       }
   }
}
