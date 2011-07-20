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
    requestMap.put new RequestKey("/checkout/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/login/auth/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/admin/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/reports/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    //requestMap.put new RequestKey("/siteLink/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/rentalTransaction/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]
    requestMap.put new RequestKey("/commission/**"), [new SecurityConfig("REQUIRES_SECURE_CHANNEL")]

    // Stupid groovy and their IMPLICIT return values.
    // You know, I have absolutely no problem with the last statement of a method being the return value,
    // IF the language does not already have the 'return' keyword. BUT, groovy goes and 
    // does stuff like this implicit return. I come along and delete it (since it LOOKS like
    // an incomplete statement), then next.storitz.com breaks and I waste half a day figuring it out.
    // Rediculous!!! AND, since I just came back from the dentist where I had a crown prepped,
    // my jaw is aching and I have a massive headache, and, you know, this $*!% is just not
    // appreciated. SO, to make a long story short, I am adding an EXPLICIT return to this
    // method so the next fool who gets caught by this 'feature' will have a heads-up.
  
    return requestMap
  }
}
