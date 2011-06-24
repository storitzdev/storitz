package storitz

import storitz.constants.CenterShiftVersion
import storitz.constants.FeedType
import com.storitz.*
import org.hibernate.SessionFactory
import org.codehaus.groovy.grails.commons.ApplicationHolder

import storitz.service.StorageFeedServiceFactory

class FeedService {

    def sessionFactory
    def siteLinkStorageFeedService
    def cShiftStorageFeedService
    def cShift4StorageFeedService
    def quikStorStorageFeedService
    def propertyInstanceMap = org.codehaus.groovy.grails.plugins.DomainClassGrailsPlugin.PROPERTY_INSTANCE_MAP
    boolean transactional = false

    // the following getXYZService() calls are required to support gant script usage
    SessionFactory getSessionFactory() {
        if (!sessionFactory) {
            sessionFactory = ApplicationHolder.application.mainContext.sessionFactory
        }
        return sessionFactory
    }

    SiteLinkStorageFeedService getSiteLinkService() {
        if (!siteLinkStorageFeedService) {
            siteLinkStorageFeedService = new SiteLinkStorageFeedService()
        }
        return siteLinkStorageFeedService;
    }

    CShiftStorageFeedService getCShiftService() {
        if (!cShiftStorageFeedService) {
            cShiftStorageFeedService = new CShiftStorageFeedService()
        }
        return cShiftStorageFeedService;
    }

    CShift4StorageFeedService getCShift4Service() {
        if (!cShift4StorageFeedService) {
            cShift4StorageFeedService = new CShift4StorageFeedService()
        }
        return cShift4StorageFeedService;
    }

    QuikStorStorageFeedService getQuikStorService() {
        if (!quikStorStorageFeedService) {
            quikStorStorageFeedService = new QuikStorStorageFeedService()
        }
        return quikStorStorageFeedService;
    }

    def clearSession() {
        println("flushing hibernate session...")
        try {
            def session = getSessionFactory().currentSession
            session.flush()
            session.clear()
            propertyInstanceMap.get().clear()
        } catch (Throwable t) {
            t.printStackTrace()
        }
    }

    def updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
        StorageFeedServiceFactory.getFeedServiceInstance(storageSiteInstance).updateSite(storageSiteInstance, stats, writer)
    }

    def updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
        StorageFeedServiceFactory.getFeedServiceInstance(storageSiteInstance).updateUnits(storageSiteInstance, stats, writer)

        // JM: 2011-06-07 Post op processing.
        // bestUnitPrice is pushRate or price, as appropriate.
        // this is used in calls to find BestUnit *only*.
        storageSiteInstance.units.each { unit ->
          if (storageSiteInstance.allowPushPrice)
            unit.bestUnitPrice = unit.pushRate;
          else
            unit.bestUnitPrice = unit.price
          unit.save(flush:true)
        }
    }

    def refreshPromos(StorageSite storageSiteInstance, PrintWriter writer) {
        StorageFeedServiceFactory.getFeedServiceInstance(storageSiteInstance).loadPromos(storageSiteInstance, writer)
    }

    def refreshPhones(StorageSite storageSiteInstance, PrintWriter writer) {
        StorageFeedServiceFactory.getFeedServiceInstance(storageSiteInstance).addSitePhone(storageSiteInstance, writer)
    }

    def refreshInsurance(Feed feed) {
        switch (feed.feedType) {
            case FeedType.SITELINK:
                getSiteLinkService().refreshInsurance(feed)
                break

            case FeedType.CENTERSHIFT:
                CenterShift cshift = (CenterShift) feed
                if (cshift.cshiftVersion == CenterShiftVersion.CS3) {
                    getCShiftService().refreshInsurance(feed)
                } else {
                    getCShift4Service().refreshInsurance(feed)
                }
                break

            case FeedType.QUIKSTOR:
                getQuikStorService().refreshInsurance(feed)
                break

            default:
                throw new Exception("Unknown service for insurance refresh")
        }
    }
}
