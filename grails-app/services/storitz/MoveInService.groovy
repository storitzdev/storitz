package storitz

import com.storitz.RentalTransaction
import storitz.service.StorageFeedServiceFactory
import grails.util.Environment

class MoveInService {

  boolean transactional = false

  def isAvailable(RentalTransaction trans) {
    StorageFeedServiceFactory.getMoveInServiceInstance(trans.site).isAvailable(trans)
  }

  def moveInDetail(RentalTransaction trans) {
    StorageFeedServiceFactory.getMoveInServiceInstance(trans.site).moveInDetail(trans)
  }

  def moveIn(RentalTransaction trans) {
    StorageFeedServiceFactory.getMoveInServiceInstance(trans.site).moveIn(trans)
  }

  def reserve(RentalTransaction trans) {
    StorageFeedServiceFactory.getMoveInServiceInstance(trans.site).reserve(trans)
  }

  // TODO: Determine where/when to best utilize this
  public static boolean isValidMoveInEnvironment () {
    return grails.util.Environment.getCurrent() == Environment.PRODUCTION
  }
}
