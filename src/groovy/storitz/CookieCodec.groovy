package storitz

import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import org.bouncycastle.util.encoders.UrlBase64

public class CookieCodec
{

  public static String LANDING_COOKIE_NAME = 'LANDING'

  public static Integer LANDING_COOKIE_TTL = 604800   // A week in seconds

  public static  Cookie bakeLandingCookie(Map ingredients)
  {
    bakeLandingCookie(CookieCodec.encodeCookieValue(ingredients))
  }

  public static  Cookie bakeLandingCookie(String value)
  {
    Cookie landingCookie = new Cookie(LANDING_COOKIE_NAME, value)
    landingCookie.path = '/'
    landingCookie.maxAge = LANDING_COOKIE_TTL

    landingCookie
  }

  public static Cookie getCookie(HttpServletRequest request, String name)
  {
    def cookieJar = request.cookies.grep { it.name == name }
    cookieJar ? (Cookie) cookieJar[0] : null
  }

  public static String encodeCookieValue(Map m)
  {
    StringBuilder sb = new StringBuilder()

    m.each { k, v ->
      sb.append(k)
      sb.append('<')
      // A null will be treated as an empty string.
      byte[] bytes = ((v ?: '') as String).getBytes('UTF-8')
      String s = new String(UrlBase64.encode(bytes), 'ASCII')
      sb.append(s)
      sb.append('>')
    }

    sb.toString()
  }

  static Pattern cookieCutter = ~/(.*?)<(.*?)>/

  public static Map decodeCookieValue(String s)
  {
    Map result = [:]
    Matcher m = cookieCutter.matcher(s)

    while (m.find()) {
      result[(m.group(1))] = new String(UrlBase64.decode(m.group(2).getBytes('UTF-8')), 'ISO-8859-1')
    }
    
    result
  }
}
