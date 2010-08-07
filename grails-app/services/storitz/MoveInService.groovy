package storitz

import com.storitz.RentalTransaction

class MoveInService {

    def siteLinkService
    def cShiftService

    boolean transactional = false

    def moveIn(RentalTransaction trans) {
      switch(trans.site.source) {
        case "SL":
          siteLinkService.createTenant(trans)
          siteLinkService.moveIn(trans)
          break

        case "CS3":
          break

        case "CS4":
          break

        default:
          throw new Exception("Unknown service for move in")
      }
    }


}
