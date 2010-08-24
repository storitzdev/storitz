package storitz

import storitz.constants.NotificationEventType
import com.storitz.RentalTransaction

class NotificationService {

    boolean transactional = false

    def notify(NotificationEventType eventType, RentalTransaction rentalTransaction) {

      switch(eventType) {
        case NotificationEventType.NEW_TENANT:
          break

        case NotificationEventType.PRE_MOVE_IN_TENANT:
          break

        case NotificationEventType.PRE_MOVE_IN_PROPERTY:
          break
      }

    }

}
