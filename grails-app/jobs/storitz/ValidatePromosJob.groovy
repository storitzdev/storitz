package storitz

import com.storitz.SpecialOffer
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class ValidatePromosJob {

  private static final boolean AUTOMATIC_FLUSH = true;
  private static final String DEFAULT_CHARSET = "utf8";

  def emailService

  static triggers = {
    // Check every six hours
    cron name:'checkPromos', cronExpression:"0 0 0,6,12,18 * * ?"
  }

  // Grab all active promos with quantity greater than $100
  // Eliminate the promotions that contain the quantity value in the name.
  // [ I.E. If a promo is $800 but the name says "$800 off" then assume
  // everything is correct.]
  // Whatever remains is potentially bad so report it via email.
  def execute(context) {
    def buf = new ByteArrayOutputStream()
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(buf, DEFAULT_CHARSET), AUTOMATIC_FLUSH);
    int count = 0

    def specialOffers = SpecialOffer.findAllByActiveAndPromoQtyGreaterThan(true,100)
    if (specialOffers) {
      writer.println "Active promotions only..."
      writer.println ""
      specialOffers.each { offer ->
        if (!offer.promoName.contains(((Integer)offer.promoQty).toString())) {
          ++count
          writer.println("[ID:${offer.id}] [QTY:${offer.promoQty}] [NAME:${offer.promoName}]")
        }
      }
    }

    if (count > 0) {
      String subject = "[${grails.util.Environment.getCurrent().toString()}] Potentially Bad Promos (${count})"
      String body = buf.toString()
      try {
        emailService.sendTextEmail(
            to: "tech@storitz.com",
            from: "no-reply@storitz.com",
            subject: subject,
            body: body)
      }
      catch (Exception e) {
        println "ERROR sending email!"
        e.printStackTrace()
      }
    }
  }
}
