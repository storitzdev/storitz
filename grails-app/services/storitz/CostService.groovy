package storitz

import com.storitz.StorageSite
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.Insurance

class CostService {

    boolean transactional = false

    def siteLinkService
    def cShiftService

    def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins) {
      switch(site.source) {

        case "SL":
          return siteLinkService.calculateMoveInCost(site, unit, promo, ins)

        default:
          throw new Exception("Unknown service for move in cost calculation")
      }

    }
}
