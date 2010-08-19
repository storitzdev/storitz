package com.storitz

import org.apache.commons.lang.builder.HashCodeBuilder

class UserNotificationType implements Serializable {

	User user
	NotificationType notificationType

	boolean equals(other) {
		if (!(other instanceof UserNotificationType)) {
			return false
		}

		other.user?.id == user?.id &&
			other.notificationType?.id == notificationType?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (notificationType) builder.append(notificationType.id)
		builder.toHashCode()
	}

	static UserNotificationType get(long userId, long notificationTypeId) {
		find 'from UserNotificationType where user.id=:userId and notificationType.id=:notificationTypeId',
			[userId: userId, notificationTypeId: notificationTypeId]
	}

	static UserNotificationType create(User user, NotificationType notificationType, boolean flush = false) {
		new UserNotificationType(user: user, notificationType: notificationType).save(flush: flush, insert: true)
	}

	static boolean remove(User user, NotificationType notificationType, boolean flush = false) {
		UserNotificationType instance = UserNotificationType.findByUserAndNotificationType(user, notificationType)
		instance ? instance.delete(flush: flush) : false
	}

	static void removeAll(User user) {
		executeUpdate 'DELETE FROM UserNotificationType WHERE user=:user', [user: user]
	}

	static void removeAll(NotificationType notificationType) {
		executeUpdate 'DELETE FROM UserNotificationType WHERE notificationType=:notificationType', [notificationType: notificationType]
	}

    static getUsersByNotificationTypeName(notificationTypename) {
      NotificationType notificationType = NotificationType.findByNotificationType(notificationTypename)
      return UserNotificationType.findAllByNotificationType(notificationType).collect{ it.user }.sort()
    }

    static boolean userHasNotificationType(User user, String notificationTypename) {
      NotificationType notificationType = NotificationType.findByNotificationType(notificationTypename)
      if (!notificationType) return false
      return get(user.id, notificationType.id) != null
    }

	static mapping = {
		id composite: ['notificationType', 'user']
		version false
	}
}
