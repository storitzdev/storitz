import javax.servlet.http.Cookie

import storitz.CookieCodec

class GlobalFilters {

   public static String LANDING_COOKIE_NAME = 'LANDING'

   def filters = {
       // Match anywhere for now.  There are some we could ignore (like AJAX and /admin).
       landingCookie(uri:'/**') {
           before = {
               Cookie landingCookie
               def cookieJar = request.cookies.grep { it.name == LANDING_COOKIE_NAME }
               if (cookieJar) {
                   landingCookie = cookieJar[0]
               } else {
                   // request.forwardURI is the browser's original request URI (before forwarding etc).
                   Map ingredients = [landing:request.forwardURI, time:new Date(), referrer:request.getHeader('Referer')]
                   landingCookie = new Cookie(LANDING_COOKIE_NAME, CookieCodec.encodeCookieValue(ingredients))
                   landingCookie.path = '/'
                   landingCookie.maxAge = 604800  // A week in seconds
                   response.addCookie(landingCookie)
               }
               params.cookieValue = landingCookie.value
           }
       }
   }
}
