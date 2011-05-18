package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 5/16/11
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public enum OrganizerContestReferral {
    NONE("None","None"),
    GOOGLE("Google search","Google search"),
    ADVERTISEMENT("Clicked on an ad","Clicked on an ad"),
    APARTMENT_SITE("Apartment or homeowner site","Apartment or homeowner site"),
    ADVERTISING("Self storage advertising","Self storage advertising"),
    SOCIAL_MEDIA("Twitter, Facebook or a blog","Twitter, Facebook or a blog"),
    OTHER("Other","Other");

    final String display
    final String fullName

    OrganizerContestReferral(String display, String fullName) {
        this.display = display
        this.fullName = fullName
    }

    String getValue() {
        return this.display;
    }

    static list() {
        [
            NONE, GOOGLE, ADVERTISEMENT, APARTMENT_SITE,  ADVERTISING, SOCIAL_MEDIA, OTHER
        ]
    }

    static selectList() {
        return list().collect { it.display }
    }

    public static OrganizerContestReferral fromText(String key) {
        def ret = list().find {it.display == key }
        if (!ret) return OrganizerContestReferral.valueOf(key)
        return ret
    }

    public static OrganizerContestReferral getEnumFromId(String value) {
      def ret = list().find {it.display == value }
      if (!ret) return OrganizerContestReferral.valueOf(value)
      return ret
    }

}
