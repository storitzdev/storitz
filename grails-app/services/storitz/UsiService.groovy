package storitz

import com.storitz.CenterShift
import com.storitz.SpecialOffer
import com.storitz.StorageSite
import storitz.constants.PromoType

class UsiService extends CShiftService {

  def offerFilterService

  OfferFilterService getOfferFilterService() {
      if (!offerFilterService) {
          println ("offerFilterService is null: instantiating")
          offerFilterService = new OfferFilterService()
      }
      return offerFilterService
  }

  def updateUnits(site, stats, writer) {
    super.updateUnits(site, stats, writer)
    CenterShift cshift = (CenterShift)site.feed
    loadPromos(cshift, site, writer)
  }

  def loadPromos(cshift, site, writer) {
    def ret = getPromos(cshift.location.webUrl, cshift.userName, cshift.pin, site.sourceId)
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
        boolean newOffer = false
        if (!specialOffer) {
          specialOffer = new SpecialOffer()
          specialOffer.concessionId = concessionId
          specialOffer.active = false;
          specialOffer.featured = false;
          specialOffer.waiveAdmin = false;
          specialOffer.description = promo.sDescription.text()
          specialOffer.promoName = promo.'promo-name'.text()
          newOffer = true
        } else {
          specialOffer.restrictions.clear()
          specialOffer.save(flush: true)
        }
        specialOffer.promoSize = promoSize
        specialOffer.prepay = (promo.'discount-periods'.text() as Integer) > 0
        specialOffer.expireMonth = specialOffer.prepay ? promo.'discount-periods'.text() as Integer : 0
        specialOffer.prepayMonths = specialOffer.prepay ? (promo.'prepay-periods'.text() as Integer) : 1
        specialOffer.description = description
        specialOffer.inMonth = 0
        specialOffer.promoQty = promo.'discount-min'.text() as BigDecimal
        if (specialOffer.promoQty == 0) specialOffer.promoQty = promo.'discount-max'.text() as BigDecimal

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
        if (newOffer) {
          site.addToSpecialOffers(specialOffer)
        }
        handleGovernors(specialOffer, promo)
      }
    }
    def deleteList = []
    for (promo in site.specialOffers) {
      if (!concessionIds.contains(promo.concessionId)) {
        deleteList.add(promo)
      }
    }
    for (promo in deleteList) {
      writer.println "Removing stale concession: ${site.title} - ${promo.concessionId} ${promo.promoName} - ${promo.description}"
      site.removeFromSpecialOffers(promo)
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
    deleteList.clear()
    Integer order = 6
    for (promo in site.specialOffers) {
      if (promo.description.startsWith('WXR') || promo.description.startsWith('WXA')) {
        deleteList.add(promo)
      } else {
        if (promo.description.startsWith('WXD')) {
          Integer promoOrder = (promo.description[4] as Integer)
          if (promoOrder < order) {
            order = promoOrder
            promo.featured = true
            promo.active = true
            promo.description = promo.promoName = promo.description.split('-')[1]
            promo.save(flush: true)
          }
        }
      }
    }
    for (promo in deleteList) {
      site.removeFromSpecialOffers(promo)
    }

  }

  // USI will not use online insurance

  def loadInsurance(CenterShift cshift, StorageSite site) {
    // do nothing here
    return false
  }

}
