package com.storitz

class NotificationType {

  String notificationType
  String description

  boolean equals(other) {
    if (!(other instanceof NotificationType)) {
      return false
    }

    other.id == id
  }

  int hashCode() {
    return id
  }

  static constraints = {
    notificationType blank: false, unique: true
    description(blank: false)
  }

}
