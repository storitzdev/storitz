package storitz

import com.storitz.StorageMart

class StorageMartTests extends GroovyTestCase {

  protected void setUp() {
      super.setUp()
  }

  protected void tearDown() {
      super.tearDown()
  }

  void testSomething() {

  }

  void testLoadFacilities() {
    def service
    def all = StorageMart.findAll()
    if (all && all.size() > 0) {
      def one = all[0]
      println "username: ${one.stmUser}, password: ${one.stmPass}"
      service = new StorageMartStorageFeedService(one.stmUser,one.stmPass,one.url)
      service.loadFacilities();
    }
    assertTrue(service != null)
  }
}
