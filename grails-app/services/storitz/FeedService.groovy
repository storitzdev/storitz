package storitz

import storitz.constants.CenterShiftVersion
import storitz.constants.FeedType
import com.storitz.*

class FeedService {

  def siteLinkService
  def cShiftService
  def cShift4Service
  def quikStorService
  def exrsService
  def usiService

  boolean transactional = false

  // the following getXYZService() calls are required to support gant script usage

  SiteLinkService getSiteLinkService() {
      if (!siteLinkService) {
          //println ("siteLinkService is null. instantiating...")
          siteLinkService = new SiteLinkService()
      }
      return siteLinkService;
  }

  CShiftService getCShiftService() {
      if (!cShiftService) {
          //println ("cShiftService is null. instantiating...")
          cShiftService = new CShiftService()
      }
      return cShiftService;
  }

  CShift4Service getCShift4Service() {
      if (!cShift4Service) {
          //println ("cShift4Service is null. instantiating...")
          cShift4Service = new CShift4Service()
      }
      return cShift4Service;
  }

  QuikStorService getQuikStorService() {
      if (!quikStorService) {
          //println ("quikStorService is null. instantiating...")
          quikStorService = new QuikStorService()
      }
      return quikStorService;
  }

  ExrsService getExrsService() {
      if (!exrsService) {
          //println ("exrsService is null. instantiating...")
          exrsService = new ExrsService()
      }
      return exrsService;
  }

  UsiService getUsiService() {
      if (!usiService) {
          println ("usiService is null. instantiating...")
          usiService = new UsiService()
      }
      return usiService;
  }

  def updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

    switch (storageSiteInstance.source) {

      case "SL":
        getSiteLinkService().updateSite(storageSiteInstance, stats, writer)
        break

      case "CS3":
        getCShiftService().updateSite(storageSiteInstance, stats, writer)
        break

      case "QS":
        getQuikStorService().updateSite(storageSiteInstance, stats, writer)
        break

      case "EX":
        getExrsService().updateSite(storageSiteInstance, stats, writer)
        break

      case "USI":
        getUsiService().updateSite(storageSiteInstance, stats, writer)
        break

      case "CS4":
        getCShift4Service().updateSite(storageSiteInstance, stats, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

    switch (storageSiteInstance.source) {

      case "SL":
        getSiteLinkService().updateUnits(storageSiteInstance, stats, writer)
        break

      case "CS3":
        getCShiftService().updateUnits(storageSiteInstance, stats, writer)
        break

      case "QS":
        getQuikStorService().updateUnits(storageSiteInstance, stats, writer)
        break

      case "EX":
        getExrsService().updateUnits(storageSiteInstance, stats, writer)
        break

      case "USI":
        getUsiService().updateUnits(storageSiteInstance, stats, writer)
        break

      case "CS4":
        getCShift4Service().updateUnits(storageSiteInstance, stats, writer)
        break


      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshPromos(StorageSite storageSiteInstance, PrintWriter writer) {

    switch (storageSiteInstance.source) {

      case "SL":
        def siteLink = (SiteLink) storageSiteInstance.feed
        getSiteLinkService().getPromos(siteLink, storageSiteInstance, writer)
        break

      case "CS3":
        def centerShift = (CenterShift) storageSiteInstance.feed
        getCShiftService().loadPromos(centerShift, storageSiteInstance, writer)
        break

      case "QS":
        def quikStor = (QuikStor) storageSiteInstance.feed
        getQuikStorService().loadPromos(quikStor, storageSiteInstance, writer)
        break

      case "EX":
        def centerShift = (CenterShift) storageSiteInstance.feed
        getExrsService().loadPromos(centerShift, storageSiteInstance, writer)
        break

      case "USI":
        def centerShift = (CenterShift) storageSiteInstance.feed
        getUsiService().loadPromos(centerShift, storageSiteInstance, writer)
        break

      case "CS4":
        def centerShift = (CenterShift) storageSiteInstance.feed
        getCShift4Service().loadPromos(centerShift, storageSiteInstance, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshPhones(StorageSite storageSiteInstance, PrintWriter writer) {

    switch (storageSiteInstance.source) {

      case "SL":
        def siteLink = (SiteLink) storageSiteInstance.feed
        getSiteLinkService().addPhones(siteLink, storageSiteInstance, writer)
        break

      case "CS3":
        def centerShift = (CenterShift) storageSiteInstance.feed
        getCShiftService().addSitePhone(centerShift, storageSiteInstance, writer)
        break

      case "QS":
        def quikStor = (QuikStor) storageSiteInstance.feed
        getQuikStorService().addSitePhone(quikStor, storageSiteInstance, writer)
        break

      case "EX":
        def centerShift = (CenterShift) storageSiteInstance.feed
        getExrsService().addSitePhone(centerShift, storageSiteInstance, writer)
        break

      case "USI":
        def centerShift = (CenterShift) storageSiteInstance.feed
        getUsiService().addSitePhone(centerShift, storageSiteInstance, writer)
        break

      case "CS4":
        def centerShift = (CenterShift) storageSiteInstance.feed
        getCShift4Service().addSitePhone(centerShift, storageSiteInstance, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
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
