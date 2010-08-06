package storitz

import com.storitz.RentalTransaction

class MoveInService {

    def siteLinkService
    def cShiftService

    boolean transactional = false

    def newTenant(RentalTransaction trans) {
      switch(trans.site.source) {
        case "SL":
          siteLinkService.createTenant(trans)
          break
        case "CS3":
          break
      }
    }


}
