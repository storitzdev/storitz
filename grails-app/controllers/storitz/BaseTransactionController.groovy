package storitz

import java.text.SimpleDateFormat
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.StorageSite
import java.text.ParseException

class BaseTransactionController {

  def offerFilterService
  def costService

  def renderTransactionPanel = { template ->
    if(!(params.unitId && params.siteId)) {
      render(status:400, contentType: "text/plain", text: "Missing required parameter(s) unitId and/or siteId.");
    }
    def promo = null;
    if (params.promoId && params.promoId != "-1") {
      promo = SpecialOffer.get(params.promoId as Long);
      if (!promo) {
        render(status:400, contentType: "text/plain", text: "promo ${params.promoId} could not be found");
      }
    }
    def unit = StorageUnit.get(params.unitId as Long);
    if (!unit) {
      render(status:400, contentType: "text/plain", text: "unit ${params.unitId} could not be found");
    }
    def site = StorageSite.get(params.siteId as Long);
    if (!site) {
      render(status:400, contentType: "text/plain", text:"site ${params.siteId} could not be found");
    }
    // TODO: Verify that unit and promo both belong to site
    def moveInDate = new Date();
    if (params.moveInDate) {
      try {
        moveInDate = new SimpleDateFormat("yyyy-MM-dd").parse(params.moveInDate);
      }
      catch (ParseException p) {
        // TODO: Log warning
      }
    }

    def promos = offerFilterService.getValidFeaturedOffers(site, unit);
    promos.addAll(offerFilterService.getValidNonFeaturedOffers(site, unit));
    // preload required insurance
    def insurance = null;
    if (site.noInsuranceWaiver) {
      if (site.insurances.size() > 0) {
        insurance = site.insurances.findAll { it.active }.min { it.premium }
      } else {
        // TODO: Log SEVERE warning
      }
    }
    def totals = costService.calculateTotals(site, unit, promo, insurance, moveInDate);
    render(template:template,
            contentType: "text/html",
            model:[site:site,
                   unit:unit,
                   promo: promo,
                   promos: promos,
                   moveInDate:moveInDate,
                   totals: totals,
                   insurance: insurance]);

  }
}
