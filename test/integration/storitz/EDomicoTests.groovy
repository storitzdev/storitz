package storitz

import com.edomico.www.*
import com.storitz.EDomico

class EDomicoTests extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }
//
//    void testGetToken() {
//        EDomicoStorageFeedService service = new EDomicoStorageFeedService(443,"uBvQoE0DtVTMQA8xCv57A3Rw")
//        def token = service.readToken()
//        System.out.println("TOKEN: ${token}")
//        assertTrue(token != null)
//    }
//
//    void testGetSite() {
//        EDomicoStorageFeedService service = new EDomicoStorageFeedService(443,"uBvQoE0DtVTMQA8xCv57A3Rw")
//        def token = service.readToken()
//        def site = service.readSiteID(token,"2227 SAN PABLO AVENUE","OAKLAND","94612")
//        System.out.println("SITE: ${site}")
//        assertTrue(site != null && site == "BSP")
//    }
//
    void testGetSizes() {
        EDomicoStorageFeedService service = new EDomicoStorageFeedService(400,"Oukm8#Wn36K?7Xx/bKf0IgW!Tm7")
        def token = service.readToken()
        def site = service.readSiteID(token,"21W379 Lake Street","Addison","60101")
        def sizes = service.readSizes(token,site)

        for (int i = 0; i < sizes.size(); i++) {
            def sz = sizes[i]
            System.out.println("")
            System.out.println("SiteID: " + sz.get("SiteID"))
            System.out.println("SizeID: " + sz.get("SizeID"))
            System.out.println("SizeRentRateReservationDeposit: " + sz.get("SizeRentRateReservationDeposit"))
            System.out.println("SizeRentRateSecurityDeposit: " + sz.get("SizeRentRateSecurityDeposit"))
            System.out.println("SizeCodeInfo: " + sz.get("SizeCodeInfo"))
            System.out.println("SizeRentRate: " + sz.get("SizeRentRate"))
            System.out.println("DiscountName: " + sz.get("DiscountName"))
            System.out.println("DiscountValue: " + sz.get("DiscountValue"))
            System.out.println("IsPercent: " + sz.get("IsPercent"))
        }

        assertTrue((sizes != null) && (sizes.size() > 0))
    }
//
//    void testGetUnitId() {
//        EDomicoStorageFeedService service = new EDomicoStorageFeedService(443,"uBvQoE0DtVTMQA8xCv57A3Rw")
//        def token = service.readToken()
//        def site = service.readSiteID(token,"2227 SAN PABLO AVENUE","OAKLAND","94612")
//        def sizes = service.readSizes(token,site)
//        def sizeID = new Integer(sizes[0].get("SizeID")).intValue()
//        def unitID = service.readUnitID(token,site,sizeID)
//        System.out.println("UNITID: ${unitID}")
//        assertTrue(unitID > 0)
//    }
//
//    void testGetUnitInfo() {
//        EDomicoStorageFeedService service = new EDomicoStorageFeedService(443,"uBvQoE0DtVTMQA8xCv57A3Rw")
//        def token = service.readToken()
//        def site = service.readSiteID(token, "2227 SAN PABLO AVENUE", "OAKLAND", "94612")
//        def sizes = service.readSizes(token, site)
//        def count = 0
//        for (int i = 0; i < sizes.size(); i++) {
//            def sizeID = new Integer(sizes[i].get("SizeID")).intValue()
//            def unitInfo = service.readUnitInfo(token, site, sizeID)
//            System.out.println("")
//            System.out.println("SiteID: " + unitInfo.get('SiteID'))
//            System.out.println("SizeID: " + unitInfo.get('SizeID'))
//            System.out.println("UnitID: " + unitInfo.get('UnitID'))
//            System.out.println("UnitMask: " + unitInfo.get('UnitMask'))
//            count++
//        }
//        assertTrue(count > 0)
//    }
//
//    void testGetUnits() {
//        EDomicoStorageFeedService service = new EDomicoStorageFeedService(443,"uBvQoE0DtVTMQA8xCv57A3Rw")
//        def token = service.readToken()
//        def site = service.readSiteID(token, "2227 SAN PABLO AVENUE", "OAKLAND", "94612")
//        def sizes = service.readSizes(token, site)
//        def count = 0
//        for (int i = 0; i < sizes.size(); i++) {
//            def sizeID = new Integer(sizes[i].get("SizeID")).intValue()
//            def units = service.readUnits(token,site,sizeID)
//            for (int j = 0; j < units.size(); j++) {
//               EDomicoNode un = units[j]
//               System.out.println("")
//               System.out.println("SiteID: " + un.get("SiteID"))
//               System.out.println("SizeID: " + un.get("SizeID"))
//               System.out.println("UnitID: " + un.get("UnitID"))
//               System.out.println("UnitMask: " + un.get("UnitMask"))
//            }
//            count++
//        }
//        assertTrue(count > 0)
//    }

     void testLoadFeeds() {
         def feeds = com.storitz.EDomico.findAll()

         for (int i = 0; i < feeds.size(); i++) {
             def feed = feeds[i]
             System.out.println("${feed.edomicoClientID}, ${feed.edomicoWebServicesKey}")
             EDomicoStorageFeedService service = new EDomicoStorageFeedService(feed.edomicoClientID.intValue(),feed.edomicoWebServicesKey)
             def token = service.readToken()
             for (loc in feed.locations) {
                 def site  = service.readSiteID(token,loc.address1,loc.city,loc.zipcode)
                 def sizes = service.readSizes(token,site)
                 for (int k = 0; k < sizes.size(); k++) {
                     def sz = sizes[k]
                     def sizeID = new Integer(sz.get("SizeID")).intValue()
                     def units = service.readUnits(token,site,sizeID)
                     def count = units.size()
                     System.out.println("============================================================================")
                     System.out.println("FEED: ${feed.edomicoClientID}/${feed.edomicoWebServicesKey} [ID=${feed.id}]")
                     System.out.println("LOCATION: ${loc.siteID}/${loc.siteName} [ID=${loc.id}]")
                     System.out.println("          ${loc.address1}")
                     System.out.println("          ${loc.city}, ${loc.zipcode}")
                     System.out.println("SiteID: " + sz.get("SiteID"))
                     System.out.println("SizeID: " + sz.get("SizeID") + " [COUNT=${count}]")
                     System.out.println("SizeRentRateReservationDeposit: " + sz.get("SizeRentRateReservationDeposit"))
                     System.out.println("SizeRentRateSecurityDeposit: " + sz.get("SizeRentRateSecurityDeposit"))
                     System.out.println("SizeCodeInfo: " + sz.get("SizeCodeInfo"))
                     System.out.println("SizeRentRate: " + sz.get("SizeRentRate"))
                     System.out.println("DiscountName: " + sz.get("DiscountName"))
                     System.out.println("DiscountValue: " + sz.get("DiscountValue"))
                     System.out.println("IsPercent: " + sz.get("IsPercent"))

                 }
             }
         }

         assertTrue(true)
     }
}
