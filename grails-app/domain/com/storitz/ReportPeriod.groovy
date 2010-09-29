package com.storitz

import storitz.constants.ReportOutputType

class ReportPeriod {

    Date startDate
    Date endDate
    ReportOutputType outputType

    static constraints = {
      startDate(blank:false)
      endDate(blank:false)
    }
}
