package storitz

import java.math.RoundingMode
import com.storitz.StorageUnit
import com.storitz.SpecialOffer
import com.storitz.Insurance
import com.storitz.StorageSite
import com.storitz.Feed
import com.storitz.RentalTransaction

abstract class BaseProviderService {

  static transactional = false

  def refreshInsurance(Feed feed) {
    for(site in feed.sites) {
      loadInsurance(feed, site)
    }
  }

  abstract loadInsurance(Feed feed, StorageSite site)

  def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended) {
    def ret = calculateTotals(site, unit, promo, ins, moveInDate, extended)
    return ret["moveInTotal"]
  }

  def calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate, boolean allowExtension) {
    // TODO - handle anniversary date sites (most are first of the month)
    def durationMonths = promo ? (promo.prepay ? promo.prepayMonths + promo.expireMonth : (promo.inMonth -1) + promo.expireMonth) : 1;

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
    return cal.time
  }

  def moveInDetail(RentalTransaction rentalTransaction) {

    if (!checkRented(rentalTransaction)) {
      return null
    }

    def insId = -1
    def ins
    if (rentalTransaction.insuranceId > 0) {
      ins = Insurance.get(rentalTransaction.insuranceId)
      insId = ins.insuranceId
    }
    def unit = StorageUnit.get(rentalTransaction.unitId)
    def promo = rentalTransaction.promoId > 0 ? SpecialOffer.get(rentalTransaction.promoId) : null

    def detailList = calculateTotals(rentalTransaction.site, unit, promo, ins, rentalTransaction.moveInDate)
    def moveInDetails = new MoveInDetails()
    if (detailList["rentTotal"] && detailList["rentTotal"] > 0) {
      moveInDetails.items.add(new LineItem(description:"Rent", tax:0 as BigDecimal, amount: detailList["rentTotal"] as BigDecimal))
    }
    if (detailList["feesTotal"] && detailList["feesTotal"] > 0) {
      moveInDetails.items.add(new LineItem(description:"Fees", tax:0 as BigDecimal, amount: detailList["feesTotal"] as BigDecimal))
    }
    if (detailList["insuranceCost"] && detailList["insuranceCost"] > 0) {
      moveInDetails.items.add(new LineItem(description:"Insurance", tax:0 as BigDecimal, amount: detailList["insuranceCost"] as BigDecimal))
    }
    if (detailList["deposit"] && detailList["deposit"] > 0) {
      moveInDetails.items.add(new LineItem(description:"Refundable Deposit", tax:0 as BigDecimal, amount: detailList["deposit"] as BigDecimal))
    }
    if (detailList["discountTotal"] && detailList["discountTotal"] > 0) {
      moveInDetails.items.add(new LineItem(description:"Selected Promotion", tax:0 as BigDecimal, amount: -detailList["discountTotal"] as BigDecimal))
    }
    if (detailList["tax"] && detailList["tax"] > 0) {
      moveInDetails.items.add(new LineItem(description:"Tax", tax:detailList["tax"] as BigDecimal, amount: 0 as BigDecimal))
    }

    return moveInDetails
  }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate) {
    calculateTotals(site, unit, promo, ins, moveInDate, true)
  }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean allowExtension) {
    def ret = [:]
    def durationMonths = promo ? (promo.prepay ? promo.prepayMonths + promo.expireMonth : (promo.inMonth -1) + promo.expireMonth) : 1;
    def offerDiscount = 0
    def rate = unit ? (site.allowPushPrice ? (unit.pushRate < unit.price ? unit.pushRate : unit.price) : unit.price) : 0
    def premium = ins ? ins.premium : 0
    def lockFee = site.lockFee ? site.lockFee : 0
    def adminFee = site.adminFee ? site.adminFee : 0
    def additionalFees = adminFee + lockFee
    def waiveAdmin = false
    def deposit = site.deposit ? site.deposit : 0

    def cal = new GregorianCalendar()
    cal.setTime(moveInDate)
    def lastDayInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    def moveInDay = cal.get(Calendar.DAY_OF_MONTH)

    if (allowExtension && site.useProrating && !site.prorateSecondMonth) {
      if (moveInDay > site.prorateCutoff && (!promo || promo && durationMonths == 1)) {
        durationMonths++;
        ret["extended"] = true;
      } else {
        ret["extended"] = false;
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
    def discountRate
    def durationDays
    BigDecimal insuranceCost  = 0
    if (site.useProrating && !site.prorateSecondMonth && (moveInDay > site.prorateStart)) {
      durationDays = (lastDayInMonth - moveInDay) + 1
      durationMonths -= (1 - (durationDays)/lastDayInMonth)
      insuranceCost = (premium*durationMonths).setScale(2, RoundingMode.HALF_UP)
      rentTotal = (rate*durationMonths).setScale(2, RoundingMode.HALF_UP)
      subTotal = rentTotal + insuranceCost
      discountRate = rate * (((lastDayInMonth - moveInDay) + 1)/lastDayInMonth)
    } else {
      insuranceCost = (premium*durationMonths)
      rentTotal = (rate*durationMonths)
      subTotal = rentTotal + insuranceCost
      discountRate = rate
      durationDays = 0
    }

    if (promo) {

      waiveAdmin = promo.waiveAdmin

      switch (promo.promoType) {
        case "AMOUNT_OFF":
          offerDiscount = promo.promoQty;
          break;

        case "PERCENT_OFF":
          if (promo.inMonth == 1) {
            offerDiscount = (promo.promoQty/100.0) * (discountRate + (promo.expireMonth - 1) * rate);
          } else {
            offerDiscount = (promo.promoQty/100.0) * (promo.expireMonth) * rate;
          }
          break;

        case "FIXED_RATE":
          if (promo.inMonth == 1 && promo.prepayMonths == 1) {
            offerDiscount = ((discountRate - promo.promoQty) > 0 ? (discountRate - promo.promoQty): 0) * promo.expireMonth;
          } else {
            offerDiscount = ((rate - promo.promoQty) > 0 ? (rate - promo.promoQty): 0) * promo.expireMonth;
          }
          break;
      }
    }


    def feesTotal = (waiveAdmin ? additionalFees - adminFee : additionalFees)
    def tax = (premium * durationMonths * (site.taxRateInsurance / 100) + (rate * durationMonths - offerDiscount) * (site.taxRateRental / 100)).setScale(2, RoundingMode.HALF_UP) + (lockFee * (site.taxRateMerchandise / 100)).setScale(2, RoundingMode.HALF_UP)
    def moveInTotal = feesTotal + subTotal + deposit + tax - offerDiscount;

    ret["duration"] = durationMonths
    ret["discountTotal"] = offerDiscount
    ret["feesTotal"] = feesTotal
    ret["rentTotal"] = rentTotal
    ret["insuranceCost"] = insuranceCost
    ret["tax"] = tax
    ret["deposit"] = deposit
    ret["moveInTotal"] = moveInTotal
    ret["paidThruDate"] = cal.time.format('MM/dd/yy')
    ret["paidThruDateMillis"] = cal.time
    ret["durationMonths"] =  (durationMonths as BigDecimal).setScale(0, RoundingMode.FLOOR)
    ret["durationDays"] = durationDays

    return ret
  }
}
