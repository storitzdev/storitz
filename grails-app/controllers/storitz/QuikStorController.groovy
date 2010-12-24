package storitz

import com.storitz.SiteLink
import grails.plugins.springsecurity.Secured
import storitz.constants.FeedType
import com.storitz.QuikStor

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
class QuikStorController extends FeedController {

  def quikStorService
  def imageService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST", uploadLogo: "POST", updateInventory:"POST"]

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
    return [quikStorInstance: quikStorInstance]
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
      return [quikStorInstance: quikStorInstance]
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

  def processLocations = {
    def quikStorInstance = QuikStor.get(params.id)
    if (quikStorInstance) {
      quikStorService.processLocations(quikStorInstance)
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
