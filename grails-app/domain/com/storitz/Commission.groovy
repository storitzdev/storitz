package com.storitz

import storitz.constants.CommissionSourceType
import storitz.constants.CommissionType

class Commission {

  static belongsTo = CommissionSchedule

  static constraints = {
  }

  CommissionSourceType commissionSource
  CommissionType commissionType
  BigDecimal lowerBound
  BigDecimal upperBound
  BigDecimal amount

}
