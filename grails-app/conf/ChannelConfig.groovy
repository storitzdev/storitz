import org.springframework.security.access.SecurityConfig
import org.springframework.security.web.access.intercept.RequestKey

class ChannelConfig {

  private ChannelConfig() {} // prevent instantiation

  static def getChannelConfig() {
    LinkedHashMap<RequestKey, java.util.Collection<SecurityConfig>> requestMap = new LinkedHashMap<RequestKey, Collection<SecurityConfig>>()

    // resources that can be served over http or https (typically whatever the containing page is served as)
    requestMap.put new RequestKey("/images/**"), [new SecurityConfig("ANY_CHANNEL")]
    requestMap.put new RequestKey("/css/**"), [new SecurityConfig("ANY_CHANNEL")]
    requestMap.put new RequestKey("/js/**"), [new SecurityConfig("ANY_CHANNEL")]
    requestMap.put new RequestKey("/help"), [new SecurityConfig("ANY_CHANNEL")]
    requestMap.put new RequestKey("/favicon.ico"), [new SecurityConfig("ANY_CHANNEL")]
    requestMap.put new RequestKey("/storageSite/detailTotals/**"), [new SecurityConfig("ANY_CHANNEL")]
    requestMap.put new RequestKey("/storageSite/autocompleteSite/**"), [new SecurityConfig("ANY_CHANNEL")]
    requestMap.put new RequestKey("/user/autocompleteUser/**"), [new SecurityConfig("ANY_CHANNEL")]
    requestMap.put new RequestKey("/rentalTransaction/ajax*/**"), [new SecurityConfig("ANY_CHANNEL")]

    // resources that must be served over https
    requestMap.put new RequestKey("/auth/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/admin/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/reports/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    //requestMap.put new RequestKey("/siteLink/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/rentalTransaction/payment/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/rentalTransaction/pay/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/commission/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]

    // resources that must be served over http (basically everything else not already listed above)
    requestMap.put new RequestKey("/**"), [new SecurityConfig("REQUIRES_INSECURE_CHANNEL")] // all other pages should be served over http

    requestMap
  }
}
