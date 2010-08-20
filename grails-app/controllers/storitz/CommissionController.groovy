package storitz

import com.storitz.Commission

class CommissionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
        def results
        def criteria = Commission.createCriteria()
        def query = {
          projections {
            groupProperty("commissionSource")
          }
          order("commissionSource", "asc")
          order("lowerBound", "asc")
        }
        results = criteria.list(params, query)
        [commissionInstanceList: results, commissionInstanceTotal: Commission.count()]
    }

    def create = {
        def commissionInstance = new Commission()
        commissionInstance.properties = params
        return [commissionInstance: commissionInstance]
    }

    def save = {
        def commissionInstance = new Commission(params)
        if (commissionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'commission.label', default: 'Commission'), commissionInstance.id])}"
            redirect(action: "show", id: commissionInstance.id)
        }
        else {
            render(view: "create", model: [commissionInstance: commissionInstance])
        }
    }

    def show = {
        def commissionInstance = Commission.get(params.id)
        if (!commissionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'commission.label', default: 'Commission'), params.id])}"
            redirect(action: "list")
        }
        else {
            [commissionInstance: commissionInstance]
        }
    }

    def edit = {
        def commissionInstance = Commission.get(params.id)
        if (!commissionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'commission.label', default: 'Commission'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [commissionInstance: commissionInstance]
        }
    }

    def update = {
        def commissionInstance = Commission.get(params.id)
        if (commissionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (commissionInstance.version > version) {
                    
                    commissionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'commission.label', default: 'Commission')] as Object[], "Another user has updated this Commission while you were editing")
                    render(view: "edit", model: [commissionInstance: commissionInstance])
                    return
                }
            }
            commissionInstance.properties = params
            if (!commissionInstance.hasErrors() && commissionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'commission.label', default: 'Commission'), commissionInstance.id])}"
                redirect(action: "show", id: commissionInstance.id)
            }
            else {
                render(view: "edit", model: [commissionInstance: commissionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'commission.label', default: 'Commission'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def commissionInstance = Commission.get(params.id)
        if (commissionInstance) {
            try {
                commissionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'commission.label', default: 'Commission'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'commission.label', default: 'Commission'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'commission.label', default: 'Commission'), params.id])}"
            redirect(action: "list")
        }
    }
}
