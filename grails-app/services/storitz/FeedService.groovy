package storitz

import com.storitz.StorageSite

class FeedService {

  def siteLinkService
  def CShiftService
  
  boolean transactional = false

  def updateSite(StorageSite storageSiteInstance, SiteStats stats) {

    switch(storageSiteInstance.source) {

      case "SL":
        siteLinkService.updateSite(storageSiteInstance, stats)
        break

      case "CS3":
        CShiftService.updateSite(storageSiteInstance, stats)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

  def updateUnits(StorageSite storageSiteInstance, SiteStats stats) {

    switch(storageSiteInstance.source) {

      case "SL":
        siteLinkService.updateUnits(storageSiteInstance, stats)
        break

      case "CS3":
        CShiftService.updateUnits(storageSiteInstance, stats)
        break

      default:
        throw new Exception("Unknown service for site update")
    }
  }

}
