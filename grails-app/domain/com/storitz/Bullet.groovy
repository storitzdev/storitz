package com.storitz

class Bullet {

    String bullet

    static constraints = {
      bullet(nullable:false, size:2..100)    
    }
}
