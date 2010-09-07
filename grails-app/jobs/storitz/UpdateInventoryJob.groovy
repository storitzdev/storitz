package storitz

import com.storitz.StorageSite


class UpdateInventoryJob {

    def feedService
    def emailService

    static triggers = {
      cron name:'nightlyUpdate', cronExpression:"0 30 1 * * ?"
    }

    def execute(context) {

      def buf = new ByteArrayOutputStream()
      def newOut = new PrintStream(buf)
      def saveOut = System.out

      System.out  = newOut

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

      System.out = saveOut

      String subject = "Inventory refresh ${new Date().format('yyyy-MM-dd')}"

      emailService.sendTextEmail(to: 'tech@storitz.com',
        from: 'no-reply@storitz.com',
        subject: subject,
        body: buf.toString())
    }
}
