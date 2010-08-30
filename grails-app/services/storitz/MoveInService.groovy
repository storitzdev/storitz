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

    def moveInDetail(RentalTransaction trans) {
      switch(trans.site.source) {
        case "SL":
          return siteLinkService.moveInDetail(trans)

        case "CS3":
          return CShiftService.moveInDetail(trans)

        case "CS4":
          break

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
          def today = new Date()
          if(trans.moveInDate - today <= 1) {
            return CShiftService.moveIn(trans)
          }
          return CShiftService.reserve(trans)
          break

        case "CS4":
          break

        default:
          throw new Exception("Unknown service for move in")
      }
    }


}
