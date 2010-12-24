package com.storitz

class QuikStor extends Feed {

    static hasMany = [locations:QuikStorLocation]

    static mapping = {
      locations cascade:"all,delete-orphan"
    }

    static constraints = {
    }
}
