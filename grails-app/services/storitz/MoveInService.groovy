package storitz

import com.storitz.RentalTransaction
import storitz.service.StorageFeedServiceFactory
import grails.util.Environment

class MoveInService {

  boolean transactional = false

  def isAvailable(RentalTransaction trans) {
    // TODO: Refactor to accept StorageUnit, not RentalTransaction
    StorageFeedServiceFactory.getMoveInServiceInstance(trans.site).isAvailable(trans)
  }

  def moveInDetail(RentalTransaction trans) {
    StorageFeedServiceFactory.getMoveInServiceInstance(trans.site).moveInDetail(trans)
  }

  def moveIn(RentalTransaction trans, boolean sandboxMode) {
    StorageFeedServiceFactory.getMoveInServiceInstance(trans.site).moveIn(trans, sandboxMode)
  }

  def reserve(RentalTransaction trans, boolean sandboxMode) {
    StorageFeedServiceFactory.getMoveInServiceInstance(trans.site).reserve(trans, sandboxMode)
  }
}
