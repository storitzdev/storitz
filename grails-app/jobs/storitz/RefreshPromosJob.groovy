package storitz

import com.storitz.StorageSite


class RefreshPromosJob {

  def feedService
  def emailService

  static triggers = {
    cron name:'refreshPromos', cronExpression:"0 30 2 ? * 1"
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
    println "----------------- Starting Promo refresh update... ----------------------------"
    StorageSite.findAll().each{ site ->
      feedService.refreshPromos(site)
    }
    println "----------------- Completed in ${System.currentTimeMillis() - startTime} millis ----------------------------"

    System.out = saveOut

    String subject = "Refresh promos ${new Date().format('yyyy-MM-dd')}"

    emailService.sendTextEmail(to: 'tech@storitz.com',
      from: 'no-reply@storitz.com',
      subject: subject,
      body: buf.toString())

  }
}
