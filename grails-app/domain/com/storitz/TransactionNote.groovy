package com.storitz

class TransactionNote {

    static belongsTo = RentalTransaction

    static constraints = {
      note(widget:'textarea', nullable:true, size:2..2000, markup:true)
    }

    String note
    String advisor
    Date entered
}
