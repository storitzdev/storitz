package storitz

import com.storitz.CommissionSchedule
import com.storitz.QuikStor
import com.storitz.QuikStorLocation
import com.storitz.SiteLink
import grails.plugins.springsecurity.Secured
import storitz.constants.FeedType

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
class QuikStorController extends FeedController {

  def quikStorService
  def imageService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST", uploadLogo: "POST", updateInventory: "POST"]

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    [quikStorInstanceList: QuikStor.list(params), quikStorInstanceTotal: SiteLink.count()]
  }

  def create = {
    def quikStorInstance = new QuikStor()
    quikStorInstance.properties = params
    return [quikStorInstance: quikStorInstance, commissionScheduleList: CommissionSchedule.list()]
  }

  def save = {
    def quikStorInstance = new QuikStor(params)
    quikStorInstance.feedType = FeedType.QUIKSTOR
    if (quikStorInstance.validate() && quikStorInstance.save(flush: true)) {
      redirect(action: "show", id: quikStorInstance.id)
    }
    else {
      render(view: "create", model: [quikStorInstance: quikStorInstance])
    }
  }

  def refresh = {
    def quikStorInstance = QuikStor.get(params.id)
    if (quikStorInstance) {
      def stats = new storitz.SiteStats()
      quikStorService.refreshSites(quikStorInstance, stats)
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
      redirect(action: "show", id: quikStorInstance.id)
    }
  }

  def show = {
    def quikStorInstance = QuikStor.get(params.id)
    if (!quikStorInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'quikStor.label', default: 'com.storitz.QuikStor'), params.id])}"
      redirect(action: "list")
    }
    else {
      [quikStorInstance: quikStorInstance]
    }
  }

  def edit = {
    def quikStorInstance = QuikStor.get(params.id)
    if (!quikStorInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'quikStor.label', default: 'com.storitz.QuikStor'), params.id])}"
      redirect(action: "list")
    }
    else {
      return [quikStorInstance: quikStorInstance, commissionScheduleList: CommissionSchedule.list()]
    }
  }

  def update = {
    def quikStorInstance = QuikStor.get(params.id)
    if (quikStorInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (quikStorInstance.version > version) {

          quikStorInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'quikStor.label', default: 'com.storitz.QuikStor')] as Object[], "Another user has updated this com.storitz.QuikStor while you were editing")
          render(view: "edit", model: [quikStorInstance: quikStorInstance])
          return
        }
      }
      quikStorInstance.properties = params
      for (param in params.keySet()) {
        if (param.startsWith('newSitename:_')) {
          def idx = param.substring(13)
          def loc = new QuikStorLocation()
          loc.sitename = params['newSitename:_' + idx]
          loc.username = params['newUsername:_' + idx]
          loc.password = params['newPassword:_' + idx]
          loc.quikStor = quikStorInstance
          loc.save(flush: true)
          quikStorInstance.addToLocations(loc)
        }
      }
      for (loc in quikStorInstance.locations) {
        def sitenameString = "sitename:_" + loc.id
        def usernameString = "username:_" + loc.id
        def passwordString = "password:_" + loc.id

        def changed = false
        if (params[sitenameString]) {
          loc.sitename = params[sitenameString]
          changed = true
        }
        if (params[usernameString]) {
          loc.username = params[usernameString]
          changed = true
        }
        if (params[passwordString]) {
          loc.password = params[passwordString]
          changed = true
        }
        if (changed) {
          loc.save(flush: true)
        }
      }

      if (!quikStorInstance.hasErrors() && quikStorInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'quikStor.label', default: 'com.storitz.QuikStor'), quikStorInstance.id])}"
        redirect(action: "show", id: quikStorInstance.id)
      }
      else {
        render(view: "edit", model: [quikStorInstance: quikStorInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'quikStor.label', default: 'com.storitz.QuikStor'), params.id])}"
      redirect(action: "list")
    }
  }

  def delete = {
    def quikStorInstance = QuikStor.get(params.id)
    if (quikStorInstance) {
      try {
        quikStorInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'quikStor.label', default: 'com.storitz.QuikStor'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'quikStor.label', default: 'com.storitz.QuikStor'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'quikStor.label', default: 'com.storitz.QuikStor'), params.id])}"
      redirect(action: "list")
    }
  }

  def removeLocation = {
    def loc = QuikStorLocation.get(params.locId as Long)
    if (loc) {
      def quikStor = loc.quikStor
      quikStor.removeFromLocations(loc)
      quikStor.save(flush: true)
      // TODO remove the site from the system - cascade everything
    }
    render(status: 200, contentType: "application/json", text: "{ 'locId': ${loc?.id} }")
  }

  def processLocations = {
    def quikStorInstance = QuikStor.get(params.id)
    if (quikStorInstance) {
      def writer = new PrintWriter(System.out)
      def stats = new storitz.SiteStats()
      quikStorService.processLocations(quikStorInstance, stats, writer)
      flash.message = "Locations processed."
      redirect(action: "list")
    }
  }

  def createContacts = {
    def quikStorInstance = QuikStor.get(params.id)
    if (quikStorInstance) {
      quikStorService.createSiteUsers(quikStorInstance)
      flash.message = "Site contacts created."
      redirect(action: "list")
    }
  }

  def updateTax = {
    def quikStorInstance = QuikStor.get(params.id)
    if (quikStorInstance) {
      quikStorService.createSiteTaxes(quikStorInstance)
      flash.message = "Site taxes updated."
      redirect(action: "list")
    }
  }

}
