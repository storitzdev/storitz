package com.storitz

import storitz.constants.CommissionType
import storitz.constants.CommissionSourceType

class Commission {

    static constraints = {
    }

  CommissionSourceType commissionSource
  CommissionType commissionType
  BigDecimal lowerBound
  BigDecimal upperBound
  BigDecimal amount

}
