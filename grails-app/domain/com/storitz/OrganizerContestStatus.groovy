package com.storitz

class OrganizerContestStatus {

    static constraints = {
        enabled(nullable: true)
        active(nullable: true)
        toEmailAddress(nullable:true)
    }

    boolean enabled
    boolean active
    String toEmailAddress
}
