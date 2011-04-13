package storitz

import com.edomico.www.*

class EDomicoTests extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testGetToken() {
        EDomicoService service = new EDomicoService()
        def token = service.readToken()
        System.out.println("TOKEN: ${token}")
        assertTrue(token != null)
    }

    void testGetSite() {
        EDomicoService service = new EDomicoService()
        def token = service.readToken()
        def site = service.readSiteID(token,"2227 SAN PABLO AVENUE","OAKLAND","94612")
        System.out.println("SITE: ${site}")
        assertTrue(site != null && site == "BSP")
    }

    void testGetSizes() {
        EDomicoService service = new EDomicoService()
        def token = service.readToken()
        def site = service.readSiteID(token,"2227 SAN PABLO AVENUE","OAKLAND","94612")
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

    void testGetUnitId() {
        EDomicoService service = new EDomicoService()
        def token = service.readToken()
        def site = service.readSiteID(token,"2227 SAN PABLO AVENUE","OAKLAND","94612")
        def sizes = service.readSizes(token,site)
        def sizeID = new Integer(sizes[0].get("SizeID")).intValue()
        def unitID = service.readUnitID(token,site,sizeID)
        System.out.println("UNITID: ${unitID}")
        assertTrue(unitID > 0)
    }

    void testGetUnitInfo() {
        EDomicoService service = new EDomicoService()
        def token = service.readToken()
        def site = service.readSiteID(token, "2227 SAN PABLO AVENUE", "OAKLAND", "94612")
        def sizes = service.readSizes(token, site)
        def count = 0
        for (int i = 0; i < sizes.size(); i++) {
            def sizeID = new Integer(sizes[i].get("SizeID")).intValue()
            def unitInfo = service.readUnitInfo(token, site, sizeID)
            System.out.println("")
            System.out.println("SiteID: " + unitInfo.get('SiteID'))
            System.out.println("SizeID: " + unitInfo.get('SizeID'))
            System.out.println("UnitID: " + unitInfo.get('UnitID'))
            System.out.println("UnitMask: " + unitInfo.get('UnitMask'))
            count++
        }
        assertTrue(count > 0)
    }

    void testGetUnits() {
        EDomicoService service = new EDomicoService()
        def token = service.readToken()
        def site = service.readSiteID(token, "2227 SAN PABLO AVENUE", "OAKLAND", "94612")
        def sizes = service.readSizes(token, site)
        def count = 0
        for (int i = 0; i < sizes.size(); i++) {
            def sizeID = new Integer(sizes[i].get("SizeID")).intValue()
            def units = service.readUnits(token,site,sizeID)
            for (int j = 0; j < units.size(); j++) {
               EDomicoNode un = units[j]
               System.out.println("")
               System.out.println("SiteID: " + un.get("SiteID"))
               System.out.println("SizeID: " + un.get("SizeID"))
               System.out.println("UnitID: " + un.get("UnitID"))
               System.out.println("UnitMask: " + un.get("UnitMask"))
            }
            count++
        }
        assertTrue(count > 0)

    }
}
