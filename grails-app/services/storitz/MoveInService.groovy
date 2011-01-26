package storitz

import com.storitz.RentalTransaction

class MoveInService {

    def siteLinkService
    def CShiftService
    def quikStorService

    boolean transactional = false

    def checkRented(RentalTransaction trans) {
      switch(trans.site.source) {
        case "SL":
          return siteLinkService.checkRented(trans)

        case "CS3":
          return CShiftService.checkRented(trans)

        case "CS4":
          break

        case "QS":
          return quikStorService.checkRented(trans)

        default:
          throw new Exception("Unknown service for move in")
      }
    }

    def moveInDetail(RentalTransaction trans) {
      switch(trans.site.source) {
        case "SL":
          return siteLinkService.moveInDetail(trans)

        case "CS3":
          return CShiftService.moveInDetail(trans)

        case "CS4":
          break

        case "CS3":
          return quikStorService.moveInDetail(trans)

        default:
          throw new Exception("Unknown service for move in detail")
      }
    }

    def moveIn(RentalTransaction trans) {
      switch(trans.site.source) {
        case "SL":
          siteLinkService.createTenant(trans)
          return siteLinkService.moveIn(trans)
          break

        case "CS3":
          CShiftService.createTenant(trans)
          return CShiftService.reserve(trans)
          break

        case "CS4":
          break

        case "QS":
          quikStorService.createTenant(trans)
          return quikStorService.moveIn(trans)
          break

        default:
          throw new Exception("Unknown service for move in")
      }
    }


}
