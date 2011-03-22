package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Apr 2, 2010
 * Time: 4:34:52 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ContactType {
  SUPPORT("General support question", "support@storitz.com"),
  POLICY("Privacy, terms of use or refund policy question", "privacy@storitz.com"),
  TECH("Technical or site problems question", "tech@storitz.com"),
  JOBS("Careers at Storitz", "jobs@storitz.com"),
  OPERATOR("I am a storage operator and I want to be listed by Storitz", "sales@storitz.com"),
  BUSINESS("Business opportunities to partner with Storitz", "info@storitz.com");

  final String display;
  final String email;

  ContactType(String display, String email) {
    this.display = display;
    this.email = email;
  }

  String getValue() { return this.display }

  static list() {
    [SUPPORT, POLICY, TECH, OPERATOR, BUSINESS]
  }

  static public ContactType getEnumFromId(String value) {
    def ret = list().find {it.display == value }
    if (!ret) return ContactType.valueOf(value)
    return ret
  }

}