package storitz

import com.storitz.CenterShift
import com.storitz.SpecialOffer
import com.storitz.StorageSite
import storitz.constants.PromoType
import com.storitz.StoritzUtil

class UsiStorageFeedService extends CShiftStorageFeedService {

  def offerFilterService

  OfferFilterService getOfferFilterService() {
      if (!offerFilterService) {
          log.info ("offerFilterService is null: instantiating")
          offerFilterService = new OfferFilterService()
      }
      return offerFilterService
  }

  public void updateUnits(StorageSite site, SiteStats stats, PrintWriter writer) {
    super.updateUnits(site, stats, writer)
    loadPromos(site, writer)
    updateBestUnitPrice (site)
  }

  public void loadPromos(StorageSite site, PrintWriter writer) {
    CenterShift cshift = (CenterShift)site.feed;
    def ret;

    try {
      ret = getPromos(cshift.location.webUrl, cshift.userName, cshift.pin, site.sourceId)
    }
    catch (org.xml.sax.SAXParseException saxParseException) {
        def stacktrace = StoritzUtil.stackTraceToString(saxParseException)
        writer.println "Error getting promotions: ${stacktrace}"
        return;
    }

    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def concessionIds = []

    for (promo in records.'soap:Body'.'*:GetCurrentPromotionListXMLResponse'.'*:GetCurrentPromotionListXMLResult'.'*:promotions'.'*:promo-info') {

      def description = promo.'promo-desc'.text()

      def validPromo = true
      def promoSize = null

      for (gov in promo.'promo-governors'.governor) {
        def limitFactor = gov.'limiting-factor'.text()
        if (limitFactor ==~ /Existing.*/) {
          validPromo = false
        }
      }

      if (!description.startsWith('WX')) {
        validPromo = false
      }

      if (validPromo) {

        Long concessionId = promo.'promo-id'.text() as Long
        concessionIds.add(concessionId)
        SpecialOffer specialOffer = site.specialOffers.find { it.concessionId == concessionId }
        if (!specialOffer) {
          specialOffer = new SpecialOffer()
          specialOffer.concessionId = concessionId
          specialOffer.active = false;
          specialOffer.featured = false;
          specialOffer.waiveAdmin = false;
          specialOffer.description = promo.sDescription.text()
          if (!specialOffer.promoName) specialOffer.promoName = promo.'promo-name'.text()
        } else {
          for (restriction in specialOffer.restrictions) {
            restriction.delete(flush:true);
          }
        }
        specialOffer.promoSize = promoSize
        specialOffer.prepay = (promo.'discount-periods'.text() as Integer) > 0
        specialOffer.expireMonth = specialOffer.prepay ? promo.'discount-periods'.text() as Integer : 0
        specialOffer.prepayMonths = specialOffer.prepay ? (promo.'prepay-periods'.text() as Integer) : 1
        specialOffer.description = description
        specialOffer.inMonth = 0

        // JM 2011-05-19
        // CenterShift gives us variable promos with min/max range
        // Typically the min and max are the same (i.e. no range).
        // Sometimes the max is larger. If that is the case, then take
        // the max.
        def promoMin = promo.'discount-min'.text() as BigDecimal
        def promoMax = promo.'discount-max'.text() as BigDecimal

        // I've never seen a case where the max is smaller than the
        // min. Be that as it may, verify that the max is larger before
        // applying just the same.
        specialOffer.promoQty = promoMax > promoMin ?  promoMax : promoMin

        def ptype = promo.'discount-type'.text()
        switch (ptype) {
          case '$':
            specialOffer.promoType = PromoType.AMOUNT_OFF
            break

          case '%':
            specialOffer.promoType = PromoType.PERCENT_OFF
            break

          case 'O':
            specialOffer.promoType = PromoType.FIXED_RATE
            break

          default:
            writer.println "Unknown promoType: ${ptype}"
            continue
        }
        specialOffer.save(flush: true)
        handleGovernors(specialOffer, promo)
      }
    }
    for (offer in site.specialOffers.find { it.active }) {
      if (!concessionIds.contains(offer.concessionId)) {
        writer.println "Removing stale concession: ${site.title} - ${offer.concessionId} ${offer.promoName} - ${offer.description}"
        offer.active = false
        offer.save(flush: true)
        for (restriction in offer.restrictions) {
          restriction.delete(flush:true)
        }
      }
    }

    // clear all push prices
    for (unit in site.units) {
      unit.pushRate = unit.price
    }

    List rateOffers = []
    for (promo in site.specialOffers) {
      if (promo.description.startsWith('WXR')) {
        def pm = promo.description =~ /WXRX\dX-(\d+)\%/
        if (pm.getCount()) {
          promo.promoQty = pm[0][1] as BigDecimal
        }
        rateOffers.add(promo)
      }
    }

    List addedOffers = []
    for (promo in site.specialOffers) {
      if (promo.description.startsWith('WXA')) {
        def pm = promo.description =~ /WXAX\dX-(\d+)\%/
        if (pm.getCount()) {
          promo.promoQty = pm[0][1] as BigDecimal
        }
        addedOffers.add(promo)
      }
    }


    for (unit in site.units) {
      def rList = rateOffers.clone()
      getOfferFilterService().filterOffer(rList, site, unit)
      if (rList.size() > 0) {
        def rOffer = rList.max { it.promoQty }
        unit.pushRate = (1 - (rOffer.promoQty / 100G)) * unit.price
        if (unit.pushRate != unit.price) {
          unit.save(flush: true)
        }
      }
    }

    // remove rate promos and rename other promos
    def deleteList = []
    for (promo in site.specialOffers.sort{ it.description }) {
      if (promo.description.startsWith('WXR') || promo.description.startsWith('WXA')) {
        deleteList.add(promo)
      } else {
        if (promo.description.startsWith('WXD')) {
          promo.featured = true
        }
        Integer promoOrder = (promo.description[4] as Integer)
        promo.active = true
        promo.description = promo.description.split('-')[1]
        if (!promo.promoName) promo.promoName = promo.description.split('-')[1]
        promo.save(flush: true)
      }
    }
    for (promo in deleteList) {
      promo.active = false;
      promo.save(flush: true)
    }

  }

  // USI will not use online insurance

  def loadInsurance(CenterShift cshift, StorageSite site) {
    // do nothing here
    return false
  }

}
