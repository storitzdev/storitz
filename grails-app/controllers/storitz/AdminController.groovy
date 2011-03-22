package storitz

import com.storitz.User
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER', 'ROLE_CALLCENTER'])
class AdminController {

  def springSecurityService

  def index = {
    def username = session["username"] = springSecurityService.principal.username
    session["user"] = User.findByUsername(username as String)

    println "Authenticated as: " + springSecurityService.principal.username

    [title: 'Admin Pages']
  }

}

