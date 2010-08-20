package storitz

import grails.plugins.springsecurity.Secured
import com.storitz.SiteLink

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
class SiteLinkController {

  def siteLinkService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    [siteLinkInstanceList: SiteLink.list(params), siteLinkInstanceTotal: SiteLink.count()]
  }

  def create = {
    def siteLinkInstance = new SiteLink()
    siteLinkInstance.properties = params
    return [siteLinkInstance: siteLinkInstance]
  }

  def save = {
    def siteLinkInstance = new SiteLink(params)
    if (siteLinkInstance.save(flush: true)) {
      // read in sites
      def stats = new storitz.SiteStats()
      siteLinkService.corpSites(siteLinkInstance, stats)
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
      redirect(action: "show", id: siteLinkInstance.id)
    }
    else {
      render(view: "create", model: [siteLinkInstance: siteLinkInstance])
    }
  }

  def refresh = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (siteLinkInstance) {
      def stats = new storitz.SiteStats()
      siteLinkService.refreshSites(siteLinkInstance, stats)
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
      redirect(action: "show", id: siteLinkInstance.id)
    }
  }

  def show = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (!siteLinkInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'siteLink.label', default: 'com.storitz.SiteLink'), params.id])}"
      redirect(action: "list")
    }
    else {
      [siteLinkInstance: siteLinkInstance]
    }
  }

  def edit = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (!siteLinkInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'siteLink.label', default: 'com.storitz.SiteLink'), params.id])}"
      redirect(action: "list")
    }
    else {
      return [siteLinkInstance: siteLinkInstance]
    }
  }

  def update = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (siteLinkInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (siteLinkInstance.version > version) {

          siteLinkInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'siteLink.label', default: 'com.storitz.SiteLink')] as Object[], "Another user has updated this com.storitz.SiteLink while you were editing")
          render(view: "edit", model: [siteLinkInstance: siteLinkInstance])
          return
        }
      }
      siteLinkInstance.properties = params
      if (!siteLinkInstance.hasErrors() && siteLinkInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'siteLink.label', default: 'com.storitz.SiteLink'), siteLinkInstance.id])}"
        redirect(action: "show", id: siteLinkInstance.id)
      }
      else {
        render(view: "edit", model: [siteLinkInstance: siteLinkInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'siteLink.label', default: 'com.storitz.SiteLink'), params.id])}"
      redirect(action: "list")
    }
  }

  def delete = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (siteLinkInstance) {
      try {
        siteLinkInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'siteLink.label', default: 'com.storitz.SiteLink'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'siteLink.label', default: 'com.storitz.SiteLink'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'siteLink.label', default: 'com.storitz.SiteLink'), params.id])}"
      redirect(action: "list")
    }
  }

  def createContacts = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (siteLinkInstance) {
      siteLinkService.createSiteUsers(siteLinkInstance)
      flash.message = "Site contacts created."
      redirect(action: "list")
    }
  }
}
