package storitz

import com.storitz.RentalTransaction
import com.storitz.EDomico

class MoveInService {

  def siteLinkService
  def CShiftService
  def CShift4Service
  def quikStorService
  def exrsService
  def usiService

  boolean transactional = false

  def checkRented(RentalTransaction trans) {
    switch (trans.site.source) {
      case "SL":
        return siteLinkService.checkRented(trans)

      case "CS3":
        return CShiftService.checkRented(trans)

      case "CS4":
        return CShift4Service.checkRented(trans)

      case "QS":
        return quikStorService.checkRented(trans)

      case "EX":
        return exrsService.checkRented(trans)

      case "USI":
        return usiService.checkRented(trans)

      case "DOM":
        EDomico eDomico = (EDomico)trans.site.feed
        EDomicoService eDomicoService = new EDomicoService(eDomico.edomicoClientID,eDomico.edomicoWebServicesKey)
        return eDomicoService.checkRented(trans)

      default:
        throw new Exception("Unknown service for move in")
    }
  }

  def moveInDetail(RentalTransaction trans) {
    switch (trans.site.source) {
      case "SL":
        return siteLinkService.moveInDetail(trans)

      case "CS3":
        return CShiftService.moveInDetail(trans)

      case "CS4":
        return CShift4Service.moveInDetail(trans)

      case "QS":
        return quikStorService.moveInDetail(trans)

      case "EX":
        return exrsService.moveInDetail(trans)

      case "USI":
        return usiService.moveInDetail(trans)

      case "DOM":
        EDomico eDomico = (EDomico)trans.site.feed
        EDomicoService eDomicoService = new EDomicoService(eDomico.edomicoClientID,eDomico.edomicoWebServicesKey)
        return eDomicoService.moveInDetail(trans)

      default:
        throw new Exception("Unknown service for move in detail")
    }
  }

  def moveIn(RentalTransaction trans) {
    switch (trans.site.source) {
      case "SL":
        siteLinkService.createTenant(trans)
        return siteLinkService.moveIn(trans)

      case "CS3":
        CShiftService.createTenant(trans)
        return CShiftService.reserve(trans)

      case "CS4":
        CShift4Service.createTenant(trans)
        return CShift4Service.moveIn(trans)

      case "QS":
        quikStorService.createTenant(trans)
        return quikStorService.moveIn(trans)

      case "EX":
        // TODO - create email notification to fill in form
        return exrsService.moveIn(trans)

      case "USI":
        usiService.createTenant(trans)
        return usiService.reserve(trans)

      case "DOM":
        EDomico eDomico = (EDomico)trans.site.feed
        EDomicoService eDomicoService = new EDomicoService(eDomico.edomicoClientID,eDomico.edomicoWebServicesKey)
        return eDomicoService.reserve(trans)

      default:
        throw new Exception("Unknown service for move in")
    }
  }

  def reserve(RentalTransaction trans) {
    switch (trans.site.source) {
      case "SL":
        siteLinkService.createTenant(trans)
        return siteLinkService.reserve(trans)

      case "CS3":
        CShiftService.createTenant(trans)
        return CShiftService.reserve(trans)

      case "CS4":
        CShift4Service.createTenant(trans)
        return CShift4Service.reserve(trans)

      case "QS":
        quikStorService.createTenant(trans)
        return quikStorService.reserve(trans)

      case "EX":
        // TODO - create email notification to fill in form
        return exrsService.moveIn(trans)

      case "USI":
        usiService.createTenant(trans)
        return usiService.reserve(trans)

      case "DOM":
        EDomico eDomico = (EDomico)trans.site.feed
        EDomicoService eDomicoService = new EDomicoService(eDomico.edomicoClientID,eDomico.edomicoWebServicesKey)
        return eDomicoService.reserve(trans)

      default:
        throw new Exception("Unknown service for move in")
    }
  }


}
