package com.storitz

import storitz.constants.CommissionType

class Commission {

    static constraints = {
    }

  CommissionType commissionType
  BigDecimal lowerBound
  BigDecimal upperBound
  BigDecimal amount

}
