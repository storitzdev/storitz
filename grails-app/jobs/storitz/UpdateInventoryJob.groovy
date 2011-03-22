package storitz

import com.storitz.StorageSite

class UpdateInventoryJob {
  private static final boolean AUTOMATIC_FLUSH = true;
  private static final String DEFAULT_CHARSET = "utf8";

  def feedService
  def emailService

  static triggers = {
    cron name: 'nightlyUpdate', cronExpression: "0 30 1 * * ?"
  }

  def execute(context) {

    def buf = new ByteArrayOutputStream()
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(buf, DEFAULT_CHARSET), AUTOMATIC_FLUSH);

    def startTime = System.currentTimeMillis()
    if (context.mergedJobDataMap.get('from')) {
      writer.println "Called from ${context.mergedJobDataMap.get('from')}"
    }
    writer.println "----------------- Starting nightly update... ----------------------------"
    StorageSite.findAll().each { site ->
      try {
        def stats = new storitz.SiteStats()
        feedService.updateUnits(site, stats, writer)
        writer.println "${site.title} refreshed ${stats.unitCount} units, deleted ${stats.removedCount} units"
      } catch (Exception e) {
        writer.println "Error processing site id=${site.id} Error: ${e} Stacktrace: ${e.stackTrace}"
      }
    }
    writer.println "----------------- Complete ${System.currentTimeMillis() - startTime} millis ----------------------------"

    String subject = "Inventory refresh ${new Date().format('yyyy-MM-dd')}"

    writer.flush()
    writer.close()

    emailService.sendTextEmail(to: 'tech@storitz.com',
            from: 'no-reply@storitz.com',
            subject: subject,
            body: buf.toString())

  }
}
