package storitz

import grails.test.*

class EDomicoTests extends GroovyTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {
        def accountNum = 123
        def password = "456"

        EDomicoService service = new EDomicoService()
        def token = service.readToken(accountNum,password)
        def site = service.readSiteID(accountNum,token,"123 Main St", "Culver City", "90232")
    }
}
