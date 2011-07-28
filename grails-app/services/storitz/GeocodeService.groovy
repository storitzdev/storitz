package storitz

import grails.converters.JSON
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.bouncycastle.util.encoders.UrlBase64
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.codehaus.groovy.grails.web.json.JSONElement

class GeocodeService {

  boolean transactional = false

  static String keyString = 'J3Nopobjuhb22dBD7XoE3fktDOE='
  static key = UrlBase64.decode(keyString)
  static String clientId = 'gme-storitz'

  def host = 'http://maps.googleapis.com'

  boolean signatureRequired = ConfigurationHolder.config?.storitz?.google?.signatureRequired

  def geocode(String address) {

    def uri = '/maps/api/geocode/json?address=' + URLEncoder.encode(address, "UTF-8") +
            '&sensor=false'

    if (signatureRequired) {
      uri += '&client=' + clientId
      uri = sign(uri)
    }

    JSON.use("deep")
    def url = new URL(host + uri)
    String text = url.text;
    JSONElement e = JSON.parse(text);
    return e;
  }

  def geocode(double lat, double lng) {
    def uri = "/maps/api/geocode/json?latlng=${lat},${lng}&sensor=false"

    if (signatureRequired) {
      uri += '&client=' + clientId
      uri = sign(uri)
    }

    JSON.use("deep")
    def url = new URL(host + uri)
    return JSON.parse(url.text)
  }

  private String sign(String uri) {

    Mac mac = Mac.getInstance("HmacSHA1");
    SecretKeySpec secret = new SecretKeySpec(key, mac.getAlgorithm());
    mac.init(secret);
    byte[] digest = mac.doFinal(uri.getBytes());

    String signature = new String(UrlBase64.encode(digest)).replace('+', '-').replace('/', '_')
    return uri + '&signature=' + signature;
  }
}
