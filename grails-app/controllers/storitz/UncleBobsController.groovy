package storitz

import com.storitz.UncleBobs
import com.storitz.CommissionSchedule
import storitz.constants.FeedType
import com.storitz.StorageSite
import com.storitz.Feed

class UncleBobsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [uncleBobsInstanceList: UncleBobs.list(params), uncleBobsInstanceTotal: UncleBobs.count()]
    }

    def create = {
        def uncleBobsInstance = new UncleBobs()
        uncleBobsInstance.properties = params
        return [uncleBobsInstance: uncleBobsInstance, commissionScheduleList: CommissionSchedule.list()]
    }

    def save = {
        def uncleBobsInstance = new UncleBobs(params)
        uncleBobsInstance.feedType = FeedType.UNCLEBOBS
        if (uncleBobsInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'uncleBobs.label', default: 'UncleBobs'), uncleBobsInstance.id])}"
            redirect(action: "show", id: uncleBobsInstance.id)
        }
        else {
            render(view: "create", model: [uncleBobsInstance: uncleBobsInstance])
        }
    }

    def show = {
        def uncleBobsInstance = UncleBobs.get(params.id)
        if (!uncleBobsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'uncleBobs.label', default: 'UncleBobs'), params.id])}"
            redirect(action: "list")
        }
        else {
            [uncleBobsInstance: uncleBobsInstance]
        }
    }

    def edit = {
        def uncleBobsInstance = UncleBobs.get(params.id)
        if (!uncleBobsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'uncleBobs.label', default: 'UncleBobs'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [uncleBobsInstance: uncleBobsInstance]
        }
    }

    def update = {
        def uncleBobsInstance = UncleBobs.get(params.id)
        if (uncleBobsInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (uncleBobsInstance.version > version) {
                    
                    uncleBobsInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'uncleBobs.label', default: 'UncleBobs')] as Object[], "Another user has updated this UncleBobs while you were editing")
                    render(view: "edit", model: [uncleBobsInstance: uncleBobsInstance])
                    return
                }
            }
            uncleBobsInstance.properties = params
            if (!uncleBobsInstance.hasErrors() && uncleBobsInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'uncleBobs.label', default: 'UncleBobs'), uncleBobsInstance.id])}"
                redirect(action: "show", id: uncleBobsInstance.id)
            }
            else {
                render(view: "edit", model: [uncleBobsInstance: uncleBobsInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'uncleBobs.label', default: 'UncleBobs'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def uncleBobsInstance = UncleBobs.get(params.id)
        if (uncleBobsInstance) {
            try {
                uncleBobsInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'uncleBobs.label', default: 'UncleBobs'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'uncleBobs.label', default: 'UncleBobs'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'uncleBobs.label', default: 'UncleBobs'), params.id])}"
            redirect(action: "list")
        }
    }

    // activates when user clicks the refresh sites button
    def refresh = {
      def uncleBobsInstance = UncleBobs.get(params.id)
      def stats = new storitz.SiteStats()
      def writer = new PrintWriter(System.out)
      UncleBobsStorageFeedService uncleBobsService = new UncleBobsStorageFeedService(uncleBobsInstance.UBCompanyName)
      uncleBobsService.refreshSites((Feed)uncleBobsInstance,"BOB",stats,writer)
      flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
      redirect(action: "show", id: uncleBobsInstance.id)

    }

}
