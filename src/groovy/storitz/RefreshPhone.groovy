package storitz

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 3/29/11
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */

import com.storitz.StorageSite
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.grails.mail.MailService

class RefreshPhone {
    private static final boolean AUTOMATIC_FLUSH = true;
    private static final String DEFAULT_CHARSET = "utf8";

    private FeedService feedService
    private MailService mailService

    // Run from jobs (Tomcat context)
    public RefreshPhone(FeedService feedService1, MailService mailService1) {
        feedService = feedService1;
        mailService = mailService1;
    }

    // Run from scripts!  (Spring dependency injector fails from scripts)
    public RefreshPhone()
    {
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
        writer.println "----------------- Starting Phone refresh update... ----------------------------"

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
            feedService.refreshPhones(site, writer)
            site.save(flush: true)
        }
        writer.println "----------------- Completed in ${System.currentTimeMillis() - startTime} millis ----------------------------"

        String subj = "[${ConfigurationHolder.config.grails.serverURL}] Refresh phones ${new Date().format('yyyy-MM-dd')}"

        writer.flush()
        writer.close()

        //println("to: 'tech@storitz.com'")       // test
        //println("from: 'no-reply@storitz.com'") // test
        //println("subject: ${subject}")          // test
        //println(buf.toString())                 // test

        mailService.sendMail {
              to        'tech@storitz.com'
              from      'no-reply@storitz.com'
              subject   subj.toString()
              body      buf.toString()
        }

    }

}
