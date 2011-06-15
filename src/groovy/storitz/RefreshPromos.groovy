package storitz

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 3/29/11
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */

import com.storitz.StorageSite
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class RefreshPromos {

    private static final boolean AUTOMATIC_FLUSH = true;
    private static final String DEFAULT_CHARSET = "utf8";

    private FeedService feedService
    private EmailService emailService

    // Run from jobs (Tomcat context)
    public RefreshPromos(FeedService feedService1, EmailService emailService1) {
        feedService = feedService1;
        emailService = emailService1;
    }

    // Run from scripts!  (Spring dependency injector fails from scripts)
    public RefreshPromos()
    {
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
        writer.println "----------------- Starting Promo refresh update... ----------------------------"

        def src = context.mergedJobDataMap.get('source')
        def allStorageSites

        println ("source is: ${src}")

        if (!src) {
            allStorageSites = StorageSite.findAll()
        } else {
            allStorageSites = StorageSite.findAllBySource (src)
        }

        // TEST: shrink sample size for testing
        //if (allStorageSites.size() > 25)  {
        //  allStorageSites = allStorageSites.subList(0,25)
        //}
        //println("allStorageSites = ${allStorageSites}")

        allStorageSites.each { site ->
            try {
                feedService.refreshPromos(site, writer)
                site.save(flush: true)
            } catch (Exception e) {
                writer.println "Error processing site id=${site.id} Error: ${e} Stacktrace: ${e.stackTrace}"
            }
        }
        writer.println "----------------- Completed in ${System.currentTimeMillis() - startTime} millis ----------------------------"

        String subject = "[${grails.util.Environment.getCurrent()}] Inventory promos ${new Date().format('yyyy-MM-dd')}"

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
