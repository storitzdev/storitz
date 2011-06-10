package storitz

import com.storitz.RentalTransaction
import storitz.constants.TransactionStatus
import com.storitz.StorageUnit
import com.storitz.SpecialOffer

class BalkNotificationJob {
    def emailService

    static triggers = {
      // no automatic triggers
    }

    def static transQueue = [:]

    static void scheduleBalkNotice(long id,Date when) {
      def scheduled = transQueue[id]
      if (!scheduled) {
        transQueue[id] = true
        BalkNotificationJob.schedule(when,[id:id])
      }
    }

    def execute(context) {
      def id = context.mergedJobDataMap.get('id')
      RentalTransaction trans = RentalTransaction.findById(id)
      if (trans.status == TransactionStatus.BEGUN) {
        sendBalkNotification(trans)
      }
    }

  def sendBalkNotification(RentalTransaction trans) {
    StorageUnit storageUnit = StorageUnit.findById(trans.unitId)
    SpecialOffer specialOffer = SpecialOffer.findById(trans.promoId)
    def unitPrice = storageUnit.bestUnitPrice ? storageUnit.bestUnitPrice : storageUnit.price

    StringBuilder body = new StringBuilder()
    body.append("Transaction  : ${trans.id}")
    body.append("\nOperator     : ${trans.site.feed.operatorName}")
    body.append("\nSite         : ${trans.site.title}")
    body.append("\n               ${trans.site.address}")
    body.append("\n               ${trans.site.city}, ${trans.site.state.display} ${trans.site.zipcode}")
    body.append("\nUnit         : ${storageUnit.displaySize} ${storageUnit.unitType.display}")
    body.append("\nUnit Price   : ${unitPrice} (${specialOffer?.promoName ? specialOffer?.promoName : 'no promo selected'})}")
    if (trans.moveInCost) body.append("\nMove-in Cost : ${trans.feedMoveInCost}")
    body.append("\nMove-In Date : ${trans.moveInDate.format('yyyy-MM-dd')}")
    body.append("\nContact      : ${trans.contactPrimary.firstName} ${trans.contactPrimary.lastName}")
    body.append("\n               ${trans.contactPrimary.address1}")
    body.append("\n               ${trans.contactPrimary.city}, ${trans.contactPrimary.state.display} ${trans.contactPrimary.zipcode}")
    body.append("\n               ${trans.contactPrimary.email}")
    body.append("\n               ${trans.contactPrimary.phone} (${trans.contactPrimary.phoneType.display})")

    try {
      emailService.sendTextEmail (
          to:      "balk@storitz.com",
          from:    "no-reply@storitz.com",
          subject: grails.util.Environment.getCurrent().toString() + ":Balk Notification",
          body: body.toString()
      )
    } catch (Throwable t) {
      t.printStackTrace()
    }
  }
}