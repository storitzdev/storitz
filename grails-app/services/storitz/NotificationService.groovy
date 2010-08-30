package storitz

import storitz.constants.NotificationEventType
import com.storitz.RentalTransaction
import com.storitz.NotificationType
import com.storitz.User
import com.storitz.StorageUnit
import com.storitz.SpecialOffer
import java.text.NumberFormat
import grails.util.GrailsWebUtil
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import org.codehaus.groovy.grails.web.context.ServletContextHolder

class NotificationService {

    def emailService

    boolean transactional = false

    def notify(NotificationEventType eventType, RentalTransaction rentalTransaction) {

      switch(eventType) {
        case NotificationEventType.NEW_TENANT:
          handleNewTenant(rentalTransaction)
          break

        case NotificationEventType.PRE_MOVE_IN_TENANT:
          break

        case NotificationEventType.PRE_MOVE_IN_PROPERTY:
          break
      }

    }

    def handleNewTenant(rentalTransaction) {

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

      def unit = StorageUnit.get(rentalTransaction.unitId)
      def promo = null
      if (!(rentalTransaction.promoId < 0)) {
        promo = SpecialOffer.get(rentalTransaction.promoId)
      }
      NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US)

      String rentalAgreementLink = null
      if (rentalTransaction.site.rentalAgreement) {
        rentalAgreementLink = g.resource(file: rentalTransaction.site.rentalAgreement.src())
      }
      String promoName = promo?.promoName
      String siteAddress = rentalTransaction.site.getFullAddress()
      String directionsLink = g.createLink(controller:"storageSite", action:"directions", id:rentalTransaction.site.id)
      String billingName = rentalTransaction.billingAddress.fullName()
      String billingAddress = rentalTransaction.billingAddress.fullAddress()
      String storitzId = rentalTransaction.bookingDate.format('yyyyddMM') + sprintf('%08d', rentalTransaction.id)
      String idNumber = (rentalTransaction.reserved ? 'R'+rentalTransaction.reservationId : rentalTransaction.idNumber)

      def model = [
        tenantName: rentalTransaction.contactPrimary.fullName(),
        idNumber: idNumber,
        bookingDate: rentalTransaction.bookingDate.format('MM/dd/yy'),
        moveInDate: rentalTransaction.moveInDate.format('MM/dd/yy'),
        paidThruDate: rentalTransaction.paidThruDate.format('MM/dd/yy'),
        siteName: rentalTransaction.site.title,
        siteAddress: siteAddress,
        directionsLink: directionsLink,
        phone: rentalTransaction.site.phone,
        manager: siteManager.userRealName,
        bookingDate: rentalTransaction.bookingDate.format('yyyyMMdd'),
        storitzId: storitzId,
        billingName: billingName,
        billingAddress: billingAddress,
        ccNum: rentalTransaction.cleanCCNum,
        rentalRate: nf.format(unit.pushRate),
        promoName: promoName,
        paymentTotal: nf.format(rentalTransaction.cost),
        rentalAgreementLink: rentalAgreementLink,
        unitNumber: rentalTransaction.feedUnitNumber,
        commission: nf.format(rentalTransaction.commission),
        gateAccessCode: rentalTransaction.accessCode,
        phone: rentalTransaction.contactPrimary.phone,
        email: rentalTransaction.contactPrimary.email,
        siteId: rentalTransaction.site.id
      ]

      def siteManagerEmails = User.withCriteria {
        sites {
          eq("site.id", rentalTransaction.site.id)
        }
        notificationTypes {
          or {
            eq("notificationType.id", siteManagerNotification.id)
            eq("notificationType.id", districtManagerNotification.id)
          }
        }
      }.collect{ "\"${it.email}\""}.join(",")

      def operAcctEmails = User.withCriteria {
        sites {
          eq("site.id", rentalTransaction.site.id)
        }
        notificationTypes {
          or{
            eq("notificationType.id", operationsManagerNotification.id)
            eq("notificationType.id", accountingNotification.id)
          }
        }
      }.collect{ "\"${it.email}\""}.join(",")

      String subj = "Storitz - Confirmation for your ${rentalTransaction.moveInDate.format('MM/dd/yy')} ${rentalTransaction.site.title} move-in"
      try {
          emailService.sendEmail(to: rentalTransaction.contactPrimary.email,
              from: "no-response@storitz.com",
              subject: subj,
              model: model,
              view: "/notifications/moveInTenant")

      } catch (Exception e) {
          log.error("${e}", e)
      }

      subj = "Storitz - Confirmation for ${rentalTransaction.moveInDate.format('MM/dd/yy')} new tenant move-in at ${rentalTransaction.site.title} - (Confirmation # ${rentalTransaction.idNumber} )"
      try {
          emailService.sendEmail(
              to: siteManagerEmails,
              from: "no-response@storitz.com",
              subject: subj,
              model: model,
              view: "/notifications/moveInSiteMgr")

      } catch (Exception e) {
          log.error("${e}", e)
      }

      try {
          emailService.sendEmail(
              to: operAcctEmails,
              from: "no-response@storitz.com",
              subject: "EVENT - NEW TENANT " + subj,
              model: model,
              view: "/notifications/moveInOperMgr")

      } catch (Exception e) {
          log.error("${e}", e)
      }

      try {
          emailService.sendEmail(
              to: "notifications@storitz.com",
              from: "no-response@storitz.com",
              subject: subj,
              model: model,
              view: "/notifications/moveInOperMgr")

      } catch (Exception e) {
          log.error("${e}", e)
      }
    }
}
