package storitz

import com.storitz.CenterShift
import com.storitz.Feed
import com.storitz.User
import storitz.constants.FeedType

class UsiController extends CshiftController {

  def fileUploadService
  def imageService
  def usiService

  def list = {
    def usiManager = User.findByUsername('ustoreit')
    def usiFeed = (CenterShift) Feed.findByManager(usiManager)
    def feedList = [usiFeed]
    [cshiftInstanceList: feedList, cshiftInstanceTotal: feedList.size()]
  }

  def save = {
    def cshiftInstance = new CenterShift(params)
    cshiftInstance.feedType = FeedType.CENTERSHIFT
    if (cshiftInstance.validate() && cshiftInstance.save(flush: true)) {
      // read in sites
      def stats = new storitz.SiteStats()
      def writer = new PrintWriter(System.out)
      usiService.loadSites(cshiftInstance, "USI", stats, writer)
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
      redirect(action: "show", id: cshiftInstance.id)
    }
    else {
      render(view: "create", model: [cshiftInstance: cshiftInstance])
    }
  }

  def refreshPromos = {
    def writer = new PrintWriter(System.out)
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      for (site in cshiftInstance.sites) {
        for (promo in site.specialOffers) {
          promo.delete()
        }
        site.specialOffers.clear()
        usiService.loadPromos(cshiftInstance, site, writer)
        println "Promos refreshed for ${site.title}"
      }
      flash.message = "Feed promotions refreshed."
      redirect(action: "show", id: cshiftInstance.id)
    }
  }

  def refresh = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      def stats = new storitz.SiteStats()
      def writer = new PrintWriter(System.out)
      usiService.refreshSites(cshiftInstance, 'USI', stats, writer)
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
      redirect(action: "show", id: cshiftInstance.id)
    }
  }

  def createContacts = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      usiService.createSiteUsers(cshiftInstance, "USI")
      flash.message = "Site contacts created."
      redirect(action: "list")
    }
  }

  def refreshPhones = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      def writer = new PrintWriter(System.out)
      usiService.createSitePhones(cshiftInstance, "USI", writer)
      writer.close()
      flash.message = "Feed phones refreshed."
      redirect(action: "show", id: cshiftInstance.id)
    }
  }

}
