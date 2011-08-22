package storitz

import com.storitz.StorageMartSpecialOfferLookup

class StorageMartSpecialOfferLookupController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [storageMartSpecialOfferLookupInstanceList: StorageMartSpecialOfferLookup.list(params), storageMartSpecialOfferLookupInstanceTotal: StorageMartSpecialOfferLookup.count()]
    }

    def create = {
        def storageMartSpecialOfferLookupInstance = new StorageMartSpecialOfferLookup()
        storageMartSpecialOfferLookupInstance.properties = params
        return [storageMartSpecialOfferLookupInstance: storageMartSpecialOfferLookupInstance]
    }

    def save = {
        def storageMartSpecialOfferLookupInstance = new StorageMartSpecialOfferLookup(params)
        if (storageMartSpecialOfferLookupInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup'), storageMartSpecialOfferLookupInstance.id])}"
            redirect(action: "show", id: storageMartSpecialOfferLookupInstance.id)
        }
        else {
            render(view: "create", model: [storageMartSpecialOfferLookupInstance: storageMartSpecialOfferLookupInstance])
        }
    }

    def show = {
        def storageMartSpecialOfferLookupInstance = StorageMartSpecialOfferLookup.get(params.id)
        if (!storageMartSpecialOfferLookupInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup'), params.id])}"
            redirect(action: "list")
        }
        else {
            [storageMartSpecialOfferLookupInstance: storageMartSpecialOfferLookupInstance]
        }
    }

    def edit = {
        def storageMartSpecialOfferLookupInstance = StorageMartSpecialOfferLookup.get(params.id)
        if (!storageMartSpecialOfferLookupInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [storageMartSpecialOfferLookupInstance: storageMartSpecialOfferLookupInstance]
        }
    }

    def update = {
        def storageMartSpecialOfferLookupInstance = StorageMartSpecialOfferLookup.get(params.id)
        if (storageMartSpecialOfferLookupInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (storageMartSpecialOfferLookupInstance.version > version) {
                    
                    storageMartSpecialOfferLookupInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup')] as Object[], "Another user has updated this StorageMartSpecialOfferLookup while you were editing")
                    render(view: "edit", model: [storageMartSpecialOfferLookupInstance: storageMartSpecialOfferLookupInstance])
                    return
                }
            }
            storageMartSpecialOfferLookupInstance.properties = params
            if (!storageMartSpecialOfferLookupInstance.hasErrors() && storageMartSpecialOfferLookupInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup'), storageMartSpecialOfferLookupInstance.id])}"
                redirect(action: "list")
            }
            else {
                render(view: "edit", model: [storageMartSpecialOfferLookupInstance: storageMartSpecialOfferLookupInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def storageMartSpecialOfferLookupInstance = StorageMartSpecialOfferLookup.get(params.id)
        if (storageMartSpecialOfferLookupInstance) {
            try {
                storageMartSpecialOfferLookupInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup'), params.id])}"
            redirect(action: "list")
        }
    }
}
