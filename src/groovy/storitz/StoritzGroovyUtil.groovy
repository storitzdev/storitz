package storitz

import com.storitz.SpecialOffer
import org.grails.mail.MailService
import com.storitz.SpecialOfferLookup

class StoritzGroovyUtil {

  // Grab all active promos with quantity greater than threshold
  // Eliminate the promotions that contain the quantity value in the name.
  // [ I.E. If a promo is $800 but the name says "$800 off" then assume
  // everything is correct.]
  // Whatever remains is potentially bad so report it via email.
  static def validatePromos(threshold, onlyactive) {
    def buf = new ByteArrayOutputStream()
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(buf, "utf8"), true);
    int count = 0

    def specialOffers
    if (onlyactive) {
      specialOffers= SpecialOffer.findAllByActiveAndPromoQtyGreaterThan(true,threshold)
    }
    else {
      specialOffers= SpecialOffer.findAllByPromoQtyGreaterThan(threshold)
    }

    if (specialOffers) {
      if (onlyactive) {
        writer.println "Active promotions only..."
      }
      else {
        writer.println "All promotions..."
      }

      writer.println ""
      specialOffers.each { offer ->
        if (!offer.promoName.contains(((Integer)offer.promoQty).toString())) {
          ++count
          writer.println("[ID:${offer.id}] [QTY:${offer.promoQty}] [NAME:${offer.promoName}]")
        }
      }
    }

    if (count > 0) {
      String subj = "[${grails.util.Environment.getCurrent().toString()}] Potentially Bad Promos (${count})"
      String bdy = buf.toString()
      try {
        def mailService = new MailService()
        mailService.sendMail {
            to "tech@storitz.com"
            from "no-reply@storitz.com"
            subject subj
            body bdy
        }
      }
      catch (Exception e) {
        println "ERROR sending email!"
        e.printStackTrace()
      }
    }
  }

  static def validateSpecialOfferLookup () {
    def buf = new ByteArrayOutputStream()
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(buf, "utf8"), true);
    int count = 0

    writer.println "New unknown special offers in lookup"

    SpecialOfferLookup.findAll().each { lookup ->
      if (lookup.isNew())
        ++count
        writer.println "[CLASS: ${lookup.class.name}] [NAME: ${lookup.name}]"
    }

    writer.println ""

    if (count > 0) {
      String subj = "[${grails.util.Environment.getCurrent().toString()}] Unknown Special Offers in Lookup (${count})"
      String bdy = buf.toString()
      try {
        def mailService = new MailService()
        mailService.sendMail {
            to "tech@storitz.com"
            from "no-reply@storitz.com"
            subject subj
            body bdy
        }
      }
      catch (Exception e) {
        println "ERROR sending email!"
        e.printStackTrace()
      }
    }
  }

  // Brain-dead helper. Turn a list of amenities
  // into a boolean look-up hash table.
  static def parseAmenities (amenity) {
    if (!amenity) {
      return [:]
    }

    def amen = [:]

    if (amenity instanceof String) {
      amenity = [amenity]
    }

    for (a in amenity) {
      amen[a]=true
    }

    return amen
  }





}
