package com.storitz

class QuikStorLocation {

    static belongsTo = [ quikStor: QuikStor]
  
    static constraints = {
      site(nullable:true)
    }

    String username
    String password
    String sitename
    StorageSite site
}
