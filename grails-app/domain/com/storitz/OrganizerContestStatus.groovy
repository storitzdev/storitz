package com.storitz

class OrganizerContestStatus {

    static constraints = {
        enabled(nullable: true)
        active(nullable: true)
    }

    boolean enabled
    boolean active
}
