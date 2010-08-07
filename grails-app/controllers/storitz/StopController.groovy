package storitz

import grails.util.Environment
import grails.plugins.springsecurity.Secured

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
