package storitz

import com.vinomis.authnet.AuthorizeNet
import grails.plugins.springsecurity.Secured
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
  def mailService
  def offerFilterService

  static transactional = true

  static allowedMethods = [save: "POST", update: "POST", delete: "POST", pay: ["POST", "GET"]]

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

  def beginCheckoutError = {}

  def begin = {
    String xid = params.xid ? params.xid : UUID.randomUUID().toString().toUpperCase();
    RentalTransaction trans = RentalTransaction.findByXid(xid);
    if (trans != null) {
      xid = UUID.randomUUID().toString().toUpperCase();
      trans = RentalTransaction.findByXid(xid);
    }
    if (trans != null) {
      emailMoveInProblemReportToTechTeam(null, params?.unitId as Long, "UUID collision for '${xid}'", null)
      log.error("UUID collision for '${xid}'")
      redirect(action:"beginCheckoutError");
      return
    }

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
        // Note: If the move-in date can't be parsed, the subsequent code will
        // translate the null moveInDate as today. This is a silent error.
        // We'll insert a message into the flash memory to warn the user
        // so they can reset their move-in date.
        flash.message = "Problem reading move-in date.  Please contact technical support. (877) 456-2929 or support@storitz.com"
        log.error("begin: Unable to parse ${params.moveInDate} as Date!", p)
      }
    }
    def promos = offerFilterService.getValidFeaturedOffers(site, unit);
    promos.addAll(offerFilterService.getValidNonFeaturedOffers(site, unit));
    // TODO: validate that promo is in promos and is valid
    def totals = costService.calculateTotals(site, unit, promo, insurance, moveInDate);
    [site:site, unit:unit, promos:promos, promo:promo, insurance:insurance, totals:totals, moveInDate:moveInDate, xid:xid]
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
    // all of the following objects are initialized in the following try block...
    def trans = null
    def t = RentalTransaction.findByXid(params.xid);
    if (t) {
      if (t.status == TransactionStatus.COMPLETE || t.status == TransactionStatus.CANCELED) {
        log.warn("Checkout request received with expired xid ${params.xid}")
        render(view:"xidExpired");
        return;
      }
      trans = t;
    }
    def unit = null;
    def site = null;
    def promo = null;
    def insurance = null;
    def totals = [:]
    def promos = []
    try {
      // validate params
      site = StorageSite.get(params.siteId as Long)
      unit = StorageUnit.get(params.unitId as Long)
      if (!site || !unit) {
        throw new Exception("Error: site or unit not found: siteId: ${params.siteId}, unitId: ${params.unitId}")
      }

      params.terms = (params._terms == 'y')
      // populate all model objects with data...  (TODO: this is *way* too much work to be doing here)
      if (!trans) { // brand new transaction (user hasn't been here before...)
        trans = new RentalTransaction(params);
        trans.contactPrimary = new com.storitz.Contact(params);
        trans.contactPrimary.rental = trans; // TODO: necessary?
        trans.site = site // TODO: many methods that require a RentalTransaction instance will fail if trans.site is null, method signatures should be refactored
      }
      else { // old transaction; merge new data from HTTP request into existing records
        trans.properties = params;
        trans.contactPrimary.properties = params;
      }

      insurance = Insurance.get(params.insuranceId ? params.insuranceId as Long : -1L)
      promo = SpecialOffer.get(params.promoId ? params.promoId as Long : -1L)
      promos = offerFilterService.getValidFeaturedOffers(site, unit);
      promos.addAll(offerFilterService.getValidNonFeaturedOffers(site, unit));
      if (promo && !promos.contains(promo)) {
        promo = null;
      }
      totals = costService.calculateTotals(site, unit, promo, insurance, trans.moveInDate);
      trans.moveInDate = new Date();
      if (params.moveInDate) {
        try {
          trans.moveInDate = new SimpleDateFormat("yyyy-MM-dd").parse(params.moveInDate);
        }
        catch (ParseException p) {
          log.error("create: Unable to parse ${params.moveInDate} as Date!", p)
          throw p;
        }
      }

      trans.billingAddress = trans.contactPrimary; // TODO: Restore support for multiple addresses
      trans.rentalUse = RentalUse.PERSONAL; // TODO: check params & look up enum using param value if present
      trans.isCallCenter = false
      trans.activeMilitary = (params.activeMilitary ? (params.activeMilitary == 'y') : false);
      trans.searchSize = StorageSize.get((params.searchSize ? (params.searchSize as Long) : 1));
      trans.status = TransactionStatus.BEGUN
      trans.reserveTruck = (params.reserveTruck ? (params.reserveTruck == 'y') : false) // TODO: restore checkbox in UI
      trans.bookingDate = new Date()
      // check if promo and insurance are selected
      trans.promoId = (promo == null) ? -999 : promo.id;
      trans.insuranceId = (insurance == null) ? -999 : insurance.id;
      trans.monthlyRate = unit.bestUnitPrice;
      trans.displaySize = unit.displaySize
      trans.unitType = unit.unitType;
      // TODO - compare calculated cost to our cost
      trans.moveInCost = costService.calculateMoveInCost(site, unit, promo, insurance, trans.moveInDate, false)
      CostTotals costTotals = costService.calculateTotals(site, unit, promo, insurance, trans.moveInDate)
      trans.moveInCost = costTotals.moveInTotal
      trans.duration = costTotals.duration
      trans.discount = costTotals.discountTotal
      trans.fees = costTotals.feesTotal
      trans.insuranceCost = costTotals.insuranceCost
      trans.tax = costTotals.tax
      trans.deposit = costTotals.deposit
      trans.durationDays = costTotals.durationDays
      trans.durationMonths = costTotals.durationMonths
      trans.paidThruDate = costTotals.paidThruDate

      trans.transactionType = site.transactionType
      boolean isReservation = (trans.transactionType == TransactionType.RESERVATION);
      trans.cost = isReservation ? site.rentalFee : costTotals.moveInTotal;
      def moveInDetails = moveInService.moveInDetail(trans)
      trans.feedMoveInCost = moveInDetails?.total()

      if (promo) {
        trans.promoName = promo.promoName
      }
      if (insurance) {
        // TODO: We're invoking taglib functions here!?!?!?! wtf?
        trans.insuranceName = "Total Coverage: ${g.formatNumber(number: insurance.totalCoverage, type: 'currency', currencyCode: 'USD')} Theft: ${g.formatNumber(number: insurance.percentTheft, type: 'percent')}"
      } else {
        trans.insuranceName = "None purchased"
      }

      // run model validations ...
      trans.contactPrimary.validate();
      trans.validate();

      if (!trans.hasErrors()) {
        trans.save()
      }
      else {
        trans.status = TransactionStatus.DATA_VALIDATION_FAILED;
        throw new Error(trans.status.name);
      }

      // basic params look ok, check availability
      if (!moveInService.isAvailable(trans)) { // requires trans.unitId and trans.site to be populated
        removeUnit(trans, unit) // ... and this also requires trans.site
        unit = findAlternateUnit(trans, unit) // ... as does this :(
        promos = offerFilterService.getValidFeaturedOffers(site, unit);
        promos.addAll(offerFilterService.getValidNonFeaturedOffers(site, unit));
        if (promo && !promos.contains(promo)) {
          promo = null;
        }
        totals = costService.calculateTotals(site, unit, promo, insurance, trans.moveInDate);
        trans.status = TransactionStatus.UNIT_UNAVAILABILITY_FAILED;
        throw new Error(trans.status.name)
      }

      // availability ok, finish building model objects
      def isFreeReservation = (isReservation && site.rentalFee == 0);
      if (!isFreeReservation) {
        def expCal = new GregorianCalendar()
        expCal.set(Calendar.YEAR, params.cc_year as Integer)
        expCal.set(Calendar.MONTH, (params.cc_month as Integer) - 1)
        expCal.set(Calendar.DAY_OF_MONTH, 1)
        expCal.set(Calendar.DAY_OF_MONTH, expCal.getActualMaximum(Calendar.DAY_OF_MONTH))
        trans.ccExpDate = expCal.time
        trans.ccNum = params.cc_number.replaceAll(/\D/, '') as String
        trans.cardType = creditCardService.getCardType(trans.ccNum)
        // cardType and cvv2 should be set directly from params.cardType and params.cvv2
        // note that these model object attributes are marked transient and will not be persisted to the db
      }


      // model objects passed validations...
      // next up:
      //   1. record the referral source
      //   2. if cost > 0, process the payment (if cost > 0)
      //   3. calculate commission
      //   4. create the move-in or reservation in the operator's system
      //   5. send the notifications

      // record referral
      def landing = CookieCodec.decodeCookieValue(CookieCodec.getCookie(request, CookieCodec.LANDING_COOKIE_NAME).getValue())
      def ser = null;
      if (landing?.serId) {
        ser = SearchEngineReferral.get(landing.serId as Long)
      }
      if (ser) {
        // TODO - handle possible multiple rentals
        ser.bookingDate = new Date()
        ser.commission = trans.commission
        ser.save(flush: true)
        trans.searchEngineReferral = ser
      }
      trans.save(flush:true)

      // charge card
      if (!isFreeReservation) {
        def ccExpVal = String.format("%02d", params.cc_month as Integer) + params.cc_year
        def s = new AuthorizeNet()
        if (site.source == "EX") {
          s.authorizeOnly {
            firstName trans.billingAddress.firstName
            lastName trans.billingAddress.lastName
            address "${trans.billingAddress.address1}${trans.billingAddress.address2 ? ' ' + trans.billingAddress.address2 : ''}"
            city trans.billingAddress.city
            state trans.billingAddress.state.display
            zip trans.billingAddress.zipcode
            ccNumber trans.ccNum
            cvv trans.cvv2
            ccExpDate ccExpVal
            amount StoritzUtil.roundToMoney(trans.cost) as String
          }
        }
        else {
          s.authorizeAndCapture {
            firstName trans.billingAddress.firstName
            lastName trans.billingAddress.lastName
            address "${trans.billingAddress.address1}${trans.billingAddress.address2 ? ' ' + trans.billingAddress.address2 : ''}"
            city trans.billingAddress.city
            state trans.billingAddress.state.display
            zip trans.billingAddress.zipcode
            ccNumber trans.ccNum
            cvv trans.cvv2
            ccExpDate ccExpVal
            amount StoritzUtil.roundToMoney(trans.cost) as String
          }
        }
        println "Submiting AuthNet cc request to ${ConfigurationHolder.config?.authorizeNet?.urlString}"
        def authResp = s.submit();
        println "AuthNet cc response: ${authResp.dump()}"
        trans.transactionId = authResp.transactionId
        if (authResp.responseCode as Integer == 1) {
          trans.status = TransactionStatus.PAID;
        }
        else {
          trans.status = TransactionStatus.CREDIT_CARD_FAILED;
          trans.errorMessage = authResp.responseReasonText;
          throw new Error(trans.status.name);
        }

        def ccString = "XXXX XXXX "
        if (trans.ccNum.size() == 16) {
          ccString += "XXXX "
        }
        ccString += trans.ccNum.substring(trans.ccNum.size() - 4)
        trans.cleanCCNum = ccString
      }
      else {
        trans.status = TransactionStatus.PAID;
      }

      // if payment succeeded or was not required, attempt the move in.
      if (trans.status == TransactionStatus.PAID) {
        // calculate commission
        trans.commission = costService.calculateCommission(trans.monthlyRate, site.feed)

        boolean sandboxMode = ConfigurationHolder.config?.storitz?.rentals?.sandboxMode;
        boolean movedIn = isReservation ? moveInService.reserve(trans, sandboxMode) : moveInService.moveIn(trans, sandboxMode);
        if (movedIn) {
          trans.status = TransactionStatus.COMPLETE;
          notificationService.notify(NotificationEventType.NEW_TENANT, trans, sandboxMode);
          // Unit housekeeping
          if (--unit.unitCount < 0) {
            unit.unitCount = 0
          }
          unit.save(flush: true)

          // JM: Stick this rental transaction id into session (good until the browser closes)
          // memory. We'll use this in the thankYou action to validate that the user has
          // need-to-know before showing them the transaction details. (No snooping)
          if (!session.transaction) {
            session.transaction = [:]
          }
          session.transaction[(int)trans.id] =  true
        }
      }
    }
    catch (Throwable e) {
      try {
        String status = trans ? trans.status.name : "UNK"
        Long transId = trans ? trans.id : -1;
        String name = trans && trans.contactPrimary ? "${trans.contactPrimary.firstName} ${trans.contactPrimary.lastName}" : "unknown";
        log.error("Error processing move-in ${e}}")
        String stackTrace = StoritzUtil.stackTraceToString(e)
        StringBuilder emailBody = new StringBuilder()
        emailBody.append("customer: ${name}")
        emailBody.append("\ntransaction id: ${transId}")
        emailBody.append("\nstatus: ${status}")
        emailBody.append("\n\n${stackTrace}")
        emailMoveInProblemReportToTechTeam(transId, params?.unitId as Long, "RentalTransactionController.create Exception!", emailBody.toString())
      }
      catch (Throwable e2) {
        // You have got to be kidding me...
        log.error("ERROR: Error caught while sending email to report previous error!", e2)
        log.error("ERROR: Original error", e)
      }
    }
    finally {
      String err = null;
      Long transId = trans ? trans.id : -1;
      if (!trans) {
        err = "TRANSACTION FAILURE: NULL RentalTransaction object"
        trans = new RentalTransaction() // fake object here, so switch statements are uniform below
        trans.status = TransactionStatus.BEGUN
      }
      else {
        try {
          trans.save(flush: true)
        }
        catch (Throwable e) {
          log.error("ERROR caught while saving transaction", e)
        }
      }
      switch (trans.status) {
        case TransactionStatus.CREDIT_CARD_FAILED:
          err = "TRANSACTION FAILURE: Credit card failed"
          String msg = "We were unable to process your transaction because your credit card could not be charged. " + \
                       "<b>Please double-check your card and customer billing information, and try again</b>. " + \
                        "Please note that your contact information must match the billing information for the card. " + \
                        "(Error message: '${trans.errorMessage}')"
          flash.message = msg;
          break;
        case TransactionStatus.UNIT_UNAVAILABILITY_FAILED:
          if (unit == null) {
            err = "TRANSACTION FAILURE: Unit not available, alternate NOT found"
            flash.message = "The unit you selected is no longer available, and we were unable to locate another unit in the same size category at this facility. Please go back and select a differnt size, or try another facility."
          }
          else {
            err = "TRANSACTION FAILURE: Unit not available, alternate found"
            flash.message = "The unit you have selected is no longer available. We have found the best-priced available unit in the same size category."
          }
          break;
        case TransactionStatus.DATA_VALIDATION_FAILED:
          err = "TRANSACTION FAILURE: Data validation failed";
          break;
        case TransactionStatus.PAID:
          err =  "TRANSACTION FAILURE: Move-in service failed"
          break;
      }
      if (err != null) {
        emailMoveInProblemReportToTechTeam(trans.id, params?.unitId as Long, err, null)
      }
      switch (trans.status) {
        case TransactionStatus.PAID:
        case TransactionStatus.COMPLETE:
          redirect(action:"thankYou", params:[id:trans.id])
          break;
        case TransactionStatus.DATA_VALIDATION_FAILED:
        case TransactionStatus.UNIT_UNAVAILABILITY_FAILED:
        case TransactionStatus.CREDIT_CARD_FAILED:
          render(view:"begin",
                  model:[rentalTransactionInstance:trans, contact:trans.contactPrimary, unit:unit, site:site,
                          promo:promo, promos:promos, insurance:insurance, totals:totals,
                          moveInDate:trans.moveInDate, xid:params.xid, cardType:params.cardType,
                          cc_month:params.cc_month, cc_year:params.cc_year, cvv2:params.cvv2]);
          break;
        case TransactionStatus.BEGUN:
          render(view:"error", model:[trans:trans]);
          break;
      }
    }
  }

  def thankYou = {
    def rentalTransactionInstance = RentalTransaction.get(params.id as Long)
    if (!rentalTransactionInstance) {
      log.info "RentalTransactionController.thankYou: Failed to find rental transaction for id=${params.id}"
      redirect (controller: "home", action: "index");
    }

    // JM: If this user did not just rent this unit, then bail out. (No snooping)
    if (!(session.transaction && session.transaction[(int)rentalTransactionInstance.id])) {
      redirect (controller: "home", action: "index");
    }

    def site = rentalTransactionInstance.site
    def unit = StorageUnit.get(rentalTransactionInstance.unitId)
    def promo = SpecialOffer.get(rentalTransactionInstance.promoId);
    def insurance = Insurance.get(rentalTransactionInstance.insuranceId)
    def movein = rentalTransactionInstance.moveInDate
    def totals = costService.calculateTotals(site,unit,promo,insurance,movein)

    [rentalTransactionInstance:rentalTransactionInstance, promo:promo, totals:totals, site:site, unit:unit, insurance:insurance]
  }

  def removeUnit = { trans, unit ->
    log.info "Removing unit from inventory ${unit.id}"
    unit.unitCount = 0
    unit.save(flush: true)
    emailMoveInProblemReportToTechTeam(trans.id, unit.id, "Removing unit from inventory ${unit.id}", null)
  }

  private StorageUnit findAlternateUnit(RentalTransaction trans, unit) {
    def bestUnitList = trans.site.units.findAll { it.unitCount > trans.site.minInventory && it.unitsize.id == unit.unitsize.id && it.id != unit?.id }.sort { it.bestUnitPrice }
    println "BestUnit size = ${bestUnitList.size()} rentalTransaction = ${trans.dump()}"
    for (alternateUnit in bestUnitList) {
      trans.unitId = alternateUnit.id // N.B. this is done just so that isAvailable() works on the next line :(
      if (moveInService.isAvailable(trans)) {
        return alternateUnit;
      } else {
        removeUnit(trans, alternateUnit)
      }
    }
    return null;
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

  private emailMoveInProblemReportToTechTeam(Long transId, Long unitId, String subjt, String bodee) {
    try {
      String bdy = "rentalTransactionInstance.id:"+transId+"\nrentalTransactionInstance.unitId:"+unitId+"\n"+bodee;
      def subj = "${grails.util.Environment.getCurrent().toString()} : ${subjt}"
      mailService.sendMail {
        to 'tech@storitz.com'
        from 'no-reply@storitz.com'
        subject subj.toString()
        body bdy
      }
    } catch (Throwable t) {
        t.printStackTrace()
    }
  }

  @Secured(['ROLE_ADMIN'])
  def forceNotify = {
    def trans = RentalTransaction.get(params.id)
    boolean sandboxMode = ConfigurationHolder.config?.storitz?.rentals?.sandboxMode;
    notificationService.notify(NotificationEventType.NEW_TENANT, trans, sandboxMode);
    render(view: "notificationSent", model: [trans:trans])
  }

  def edit = {
    def rentalTransactionInstance = RentalTransaction.get(params.id)
    if (!rentalTransactionInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
      redirect(action: "list")
      return
    }
    return [rentalTransactionInstance: rentalTransactionInstance]
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