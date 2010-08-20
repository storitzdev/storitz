package storitz

import com.storitz.StorageSite


class UpdateInventoryJob {

    def feedService

    static triggers = {
      cron name:'nightlyUpdate', cronExpression:"0 30 1 * * ?"
    }

    def execute(context) {
      def startTime = System.currentTimeMillis()
      if (context.mergedJobDataMap.get('from')) {
        println "Called from ${context.mergedJobDataMap.get('from')}"
      }
      println "----------------- Starting nightly update... ----------------------------"
      StorageSite.findAll().each{ site ->
        def stats = new storitz.SiteStats()
        feedService.updateUnits(site, stats)
        println "${site.title} refreshed ${stats.unitCount} units, deleted ${stats.removedCount} units"
      }
      println "----------------- Complete ${System.currentTimeMillis() - startTime} millis ----------------------------"
    }
}
