package storitz

import org.bouncycastle.util.encoders.UrlBase64
import java.util.regex.Matcher
import java.util.regex.Pattern

class CookieCodec
{

  public static String encodeCookieValue(Map m)
  {
    StringBuilder sb = new StringBuilder()

    m.each { k, v ->
      sb.append(k)
      sb.append('<')
      byte[] bytes = (v as String).getBytes('UTF-8')
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
      result[m.group(1)] = new String(UrlBase64.decode(m.group(2).getBytes('UTF-8')), 'ISO-8859-1')
    }

    result
  }
}
