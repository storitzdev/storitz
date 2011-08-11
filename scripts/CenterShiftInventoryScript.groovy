package storitz

import storitz.*
import com.storitz.*

def feeds = CenterShift.findAll()

for (int i = 0; i < feeds.size(); i++) {
  def feed = feeds[i];
  println "OPERATOR: ${feed.operatorName} : ${feed.userName}/${feed.pin} [${feed.location.webUrl}]"

  def sites = StorageSite.findAllByFeed (feed)
  for (int j = 0; j < sites.size(); j++) {
    def site = sites[j]
    println "   SITE: ${site.title} : ${site.sourceId}"

    CShiftStorageFeedService feedService = new CShiftStorageFeedService()
    feedService.init (site)
    def ret = feedService.getSiteUnits (feed.location.webUrl, feed.userName, feed.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def adminFee
    for (unit in records.'soap:Body'.'*:GetSiteUnitDataResponse'.'*:GetSiteUnitDataResult'.'*:SiteUnitData'.'*:Unit') {
      println "      UNIT"
      println "      TOTAL=${unit.TOTAL.text()}"
      println "      VACANT=${unit.VACANT.text()}"
      println "      OCCUPIED_PERCENT=${unit.OCCUPIED_PERCENT.text()}"
      println "      DIMENSIONS=${unit.DIMENSIONS.text()}"
      println "      VALUE=${unit.VALUE.text()}"
      println "      ATTRIBUTES=${unit.ATTRIBUTES.text()}"
      println "      STREET_RATE=${unit.STREET_RATE.text()}"
      println "      ADMIN_FEE=${unit.ADMIN_FEE.text()}"
      println "      TAX_RATE=${unit.TAX_RATE.text()}"
      println "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" // end unit
    }

    println "----------------------------------------------------------------------" // end sites
  }

  println "======================================================================"
  println "======================================================================" // end feeds
}


