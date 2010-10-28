package storitz

import com.storitz.Metro

class MetroController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [metroInstanceList: Metro.list(params), metroInstanceTotal: Metro.count()]
    }

    def create = {
        def metroInstance = new Metro()
        metroInstance.properties = params
        return [metroInstance: metroInstance]
    }

    def save = {
        def metroInstance = new Metro(params)
        if (metroInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'metro.label', default: 'Metro'), metroInstance.id])}"
            redirect(action: "show", id: metroInstance.id)
        }
        else {
            render(view: "create", model: [metroInstance: metroInstance])
        }
    }

    def show = {
        def metroInstance = Metro.get(params.id)
        if (!metroInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'metro.label', default: 'Metro'), params.id])}"
            redirect(action: "list")
        }
        else {
            [metroInstance: metroInstance]
        }
    }

    def edit = {
        def metroInstance = Metro.get(params.id)
        if (!metroInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'metro.label', default: 'Metro'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [metroInstance: metroInstance]
        }
    }

    def update = {
        def metroInstance = Metro.get(params.id)
        if (metroInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (metroInstance.version > version) {
                    
                    metroInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'metro.label', default: 'Metro')] as Object[], "Another user has updated this Metro while you were editing")
                    render(view: "edit", model: [metroInstance: metroInstance])
                    return
                }
            }
            metroInstance.properties = params
            if (!metroInstance.hasErrors() && metroInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'metro.label', default: 'Metro'), metroInstance.id])}"
                redirect(action: "show", id: metroInstance.id)
            }
            else {
                render(view: "edit", model: [metroInstance: metroInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'metro.label', default: 'Metro'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def metroInstance = Metro.get(params.id)
        if (metroInstance) {
            try {
                metroInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'metro.label', default: 'Metro'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'metro.label', default: 'Metro'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'metro.label', default: 'Metro'), params.id])}"
            redirect(action: "list")
        }
    }
}
