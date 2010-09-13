package storitz
import groovyx.net.ws.WSClient
import com.storitz.CenterShift

class CShift4Service {

    def cshiftUrl = "https://slc.centershift.com:443/Sandbox40/SWS.asmx?WSDL"
    def proxy
  
    boolean transactional = false

    def getProxy() {
      if (!proxy) {
        proxy = new WSClient(cshiftUrl, this.class.classLoader)
        proxy.initialize() // from 0.5.0
      }
      return proxy
    }

    def getLookupUser(CenterShift cshift) {
      getProxy()
      def lookupUser = proxy.create("com.centershift.store40.LookupUserRequest")
      lookupUser.username = cshift.userName
      lookupUser.password = cshift.pin
      lookupUser.channel = 0
      return lookupUser
    }

    def loadSites(cshift, stats) {
      getProxy()
      def siteListRequest = proxy.create("com.centershift.store40.GetSiteListRequest")
      siteListRequest.orgID = cshift.orgId

      def lookupUser = getLookupUser(cshift)
      def siteList = proxy.GetSiteList(lookupUser, siteListRequest)

      for (site in siteList.details.soagetsitelist) {
        println "retrieved site: ${site.dump()}"
      }
    }

}
