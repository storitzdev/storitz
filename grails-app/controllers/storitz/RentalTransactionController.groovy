package storitz

import com.vinomis.authnet.AuthorizeNet
import grails.plugins.springsecurity.Secured
import java.math.RoundingMode
import java.text.ParseException
import com.storitz.*
import storitz.constants.*
import com.storitz.service.CostTotals
import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class RentalTransactionController extends BaseTransactionController {

  def springSecurityService
  def costService
  def moveInService
  def creditCardService
  def notificationService
  def nachaService
  def emailService
  def offerFilterService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST", pay: ["POST", "GET"]]

  static Map liveSessions = [:]

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    [rentalTransactionInstanceList: RentalTransaction.list(params), rentalTransactionInstanceTotal: RentalTransaction.count()]
  }

  def bookingSummaryPanel = {
    renderTransactionPanel("/rentalTransaction/bookingSummaryPanel")
  }

  void updateSessions(params) {
    def site, searchSize, address, date, page, searchType, unitType, shortSessionId;
    /*
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
    def searchType = params.SC_searchType
    params.remove('SC_searchType')
    if (!searchType) {
      searchType = SearchType.STORAGE
    }
    def unitType = params.chosenUnitType

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

    def callParams = [timestamp: System.currentTimeMillis(), shortSessionId: params.id, unitType: unitType, site: site,
            searchSize: searchSize, address: address, date: date, page: page, searchType: searchType,
            rentalTransaction: rentalTransactionInstance, landingCookie: params.landingCookie]
     */
    def callParams = [timestamp: System.currentTimeMillis(), shortSessionId: shortSessionId, unitType: unitType, site: site,
            searchSize: searchSize, address: address, date: date, page: page, searchType: searchType,
            rentalTransaction: rentalTransactionInstance, landingCookie: params.landingCookie]

    liveSessions[params.id] = callParams
  }

  def begin = {
    def site = StorageSite.get(params.siteId as Long)
    def unit = StorageUnit.get(params.unitId as Long)
    // TODO: Check availability here
    def insurance = Insurance.get(params.insuranceId != "" ? params.insuranceId as Long : -1L)
    def promo = SpecialOffer.get(params.promoId != "" ? params.promoId as Long : -1L)
    def moveInDate = new Date();
    if (params.moveInDate) {
      try {
        moveInDate = new SimpleDateFormat("yyyy-MM-dd").parse(params.moveInDate);
      }
      catch (ParseException p) {
        // TODO: Log warning
      }
    }
    def promos = offerFilterService.getValidFeaturedOffers(site, unit);
    promos.addAll(offerFilterService.getValidNonFeaturedOffers(site, unit));
    // TODO: validate that promo is in promos and is valid
    def totals = costService.calculateTotals(site, unit, promo, insurance, moveInDate);
    [site:site, unit:unit, promos:promos, promo:promo, insurance:insurance, totals:totals, moveInDate:moveInDate]
  }

  def ajaxPoll = {
    render {
      span("${session.shortSessionId} ${new Date()}")
    }
  }

  def ajaxUpdate = {

    render(status: 200, contentType: "application/json", text: "{ 'update':false }")
  }

  def create = {
    def site = StorageSite.get(params.siteId as Long)
    def unit = StorageUnit.get(params.unitId as Long)
    def insurance = Insurance.get(params.insuranceId ? params.insuranceId as Long : -1L)
    def promo = SpecialOffer.get(params.promoId ? params.promoId as Long : -1L)
    params.terms = (params._terms == 'y')
    def rentalTransactionInstance = new RentalTransaction(params)
    def contact = new com.storitz.Contact(params)
    contact.rental = rentalTransactionInstance;
    rentalTransactionInstance.contactPrimary = contact;
    rentalTransactionInstance.billingAddress = contact; // TODO: Restore support for multiple addresses
    rentalTransactionInstance.rentalUse = RentalUse.PERSONAL; // TODO: check params & look up enum using param value if present
    rentalTransactionInstance.activeMilitary = (params.activeMilitary ? (params.activeMilitary == 'y') : false);
    rentalTransactionInstance.searchSize = StorageSize.get((params.searchSize ? (params.searchSize as Long) : 1));
    rentalTransactionInstance.unitType = unit.unitType;
    rentalTransactionInstance.status = TransactionStatus.BEGUN
    rentalTransactionInstance.site = site
    rentalTransactionInstance.reserveTruck = (params.reserveTruck ? params.reserveTruck : false) // TODO: restore checkbox in UI
    rentalTransactionInstance.transactionType = rentalTransactionInstance.site.transactionType
    rentalTransactionInstance.bookingDate = new Date()
    rentalTransactionInstance.moveInDate = new Date();
    if (params.moveInDate) {
      try {
        rentalTransactionInstance.moveInDate = new SimpleDateFormat("yyyy-MM-dd").parse(params.moveInDate);
      }
      catch (ParseException p) {
        // TODO: Log warning
      }
    }
    // check if no promo selected
    if (promo == null) {
      rentalTransactionInstance.promoId = -999;
    } else {
      rentalTransactionInstance.promoId = promo.id
    }
    if (insurance == null) {
      rentalTransactionInstance.insuranceId = -999
    } else {
      rentalTransactionInstance.insuranceId = insurance.id
    }

    rentalTransactionInstance.monthlyRate = unit.bestUnitPrice

    // TODO - compare calculated cost to our cost
    rentalTransactionInstance.moveInCost = costService.calculateMoveInCost(site, unit, promo, insurance, rentalTransactionInstance.moveInDate, false)
    CostTotals costTotals = costService.calculateTotals(site, unit, promo, insurance, rentalTransactionInstance.moveInDate)
    if (rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION) {
      rentalTransactionInstance.cost = rentalTransactionInstance.site.rentalFee
    } else {
      rentalTransactionInstance.cost = costTotals.moveInTotal
    }
    rentalTransactionInstance.moveInCost = costTotals.moveInTotal
    rentalTransactionInstance.duration = costTotals.duration
    rentalTransactionInstance.discount = costTotals.discountTotal
    rentalTransactionInstance.fees = costTotals.feesTotal
    rentalTransactionInstance.insuranceCost = costTotals.insuranceCost
    rentalTransactionInstance.tax = costTotals.tax
    rentalTransactionInstance.deposit = costTotals.deposit
    rentalTransactionInstance.durationDays = costTotals.durationDays
    rentalTransactionInstance.durationMonths = costTotals.durationMonths
    rentalTransactionInstance.paidThruDate = costTotals.paidThruDate
    rentalTransactionInstance.displaySize = unit?.displaySize

    if (promo) {
      rentalTransactionInstance.promoName = promo.promoName
    }
    if (insurance) {
      rentalTransactionInstance.insuranceName = "Total Coverage: ${g.formatNumber(number: ins.totalCoverage, type: 'currency', currencyCode: 'USD')} Theft: ${g.formatNumber(number: ins.percentTheft, type: 'percent')}"
    } else {
      rentalTransactionInstance.insuranceName = "None purchased"
    }

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

    def promos = offerFilterService.getValidFeaturedOffers(site, unit);
    promos.addAll(offerFilterService.getValidNonFeaturedOffers(site, unit));
    // TODO: validate that promo is in promos and is valid
    def totals = costService.calculateTotals(site, unit, promo, insurance, rentalTransactionInstance.moveInDate);

    if (!moveInService.isAvailable(rentalTransactionInstance)) {
      removeUnit(rentalTransactionInstance)
      def alternateUnit = findAlternateUnit(rentalTransactionInstance, unit)
      promos = offerFilterService.getValidFeaturedOffers(site, alternateUnit);
      promos.addAll(offerFilterService.getValidNonFeaturedOffers(site, alternateUnit));
      if (promo && !promos.contains(promo)) {
        promo = null;
      }
      totals = costService.calculateTotals(site, alternateUnit, promo, insurance, rentalTransactionInstance.moveInDate);
      render(view:"begin", model:[rentalTransactionInstance:rentalTransactionInstance, unit:alternateUnit, site:site, promo:promo, promos:promos, insurance:insurance, totals:totals, moveInDate: rentalTransactionInstance.moveInDate]);
      return
    }

    def moveInDetails = moveInService.moveInDetail(rentalTransactionInstance)
    rentalTransactionInstance.feedMoveInCost = moveInDetails?.total()

    def isFreeReservation = (rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION && rentalTransactionInstance.site.rentalFee == 0);
    if (!isFreeReservation) {
      def expCal = new GregorianCalendar()
      expCal.set(Calendar.YEAR, params.cc_year as Integer)
      expCal.set(Calendar.MONTH, (params.cc_month as Integer) - 1)
      expCal.set(Calendar.DAY_OF_MONTH, 1)
      expCal.set(Calendar.DAY_OF_MONTH, expCal.getActualMaximum(Calendar.DAY_OF_MONTH))
      rentalTransactionInstance.ccExpDate = expCal.time
      rentalTransactionInstance.ccNum = params.cc_number.replaceAll(/\D/, '') as String
      rentalTransactionInstance.cardType = creditCardService.getCardType(rentalTransactionInstance.ccNum)

      // cardType and cvv2 should be set directly from params.cardType and params.cvv2
      // note that these model object attributes are marked transient and will not be persisted to the db
    }

    rentalTransactionInstance.validate();
    contact.validate();

    if (rentalTransactionInstance.hasErrors()) {
      render(view:"begin", model:[rentalTransactionInstance:rentalTransactionInstance, contact:contact, unit:unit, site:site, promo:promo, promos:promos, insurance:insurance, totals:totals, moveInDate: rentalTransactionInstance.moveInDate]);
      return;
    }

    if (!performTransaction(rentalTransactionInstance, isFreeReservation)) {
      render(view:"begin", model:[rentalTransactionInstance:rentalTransactionInstance, contact:contact, unit:unit, site:site, promo:promo, promos:promos, insurance:insurance, totals:totals, moveInDate: rentalTransactionInstance.moveInDate]);
      return;
    }

    // remove unit from inventory
    if (--unit.unitCount <= 0) {
      rentalTransactionInstance.site.removeFromUnits(unit)
      rentalTransactionInstance.save(flush: true)
    } else {
      unit.save(flush: true)
    }

    if (!rentalTransactionInstance.save(flush: true)) {
      render(view:"begin", model:[rentalTransactionInstance:rentalTransactionInstance, contact:contact, unit:unit, site:site, promo:promo, promos:promos, insurance:insurance, totals:totals, moveInDate: rentalTransactionInstance.moveInDate]);
      return;
    }

    redirect(url:createLink(mapping:'thankYou', params:[id:rentalTransactionInstance.id]))
  }

  def thankYou = {
    def rentalTransactionInstance = RentalTransaction.get(params.id as Long)
    def promo = SpecialOffer.get(rentalTransactionInstance.promoId);
    [rentalTransactionInstance:rentalTransactionInstance, promo:promo]
  }

  def removeUnit = { RentalTransactionInstance, unit ->
    println "Removing unit from inventory ${unit.id}"
    rentalTransactionInstance.site.removeFromUnits(unit)
    rentalTransactionInstance.site.save(flush: true)
    emailMoveInProblemReportToTechTeam("Removing unit from inventory ${unit.id}", rentalTransactionInstance)
  }

  def findAlternateUnit = { rentalTransactionInstance, unit ->
    def alternateUnit = null;
    def bestUnitList = rentalTransactionInstance.site.units.findAll { it.unitType == unit.unitType && it.unitsize.id == unit.unitsize.id && it.id != unit?.id }.sort { it.price }
    println "BestUnit size = ${bestUnitList.size()} rentalTransaction = ${rentalTransactionInstance.dump()}"
    for (myUnit in bestUnitList) {
      rentalTransactionInstance.unitId = myUnit.id
      if (moveInService.isAvailable(rentalTransactionInstance)) {
        alternateUnit = myUnit
        emailMoveInProblemReportToTechTeam("Desired unit not found. Alternate unit selected.", rentalTransactionInstance)
        flash.message = "The unit you have selected is no longer available.  We have found the next best unit that matches your search criteria."
        break
      } else {
        removeUnit(rentalTransactionInstance, unit)
      }
    }
    if (alternateUnit == null) {
      emailMoveInProblemReportToTechTeam("Unit not found during rental transaction!", rentalTransactionInstance)
      flash.message = "Unit already reserved - refresh and try again"
    }
    return alternateUnit;
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

  private emailMoveInProblemReportToTechTeam(String subject, RentalTransaction rentalTransactionInstance) {
    try {
      int transID = rentalTransactionInstance.id
      int unitID = rentalTransactionInstance.unitId
      String body = "rentalTransactionInstance.id:"+transID+"\nrentalTransactionInstance.unitId:"+unitID+"\n"
      emailService.sendTextEmail(
        to: 'tech@storitz.com',
        from: 'no-reply@storitz.com',
        subject: grails.util.Environment.getCurrent().toString() + ":" + subject,
        body: body
      )
    } catch (Throwable t) {
        t.printStackTrace()
    }
  }

  private boolean performTransaction(RentalTransaction rentalTransactionInstance, boolean isFreeReservation) {

    if (!isFreeReservation) {
      def ccExpVal = String.format("%02d", params.cc_month as Integer) + params.cc_year

      def s = new AuthorizeNet()

      def user = null
      if (!springSecurityService.principal.equals('anonymousUser')) {
        def username = springSecurityService.principal.username
        user = User.findByUsername(username as String)
      }
      if (!springSecurityService.principal.equals('anonymousUser') && user && UserRole.userHasRole(user, 'ROLE_CALLCENTER')) {

        s.authorizeAndCapture {
          firstName rentalTransactionInstance.billingAddress.firstName
          lastName rentalTransactionInstance.billingAddress.lastName
          address "${rentalTransactionInstance.billingAddress.address1}${rentalTransactionInstance.billingAddress.address2 ? ' ' + rentalTransactionInstance.billingAddress.address2 : ''}"
          city rentalTransactionInstance.billingAddress.city
          state rentalTransactionInstance.billingAddress.state.display
          zip rentalTransactionInstance.billingAddress.zipcode
          ccNumber rentalTransactionInstance.ccNum
          ccExpDate ccExpVal
          amount rentalTransactionInstance.cost.setScale(2, RoundingMode.HALF_UP) as String
        }
      } else if (rentalTransactionInstance.site.source == "EX") {
        s.authorizeOnly {
          firstName rentalTransactionInstance.billingAddress.firstName
          lastName rentalTransactionInstance.billingAddress.lastName
          address "${rentalTransactionInstance.billingAddress.address1}${rentalTransactionInstance.billingAddress.address2 ? ' ' + rentalTransactionInstance.billingAddress.address2 : ''}"
          city rentalTransactionInstance.billingAddress.city
          state rentalTransactionInstance.billingAddress.state.display
          zip rentalTransactionInstance.billingAddress.zipcode
          ccNumber rentalTransactionInstance.ccNum
          cvv rentalTransactionInstance.cvv2
          ccExpDate ccExpVal
          amount rentalTransactionInstance.cost.setScale(2, RoundingMode.HALF_UP) as String
        }
      } else {
        s.authorizeAndCapture {
          firstName rentalTransactionInstance.billingAddress.firstName
          lastName rentalTransactionInstance.billingAddress.lastName
          address "${rentalTransactionInstance.billingAddress.address1}${rentalTransactionInstance.billingAddress.address2 ? ' ' + rentalTransactionInstance.billingAddress.address2 : ''}"
          city rentalTransactionInstance.billingAddress.city
          state rentalTransactionInstance.billingAddress.state.display
          zip rentalTransactionInstance.billingAddress.zipcode
          ccNumber rentalTransactionInstance.ccNum
          cvv rentalTransactionInstance.cvv2
          ccExpDate ccExpVal
          amount rentalTransactionInstance.cost.setScale(2, RoundingMode.HALF_UP) as String
        }
      }

      if (ConfigurationHolder.config?.storitz?.rentals?.sandboxMode) {
        println "SANDBOX MODE: Skipping credit card auth/change"
        rentalTransactionInstance.transactionId = "123456"
      }
      else {
        def authResp = s.submit();
        println "Credit card response: ${authResp.dump()}"
        if (authResp.responseCode as Integer != 1) {
          flash.message = "Credit card not accepted ${authResp.responseReasonText}"
          return false
        }
        println "Logged transaction = ${authResp.dump()}"

        rentalTransactionInstance.transactionId = authResp.transactionId
      }

      def ccString = "XXXX XXXX "
      if (rentalTransactionInstance.ccNum.size() == 16) {
        ccString += "XXXX "
      }
      ccString += rentalTransactionInstance.ccNum.substring(rentalTransactionInstance.ccNum.size() - 4)
      rentalTransactionInstance.cleanCCNum = ccString
    }

    rentalTransactionInstance.commission = costService.calculateCommission(rentalTransactionInstance.monthlyRate, rentalTransactionInstance.site.feed)
    rentalTransactionInstance.status = isFreeReservation ? TransactionStatus.RESERVED : TransactionStatus.PAID
    rentalTransactionInstance.save(flush: true)

    def landing = CookieCodec.decodeCookieValue(CookieCodec.getCookie(request, CookieCodec.LANDING_COOKIE_NAME).getValue())

    def ser
    if (landing?.serId) {
      ser = SearchEngineReferral.get(landing.serId as Long)
    }
    if (ser) {
      // TODO - handle possible multiple rentals

      // record transaction
      ser.bookingDate = new Date()
      ser.commission = rentalTransactionInstance.commission
      ser.save(flush: true)
      rentalTransactionInstance.searchEngineReferral = ser
      rentalTransactionInstance.save(flush: true)
    }

    if (ConfigurationHolder.config?.storitz?.rentals?.sandboxMode) {
      println "SANDBOX MODE: Skipping moveIn"
    }
    else {
      if (rentalTransactionInstance.transactionType == TransactionType.RESERVATION) {
        if (!moveInService.reserve(rentalTransactionInstance)) {
          flash.message = "Problem with move-in.  Please contact technical support. (877) 456-2929 or support@storitz.com"
          emailMoveInProblemReportToTechTeam("moveInService failed for reservation!", rentalTransactionInstance)
          return false;
        }
      } else {
        if (!moveInService.moveIn(rentalTransactionInstance)) {
          flash.message = "Problem with move-in.  Please contact technical support. (877) 456-2929 or support@storitz.com"
          emailMoveInProblemReportToTechTeam("moveInService failed for rental!", rentalTransactionInstance)
          return false;
        }
      }
    }
    if (ConfigurationHolder.config?.storitz?.rentals?.sandboxMode) {
      println "SANDBOX MODE: Skipping notification"
    }
    else {
      notificationService.notify(NotificationEventType.NEW_TENANT, rentalTransactionInstance)
    }
    return true;
  }

  @Secured(['ROLE_ADMIN'])
  def forceBook = {
    RentalTransaction rentalTransactionInstance = RentalTransaction.get(params.id)
    rentalTransactionInstance.cardType = params.cardType ? CreditCardType.getEnumFromId(params.cardType) : CreditCardType.VISA
    rentalTransactionInstance.ccNum = params.ccNum
    rentalTransactionInstance.ccExpDate = Date.parse('yyyy-MM-dd', params.ccExpDate)
    rentalTransactionInstance.cvv2 = params.cvv2

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
      redirect(action: 'payment', params: ["id": rentalTransactionInstance.id])
      return
    }

    if (params.notify) {
      notificationService.notify(NotificationEventType.NEW_TENANT, rentalTransactionInstance)
    }

    // remove unit from inventory
    if (unit && --unit.unitCount <= 0) {
      rentalTransactionInstance.site.removeFromUnits(unit)
      rentalTransactionInstance.save(flush: true)
    } else if (unit) {
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

    render(view: "complete", model: [rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, siteManager: siteManager])

  }

  @Secured(['ROLE_ADMIN'])
  def forceNotify = {
    def rentalTransactionInstance = RentalTransaction.get(params.id)

    if (!rentalTransactionInstance) {
      // TODO - send them to an error page
    }

    SpecialOffer promo = null
    if (rentalTransactionInstance.promoId && rentalTransactionInstance.promoId > 0) {
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
    } else if (unit) {
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

    render(view: "complete", model: [rentalTransactionInstance: rentalTransactionInstance, site: rentalTransactionInstance.site, promo: promo, unit: unit, siteManager: siteManager])

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
    storitz.ReservationMoveInJob.triggerNow([from: 'Admin', target: params.target]);
    flash.message = "Processed reservations with target date of ${params.target}"
    redirect(controller: "admin", action: "index")
  }

  @Secured(['ROLE_ADMIN'])
  def processNacha = {
    def c = RentalTransaction.createCriteria()
    def results = c.list(params) {
      and {
        or {
          eq('status', TransactionStatus.PAID)
          eq('status', TransactionStatus.COMPLETE)
        }
        or {
          ne('checkIssued', true)
          isNull('checkIssued')
        }
        isNull('achTransferDate')
      }
    }
    nachaService.buildFile(results)
    flash.message = "NACHA processing complete"
    redirect(controller: "admin", action: "index")
  }
}
