package storitz

import com.storitz.ContactUs

class ContactUsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [contactUsInstanceList: ContactUs.list(params), contactUsInstanceTotal: ContactUs.count()]
    }

    def create = {
        def contactUsInstance = new ContactUs()
        contactUsInstance.properties = params
        return [contactUsInstance: contactUsInstance]
    }

    def save = {
        def contactUsInstance = new ContactUs(params)
        if (contactUsInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), contactUsInstance.id])}"
            redirect(action: "show", id: contactUsInstance.id)
        }
        else {
            render(view: "create", model: [contactUsInstance: contactUsInstance])
        }
    }

    def show = {
        def contactUsInstance = ContactUs.get(params.id)
        if (!contactUsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
            redirect(action: "list")
        }
        else {
            [contactUsInstance: contactUsInstance]
        }
    }

    def edit = {
        def contactUsInstance = ContactUs.get(params.id)
        if (!contactUsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [contactUsInstance: contactUsInstance]
        }
    }

    def update = {
        def contactUsInstance = ContactUs.get(params.id)
        if (contactUsInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (contactUsInstance.version > version) {
                    
                    contactUsInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'contactUs.label', default: 'ContactUs')] as Object[], "Another user has updated this ContactUs while you were editing")
                    render(view: "edit", model: [contactUsInstance: contactUsInstance])
                    return
                }
            }
            contactUsInstance.properties = params
            if (!contactUsInstance.hasErrors() && contactUsInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), contactUsInstance.id])}"
                redirect(action: "show", id: contactUsInstance.id)
            }
            else {
                render(view: "edit", model: [contactUsInstance: contactUsInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def contactUsInstance = ContactUs.get(params.id)
        if (contactUsInstance) {
            try {
                contactUsInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
            redirect(action: "list")
        }
    }
}
