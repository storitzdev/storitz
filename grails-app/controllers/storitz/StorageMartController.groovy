package storitz

import com.storitz.Feed
import com.storitz.StorageMart
import com.storitz.CommissionSchedule
import storitz.constants.FeedType

class StorageMartController {

  def index = {
    redirect (action:"list", params: params)
  }

  def list = {
      params.max = Math.min(params.max ? params.int('max') : 10, 100)
      [storageMartInstanceList: StorageMart.list(params), storageMartInstanceTotal: StorageMart.count()]
  }

  def create = {
      def storageMartInstance = new StorageMart()
      storageMartInstance.properties = params
      return [storageMartInstance: storageMartInstance, commissionScheduleList: CommissionSchedule.list()]
  }

  def save = {
      def storageMartInstance = new StorageMart(params)
      storageMartInstance.feedType = FeedType.STORAGEMART
      if (storageMartInstance.save(flush: true)) {
          flash.message = "${message(code: 'default.created.message', args: [message(code: 'storageMart.label', default: 'storageMart'), storageMartInstance.id])}"
          redirect(action: "show", id: storageMartInstance.id)
      }
      else {
          render(view: "create", model: [storageMartInstance: storageMartInstance])
      }
  }

  def show = {
      def storageMartInstance = StorageMart.get(params.id)
      if (!storageMartInstance) {
          flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageMart.label', default: 'storageMart'), params.id])}"
          redirect(action: "list")
      }
      else {
          [storageMartInstance: storageMartInstance]
      }
  }

  def edit = {
      def storageMartInstance = StorageMart.get(params.id)
      if (!storageMartInstance) {
          flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageMart.label', default: 'storageMart'), params.id])}"
          redirect(action: "list")
      }
      else {
          return [storageMartInstance: storageMartInstance]
      }
  }

  def update = {
      def storageMartInstance = StorageMart.get(params.id)
      if (storageMartInstance) {
          if (params.version) {
              def version = params.version.toLong()
              if (storageMartInstance.version > version) {

                  storageMartInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'storageMart.label', default: 'storageMart')] as Object[], "Another user has updated this storageMart while you were editing")
                  render(view: "edit", model: [storageMartInstance: storageMartInstance])
                  return
              }
          }
          storageMartInstance.properties = params
          if (!storageMartInstance.hasErrors() && storageMartInstance.save(flush: true)) {
              flash.message = "${message(code: 'default.updated.message', args: [message(code: 'storageMart.label', default: 'storageMart'), storageMartInstance.id])}"
              redirect(action: "show", id: storageMartInstance.id)
          }
          else {
              render(view: "edit", model: [storageMartInstance: storageMartInstance])
          }
      }
      else {
          flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageMart.label', default: 'storageMart'), params.id])}"
          redirect(action: "list")
      }
  }

  def delete = {
      def storageMartInstance = StorageMart.get(params.id)
      if (storageMartInstance) {
          try {
              storageMartInstance.delete(flush: true)
              flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'storageMart.label', default: 'storageMart'), params.id])}"
              redirect(action: "list")
          }
          catch (org.springframework.dao.DataIntegrityViolationException e) {
              flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'storageMart.label', default: 'storageMart'), params.id])}"
              redirect(action: "show", id: params.id)
          }
      }
      else {
          flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageMart.label', default: 'storageMart'), params.id])}"
          redirect(action: "list")
      }
  }

  // activates when user clicks the refresh sites button
  def refresh = {
    def storageMartInstance = StorageMart.get(params.id)
    def stats = new storitz.SiteStats()
    def writer = new PrintWriter(System.out)
    StorageMartStorageFeedService storageMartService = new StorageMartStorageFeedService(storageMartInstance.stmUser, storageMartInstance.stmPass, storageMartInstance.url)
    storageMartService.refreshSites((Feed)storageMartInstance,"STM",stats,writer)
    flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
    redirect(action: "show", id: storageMartInstance.id)

  }

}
