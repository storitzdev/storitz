package storitz

import grails.test.*
import com.storitz.exrsclient.ExrsWebFormProcessor
import com.storitz.RentalTransaction
import com.storitz.StorageUnit
import com.storitz.StorageSite

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
//    void testExrsFormPost430() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (430)
//        boolean res = exrsWebFormProcessor.processMoveIn(trans)
//        assertFalse(res) // no longer available
//    }
//
//    void testExrsFormPost431() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (431)
//        boolean res = exrsWebFormProcessor.processMoveIn(trans)
//        assertFalse(res) // no longer available
//    }
//
//    void testExrsFormPost432() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (432)
//        boolean res = exrsWebFormProcessor.processMoveIn(trans)
//        assertFalse(res) // no longer available
//    }
//
//    void testExrsFormPost434() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (434)
//        boolean res = exrsWebFormProcessor.processMoveIn(trans)
//        assertFalse(res)  // no longer available
//    }
//
//    void testExrsFormPost437() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (437)
//        boolean res = exrsWebFormProcessor.processMoveIn(trans)
//        assertFalse(res)  // no longer available
//    }
//
//
//    void testExrsFormPost438() {
//        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor()
//        RentalTransaction trans = RentalTransaction.findById (438)
//        boolean res = exrsWebFormProcessor.processMoveIn(trans)
//        if (!res) {
//            sendEmail(exrsWebFormProcessor.logBuf)
//        }
//        assertTrue(res)
//    }

    def sendEmail(message) {
        EmailService es = new EmailService()
        def args = [to:"tech@storitz.com",from:"no-reply@storitz.com",subject:"EXRS Automatic Move-In Error Log",body:message]
        es.sendTextEmail (args)
    }

}
