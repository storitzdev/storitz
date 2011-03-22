package com.storitz

class User {

  static transients = ['pass']
  static hasMany = [sites: SiteUser, notificationTypes: UserNotificationType]

  String username
  String password
  String email
  String userRealName
  String description
  boolean enabled
  boolean accountExpired
  boolean accountLocked
  boolean passwordExpired


  User manager;

  static constraints = {
    username(blank: false, unique: true)
    email(email: true)
    userRealName(blank: false)
    password(blank: false)
    manager(nullable: true)
    description(nullable: true, widget: 'textarea')
  }

  static mapping = {
    password column: '`password`'
  }

  Set<Role> getAuthorities() {
    UserRole.findAllByUser(this).collect { it.role } as Set
  }

  static showNotificationTypes(user) {
    return UserNotificationType.findAllByUser(user).collect { it.notificationType.description }.join(", ")
  }
}
