package storitz

import grails.plugins.springsecurity.Secured
import grails.util.Environment

@Secured(['ROLE_ADMIN', 'ROLE_CALLCENTER'])
class StopController {

    // Can't seem to use ctrl-c in IntelliJ.
    // Want to use normal shutdown to flush caches when using file db.
    def index = {
      if (Environment.DEVELOPMENT.is(Environment.current)) {
        println "Stopping..."
        System.exit(1)
      } else {
        println "Not in DEVELOPMENT environment!"
      }
      [:]
    }
}
