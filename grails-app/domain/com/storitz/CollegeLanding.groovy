package com.storitz

class CollegeLanding {

    String name
    String address
    String displayName
    String logoBaseName
    String logoFileLoc
    String primaryBGColor
    String primaryFGColor
    String secondaryBGColor
    String secondaryFGColor

    static constraints = {
        name(nullable:false)
        address(nullable:false)
        displayName(nullable:false)
        logoBaseName(nullable:false)
        logoFileLoc(nullable:false)
        primaryBGColor(nullable:false)
        primaryFGColor(nullable:false)
        secondaryBGColor(nullable:false)
        secondaryFGColor(nullable:false)
    }

    def logoSrc() {
        def loc = logoBaseName + logoFileLoc
        log.info loc
        return loc
    }
}
