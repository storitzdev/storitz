package storitz

import storitz.constants.TransactionStatus
import com.storitz.RentalTransaction
import com.storitz.StorageSite
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.UserRole
import com.storitz.User
import com.storitz.Insurance
import com.storitz.StorageSize
import com.vinomis.authnet.AuthorizeNet

class RentalTransactionController {

    def springSecurityService
    def costService

    static allowedMethods = [save:"POST", update: "POST", delete: "POST", pay:["POST", "GET"]]

    static liveSessions = [:]

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
//      def site = StorageSite.get(params.site)
      def site = params.site
      params.remove('site')
      def searchSize = params.SC_searchSize
      params.remove('SC_searchSize')
      def address = params.SC_address
      params.remove('SC_address')
      def date = params.SC_date
      params.remove('SC_date')
      def rentalTransactionInstance = new RentalTransaction(params)
      println (rentalTransactionInstance.dump())
      liveSessions[params.id] = [shortSessionId:params.id, site:site, searchSize:searchSize, address:address, date:date, rentalTransaction:rentalTransactionInstance]
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
        return
      }
      def promo = null
      if (!rentalTransactionInstance.promoId == -999) {
        promo = SpecialOffer.get(rentalTransactionInstance.promoId)
      }
      def unit = StorageUnit.get(rentalTransactionInstance.unitId)
      def ins = null
      if (!rentalTransactionInstance.insuranceId == -999) {
        ins = Insurance.get(rentalTransactionInstance.insuranceId)
      }
      if (rentalTransactionInstance.status != TransactionStatus.BEGUN) {
        render(view:"paid", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, ins: ins])
        return
      }
      [rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, ins: ins]
    }

    def pay = {
//      println params.billingAddress
//      println params
      def rentalTransactionInstance = RentalTransaction.get(params.id)

      if (!rentalTransactionInstance) {
        // TODO - send them to an error page
      }

      def promo = null
      if (!rentalTransactionInstance.promoId == -999) {
        promo = SpecialOffer.get(rentalTransactionInstance.promoId)
      }
      def unit = StorageUnit.get(rentalTransactionInstance.unitId)
      def ins = null
      if (!rentalTransactionInstance.insuranceId == -999) {
        ins = Insurance.get(rentalTransactionInstance.insuranceId)
      }

      if (rentalTransactionInstance.status != TransactionStatus.BEGUN) {
        render(view:"paid", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, ins: ins])
        return
      }

      switch(params.billingAddress) {

        case "new":
          def billingContact = new com.storitz.Contact(params)
          if (!billingContact.save(flush: true)) {
            flash.message = "${message(code: 'default.not.created.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.Contact'), params.id])}"
            render(view:"payment", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, ins: ins])
            return
          } else {
            rentalTransactionInstance.billingAddress = billingContact
          }
          break

        case "primary":
          rentalTransactionInstance.billingAddress = rentalTransactionInstance.contactPrimary
          break

        case "secondary":
          rentalTransactionInstance.billingAddress = rentalTransactionInstance.contactSecondary
          break
      }
      if (!rentalTransactionInstance.save(flush: true)) {
        flash.message = "Could not save billing address"
        render(view:"payment", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, ins: ins])
        return
      }

      // TODO - check if unit is still available

      def ccNum = params.cc_number.replaceAll(/\D/, '') as String
      def ccExpVal = String.format("%02d", params.cc_month as Integer) + params.cc_year
      def moveInCost = costService.calculateMoveInCost(rentalTransactionInstance.site, unit, promo, ins)
      def s = new AuthorizeNet()
      s.authorizeAndCapture {
        custId rentalTransactionInstance.id as String
        firstName rentalTransactionInstance.billingAddress.firstName.encodeAsURL()
        lastName rentalTransactionInstance.billingAddress.lastName
        address "${rentalTransactionInstance.billingAddress.streetNumber} ${rentalTransactionInstance.billingAddress.street} ${rentalTransactionInstance.billingAddress.streetType.display}"
        city rentalTransactionInstance.billingAddress.city
        state rentalTransactionInstance.billingAddress.state.display
        zip rentalTransactionInstance.billingAddress.zipcode
        ccNumber ccNum
        cvv params.cc_cvv2
        ccExpDate ccExpVal
        amount moveInCost as String
      }
      def authResp = s.submit()
      println "Authorize.net response: ${authResp.dump()}"

      if (authResp.responseCode as Integer != 1) {
        flash.message = "Credit card not accepted ${authResp.responseReasonText}"
        render(view:"payment", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, ins: ins, cc_month:params.cc_month, cc_year:params.cc_year, cc_number:params.cc_number, cc_cvv2:params.cc_cvv2])
        return
      }
      rentalTransactionInstance.transactionId = authResp.transactionId
      rentalTransactionInstance.status = TransactionStatus.PAID
      rentalTransactionInstance.save(flush:true)

      // TODO create new tennant
      // TODO - move in
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
