package com.storitz

class StorageMart extends Feed {

    static constraints = {
      stmUser (nullable:false)
      stmPass (nullable:false)
    }

    String stmUser
    String stmPass
}
