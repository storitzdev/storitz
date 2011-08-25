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
import org.grails.mail.MailService
import org.hibernate.Session
import org.hibernate.Hibernate

class UpdateInventory {

    private static final boolean AUTOMATIC_FLUSH = true;
    private static final String DEFAULT_CHARSET = "utf8";

    private FeedService feedService;
    private MailService mailService;

    // Run from jobs (Tomcat context)
    public UpdateInventory(FeedService feedService1, MailService mailService1) {
        feedService = feedService1;
        mailService = mailService1;
    }

    // Run from scripts!  (Spring dependency injector fails from scripts)
    public UpdateInventory() {
        feedService = new FeedService();
        mailService = new MailService();
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

      // JM: Notice that here we filter out disabled sites...
      String sql;
      if (src) {
        sql = "SELECT id FROM storage_site WHERE source = '${src}' AND disabled = 0";
      } else {
        sql = "SELECT id FROM storage_site WHERE disabled = 0";
      }
      Session s = feedService.getSessionFactory().currentSession;
      allStorageSitesIds = s.createSQLQuery(sql).addScalar("ID", Hibernate.LONG).list()

        // TEST: shrink sample size for testing
        //if (allStorageSitesIds.size() > 3)  {
        //    allStorageSitesIds = allStorageSitesIds.subList(0,3)
        //}
        //println ("allStorageSitesIds=${allStorageSitesIds}")

        int batch_size = 50
        int i = 0;
        int num_errors = 0;
        println "Beginning inventory refresh for ${allStorageSitesIds.size()} sites"
        while (i < allStorageSitesIds.size()) {
            int lower_i = i
            int upper_i = i+batch_size-1 > allStorageSitesIds.size()-1 ? allStorageSitesIds.size()-1 : i+batch_size-1
            int lower_id = allStorageSitesIds[lower_i]
            int upper_id = allStorageSitesIds[upper_i]

            //println ("lower_i=${lower_i}, upper_i=${upper_i}")
            //println ("lower_id=${lower_id}, upper_id=${upper_id}")

            List<StorageSite> allStorageSites

            // JM: ... But notice here that we *don't* filter by disabled! I'd
            //     like to but GORM only gives us two fields by default, so to
            //     get around that I'd need to use a context, or closure, or
            //     some other method...
            if (src) {
                allStorageSites = StorageSite.findAllByIdBetweenAndSource(lower_id,upper_id,src)
            } else {
                allStorageSites = StorageSite.findAllByIdBetween(lower_id,upper_id)
            }
            //println ("allStorageSites.size()=${allStorageSites.size()}")
            //println ("allStorageSites=${allStorageSites}")

            //println ("START:${new Date().toString()}")
            for (StorageSite site: allStorageSites) {

                // JM: ... Here's the other method.
                if (site.disabled) continue

                try {
                    def stats = new storitz.SiteStats()
                    feedService.updateUnits(site, stats, writer)
                    writer.println "${site.title} refreshed ${stats.unitCount} units, deleted ${stats.removedCount} units"
                    println "${site.title} refreshed ${stats.unitCount} units, deleted ${stats.removedCount} units"
                } catch (Throwable t) {
                    ++num_errors
                    writer.println "Error processing site id=${site.id} Error: ${t} Stacktrace: ${t.stackTrace}"
                }
            }
            //println ("STOP:${new Date().toString()}")
            feedService.clearSession()
            i=upper_i+1;
            println "Completed ${upper_i} sites"
        }

      writer.println "----------------- Complete ${System.currentTimeMillis() - startTime} millis ----------------------------"

      String subj = "[${ConfigurationHolder.config.grails.serverURL}, ${src} (SITES:${allStorageSitesIds.size()}/ERRORS:${num_errors})] Inventory refresh ${new Date().format('yyyy-MM-dd')}"

      writer.flush()
      writer.close()

      //println("to: 'tech@storitz.com'")       // test
      //println("from: 'no-reply@storitz.com'") // test
      //println("subject: ${subject}")          // test
      //println(buf.toString())                 // test

      mailService.sendMail {
        to "tech@storitz.com"
        from "no-reply@storitz.com"
        subject subj
        body buf.toString()
      }
    }
}
