package storitz

import com.storitz.StorageSite
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.Insurance

class CostService {

    boolean transactional = false

    def siteLinkService
    def CShiftService

    def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins) {
      switch(site.source) {

        case "SL":
          return siteLinkService.calculateMoveInCost(site, unit, promo, ins)

        case "CS3":
          return CShiftService.calculateMoveInCost(site, unit, promo, ins)

        default:
          throw new Exception("Unknown service for move in cost calculation")
      }

    }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins) {
    switch(site.source) {

      case "SL":
        return siteLinkService.calculateTotals(site, unit, promo, ins)

      case "CS3":
        return CShiftService.calculateTotals(site, unit, promo, ins)

      default:
        throw new Exception("Unknown service totals calculation")
    }

  }

    def calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate) {

      switch(site.source) {

        case "SL":
          return siteLinkService.calculatePaidThruDate(site, promo, moveInDate)

        case "CS3":
          return CShiftService.calculatePaidThruDate(site, promo, moveInDate)

        default:
          throw new Exception("Unknown service for paid thru date")
      }
    }
}
