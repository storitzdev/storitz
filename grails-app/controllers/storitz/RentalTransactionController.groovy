package storitz

import storitz.constants.TransactionStatus
import com.storitz.RentalTransaction
import com.storitz.StorageSite
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.UserRole
import com.storitz.User
import com.storitz.Insurance

class RentalTransactionController {

    def springSecurityService
    def siteLinkService
    def cShiftService

    static allowedMethods = [save:"POST", update: "POST", delete: "POST", pay:["POST", "GET"]]

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

    def ajaxPoll = {
//      println "Polled by ${params.id}"
      render {
        span("${session.shortSessionId} ${new Date()}")
      }
    }

    def ajaxUpdate = {
      println "Update by ${params.id}: ${params.dump()}"
      def site = StorageSite.get(params.site)
      params.remove('site')
      def rentalTransactionInstance = new RentalTransaction(params)
      render(status: 200, contentType: "application/json", text: "{ 'update':false }")
    }

    def save = {
        println params.dump()
        def site = StorageSite.get(params.site)
        params.remove('site')
        def rentalTransactionInstance = new RentalTransaction(params)
        rentalTransactionInstance.status = TransactionStatus.BEGUN
        rentalTransactionInstance.bookingDate = new Date()
        rentalTransactionInstance.moveInDate = Date.parse('MM-dd-yyyy', params.moveInDate)
        rentalTransactionInstance.site = site

        if (!springSecurityService.principal.equals('anonymousUser')) {
          def person = User.findByUsername(springSecurityService.principal.username)
          rentalTransactionInstance.isCallCenter = (UserRole.userHasRole(person, 'ROLE_CALLCENTER'))
        } else {
          rentalTransactionInstance.isCallCenter = false          
        }

        // check if no promo selected
        if (!params.promoId && site.siteLink) {
          rentalTransactionInstance.promoId = -999;
        }
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
          def promo = SpecialOffer.get(rentalTransactionInstance.promoId)
          def unit = StorageUnit.get(rentalTransactionInstance.unitId)
          def ins = null
          if (!rentalTransactionInstance.insuranceId == -999) {
            ins = Insurance.get(rentalTransactionInstance.insuranceId)
          }
          // TODO - validate state to make sure we are not redoing a transaction
          println "Rental transaction - movein: ${rentalTransactionInstance.moveInDate} booking date: ${rentalTransactionInstance.bookingDate}"
          [rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, ins: ins]
        }
    }

    def pay = {
//      println params.billingAddress
//      println params
      def rentalTransactionInstance = RentalTransaction.get(params.id)
      if (params.billingAddress == 'new') {
        def billingContact = new com.storitz.Contact(params)
        if (!billingContact.save(flush: true)) {
          def promo = SpecialOffer.get(rentalTransactionInstance.promoId)
          def unit = StorageUnit.get(rentalTransactionInstance.unitId)
          def ins = null
          if (!rentalTransactionInstance.insuranceId == -999) {
            ins = Insurance.get(rentalTransactionInstance.insuranceId)
          }
          flash.message = "${message(code: 'default.not.created.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.Contact'), params.id])}"
          [rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, ins: ins]
        } else {
          rentalTransactionInstance.billingAddress = billingContact
        }
      } else if (params.billingAddress == 'primary') {
        rentalTransactionInstance.billingAddress = rentalTransactionInstance.contactPrimary
      } else {
        rentalTransactionInstance.billingAddress = rentalTransactionInstance.contactSecondary
      }
      // get MoveInCosts
      if (rentalTransactionInstance.site.siteLink) {

      } else if (rentalTransactionInstance.site.centerShift) {

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
