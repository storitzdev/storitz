import grails.plugins.springsecurity.Secured
import com.storitz.User

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
class AdminController {

    def springSecurityService

    def index = {
      def username  = session["username"] = springSecurityService.principal.username
      session["user"] = User.findByUsername(username as String)
      
      println "Authenticated as: " + springSecurityService.principal.username
      
      [ title:'Admin Pages']
    }
}
