package storitz

import com.storitz.RentalTransaction
import storitz.constants.TransactionStatus
import com.storitz.StorageUnit
import com.storitz.SpecialOffer

class BalkNotificationJob {
    def mailService

    static triggers = {
      // no automatic triggers
    }

    def static transQueue = [:]
    def static sentEmails = [:]

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
      def sentEmailBefore = sentEmails[trans.contactPrimary.email]
      if (trans.status == TransactionStatus.BEGUN && !sentEmailBefore) {
        sendInternalBalkNotification(trans)
        sendExternalBalkNotification(trans)
        sentEmails[trans.contactPrimary.email] = true; // don't email this person again
      }
    }

  def sendInternalBalkNotification(RentalTransaction trans) {
    StorageUnit storageUnit = StorageUnit.findById(trans.unitId)
    SpecialOffer specialOffer = SpecialOffer.findById(trans.promoId)
    def unitPrice = storageUnit.bestUnitPrice ? storageUnit.bestUnitPrice : storageUnit.price

    StringBuilder bdy = new StringBuilder()
    bdy.append("Transaction  : ${trans.id}")
    bdy.append("\nOperator     : ${trans.site.feed.operatorName}")
    bdy.append("\nSite         : ${trans.site.title}")
    bdy.append("\n               ${trans.site.address}")
    bdy.append("\n               ${trans.site.city}, ${trans.site.state.display} ${trans.site.zipcode}")
    bdy.append("\nUnit         : ${storageUnit.displaySize} ${storageUnit.unitType.display}")
    bdy.append("\nUnit Price   : ${unitPrice} (${specialOffer?.promoName ? specialOffer?.promoName : 'no promo selected'})}")
    if (trans.moveInCost) bdy.append("\nMove-in Cost : ${trans.feedMoveInCost}")
    bdy.append("\nMove-In Date : ${trans.moveInDate.format('yyyy-MM-dd')}")
    bdy.append("\nContact      : ${trans.contactPrimary.firstName} ${trans.contactPrimary.lastName}")
    bdy.append("\n               ${trans.contactPrimary.address1}")
    bdy.append("\n               ${trans.contactPrimary.city}, ${trans.contactPrimary.state.display} ${trans.contactPrimary.zipcode}")
    bdy.append("\n               ${trans.contactPrimary.email}")
    bdy.append("\n               ${trans.contactPrimary.phone} (${trans.contactPrimary.phoneType.display})")

    try {
      def subj = "${grails.util.Environment.getCurrent().toString()} Balk Notification"
      mailService.sendMail {
          to "balk@storitz.com"
          from "no-reply@storitz.com"
          subject subj.toString()
          body bdy.toString()
      }
    } catch (Throwable t) {
      t.printStackTrace()
    }
  }

  def sendExternalBalkNotification(RentalTransaction trans) {
    StringBuilder bdy = new StringBuilder()

    bdy.append("Hi ${trans.contactPrimary.firstName},");
    bdy.append("\n");
    bdy.append("\nEarlier today, you visited Storitz.com and searched for self storage.");
    bdy.append("\nWe’re really glad that you decided to check out our site! Still, we");
    bdy.append("\ncouldn’t help but notice that you didn’t manage to complete your");
    bdy.append("\ntransaction and rent a storage unit.");
    bdy.append("\n");
    bdy.append("\n");
    bdy.append("\nAt Storitz, we’re constantly striving to improve our site and our");
    bdy.append("\ncustomer service, so we wanted to drop you a line and see if you had");
    bdy.append("\nany problems with the site that we could help you with.  Did something");
    bdy.append("\nbreak or fail?  Was something about Storitz too confusing?");
    bdy.append("\n");
    bdy.append("\n");
    bdy.append("\nIf there is anything I can help you with, please don’t hesitate to");
    bdy.append("\ncontact me. You can give me a call on the toll-free number listed");
    bdy.append("\nbelow, or just respond to this email and I’ll get back to you right");
    bdy.append("\naway.");
    bdy.append("\n");
    bdy.append("\n");
    bdy.append("\nThen, if you do decide to rent with us, we’d like to offer you a \$20");
    bdy.append("\ncredit on your first move-in.");
    bdy.append("\n");
    bdy.append("\n");
    bdy.append("\nWe look forward to talking to you soon and helping you with all your");
    bdy.append("\nself-storage needs!");
    bdy.append("\n");
    bdy.append("\n");
    bdy.append("\nSincerely,");
    bdy.append("\n");
    bdy.append("\nGillian Singletary");
    bdy.append("\nCustomer Service Specialist");
    bdy.append("\nStoritz, Inc.");
    bdy.append("\n(877) 456-2929");
    bdy.append("\ngsingletary@storitz.com");

    try {
      mailService.sendMail {
          to trans.contactPrimary.email
          from "gsingletary@storitz.com"
          subject "Thanks for visiting Storitz!"
          body bdy.toString()
    }
      // CC us too
      mailService.sendMail {
          to "balk@storitz.com"
          from "gsingletary@storitz.com"
          subject "Thanks for visiting Storitz!"
          body bdy.toString()
    }
    } catch (Throwable t) {
      t.printStackTrace()
    }
  }
}