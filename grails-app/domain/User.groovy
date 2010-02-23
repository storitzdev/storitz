/**
 * User domain class.
 */
class User {
	static transients = ['pass']
	static hasMany = [authorities:Role, sites:SiteUser, specialOffers:SpecialOffer]
	static belongsTo = Role

	/** Username */
	String username
	/** User Real Name*/
	String userRealName
	/** MD5 Password */
	String passwd
	/** enabled */
	boolean enabled

	String email
	boolean emailShow

	/** description */
	String description = ''

	/** plain password to create a MD5 password */
	String pass = '[secret]'

    User manager;

	static constraints = {
		username(blank: false, unique: true)
        email(email: true)
		userRealName(blank: false)
		passwd(blank: false)
        manager(nullable: true)
        description(nullable: true, widget: 'textarea')
		enabled()
	}

    def sites() {
		return sites.collect{it.site}
	}

}
