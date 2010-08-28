package storitz

import com.storitz.RentalTransaction

class MoveInService {

    def siteLinkService
    def CShiftService

    boolean transactional = false

    def checkRented(RentalTransaction trans) {
      switch(trans.site.source) {
        case "SL":
          return siteLinkService.checkRented(trans)

        case "CS3":
          return CShiftService.checkRented(trans)

        case "CS4":
          break

        default:
          throw new Exception("Unknown service for move in")
      }
    }

    def moveIn(RentalTransaction trans) {
      switch(trans.site.source) {
        case "SL":
          siteLinkService.createTenant(trans)
          siteLinkService.moveInCostRetrieve(trans)
          return siteLinkService.moveIn(trans)
          break

        case "CS3":
          CShiftService.createTenant(trans)
          return CShiftService.moveIn(trans)
          break

        case "CS4":
          break

        default:
          throw new Exception("Unknown service for move in")
      }
    }


}
