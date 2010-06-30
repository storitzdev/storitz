package com.storitz

class Role {

    static hasMany = [people: User]

	String authority
    /** description */
    String description

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
        description(blank:false)
	}
}
