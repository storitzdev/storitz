package storitz

import com.storitz.CenterShift
import com.storitz.SiteLink
import com.storitz.StorageSite
import com.storitz.QuikStor

class FeedService {

  def siteLinkService
  def CShiftService
  def quikStorService
  
  boolean transactional = false

  def updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

    switch(storageSiteInstance.source) {

      case "SL":
        siteLinkService.updateSite(storageSiteInstance, stats, writer)
        break

      case "CS3":
        CShiftService.updateSite(storageSiteInstance, stats, writer)
        break

      case "QS":
        quikStorService.updateSite(storageSiteInstance, stats, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

    switch(storageSiteInstance.source) {

      case "SL":
        siteLinkService.updateUnits(storageSiteInstance, stats, writer)
        break

      case "CS3":
        CShiftService.updateUnits(storageSiteInstance, stats, writer)
        break

      case "QS":
        quikStorService.updateUnits(storageSiteInstance, stats, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshPromos(StorageSite storageSiteInstance, PrintWriter writer) {

    switch(storageSiteInstance.source) {

      case "SL":
        def siteLink = (SiteLink)storageSiteInstance.feed
        siteLinkService.getPromos(siteLink, storageSiteInstance, writer)
        break

      case "CS3":
        def centerShift = (CenterShift)storageSiteInstance.feed
        CShiftService.loadPromos(centerShift, storageSiteInstance, writer)
        break

      case "QS":
        def quickStor = (QuikStor)storageSiteInstance.feed
        quikStorService.loadPromos(quickStor, storageSiteInstance, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshPhones(StorageSite storageSiteInstance, PrintWriter writer) {

    switch(storageSiteInstance.source) {

      case "SL":
        def siteLink = (SiteLink)storageSiteInstance.feed
        siteLinkService.addPhones(siteLink, storageSiteInstance, writer)
        break

      case "CS3":
        def centerShift = (CenterShift)storageSiteInstance.feed
        CShiftService.addSitePhone(centerShift, storageSiteInstance, writer)
        break

      case "QS":
        def quickStor = (QuikStor)storageSiteInstance.feed
        quikStorService.addSitePhone(quikStor, storageSiteInstance, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }
}
