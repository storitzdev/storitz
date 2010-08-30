package storitz

import com.storitz.StorageSite
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.Insurance
import com.storitz.Commission
import storitz.constants.CommissionType
import com.storitz.RentalTransaction

class CostService {

    boolean transactional = false

    def siteLinkService
    def CShiftService

  def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended) {
    switch(site.source) {

      case "SL":
        return siteLinkService.calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)

      case "CS3":
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
