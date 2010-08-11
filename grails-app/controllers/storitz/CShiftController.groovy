package storitz

import grails.plugins.springsecurity.Secured
import com.storitz.CenterShift

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
class CShiftController {


  def geocodeService
  def CShiftService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

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
    return [cshiftInstance: cshiftInstance]
  }

  def save = {
    def cshiftInstance = new CenterShift(params)
    if (cshiftInstance.save(flush: true)) {
      // read in sites
      def stats = new storitz.SiteStats()
      CShiftService.loadSites(cshiftInstance, stats)
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
      CShiftService.refreshSites(cshiftInstance, stats, geocodeService)
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
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
      return [cshiftInstance: cshiftInstance]
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
}
