package storitz

import com.storitz.StorageSite

class FeedService {

  def siteLinkService
  def CShiftService
  
  boolean transactional = false

  def updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

    switch(storageSiteInstance.source) {

      case "SL":
        siteLinkService.updateSite(storageSiteInstance, stats, writer)
        break

      case "CS3":
        CShiftService.updateSite(storageSiteInstance, stats, writer)
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

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshPromos(StorageSite storageSiteInstance, PrintWriter writer) {

    switch(storageSiteInstance.source) {

      case "SL":
        siteLinkService.getPromos(storageSiteInstance.siteLink, storageSiteInstance, writer)
        break

      case "CS3":
        CShiftService.loadPromos(storageSiteInstance.centerShift, storageSiteInstance, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def refreshPhones(StorageSite storageSiteInstance, PrintWriter writer) {

    switch(storageSiteInstance.source) {

      case "SL":
        siteLinkService.addPhones(storageSiteInstance.siteLink, storageSiteInstance, writer)
        break

      case "CS3":
        CShiftService.addSitePhone(storageSiteInstance.centerShift, storageSiteInstance, writer)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }
}
