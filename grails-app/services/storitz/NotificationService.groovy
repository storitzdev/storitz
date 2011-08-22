package storitz

import com.storitz.NotificationType
import com.storitz.RentalTransaction
import com.storitz.User
import java.text.NumberFormat
import storitz.constants.NotificationEventType
import storitz.constants.TransactionType

class NotificationService {

  def mailService

  static transactional = true

  def notify(NotificationEventType eventType, RentalTransaction rentalTransaction) {
    notify(eventType, rentalTransaction, false);
  }

  def notify(NotificationEventType eventType, RentalTransaction rentalTransaction, boolean sandboxMode) {

    switch (eventType) {
      case NotificationEventType.NEW_TENANT:
        handleNewTenant(rentalTransaction, sandboxMode)
        break

      case NotificationEventType.PRE_MOVE_IN_TENANT:
        break

      case NotificationEventType.PRE_MOVE_IN_PROPERTY:
        break

      case NotificationEventType.ACH_TRANSFER:
        handleAchTransfer(rentalTransaction)
        break
    }

  }

  def handleNewTenant(rentalTransaction, boolean sandboxMode) {

   def g = new org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib()

    def siteManagerNotification = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
    def districtManagerNotification = NotificationType.findByNotificationType('NOTIFICATION_DISTRICT_MANAGER')
    def operationsManagerNotification = NotificationType.findByNotificationType('NOTIFICATION_OPERATIONS_MANAGER')
    def accountingNotification = NotificationType.findByNotificationType('NOTIFICATION_ACCOUNTING')

    def siteManager = User.withCriteria {
      sites {
        eq("site.id", rentalTransaction.site.id)
      }
      notificationTypes {
        eq("notificationType.id", siteManagerNotification.id)
      }
      maxResults(1)
    }

    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US)

    String rentalAgreementLink = null
    if (rentalTransaction.site.rentalAgreement) {
      rentalAgreementLink = g.resource(file: rentalTransaction.site.rentalAgreement.src())
    }
    String promoName = rentalTransaction.promoName
    String insuranceName = rentalTransaction.insuranceName
    String siteAddress = rentalTransaction.site.getFullAddress()
    String directionsLink = g.createLink(controller: "storageSite", action: "directions", id: rentalTransaction.site.id, absolute:true)
    String billingName = rentalTransaction.billingAddress.fullName()
    String billingAddress = rentalTransaction.billingAddress.fullAddress()
    String storitzId = rentalTransaction.bookingDate.format('yyyyddMM') + sprintf('%08d', rentalTransaction.id)
    String idNumber = (rentalTransaction.reserved ? 'R' + rentalTransaction.reservationId : rentalTransaction.idNumber)
    String tenantName = rentalTransaction.contactPrimary.fullName()
    String displaySize = rentalTransaction.displaySize

    def model = [
            tenantName: tenantName,
            idNumber: idNumber,
            bookingDate: rentalTransaction.bookingDate.format('MM/dd/yy'),
            moveInDate: rentalTransaction.moveInDate.format('MM/dd/yy'),
            paidThruDate: rentalTransaction.paidThruDate.format('MM/dd/yy'),
            siteName: rentalTransaction.site.title,
            siteAddress: siteAddress,
            directionsLink: directionsLink,
            phone: rentalTransaction.site.phone,
            manager: siteManager.userRealName,
            storitzId: storitzId,
            billingName: billingName,
            billingAddress: billingAddress,
            ccNum: rentalTransaction.cleanCCNum,
            rentalRate: nf.format(rentalTransaction.monthlyRate),
            promoName: promoName,
            insuranceName: insuranceName,
            paymentTotal: nf.format(rentalTransaction.moveInCost),
            moveInCost: nf.format(rentalTransaction.moveInCost),
            remainderDueAtMoveIn: nf.format(rentalTransaction.moveInCost - rentalTransaction.cost),
            rentalFee: nf.format(rentalTransaction.cost),
            rentalAgreementLink: rentalAgreementLink,
            unitNumber: rentalTransaction.feedUnitNumber,
            commission: nf.format(rentalTransaction.commission),
            gateAccessCode: rentalTransaction.accessCode,
            phone: rentalTransaction.contactPrimary.phone,
            email: rentalTransaction.contactPrimary.email,
            displaySize: rentalTransaction.displaySize,
            siteId: rentalTransaction.site.id
    ]

    List<String> siteManagerEmails = User.withCriteria {
      sites {
        eq("site.id", rentalTransaction.site.id)
      }
      notificationTypes {
        or {
          eq("notificationType.id", siteManagerNotification.id)
          eq("notificationType.id", districtManagerNotification.id)
        }
      }
    }.collect { it.email as String}

    List<String> operAcctEmails = User.withCriteria {
      sites {
        eq("site.id", rentalTransaction.site.id)
      }
      notificationTypes {
        or {
          eq("notificationType.id", operationsManagerNotification.id)
          eq("notificationType.id", accountingNotification.id)
        }
      }
    }.collect { it.email as String}

    String operView
    String tenantView
    String mgrView
    String operSubj
    String tenantSubj
    switch (rentalTransaction.site.transactionType) {
      case TransactionType.RENTAL:
        operView = "/notifications/moveInOperMgr"
        tenantView = "/notifications/moveInTenant"
        mgrView = "/notifications/moveInSiteMgr"
        operSubj = "Storitz - Confirmation for your ${rentalTransaction.moveInDate.format('MM/dd/yy')} ${rentalTransaction.site.title} move-in"
        tenantSubj = "Storitz - Confirmation for ${rentalTransaction.moveInDate.format('MM/dd/yy')} new tenant move-in at ${rentalTransaction.site.title} (Confirmation #${rentalTransaction.idNumber})"
        break
      case TransactionType.RESERVATION:
        operView = "/notifications/reservationOperMgr"
        tenantView = "/notifications/reservationTenant"
        mgrView = "/notifications/reservationOperMgr"
        operSubj = "Storitz - Confirmation for your ${rentalTransaction.moveInDate.format('MM/dd/yy')} ${rentalTransaction.site.title} reservation"
        tenantSubj = "Storitz - Confirmation for ${rentalTransaction.moveInDate.format('MM/dd/yy')} new tenant reservation at ${rentalTransaction.site.title} (Confirmation #${rentalTransaction.idNumber})"
        break
    }
    if (sandboxMode) {
      tenantSubj = "SANDBOX: " + tenantSubj;
      operSubj = "SANDBOX: " + operSubj;
    }

    //// TENANT
    try {
      def recipient
      if (sandboxMode) {
        recipient = rentalTransaction.contactPrimary.email.endsWith("storitz.com") ? rentalTransaction.contactPrimary.email : "tech@storitz.com"
      }
      else {
        recipient = rentalTransaction.contactPrimary.email
      }
      mailService.sendMail {
        to recipient
        from "no-response@storitz.com"
        subject operSubj
        body (model:model,view:tenantView)
      }
    } catch (Throwable t) {
      log.error("${t}", t)
    }

    ///// ON-SITE MANAGERS
    try {
      def recipients = filterEmails(siteManagerEmails, sandboxMode)
      mailService.sendMail {
              to recipients
              from "no-response@storitz.com"
              subject tenantSubj
              body (model:model,view:mgrView)
      }

    } catch (Throwable t) {
      log.error("${t}", t)
    }

    ///// SITE OPERATORS
    try {
      def recipients = filterEmails(operAcctEmails, sandboxMode)
      def subj =  "EVENT - NEW TENANT ${tenantSubj}"
      mailService.sendMail {
              to recipients
              from "no-response@storitz.com"
              subject subj.toString()
              body (model:model,view:operView)
      }
    } catch (Throwable t) {
      log.error("${t}", t)
    }

    ///// US
    try {
      def recipient = sandboxMode ? "tech@storitz.com" : "notifications@storitz.com"
      mailService.sendMail {
              to recipient
              from "no-response@storitz.com"
              subject tenantSubj
              body (model:model,view:operView)
      }
    } catch (Throwable t) {
      log.error("${t}", t)
    }
  }

  def filterEmails(List<String> emails, boolean sandboxMode) {
    def recipients
    if (sandboxMode) {
      recipients = emails.findAll { it.endsWith("storitz.com") }
      if (recipients.size() == 0) {
        recipients.add("tech@storitz.com")
      }
    }
    else {
      recipients = emails
    }
    return recipients.toArray()
  }

  def handleAchTransfer(rentalTransaction) {
    def operationsManagerNotification = NotificationType.findByNotificationType('NOTIFICATION_OPERATIONS_MANAGER')
    def accountingNotification = NotificationType.findByNotificationType('NOTIFICATION_ACCOUNTING')

    def model = []

    List<String> operAcctEmails = User.withCriteria {
      sites {
        eq("site.id", rentalTransaction.site.id)
      }
      notificationTypes {
        or {
          eq("notificationType.id", operationsManagerNotification.id)
          eq("notificationType.id", accountingNotification.id)
        }
      }
    }.collect { it.email as String}

    operAcctEmails.add("achnotify@storitz.com")

    try {
      mailService.sendMail {
              to operAcctEmails.toArray()
              from "no-response@storitz.com"
              subject "EVENT - ACH Transfer "
              body (model:model, view:"/notifications/achOperMgr")
      }
    } catch (Exception e) {
      log.error("${e}", e)
    }


  }
}
