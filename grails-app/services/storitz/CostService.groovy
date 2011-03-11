package storitz

import storitz.constants.CommissionType
import com.storitz.*

class CostService {

    boolean transactional = false

    def siteLinkService
    def CShiftService
    def quikStorService
    def exrsService
    def usiService

  def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended) {
    switch(site.source) {

      case "SL":
        return siteLinkService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      case "CS3":
        return CShiftService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      case "QS":
        return quikStorService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      case "EX":
        return exrsService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      case "USI":
        return usiService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      default:
        throw new Exception("Unknown service for move in cost calculation")
    }

  }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate) {
    switch(site.source) {

      case "SL":
        return siteLinkService.calculateTotals(site, unit, promo, ins, moveInDate)

      case "CS3":
        return CShiftService.calculateTotals(site, unit, promo, ins, moveInDate)

      case "QS":
        return quikStorService.calculateTotals(site, unit, promo, ins, moveInDate)

      case "EX":
        return exrsService.calculateTotals(site, unit, promo, ins, moveInDate)

      case "USI":
        return usiService.calculateTotals(site, unit, promo, ins, moveInDate)

      default:
        throw new Exception("Unknown service totals calculation")
    }

  }

  def calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate, boolean allowExtension) {

    switch(site.source) {

      case "SL":
        return siteLinkService.calculatePaidThruDate(site, promo, moveInDate, allowExtension)

      case "CS3":
        return CShiftService.calculatePaidThruDate(site, promo, moveInDate, allowExtension)

      case "QS":
        return quikStorService.calculatePaidThruDate(site, promo, moveInDate, allowExtension)

      case "EX":
        return exrsService.calculatePaidThruDate(site, promo, moveInDate, allowExtension)

      case "USI":
        return usiService.calculatePaidThruDate(site, promo, moveInDate, allowExtension)

      default:
        throw new Exception("Unknown service for paid thru date")
    }
  }

  def calculateCommission(BigDecimal monthly, Feed feed) {

    CommissionSchedule schedule = feed.commissionSchedule
    Commission ctype = schedule.entries.find{ it.lowerBound < monthly && it.upperBound >= monthly}

    if (!ctype) return monthly * 0.25

    if (ctype.commissionType == CommissionType.PERCENTAGE) {
      return monthly * (ctype.amount / 100)
    }
    return ctype.amount
  }
}
