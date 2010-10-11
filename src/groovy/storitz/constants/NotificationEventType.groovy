package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Aug 18, 2010
 * Time: 2:04:45 PM
 * To change this template use File | Settings | File Templates.
 */
public enum NotificationEventType {
  NEW_TENANT("New Tenant"),
  PRE_MOVE_IN_PROPERTY("Pre Move-In - Property"),
  PRE_MOVE_IN_TENANT("Pre Move-In - Tenant"),
  POST_MOVE_IN("Post Move In");

  final String display

  NotificationEventType(String display) {
    this.display = display;
  }

  String getValue() { return this.display }

  static list() {
    [NEW_TENANT, PRE_MOVE_IN_PROPERTY, PRE_MOVE_IN_TENANT, POST_MOVE_IN]
  }

  static public NotificationEventType getEnumFromId(String value) {
        list().find {it.display == value }
    }

}