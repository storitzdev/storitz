package storitz

import com.storitz.EDomicoAmenitiesMap

class EDomicoAmenitiesMapController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 50, 100)
        [EDomicoAmenitiesMapInstanceList: EDomicoAmenitiesMap.list(params), EDomicoAmenitiesMapInstanceTotal: EDomicoAmenitiesMap.count()]
    }

    def create = {
        def EDomicoAmenitiesMapInstance = new EDomicoAmenitiesMap()
        EDomicoAmenitiesMapInstance.properties = params
        return [EDomicoAmenitiesMapInstance: EDomicoAmenitiesMapInstance]
    }

    def save = {
        def EDomicoAmenitiesMapInstance = new EDomicoAmenitiesMap(params)
        if (EDomicoAmenitiesMapInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap'), EDomicoAmenitiesMapInstance.id])}"
            redirect(action: "show", id: EDomicoAmenitiesMapInstance.id)
        }
        else {
            render(view: "create", model: [EDomicoAmenitiesMapInstance: EDomicoAmenitiesMapInstance])
        }
    }

    def show = {
        def EDomicoAmenitiesMapInstance = EDomicoAmenitiesMap.get(params.id)
        if (!EDomicoAmenitiesMapInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap'), params.id])}"
            redirect(action: "list")
        }
        else {
            [EDomicoAmenitiesMapInstance: EDomicoAmenitiesMapInstance]
        }
    }

    def edit = {
        def EDomicoAmenitiesMapInstance = EDomicoAmenitiesMap.get(params.id)
        if (!EDomicoAmenitiesMapInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [EDomicoAmenitiesMapInstance: EDomicoAmenitiesMapInstance]
        }
    }

    def update = {
        def EDomicoAmenitiesMapInstance = EDomicoAmenitiesMap.get(params.id)
        if (EDomicoAmenitiesMapInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (EDomicoAmenitiesMapInstance.version > version) {
                    
                    EDomicoAmenitiesMapInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap')] as Object[], "Another user has updated this EDomicoAmenitiesMap while you were editing")
                    render(view: "edit", model: [EDomicoAmenitiesMapInstance: EDomicoAmenitiesMapInstance])
                    return
                }
            }
            EDomicoAmenitiesMapInstance.properties = params
            if (!EDomicoAmenitiesMapInstance.hasErrors() && EDomicoAmenitiesMapInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap'), EDomicoAmenitiesMapInstance.id])}"
                redirect(action: "list", id: EDomicoAmenitiesMapInstance.id)
            }
            else {
                render(view: "edit", model: [EDomicoAmenitiesMapInstance: EDomicoAmenitiesMapInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def EDomicoAmenitiesMapInstance = EDomicoAmenitiesMap.get(params.id)
        if (EDomicoAmenitiesMapInstance) {
            try {
                EDomicoAmenitiesMapInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap'), params.id])}"
            redirect(action: "list")
        }
    }
}
