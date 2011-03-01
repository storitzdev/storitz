package storitz

import com.storitz.RentalTransaction

class MoveInService {

    def siteLinkService
    def CShiftService
    def quikStorService
    def exrsService

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

        case "EX":
          return exrsService.checkRented(trans)  

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

        case "QS":
          return quikStorService.moveInDetail(trans)

        case "EX":
          return exrsService.moveInDetail(trans)

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

        case "EX":
          // TODO - create email notification to fill in form
          return exrsService.moveIn(trans)
          break

        default:
          throw new Exception("Unknown service for move in")
      }
    }


}
