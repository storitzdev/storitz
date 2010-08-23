import javax.servlet.http.Cookie

import storitz.CookieCodec

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

                   println "Setting cookie ${ingredients}"
                 
                   landingCookie = CookieCodec.bakeLandingCookie(ingredients)

                   response.addCookie(landingCookie)
               }

               params.landingCookie = landingCookie.value

               if (params.sem_id) {
                 // Search for "location_id" which will be something like "city, ST" or a zip code.
                 println "Have SEM parameters supplied.  Redirecting to home..."

                 redirect(controller:'home', action:'index', params:[address:params.location_id])

                 return false
               }

               return true
           }
       }
   }
}
