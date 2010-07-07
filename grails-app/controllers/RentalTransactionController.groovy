import storitz.constants.TransactionStatus
import com.storitz.RentalTransaction
import com.storitz.StorageSite

class RentalTransactionController {

    static allowedMethods = [save:"POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [rentalTransactionInstanceList: RentalTransaction.list(params), rentalTransactionInstanceTotal: RentalTransaction.count()]
    }

    def create = {
        def rentalTransactionInstance = new RentalTransaction()
        rentalTransactionInstance.properties = params
        return [rentalTransactionInstance: rentalTransactionInstance]
    }

    def save = {
        println params.dump()
        def site = StorageSite.get(params.site)
        params.remove('site')
        def rentalTransactionInstance = new RentalTransaction(params)
        rentalTransactionInstance.status = TransactionStatus.BEGUN
        rentalTransactionInstance.bookingDate = new Date()
        rentalTransactionInstance.site = site
        if (rentalTransactionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), rentalTransactionInstance.id])}"
            redirect(action: "payment", id: rentalTransactionInstance.id)
        }
        else {
            render(view: "create", model: [rentalTransactionInstance: rentalTransactionInstance])
        }
    }

    def show = {
        def rentalTransactionInstance = RentalTransaction.get(params.id)
        if (!rentalTransactionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
            redirect(action: "list")
        }
        else {
            [rentalTransactionInstance: rentalTransactionInstance]
        }
    }

    def payment = {
        def rentalTransactionInstance = RentalTransaction.get(params.id)
        if (!rentalTransactionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
            // TODO - handle error of not found transaction
          [rentalTransactionInstance: rentalTransactionInstance, storageSite: rentalTransactionInstance.site]
        }
        else {
            // TODO - validate state to make sure we are not redoing a transaction
            [rentalTransactionInstance: rentalTransactionInstance, storageSite: rentalTransactionInstance.site]
        }
    }

    def edit = {
        def rentalTransactionInstance = RentalTransaction.get(params.id)
        if (!rentalTransactionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [rentalTransactionInstance: rentalTransactionInstance]
        }
    }

    def update = {
        def rentalTransactionInstance = RentalTransaction.get(params.id)
        if (rentalTransactionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (rentalTransactionInstance.version > version) {
                    
                    rentalTransactionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction')] as Object[], "Another user has updated this com.storitz.RentalTransaction while you were editing")
                    render(view: "edit", model: [rentalTransactionInstance: rentalTransactionInstance])
                    return
                }
            }
            rentalTransactionInstance.properties = params
            if (!rentalTransactionInstance.hasErrors() && rentalTransactionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), rentalTransactionInstance.id])}"
                redirect(action: "show", id: rentalTransactionInstance.id)
            }
            else {
                render(view: "edit", model: [rentalTransactionInstance: rentalTransactionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def rentalTransactionInstance = RentalTransaction.get(params.id)
        if (rentalTransactionInstance) {
            try {
                rentalTransactionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
            redirect(action: "list")
        }
    }
}
