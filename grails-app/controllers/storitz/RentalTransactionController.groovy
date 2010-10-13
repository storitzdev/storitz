package storitz

import storitz.constants.TransactionStatus
import com.storitz.RentalTransaction
import com.storitz.StorageSite
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.UserRole
import com.storitz.User
import com.storitz.Insurance
import com.vinomis.authnet.AuthorizeNet
import com.storitz.TransactionNote
import storitz.constants.CommissionSourceType
import com.storitz.SearchEngineReferral
import com.storitz.NotificationType
import org.hibernate.FetchMode as FM
import storitz.constants.NotificationEventType
import java.math.RoundingMode
import grails.plugins.springsecurity.Secured
import com.storitz.StorageSize
import storitz.constants.UnitType

class RentalTransactionController {

    def springSecurityService
    def costService
    def moveInService
    def creditCardService
    def notificationService
    def nachaService

    static allowedMethods = [save:"POST", update: "POST", delete: "POST", pay:["POST", "GET"]]

    static Map liveSessions = [:]

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
      render {
        span("${session.shortSessionId} ${new Date()}")
      }
    }

    def ajaxUpdate = {

      def site = params.site
      params.remove('site')
      def searchSize = params.SC_searchSize
      params.remove('SC_searchSize')
      def address = params.SC_address
      params.remove('SC_address')
      def date = params.SC_date
      params.remove('SC_date')
      def page = params.SC_page
      params.remove('SC_page')

      def rentalTransactionInstance
      if (page == 'payment') {
        def c = RentalTransaction.createCriteria()
        rentalTransactionInstance = c.get {
          eq("id", params.rentalTransactionId as Long)
          fetchMode('contactPrimary', FM.EAGER)
          fetchMode('site', FM.EAGER)
        }
      } else {
        rentalTransactionInstance = new RentalTransaction(params)
      }

      def callParams = [timestamp: System.currentTimeMillis(), shortSessionId: params.id
              , site: site, searchSize: searchSize, address: address, date: date, page: page
              , rentalTransaction: rentalTransactionInstance, landingCookie:params.landingCookie]

      liveSessions[params.id] = callParams

      render(status: 200, contentType: "application/json", text: "{ 'update':false }")
    }

    def save = {
        def site = StorageSite.get(params.site)
        params.remove('site')
        def storageSize = StorageSize.get(params.searchSize as Long)
        params.remove('searchSize')

        def rentalTransactionInstance
        if (params.id) {
          rentalTransactionInstance = RentalTransaction.get(params.id as Long)
          rentalTransactionInstance.properties = params
        } else {
          rentalTransactionInstance = new RentalTransaction(params)
        }
        rentalTransactionInstance.status = TransactionStatus.BEGUN
        rentalTransactionInstance.bookingDate = new Date()
        if (params.moveInDate && params.moveInDate instanceof Date) {
          rentalTransactionInstance.moveInDate = params.moveInDate
        } else {
          rentalTransactionInstance.moveInDate = Date.parse('MM/dd/yy', params.moveInDate)
        }
        rentalTransactionInstance.site = site
        rentalTransactionInstance.searchSize = storageSize
        rentalTransactionInstance.unitType = params.chosenType
        rentalTransactionInstance.reserveTruck = (params.reserveTruck ? params.reserveTruck : false)
        rentalTransactionInstance.contactPrimary.rental = rentalTransactionInstance

        if (!springSecurityService.principal.equals('anonymousUser')) {
          def person = User.findByUsername(springSecurityService.principal.username)
          rentalTransactionInstance.isCallCenter = (UserRole.userHasRole(person, 'ROLE_CALLCENTER'))
          if (params.operatorInitials) {
            def transNote = new TransactionNote()
            transNote.advisor = params.operatorInitials
            transNote.note = params.operatorNote
            transNote.entered = new Date()

            rentalTransactionInstance.addToNotes(transNote)
          }
        } else {
          rentalTransactionInstance.isCallCenter = false
        }

        // check if no promo selected
        if (!params.promoId) {
          rentalTransactionInstance.promoId = -999;
        }
        if (!params.insuranceId) {
          rentalTransactionInstance.insuranceId = -999
        }
        if (rentalTransactionInstance.validate() && rentalTransactionInstance.save(flush: true)) {
            println("Transaction move in save date is ${rentalTransactionInstance.moveInDate.format('MM/dd/yy')}")
            redirect(action: "payment", id: rentalTransactionInstance.id)
        } else {
            println "RentalTransaction errors:"
            rentalTransactionInstance.errors.allErrors.each {
              println it
            }
            redirect(controller:"storageSite", action: "detail", model: [rentalTransactionInstance: rentalTransactionInstance, rentalTransactionId: rentalTransactionInstance.id, id: site.id])
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
      if (rentalTransactionInstance.promoId > 0) {
        promo = SpecialOffer.get(rentalTransactionInstance.promoId)
      }
      def unit = StorageUnit.get(rentalTransactionInstance.unitId)
      def ins = null
      if (rentalTransactionInstance.insuranceId > 0) {
        ins = Insurance.get(rentalTransactionInstance.insuranceId)
      }
      if (rentalTransactionInstance.status != TransactionStatus.BEGUN) {
        render(view:"paid", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site])
        return
      }

      def moveInDetails = moveInService.moveInDetail(rentalTransactionInstance)
      if (!moveInDetails) {
        def found = false
        def bestUnit = rentalTransactionInstance.site.units.findAll{ it.unitType == rentalTransactionInstance.unitType && it.unitsize.id == rentalTransactionInstance.searchSize.id && it.id != unit?.id }.min{ it.price }
        for(myUnit in bestUnit) {
          rentalTransactionInstance.unitId = myUnit.id
          if (moveInService.checkRented(rentalTransactionInstance)) {
            found = true
            unit = myUnit
            break
          }
        }
        if (!found) {
          flash.message = "Unit already reserved - refresh and try again"
          redirect(controller:"storageSite", action: "detail", model: [rentalTransactionInstance: rentalTransactionInstance, rentalTransactionId: rentalTransactionInstance.id, id: rentalTransactionInstance.site.id])
          return
        }
        moveInDetails = moveInService.moveInDetail(rentalTransactionInstance)
      }
      rentalTransactionInstance.feedMoveInCost = moveInDetails?.total()

      [rentalTransactionInstance: rentalTransactionInstance,
              title: "Storitz self-storage for ${rentalTransactionInstance.site.title} - located in ${rentalTransactionInstance.site.city}, ${rentalTransactionInstance.site.state.fullName} ${rentalTransactionInstance.site.zipcode}",
              site: rentalTransactionInstance.site, shortSessionId:session.shortSessionId, moveInDetails: moveInDetails,
              unit: unit, promo:promo, ins:ins, paidThruDate:costService.calculatePaidThruDate(rentalTransactionInstance.site, promo, rentalTransactionInstance.moveInDate, true)]
    }

    def pay = {
      def rentalTransactionInstance = RentalTransaction.get(params.id)

      if (!rentalTransactionInstance) {
        // TODO - send them to an error page
      }

      SpecialOffer promo = null
      if (rentalTransactionInstance.promoId > 0) {
        promo = SpecialOffer.get(rentalTransactionInstance.promoId)
      }
      def unit = StorageUnit.get(rentalTransactionInstance.unitId)
      Insurance ins = null
      if (rentalTransactionInstance.insuranceId > 0) {
        ins = Insurance.get(rentalTransactionInstance.insuranceId)
      }

      if (rentalTransactionInstance.status != TransactionStatus.BEGUN) {
        render(view:"paid", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site])
        return
      }

      switch(params.billingAddress) {

        case "new":
          def billingContact = new com.storitz.Contact(params)
          billingContact.rental = rentalTransactionInstance
          if (!billingContact.validate() || !billingContact.save(flush: true)) {
            flash.message = "${message(code: 'default.not.created.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
            redirect (action:'payment', params:["id":rentalTransactionInstance.id])
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
      if (!rentalTransactionInstance.validate() || !rentalTransactionInstance.save(flush: true)) {
        flash.message = "Could not save billing address"
        redirect (action:'payment', params:["id":rentalTransactionInstance.id])
        return
      }

      if (!moveInService.checkRented(rentalTransactionInstance)) {
        def found = false
        def bestUnit = rentalTransactionInstance.site.units.findAll{ it.unitType == rentalTransactionInstance.unitType && it.unitsize.id == rentalTransactionInstance.searchSize.id && it.id != unit?.id }.min{ it.price }
        for(myUnit in bestUnit) {
          rentalTransactionInstance.unitId = myUnit.id
          if (moveInService.checkRented(rentalTransactionInstance)) {
            found = true
            unit = myUnit
            break
          }
        }
        if (!found) {
          flash.message = "Unit already reserved - refresh and try again"
          redirect (action:'payment', params:["id":rentalTransactionInstance.id])
          return
        }
      }
      rentalTransactionInstance.monthlyRate = unit.pushRate ? unit.pushRate : unit.price


      def ccNum = params.cc_number.replaceAll(/\D/, '') as String
      def ccExpVal = String.format("%02d", params.cc_month as Integer) + params.cc_year

      def expCal = new GregorianCalendar()
      expCal.set(Calendar.YEAR, params.cc_year as Integer)
      expCal.set(Calendar.MONTH, (params.cc_month as Integer) -1)
      expCal.set(Calendar.DAY_OF_MONTH, 1)
      expCal.set(Calendar.DAY_OF_MONTH, expCal.getActualMaximum(Calendar.DAY_OF_MONTH))
      rentalTransactionInstance.ccExpDate = expCal.time

      // TODO - compare calculated cost to our cost
      rentalTransactionInstance.cost = costService.calculateMoveInCost(rentalTransactionInstance.site, unit, promo, ins, rentalTransactionInstance.moveInDate, true)
      rentalTransactionInstance.moveInCost = costService.calculateMoveInCost(rentalTransactionInstance.site, unit, promo, ins, rentalTransactionInstance.moveInDate, false)
      rentalTransactionInstance.paidThruDate = costService.calculatePaidThruDate(rentalTransactionInstance.site, promo, rentalTransactionInstance.moveInDate, false)


      def s = new AuthorizeNet()

      def user  = null
      if (!springSecurityService.principal.equals('anonymousUser')) {
        def username  = springSecurityService.principal.username
        user = User.findByUsername(username as String)
      }
      if (!springSecurityService.principal.equals('anonymousUser') && user && UserRole.userHasRole(user, 'ROLE_CALLCENTER')) {

        s.authorizeAndCapture {
          custId rentalTransactionInstance.id as String
          firstName rentalTransactionInstance.billingAddress.firstName
          lastName rentalTransactionInstance.billingAddress.lastName
          address "${rentalTransactionInstance.billingAddress.address1}${rentalTransactionInstance.billingAddress.address2 ? ' ' + rentalTransactionInstance.billingAddress.address2 : ''}"
          city rentalTransactionInstance.billingAddress.city
          state rentalTransactionInstance.billingAddress.state.display
          zip rentalTransactionInstance.billingAddress.zipcode
          ccNumber ccNum
          ccExpDate ccExpVal
          amount rentalTransactionInstance.cost.setScale(2, RoundingMode.HALF_UP) as String
        }
      } else {

        s.authorizeAndCapture {
          custId rentalTransactionInstance.id as String
          firstName rentalTransactionInstance.billingAddress.firstName
          lastName rentalTransactionInstance.billingAddress.lastName
          address "${rentalTransactionInstance.billingAddress.address1}${rentalTransactionInstance.billingAddress.address2 ? ' ' + rentalTransactionInstance.billingAddress.address2 : ''}"
          city rentalTransactionInstance.billingAddress.city
          state rentalTransactionInstance.billingAddress.state.display
          zip rentalTransactionInstance.billingAddress.zipcode
          ccNumber ccNum
          cvv params.cc_cvv2
          ccExpDate ccExpVal
          amount rentalTransactionInstance.cost.setScale(2, RoundingMode.HALF_UP) as String
        }
      }
      def authResp = s.submit()

      println "Credit card response: ${authResp.dump()}"

      if (authResp.responseCode as Integer != 1) {
        flash.message = "Credit card not accepted ${authResp.responseReasonText}"
        redirect (action:'payment', params:["id":rentalTransactionInstance.id])
        return
      }
      println "Logged transaction = ${authResp.dump()}"
      
      rentalTransactionInstance.transactionId = authResp.transactionId
      rentalTransactionInstance.status = TransactionStatus.PAID
      rentalTransactionInstance.save(flush:true)

      // record CC info for the services
      rentalTransactionInstance.ccNum = ccNum
      rentalTransactionInstance.cardType = creditCardService.getCardType(ccNum)
      rentalTransactionInstance.cvv2 = params.cc_cvv2

      rentalTransactionInstance.commission = costService.calculateCommission(rentalTransactionInstance.cost, CommissionSourceType.WEBSITE)

      def ccString = "XXXX XXXX XXXX "
      if (ccNum.size() == 16) {
        ccString += 'XXXX '
      }
      ccString += ccNum.substring(ccNum.size() - 4)
      rentalTransactionInstance.cleanCCNum = ccString

      if (params.landingCookie) {
        def landing = CookieCodec.decodeCookieValue(params.landingCookie)

        if (landing.sem_id) {
          rentalTransactionInstance.searchEngineReferral = new SearchEngineReferral(sem_id:landing.sem_id, ts_code:landing.ts_code, match_type:landing.match_type
            , location_id:landing.location_id, ad_id:landing.ad_id, keyword:landing.keyword
            , landingDate:landing.time, bookingDate:rentalTransactionInstance.bookingDate, commission:rentalTransactionInstance.commission)
        }
      }

      if (!moveInService.moveIn(rentalTransactionInstance)) {
        flash.message = "Problem with move-in.  Please contact technical support. (877) 456-2929 or support@storitz.com"
        // TODO - notify with email to admin
        redirect (action:'payment', params:["id":rentalTransactionInstance.id])
        return
      }

      notificationService.notify(NotificationEventType.NEW_TENANT, rentalTransactionInstance)

      // remove unit from inventory
      if (--unit.unitCount <= 0) {
        rentalTransactionInstance.site.removeFromUnits(unit)
        rentalTransactionInstance.save(flush: true)
      }  else {
        unit.save(flush: true)
      }

      def siteManagerNotification = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
      def siteManager = User.createCriteria().get {
        sites {
          eq("site.id", rentalTransactionInstance.site.id)
        }
        notificationTypes {
          eq("notificationType.id", siteManagerNotification.id)
        }
        maxResults(1)
      }

      render(view:"complete", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, siteManager:siteManager])
    }

    @Secured(['ROLE_ADMIN'])
    def forceBook = {
      def rentalTransactionInstance = RentalTransaction.get(params.id)

      if (!rentalTransactionInstance) {
        // TODO - send them to an error page
      }

      SpecialOffer promo = null
      if (rentalTransactionInstance.promoId > 0) {
        promo = SpecialOffer.get(rentalTransactionInstance.promoId)
      }
      def unit = StorageUnit.get(rentalTransactionInstance.unitId)
      Insurance ins = null
      if (rentalTransactionInstance.insuranceId > 0) {
        ins = Insurance.get(rentalTransactionInstance.insuranceId)
      }
      
      if (!moveInService.moveIn(rentalTransactionInstance)) {
        flash.message = "Problem with move-in.  Please contact technical support. (877) 456-2929 or support@storitz.com"
        // TODO - notify with email to admin
        redirect (action:'payment', params:["id":rentalTransactionInstance.id])
        return
      }

      notificationService.notify(NotificationEventType.NEW_TENANT, rentalTransactionInstance)

      // remove unit from inventory
      if (unit && --unit.unitCount <= 0) {
        rentalTransactionInstance.site.removeFromUnits(unit)
        rentalTransactionInstance.save(flush: true)
      }  else if (unit) {
        unit.save(flush: true)
      }

      def siteManagerNotification = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
      def siteManager = User.createCriteria().get {
        sites {
          eq("site.id", rentalTransactionInstance.site.id)
        }
        notificationTypes {
          eq("notificationType.id", siteManagerNotification.id)
        }
        maxResults(1)
      }

      render(view:"complete", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, siteManager:siteManager])

    }

    @Secured(['ROLE_ADMIN'])
    def forceNotify = {
      def rentalTransactionInstance = RentalTransaction.get(params.id)

      if (!rentalTransactionInstance) {
        // TODO - send them to an error page
      }

      SpecialOffer promo = null
      if (rentalTransactionInstance.promoId > 0) {
        promo = SpecialOffer.get(rentalTransactionInstance.promoId)
      }
      def unit = StorageUnit.get(rentalTransactionInstance.unitId)
      Insurance ins = null
      if (rentalTransactionInstance.insuranceId > 0) {
        ins = Insurance.get(rentalTransactionInstance.insuranceId)
      }


      notificationService.notify(NotificationEventType.NEW_TENANT, rentalTransactionInstance)

      // remove unit from inventory
      if (unit && --unit.unitCount <= 0) {
        rentalTransactionInstance.site.removeFromUnits(unit)
        rentalTransactionInstance.save(flush: true)
      }  else if (unit) {
        unit.save(flush: true)
      }

      def siteManagerNotification = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
      def siteManager = User.createCriteria().get {
        sites {
          eq("site.id", rentalTransactionInstance.site.id)
        }
        notificationTypes {
          eq("notificationType.id", siteManagerNotification.id)
        }
        maxResults(1)
      }

      render(view:"complete", model:[rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, siteManager:siteManager])

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

  def processReservations = {
      storitz.ReservationMoveInJob.triggerNow([from:'Admin', target:params.target]);
      flash.message = "Processed reservations with target date of ${params.target}"
      redirect(controller:"admin", action:"index")
  }

  @Secured(['ROLE_ADMIN'])
  def processNacha = {
    def c = RentalTransaction.createCriteria()
    def results = c.list(params) {
      or {
        eq('status', TransactionStatus.PAID)
        eq('status', TransactionStatus.COMPLETE)
      }
      isNull('achTransferDate')
    }
    nachaService.buildFile(results)
    flash.message = "NACHA processing complete"
    redirect(controller:"admin", action: "index")
  }
}
