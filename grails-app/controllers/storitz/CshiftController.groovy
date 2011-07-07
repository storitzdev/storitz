package storitz

import com.storitz.CenterShift
import com.storitz.CommissionSchedule
import grails.plugins.springsecurity.Secured
import storitz.constants.CenterShiftVersion
import storitz.constants.FeedType
import com.storitz.Feed

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
class CshiftController extends FeedController {


  def CShiftStorageFeedService
  def CShift4StorageFeedService
  def imageService

  static allowedMethods = [save: "POST", update: "POST", uploadLogo: "POST", updateInventory: "POST"]

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    [cshiftInstanceList: CenterShift.list(params), cshiftInstanceTotal: CenterShift.count()]
  }

  def create = {
    def cshiftInstance = new CenterShift()
    cshiftInstance.properties = params
    return [cshiftInstance: cshiftInstance, commissionScheduleList: CommissionSchedule.list()]
  }

  def save = {
    def cshiftInstance = new CenterShift(params)
    cshiftInstance.feedType = FeedType.CENTERSHIFT
    if (cshiftInstance.validate() && cshiftInstance.save(flush: true)) {
      // read in sites
      def stats = new storitz.SiteStats()
      def writer = new PrintWriter(System.out)
      if (cshiftInstance.cshiftVersion == CenterShiftVersion.CS3) {
        CShiftStorageFeedService.loadSites(cshiftInstance, "CS3", stats, writer)
      } else {
        CShift4StorageFeedService.loadSites(cshiftInstance, stats, writer)
      }
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
      redirect(action: "show", id: cshiftInstance.id)
    }
    else {
      render(view: "create", model: [cshiftInstance: cshiftInstance])
    }
  }

  def refresh = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      def stats = new storitz.SiteStats()
      def writer = new PrintWriter(System.out)
      if (cshiftInstance.cshiftVersion == CenterShiftVersion.CS3) {
        CShiftStorageFeedService.refreshSites((Feed)cshiftInstance, 'CS3', stats, writer)
      } else {
        CShift4StorageFeedService.refreshSites((Feed)cshiftInstance, 'CS4', stats, writer)
      }
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
      redirect(action: "show", id: cshiftInstance.id)
    }
  }

  def refreshPromos = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      for (site in cshiftInstance.sites) {
        for (promo in site.specialOffers) {
          promo.delete()
        }
        site.specialOffers.clear()
        def writer = new PrintWriter(System.out)
        if (cshiftInstance.cshiftVersion == CenterShiftVersion.CS3) {
          CShiftStorageFeedService.loadPromos(site, writer)
        } else {
          CShift4StorageFeedService.loadPromos(site, writer)
        }
        writer.close()
        println "Promos refreshed for ${site.title}"
      }
      flash.message = "Feed promotions refreshed."
      redirect(action: "show", id: cshiftInstance.id)
    }
  }

  def refreshInsurance = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      for (site in cshiftInstance.sites) {
        if (cshiftInstance.cshiftVersion == CenterShiftVersion.CS3) {
          for (ins in site.insurances) {
            ins.delete()
          }
          site.insurances.clear()
          CShiftStorageFeedService.loadInsurance(cshiftInstance, site)
        } else {
          CShift4StorageFeedService.loadInsurance(cshiftInstance, site)
        }
        println "Insurance refreshed for ${site.title}"
      }
      flash.message = "Feed insurance refreshed."
      redirect(action: "show", id: cshiftInstance.id)
    }
  }

  def refreshPhones = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      def writer = new PrintWriter(System.out)
      CShiftStorageFeedService.createSitePhones(cshiftInstance, "CS3", writer)
      writer.close()
      flash.message = "Feed phones refreshed."
      redirect(action: "show", id: cshiftInstance.id)
    }
  }

  def show = {
    def cshiftInstance = CenterShift.get(params.id)
    if (!cshiftInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cshift.label', default: 'com.storitz.cshift'), params.id])}"
      redirect(action: "list")
    }
    else {
      [cshiftInstance: cshiftInstance]
    }
  }

  def edit = {
    def cshiftInstance = CenterShift.get(params.id)
    if (!cshiftInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cshift.label', default: 'com.storitz.cshift'), params.id])}"
      redirect(action: "list")
    }
    else {
      return [cshiftInstance: cshiftInstance, commissionScheduleList: CommissionSchedule.list()]
    }
  }

  def update = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (cshiftInstance.version > version) {

          cshiftInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'cshift.label', default: 'com.storitz.cshift')] as Object[], "Another user has updated this com.storitz.cshift while you were editing")
          render(view: "edit", model: [cshiftInstance: cshiftInstance])
          return
        }
      }
      cshiftInstance.properties = params
      if (!cshiftInstance.hasErrors() && cshiftInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'cshift.label', default: 'com.storitz.cshift'), cshiftInstance.id])}"
        redirect(action: "show", id: cshiftInstance.id)
      }
      else {
        render(view: "edit", model: [cshiftInstance: cshiftInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cshift.label', default: 'com.storitz.cshift'), params.id])}"
      redirect(action: "list")
    }
  }

  def delete = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      try {
        cshiftInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'cshift.label', default: 'com.storitz.cshift'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'cshift.label', default: 'com.storitz.cshift'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cshift.label', default: 'com.storitz.cshift'), params.id])}"
      redirect(action: "list")
    }
  }

  def createContacts = {
    def cshiftInstance = CenterShift.get(params.id)
    if (cshiftInstance) {
      CShiftStorageFeedService.createSiteUsers(cshiftInstance, "CS3")
      flash.message = "Site contacts created."
      redirect(action: "list")
    }
  }

}
