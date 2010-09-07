package storitz

import com.storitz.StorageSite


class RefreshPromosJob {
  def feedService

  static triggers = {
    cron name:'refreshPromos', cronExpression:"0 30 2 ? * 1"
  }

  def execute(context) {
    def startTime = System.currentTimeMillis()
    if (context.mergedJobDataMap.get('from')) {
      println "Called from ${context.mergedJobDataMap.get('from')}"
    }
    println "----------------- Starting Promo refresh update... ----------------------------"
    StorageSite.findAll().each{ site ->
      feedService.refreshPromos(site)
    }
    println "----------------- Completed in ${System.currentTimeMillis() - startTime} millis ----------------------------"
  }
}
