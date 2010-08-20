package com.storitz

class NotificationType {

    String notificationType
    String description

  static constraints = {
    notificationType blank: false, unique: true
    description(blank:false)
  }

}
