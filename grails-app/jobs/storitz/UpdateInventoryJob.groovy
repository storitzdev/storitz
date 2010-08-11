package storitz

import com.storitz.StorageSite


class UpdateInventoryJob {

    def siteLinkService

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
        if (site.source == "SL") {
          def stats = new storitz.SiteStats()
          siteLinkService.updateUnits(site, stats)
          println "${site.title} refreshed ${stats.unitCount} units"
        }
        // TODO handle centershift
      }
      println "----------------- Complete ${System.currentTimeMillis() - startTime} millis ----------------------------"
    }
}
