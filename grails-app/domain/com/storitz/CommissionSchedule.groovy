package com.storitz

class CommissionSchedule {

    static hasMany = [entries:Commission]

    static constraints = {
    }

    static mapping = {
        entries cascade:"all,delete-orphan"
    }

    String scheduleName
}
