import javax.servlet.http.Cookie

import storitz.CookieCodec
import com.storitz.SEMLocation

class GlobalFilters {

   def filters = {
       // Match anywhere for now.  There are some we could ignore (like AJAX and /admin).
       landingCookie(uri:'/**') {
           before = {
               Cookie landingCookie = CookieCodec.getCookie(request, CookieCodec.LANDING_COOKIE_NAME)

               if (landingCookie == null) {
                   // request.forwardURI is the browser's original request URI (before forwarding etc).
                   Map ingredients = [landing:request.forwardURI, time:new Date(), referrer:request.getHeader('Referer')]

                   // Is this a SEM referral?
                   if (params.sem_id) {
                     ingredients += [sem_id:params.sem_id, ts_code:params.ts_code, match_type:params.match_type
                        , location_id:params.location_id, ad_id:params.ad_id, keyword:params.keyword]
                   }

                   // println "Setting cookie ${ingredients}"
                 
                   landingCookie = CookieCodec.bakeLandingCookie(ingredients)

                   response.addCookie(landingCookie)
               }

               params.landingCookie = landingCookie.value

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
