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

    static void scheduleBalkNotice(long id) {
      def scheduled = transQueue[id]
      if (!scheduled) {
        transQueue[id] = true
        long millisecondsNow = (new Date()).time
        long millisecondsFifteenMinutes = 1000 * 60 * 15;
        Date when = new Date(millisecondsNow + millisecondsFifteenMinutes)
        BalkNotificationJob.schedule(when,[id:id])
      }
    }

    def execute(context) {
      def id = context.mergedJobDataMap.get('id')
      RentalTransaction trans = RentalTransaction.findById(id)
      if (trans.status == TransactionStatus.BEGUN) {
        sendInternalBalkNotification(trans)
        sendExternalBalkNotification(trans)
      }
    }

  def sendInternalBalkNotification(RentalTransaction trans) {
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

  def sendExternalBalkNotification(RentalTransaction trans) {
    StringBuilder body = new StringBuilder()

    body.append("Hi ${trans.contactPrimary.firstName},");
    body.append("\n");
    body.append("\nEarlier today, you visited Storitz.com and searched for self storage.");
    body.append("\nWe’re really glad that you decided to check out our site! Still, we");
    body.append("\ncouldn’t help but notice that you didn’t manage to complete your");
    body.append("\ntransaction and rent a storage unit.");
    body.append("\n");
    body.append("\n");
    body.append("\nAt Storitz, we’re constantly striving to improve our site and our");
    body.append("\ncustomer service, so we wanted to drop you a line and see if you had");
    body.append("\nany problems with the site that we could help you with.  Did something");
    body.append("\nbreak or fail?  Was something about Storitz too confusing?");
    body.append("\n");
    body.append("\n");
    body.append("\nIf there is anything I can help you with, please don’t hesitate to");
    body.append("\ncontact me. You can give me a call on the toll-free number listed");
    body.append("\nbelow, or just respond to this email and I’ll get back to you right");
    body.append("\naway.");
    body.append("\n");
    body.append("\n");
    body.append("\nThen, if you do decide to rent with us, we’d like to offer you a \$20");
    body.append("\ncredit on your first move-in.");
    body.append("\n");
    body.append("\n");
    body.append("\nWe look forward to talking to you soon and helping you with all your");
    body.append("\nself-storage needs!");
    body.append("\n");
    body.append("\n");
    body.append("\nSincerely,");
    body.append("\n");
    body.append("\nGillian Singletary");
    body.append("\nCustomer Service Specialist");
    body.append("\nStoritz, Inc.");
    body.append("\n(877) 456-2929");
    body.append("\ngsingletary@storitz.com");

    try {
      emailService.sendTextEmail (
          to:      trans.contactPrimary.email,
          from:    "gsingletary@storitz.com",
          subject: "Thanks for visiting Storitz!",
          body: body.toString()
      )
      // CC Gillian too
      emailService.sendTextEmail (
          to:      "gsingletary@storitz.com",
          from:    "gsingletary@storitz.com",
          subject: "Thanks for visiting Storitz!",
          body: body.toString()
      )
    } catch (Throwable t) {
      t.printStackTrace()
    }
  }




}