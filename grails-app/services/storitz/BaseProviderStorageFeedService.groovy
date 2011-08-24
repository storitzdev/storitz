package storitz

import java.math.RoundingMode
import com.storitz.*
import com.storitz.service.ICostStorageFeedService
import com.storitz.service.IFeedStorageFeedService
import com.storitz.service.IMoveInStorageFeedService
import com.storitz.service.CostTotals
import java.util.regex.Pattern

abstract class BaseProviderStorageFeedService implements ICostStorageFeedService, IFeedStorageFeedService, IMoveInStorageFeedService {

  static transactional = false

  def refreshInsurance(Feed feed) {
    for (site in feed.sites) {
      loadInsurance(feed, site)
    }
  }

  abstract loadInsurance(Feed feed, StorageSite site)

  // Don't delete units that are no longer available. Instead, mark the units
  // as unavailable, and zero out their unit count.
  public final void zeroOutUnitsForSite(StorageSite site, SiteStats stats, PrintWriter writer) {
    site.units.each { unit ->
      if (unit.isAvailable && unit.unitCount > 0) {
        stats.removedCount++
        unit.isAvailable = false;
        unit.unitCount = 0;
      }
    }
  }

  public static void updateBestUnitPrice (StorageSite site) {
      // JM: 2011-06-07 Post op processing.
      // bestUnitPrice is pushRate or price, as appropriate.
      site.units.each { unit ->
        if (site.allowPushPrice)
          unit.bestUnitPrice = unit.pushRate;
        else
          unit.bestUnitPrice = unit.price
        unit.save(flush:true)
      }
   }

  def geoCodeSite(StorageSite storageSite)  {
      def maxidx = storageSite.zipcode.size() > 5 ? 5 : storageSite.zipcode.size()
      def address = cleanAddress(storageSite.address) + ', ' + storageSite.city + ', ' + storageSite.state.display + ' ' + storageSite.zipcode.substring(0,maxidx)
      GeocodeService geocodeService = new GeocodeService()
      def geoResult = geocodeService.geocode(address)
      storageSite.lng = geoResult?.results[0]?.geometry?.location?.lng
      storageSite.lat = geoResult?.results[0]?.geometry?.location?.lat
  }

  // JM: removes parenthesis from address
  // This is needed for google maps geolookup to work.
  // For example:= Uncle Bos site 226 gives us this:
  // 1171 Turnpike Street (Route 114)
  // Google geolookup can't handle that. If we strip off the (Route 114)
  // part (i.e. 1171 Turnpike Street), then it works fine.
  private String cleanAddress (String address) {
    if (address == null) {
      return address
    }
    String input = new String(address); // work on a copy
	  String regex = "\\(.+?\\)";
	  return Pattern.compile(regex).matcher(input).replaceAll("");
  }

  @Override
  public double calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended) {
    CostTotals totals = calculateTotals(site, unit, promo, ins, moveInDate, extended)
    return totals.moveInTotal
  }

  @Override
  public Date calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate, boolean allowExtension) {
    // TODO - handle anniversary date sites (most are first of the month)
    def durationMonths = promo ? (promo.prepay ? promo.prepayMonths + promo.expireMonth : (promo.inMonth - 1) + promo.expireMonth) : 1;

    // algo - subtract 1 from duration month and then get up to end of month
    def cal = new GregorianCalendar()
    cal.setTime(moveInDate)
    def moveInDay = cal.get(Calendar.DAY_OF_MONTH)
    if (site.useProrating && !site.prorateSecondMonth) {
      if (moveInDay > site.prorateCutoff && (!promo || promo && durationMonths == 1)) {
        durationMonths++;
      }
    }
    if (site.useProrating) {
      if (durationMonths - 1 > 0) {
        cal.add(Calendar.MONTH, durationMonths - 1)
      }
      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
    } else {
      cal.add(Calendar.MONTH, durationMonths)
      cal.add(Calendar.DAY_OF_MONTH, -1)
    }
    return cal.time as Date
  }

  @Override
  public MoveInDetails moveInDetail(RentalTransaction rentalTransaction) {

    def ins
    if (rentalTransaction.insuranceId > 0) {
      ins = Insurance.get(rentalTransaction.insuranceId)
    }
    def unit = StorageUnit.get(rentalTransaction.unitId)
    def promo = rentalTransaction.promoId > 0 ? SpecialOffer.get(rentalTransaction.promoId) : null

    CostTotals costTotals = calculateTotals(rentalTransaction.site, unit, promo, ins, rentalTransaction.moveInDate)

    def moveInDetails = new MoveInDetails()
    if (costTotals.rentTotal && costTotals.rentTotal > 0) {
      moveInDetails.items.add(new LineItem(description: "Rent", tax: 0 as BigDecimal, amount: costTotals.rentTotal as BigDecimal))
    }
    if (costTotals.feesTotal && costTotals.feesTotal > 0) {
      moveInDetails.items.add(new LineItem(description: "Fees", tax: 0 as BigDecimal, amount: costTotals.feesTotal as BigDecimal))
    }
    if (costTotals.insuranceCost && costTotals.insuranceCost > 0) {
      moveInDetails.items.add(new LineItem(description: "Insurance", tax: 0 as BigDecimal, amount: costTotals.insuranceCost as BigDecimal))
    }
    if (costTotals.deposit && costTotals.deposit > 0) {
      moveInDetails.items.add(new LineItem(description: "Refundable Deposit", tax: 0 as BigDecimal, amount: costTotals.deposit as BigDecimal))
    }
    if (costTotals.discountTotal && costTotals.discountTotal > 0) {
      moveInDetails.items.add(new LineItem(description: "Selected Promotion", tax: 0 as BigDecimal, amount: -costTotals.discountTotal as BigDecimal))
    }
    if (costTotals.tax && costTotals.tax > 0) {
      moveInDetails.items.add(new LineItem(description: "Tax", tax: costTotals.tax as BigDecimal, amount: 0 as BigDecimal))
    }

    return moveInDetails
  }

  @Override
  public CostTotals calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate) {
    return calculateTotals(site, unit, promo, ins, moveInDate, true)
  }

  public CostTotals calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean allowExtension) {
    CostTotals ret = new CostTotals();
    def durationMonths = promo ? (promo.prepay ? promo.prepayMonths + promo.expireMonth : (promo.inMonth - 1) + promo.expireMonth) : 1;
    def offerDiscount = 0
    def rate = unit ? (site.allowPushPrice ? (unit.pushRate < unit.price ? unit.pushRate : unit.price) : unit.price) : 0
    def premium = ins ? ins.premium : 0
    def lockFee = site.lockFee ? site.lockFee : 0
    def adminFee = site.adminFee ? site.adminFee : 0
    def additionalFees = adminFee + lockFee
    def waiveAdmin = false
    def deposit = unit?.deposit ? unit.deposit : (site.deposit ? site.deposit : 0)

    def cal = new GregorianCalendar()
    cal.setTime(moveInDate)
    def lastDayInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    def moveInDay = cal.get(Calendar.DAY_OF_MONTH)

    // handle SiteLink case where 2nd month proration is chosen with no promo
    if (!promo && site.prorateSecondMonth) {
      durationMonths = 2
    }

    if (allowExtension && site.useProrating && !site.prorateSecondMonth) {
      if (moveInDay > site.prorateCutoff && (!promo || promo && durationMonths == 1)) {
        durationMonths++;
        ret.extended = true;
      } else {
        ret.extended = false;
      }
    }

    if (site.useProrating) {
      if (durationMonths - 1 > 0) {
        cal.add(Calendar.MONTH, durationMonths - 1)
      }
      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
    } else {
      cal.add(Calendar.MONTH, durationMonths)
      cal.add(Calendar.DAY_OF_MONTH, -1)
    }

    def subTotal
    def rentTotal
    def monthOneProRate
    def durationDays
    BigDecimal insuranceCost = 0
    if (site.useProrating && !site.prorateSecondMonth && (moveInDay > site.prorateStart)) {
      durationDays = (lastDayInMonth - moveInDay) + 1
      durationMonths -= (1 - (durationDays) / lastDayInMonth)
      if (durationMonths < 0) {
        durationMonths = 1 + durationMonths;
      }
      insuranceCost = StoritzUtil.roundToMoney(premium * durationMonths)
      rentTotal = StoritzUtil.roundToMoney(rate * durationMonths)
      subTotal = rentTotal + insuranceCost
      monthOneProRate = rate * (((lastDayInMonth - moveInDay) + 1) / lastDayInMonth)
    } else {
      insuranceCost = (premium * durationMonths)
      rentTotal = (rate * durationMonths)
      subTotal = rentTotal + insuranceCost
      monthOneProRate = rate // no pro-rate
      durationDays = 0
    }

    if (promo) {

      waiveAdmin = promo.waiveAdmin

      switch (promo.promoType) {
        case "AMOUNT_OFF":
          offerDiscount = promo.promoQty;
          break;

        case "PERCENT_OFF":
          if (promo.inMonth == 1 && !promo.prepay) {
            offerDiscount = (promo.promoQty / 100.0) * (monthOneProRate + (promo.expireMonth - 1) * rate);
          }
          else if (promo.inMonth > 1 && !promo.prepay) {
            offerDiscount = 0.0; // offer only reduces move-in cost if it requires *prepayment* and hits in month 1
          }
          else {
            offerDiscount = (promo.promoQty / 100.0) * (promo.expireMonth) * rate;
          }
          break;

        case "FIXED_RATE":
          if (promo.inMonth == 1 && promo.prepayMonths == 1) {
            offerDiscount = ((monthOneProRate - promo.promoQty) > 0 ? (monthOneProRate - promo.promoQty) : 0) * promo.expireMonth;
          } else {
            offerDiscount = ((rate - promo.promoQty) > 0 ? (rate - promo.promoQty) : 0) * promo.expireMonth;
          }
          break;
      }
    }

    // Check for null tax rates and handle as appropriate
    def taxRateInsurance = site.taxRateInsurance ? site.taxRateInsurance : 0
    def taxRateRental = site.taxRateRental ? site.taxRateRental : 0
    def taxRateMerchandise = site.taxRateMerchandise ? site.taxRateMerchandise : 0

    def feesTotal = (waiveAdmin ? additionalFees - adminFee : additionalFees)
    def tax = StoritzUtil.roundToMoney(premium * durationMonths * (taxRateInsurance / 100) + (rate * durationMonths - offerDiscount) * (taxRateRental / 100)) + StoritzUtil.roundToMoney(lockFee * (taxRateMerchandise / 100))

    // don't allow negative move-in
    if (offerDiscount > (feesTotal + subTotal + deposit + tax)) {
      offerDiscount = (feesTotal + subTotal + deposit + tax)
    }

    def moveInTotal = feesTotal + subTotal + deposit + tax - offerDiscount;

    ret.duration = durationMonths
    ret.discountTotal = offerDiscount
    ret.feesTotal = feesTotal
    ret.rentTotal = rentTotal
    ret.insuranceCost = insuranceCost
    ret.tax = tax
    ret.deposit = deposit
    ret.moveInTotal = StoritzUtil.roundToMoney(moveInTotal)
    ret.paidThruDate = cal.time
    ret.durationMonths = (durationMonths as BigDecimal).setScale(0, RoundingMode.FLOOR)
    ret.durationDays = durationDays

    return ret
  }

  def createSiteUser(site, email, realName, manager) {
    def user = User.findByEmail(email)

    if (!email || email.size() == 0)
      return null

    if (!realName || realName.size() == 0)
      realName = email

    if (!user) {
      user = new User(
          username: email,
          password: (Math.random() * System.currentTimeMillis()) as String,
          description: "Site Manager for ${site.title}",
          email: email,
          userRealName: realName,
          accountExpired: false,
          accountLocked: false,
          passwordExpired: false,
          enabled: false
      )
      user.manager = manager
      if (user.validate()) {
        user.save(flush: true)
        SiteUser.link(site, user)
      }
      else {
        log.info "Bad user from feed - errors below: "
        user.errors.allErrors.each {
          log.info it
        }
        return null;
      }
    }
    if (!UserNotificationType.userHasNotificationType(user, 'NOTIFICATION_SITE_MANAGER')) {
      def notificationType = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
      UserNotificationType.create(user, notificationType, true)
    }
    if (!UserRole.userHasRole(user, 'ROLE_USER')) {
      UserRole.create(user, Role.findByAuthority('ROLE_USER'), true)
    }

    return user
  }

  /**
   * names of keys to be used by deactivateDeletedOffers below
   */
  protected static final String CONCESSION_ID_FIELD = "concessionId";
  protected static final String CODE_FIELD = "code";
  /**
   * Mark obsolete offers as inactive; do not delete associated requirements
   * @param site
   * @param currentOfferKeys
   * @param keyName
   * @param writer
   */
  protected void deactivateDeletedOffers(StorageSite site, ArrayList currentOfferKeys, String keyName, PrintWriter writer) {
    if (!(keyName == CONCESSION_ID_FIELD || keyName == CODE_FIELD)) {
      log.warn("Uknown keyName ${keyName} passed to deactivateDeletedOffers() for ${site}");
      return;
    }
    for (offer in site.specialOffers.find { it.active }) {
      boolean found = (keyName == CONCESSION_ID_FIELD) ? currentOfferKeys.contains(offer.concessionId) : currentOfferKeys.contains(offer.code);
      if (!found) {
        writer.println "Removing stale concession: ${site.title} - ${offer.concessionId} - ${offer.code} ${offer.promoName} - ${offer.description}"
        offer.active = false
        offer.save(flush: true)
      }
    }
  }

}
