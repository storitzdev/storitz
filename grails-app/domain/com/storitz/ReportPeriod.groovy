package com.storitz

import storitz.constants.ReportOutputType
import storitz.constants.ReportName

class ReportPeriod {

    Date startDate
    Date endDate
    ReportOutputType outputType
    ReportName reportName
    StorageSite site

    static constraints = {
      startDate(blank:false)
      endDate(blank:false)
      site(nullable:true)
    }
}
