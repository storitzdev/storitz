package com.storitz

import storitz.constants.SearchType

class StorageSize {

    static constraints = {
      height(nullable:true)
    }

    String description
    BigDecimal width
    BigDecimal length
    BigDecimal height

    SearchType searchType
}
