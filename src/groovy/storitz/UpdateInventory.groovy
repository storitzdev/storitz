package storitz

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 3/18/11
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */

import com.storitz.StorageSite
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import com.storitz.StorageUnit

class UpdateInventory {

    private static final boolean AUTOMATIC_FLUSH = true;
    private static final String DEFAULT_CHARSET = "utf8";

    private FeedService feedService;
    private EmailService emailService;

    // Run from jobs (Tomcat context)
    public UpdateInventory(FeedService feedService1, EmailService emailService1) {
        feedService = feedService1;
        emailService = emailService1;
    }

    // Run from scripts!  (Spring dependency injector fails from scripts)
    public UpdateInventory() {
        feedService = new FeedService();
        emailService = new EmailService();
    }


    def execute(context) {

      def buf = new ByteArrayOutputStream()
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(buf, DEFAULT_CHARSET), AUTOMATIC_FLUSH);

      def startTime = System.currentTimeMillis()
      if (context.mergedJobDataMap.get('from')) {
        writer.println "Called from ${context.mergedJobDataMap.get('from')}"
      }
      writer.println  "----------------- Starting nightly update... ----------------------------"

      // If source is provided, then select by that. Otherwise just grab all
      def src = context.mergedJobDataMap.get('source')
      //def allStorageSites
      def allStorageSitesIds

      //println ("source is: ${src}")

      if (src) {
        allStorageSitesIds = StorageSite.findAllBySource(src).collect{ it.id }.sort()
      } else {
        allStorageSitesIds = StorageSite.findAll().collect{ it.id }.sort()
      }

        // TEST: shrink sample size for testing
        //if (allStorageSitesIds.size() > 3)  {
        //    allStorageSitesIds = allStorageSitesIds.subList(0,3)
        //}
        //println ("allStorageSitesIds=${allStorageSitesIds}")

        int batch_size = 50
        int i = 0;
        int num_errors = 0;
        while (i < allStorageSitesIds.size()) {
            int lower_i = i
            int upper_i = i+batch_size-1 > allStorageSitesIds.size()-1 ? allStorageSitesIds.size()-1 : i+batch_size-1
            int lower_id = allStorageSitesIds[lower_i]
            int upper_id = allStorageSitesIds[upper_i]

            //println ("lower_i=${lower_i}, upper_i=${upper_i}")
            //println ("lower_id=${lower_id}, upper_id=${upper_id}")
            List<StorageSite> allStorageSites
            if (src) {
                allStorageSites = StorageSite.findAllByIdBetweenAndSource(lower_id,upper_id,src)
            } else {
                allStorageSites = StorageSite.findAllByIdBetween(lower_id,upper_id)
            }
            //println ("allStorageSites.size()=${allStorageSites.size()}")
            //println ("allStorageSites=${allStorageSites}")

            //println ("START:${new Date().toString()}")
            for (StorageSite site: allStorageSites) {
                try {
                    def stats = new storitz.SiteStats()
                    feedService.updateUnits(site, stats, writer)
                    writer.println "${site.title} refreshed ${stats.unitCount} units, deleted ${stats.removedCount} units"
                } catch (Throwable t) {
                    ++num_errors
                    writer.println "Error processing site id=${site.id} Error: ${t} Stacktrace: ${t.stackTrace}"
                }
            }
            //println ("STOP:${new Date().toString()}")
            feedService.clearSession()
            i=upper_i+1;
        }

      writer.println "----------------- Complete ${System.currentTimeMillis() - startTime} millis ----------------------------"

      String subject = "[${grails.util.Environment.getCurrent()}, ${src} (SITES:${allStorageSitesIds.size()}/ERRORS:${num_errors})] Inventory refresh ${new Date().format('yyyy-MM-dd')}"

      writer.flush()
      writer.close()

      //println("to: 'tech@storitz.com'")       // test
      //println("from: 'no-reply@storitz.com'") // test
      //println("subject: ${subject}")          // test
      //println(buf.toString())                 // test

     emailService.sendTextEmail(to: 'tech@storitz.com',
       from: 'no-reply@storitz.com',
       subject: subject,
       body: buf.toString())

    }
}
