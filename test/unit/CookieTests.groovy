import grails.test.GrailsUnitTestCase
import storitz.CookieCodec

class CookieTests extends GrailsUnitTestCase {
  protected void setUp() {
    super.setUp()
  }

  protected void tearDown() {
    super.tearDown()
  }

  void testCookieCodec() {
    Map m = [abc: 'lkjsdf*&^h43JHGdjmghdfs228\'"kjfd[]{}', HELLO: 98743, xyz123: new Date()]
    String s = CookieCodec.encodeCookieValue(m)
    println s
    Map r = CookieCodec.decodeCookieValue(s)
    m.each {
      k, v -> assert r[k] == v as String
    }
//     assertEquals(r, m)
  }

}
