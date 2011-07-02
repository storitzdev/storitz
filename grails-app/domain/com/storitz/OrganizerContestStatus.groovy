package com.storitz

class OrganizerContestStatus {

    static constraints = {
        enabled(nullable: true)
        active(nullable: true)
        toEmailAddress(nullable:true)
        videoId(nullable:true)
    }

    Boolean enabled
    Boolean active
    String toEmailAddress
    String videoId
}
