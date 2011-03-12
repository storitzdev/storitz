package storitz

import com.storitz.StorageSite


class RefreshPromosJob {
  private static final boolean AUTOMATIC_FLUSH = true;
  private static final String DEFAULT_CHARSET = "utf8";

  def feedService
  def emailService

  static triggers = {
    cron name:'refreshPromos', cronExpression:"0 30 2 ? * 1"
  }

  def execute(context) {

    def buf = new ByteArrayOutputStream()
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(buf, DEFAULT_CHARSET), AUTOMATIC_FLUSH);

    def startTime = System.currentTimeMillis()
    if (context.mergedJobDataMap.get('from')) {
      writer.println "Called from ${context.mergedJobDataMap.get('from')}"
    }
    writer.println "----------------- Starting Promo refresh update... ----------------------------"
    StorageSite.findAll().each{ site ->
      try {
        feedService.refreshPromos(site, writer)
        site.save(flush: true)
      } catch (Exception e) {
        writer.println "Error processing site id=${site.id} Error: ${e} Stacktrace: ${e.stackTrace}"
      }
    }
    writer.println  "----------------- Completed in ${System.currentTimeMillis() - startTime} millis ----------------------------"

    String subject = "Refresh promos ${new Date().format('yyyy-MM-dd')}"

    writer.flush()
    writer.close()
    
    emailService.sendTextEmail(to: 'tech@storitz.com',
      from: 'no-reply@storitz.com',
      subject: subject,
      body: buf.toString())


  }
}
