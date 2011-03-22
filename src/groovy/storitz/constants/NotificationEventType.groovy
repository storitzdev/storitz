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
  POST_MOVE_IN("Post Move In"),
  ACH_TRANSFER("ACH Transfer");

  final String display

  NotificationEventType(String display) {
    this.display = display;
  }

  String getValue() { return this.display }

  static list() {
    [NEW_TENANT, PRE_MOVE_IN_PROPERTY, PRE_MOVE_IN_TENANT, POST_MOVE_IN, ACH_TRANSFER]
  }

  static public NotificationEventType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return NotificationEventType.valueOf(value)
    return ret
  }

}