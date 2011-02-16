package storitz

import storitz.constants.CommissionType
import com.storitz.*

class CostService {

    boolean transactional = false

    def siteLinkService
    def CShiftService
    def quikStorService
    def exrsService

  def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended) {
    switch(site.source) {

      case "SL":
        return siteLinkService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      case "CS3":
        return CShiftService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      case "QS":
        return quikStorService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      case "EX":
        return CShiftService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

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

      default:
        throw new Exception("Unknown service for paid thru date")
    }
  }

  def calculateCommission(cost, commissionSource) {

    def c = Commission.createCriteria()

    def ctype = c.get {
      and {
        eq("commissionSource", commissionSource)
        lt("lowerBound", cost)
        ge("upperBound", cost)
      }
    }
    if (!ctype) return cost * 0.25

    if (ctype.commissionType == CommissionType.PERCENTAGE) {
      return cost * (ctype.amount / 100)
    }
    return ctype.amount
  }
}
