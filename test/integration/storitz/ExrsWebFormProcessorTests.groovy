package storitz

import grails.test.*
import com.storitz.exrsclient.ExrsWebFormProcessor
import com.storitz.RentalTransaction
import com.storitz.StorageUnit
import com.storitz.StorageSite
import org.grails.mail.MailService

class ExrsWebFormProcessorTests extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testLogin1() {
        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
        assertTrue(exrsWebFormProcessor.testLogin1())
    }

    void testLogin2() {
        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
        assertTrue(exrsWebFormProcessor.testLogin2())
    }

    //these tests are perishable due to the nature of the inventory in question.
//    void testExrsFormPost507() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (507)
//        def res = exrsWebFormProcessor.processMoveIn(trans)
//        sendEmail(exrsWebFormProcessor.logBuf)
//        assertTrue(res)
//    }
//
//    void testExrsFormPost526() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (526)
//        def res = exrsWebFormProcessor.processMoveIn(trans)
//        sendEmail(exrsWebFormProcessor.logBuf)
//        assertTrue(res)
//    }
//
//    void testExrsFormPost528() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (528)
//        def res = exrsWebFormProcessor.processMoveIn(trans)
//        sendEmail(exrsWebFormProcessor.logBuf)
//        assertTrue(res)
//    }
//
//    void testExrsFormPost539() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (539)
//        def res = exrsWebFormProcessor.processMoveIn(trans)
//        sendEmail(exrsWebFormProcessor.logBuf)
//        assertTrue(res)
//    }
//
//    void testExrsFormPost543() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (543)
//        def res = exrsWebFormProcessor.processMoveIn(trans)
//        sendEmail(exrsWebFormProcessor.logBuf)
//        assertTrue(res)
//    }
//
//    void testExrsFormPost544() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (544)
//        def res = exrsWebFormProcessor.processMoveIn(trans)
//        sendEmail(exrsWebFormProcessor.logBuf)
//        assertTrue(res)
//    }
//
//    void testExrsFormPost546() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (546)
//        def res = exrsWebFormProcessor.processMoveIn(trans)
//        sendEmail(exrsWebFormProcessor.logBuf)
//        assertTrue(res)
//    }

    def sendEmail(message) {
        MailService ms = new MailService()
        ms.sendMail {
            to          "tech@storitz.com"
            from        "no-reply@storitz.com"
            subject     "EXRS Integration Test - IGNORE"
            body        message
        }
    }

}
