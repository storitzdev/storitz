import org.codehaus.groovy.grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
class AdminController {

    def authenticateService

    def index = {
      def username = session["username"] = authenticateService.principal().username
      session["user"] = User.findByUsername(username)
      
      println "Authenticated as: " + authenticateService.principal().username
      
      [ title:'Admin Pages']
    }
}
