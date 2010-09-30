package com.storitz

import storitz.constants.ReportOutputType

class ReportPeriod {

    Date startDate
    Date endDate
    ReportOutputType outputType
    StorageSite site

    static constraints = {
      startDate(blank:false)
      endDate(blank:false)
      site(nullable:true)
    }
}
