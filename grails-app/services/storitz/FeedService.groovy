package storitz

import storitz.constants.CenterShiftVersion
import storitz.constants.FeedType
import com.storitz.*

class FeedService {

  def siteLinkService
  def CShiftService
  def CShift4Service
  def quikStorService
  def exrsService
  def usiService

  boolean transactional = false

  def updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

    switch (storageSiteInstance.source) {

      case "SL":
        siteLinkService.updateSite(storageSiteInstance, stats, writer)
        break

      case "CS3":
        CShiftService.updateSite(storageSiteInstance, stats, writer)
        break

      case "QS":
        quikStorService.updateSite(storageSiteInstance, stats, writer)
        break

      case "EX":
        exrsService.updateSite(storageSiteInstance, stats, writer)
        break

      case "USI":
        usiService.updateSite(storageSiteInstance, stats, writer)
        break

      case "CS4":
        CShift4Service.updateSite(storageSiteInstance, stats, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

    switch (storageSiteInstance.source) {

      case "SL":
        siteLinkService.updateUnits(storageSiteInstance, stats, writer)
        break

      case "CS3":
        CShiftService.updateUnits(storageSiteInstance, stats, writer)
        break

      case "QS":
        quikStorService.updateUnits(storageSiteInstance, stats, writer)
        break

      case "EX":
        exrsService.updateUnits(storageSiteInstance, stats, writer)
        break

      case "USI":
        usiService.updateUnits(storageSiteInstance, stats, writer)
        break

      case "CS4":
        CShift4Service.updateUnits(storageSiteInstance, stats, writer)
        break


      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshPromos(StorageSite storageSiteInstance, PrintWriter writer) {

    switch (storageSiteInstance.source) {

      case "SL":
        def siteLink = (SiteLink) storageSiteInstance.feed
        siteLinkService.getPromos(siteLink, storageSiteInstance, writer)
        break

      case "CS3":
        def centerShift = (CenterShift) storageSiteInstance.feed
        CShiftService.loadPromos(centerShift, storageSiteInstance, writer)
        break

      case "QS":
        def quikStor = (QuikStor) storageSiteInstance.feed
        quikStorService.loadPromos(quikStor, storageSiteInstance, writer)
        break

      case "EX":
        def centerShift = (CenterShift) storageSiteInstance.feed
        exrsService.loadPromos(centerShift, storageSiteInstance, writer)
        break

      case "USI":
        def centerShift = (CenterShift) storageSiteInstance.feed
        usiService.loadPromos(centerShift, storageSiteInstance, writer)
        break

      case "CS4":
        def centerShift = (CenterShift) storageSiteInstance.feed
        CShift4Service.loadPromos(centerShift, storageSiteInstance, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshPhones(StorageSite storageSiteInstance, PrintWriter writer) {

    switch (storageSiteInstance.source) {

      case "SL":
        def siteLink = (SiteLink) storageSiteInstance.feed
        siteLinkService.addPhones(siteLink, storageSiteInstance, writer)
        break

      case "CS3":
        def centerShift = (CenterShift) storageSiteInstance.feed
        CShiftService.addSitePhone(centerShift, storageSiteInstance, writer)
        break

      case "QS":
        def quikStor = (QuikStor) storageSiteInstance.feed
        quikStorService.addSitePhone(quikStor, storageSiteInstance, writer)
        break

      case "EX":
        def centerShift = (CenterShift) storageSiteInstance.feed
        exrsService.addSitePhone(centerShift, storageSiteInstance, writer)
        break

      case "USI":
        def centerShift = (CenterShift) storageSiteInstance.feed
        usiService.addSitePhone(centerShift, storageSiteInstance, writer)
        break

      case "CS4":
        def centerShift = (CenterShift) storageSiteInstance.feed
        CShift4Service.addSitePhone(centerShift, storageSiteInstance, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshInsurance(Feed feed) {
    switch (feed.feedType) {

      case FeedType.SITELINK:
        siteLinkService.refreshInsurance(feed)
        break

      case FeedType.CENTERSHIFT:
        CenterShift cshift = (CenterShift) feed
        if (cshift.cshiftVersion == CenterShiftVersion.CS3) {
          CShiftService.refreshInsurance(feed)
        } else {
          CShift4Service.refreshInsurance(feed)
        }
        break

      case FeedType.QUIKSTOR:
        quikStorService.refreshInsurance(feed)
        break

      default:
        throw new Exception("Unknown service for insurance refresh")
    }
  }
}
