package com.storitz

class StorageMart extends Feed {

    static constraints = {
      stmUser (nullable:true)
      stmPass (nullable:true)
      url (nullable:true)
    }

    String stmUser
    String stmPass
    String url
}
