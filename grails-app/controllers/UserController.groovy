import com.storitz.Role
import com.storitz.User
import grails.plugins.springsecurity.Secured
import com.storitz.UserRole
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

/**
 * User controller.
 */
@Secured(['ROLE_ADMIN'])
class UserController {

	def springSecurityService
    def webUtilService

	// the delete, save and update actions only accept POST requests
	static Map allowedMethods = [delete: 'POST', save: 'POST', update: 'POST']

	def index = {
		redirect action: list, params: params
	}

    def managers = {
      webUtilService.nocache(response)
      render(status: 200, contentType:"application/json", text:"${url.text}")

    }

	def list = {
      
        flash.username = params.username

		if (!params.max) {
			params.max = 10
		}

        def results

        if (params.username) {
          def query
          def criteria = User.createCriteria()

          query = {
            and {
              like("username", params.username+ '%')
            }
          }
          results = criteria.list(params, query)
        } else {
          results = User.list(params)
        }
		[personList: results]
	}

    @Secured(['ROLE_ADMIN','ROLE_MANAGER','ROLE_USER'])
	def show = {
		def person = User.get(params.id)
		if (!person) {
			flash.message = "User not found with id $params.id"
			redirect action: list
			return
		}
		List roleNames = []
		for (role in person.authorities) {
			roleNames << role.authority
		}
		roleNames.sort { n1, n2 ->
			n1 <=> n2
		}
		[person: person, roleNames: roleNames]
	}

	/**
	 * Person delete action. Before removing an existing person,
	 * he should be removed from those authorities which he is involved.
	 */

	def delete = {

		def person = User.get(params.id)
		if (person) {
			def authPrincipal = springSecurityService.principal()
			//avoid self-delete if the logged-in user is an admin
			if (!(authPrincipal instanceof String) && authPrincipal.username == person.username) {
				flash.message = "You can not delete yourself, please login as another admin and try again"
			}
			else {
				//first, delete this person from People_Authorities table.
                UserRole.removeAll(person)
                person.delete()
				flash.message = "User $params.id deleted."
			}
		}
		else {
			flash.message = "User not found with id $params.id"
		}

		redirect action: list
	}

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER'])
	def edit = {

		def person = User.get(params.id)
		if (!person) {
			flash.message = "User not found with id $params.id"
			redirect action: list
			return
		}

		return buildPersonModel(person)
	}

    def password = {
      render view: 'changePassword'    
    }

    def changePassword = {

      
      def person = User.findByUsername(springSecurityService.principal.username)
      if (!person) {
          flash.message = "User not found with id $params.id"
          redirect action: changePassword
          return
      }

      def encOldPassword = springSecurityService.encodePassword(params.oldPasswd)
      if (!person.password.equals(encOldPassword)) {
        flash.message = 'The old password incorrect.'
        render view: 'changePassword'
        return
      }
      if (!params.passwd.equals(params.repasswd)) {
        flash.message = 'The passwords you entered do not match.'
        render view: 'changePassword'
        return          
      }
      person.password = springSecurityService.encodePassword(params.passwd)
      person.save(flush:true)

      if (springSecurityService.loggedIn &&
               springSecurityService.principal.username == person.username) {
         springSecurityService.reauthenticate person.username
      }
      flash.message = 'Your password was successfully changed.'
      redirect (controller: 'admin', action: 'index')
    }

	/**
	 * Person update action.
	 */
	def update = {

		def person = User.get(params.id)
		if (!person) {
			flash.message = "User not found with id $params.id"
			redirect action: edit, id: params.id
			return
		}

		long version = params.version.toLong()
		if (person.version > version) {
			person.errors.rejectValue 'version', "person.optimistic.locking.failure",
				"Another user has updated this User while you were editing."
				render view: 'edit', model: buildPersonModel(person)
			return
		}

		def oldPassword = person.password
		person.properties = params
		if (!params.passwd.equals(oldPassword)) {
            if (!params.passwd.equals(params.repasswd)) {
               flash.message = 'The passwords you entered do not match.'
               render view: 'edit', model: buildPersonModel(person)
            }
			person.password = springSecurityService.encodePassword(params.passwd)
		}
		if (person.save()) {
			UserRole.removeAll(person)
			addRoles(person)
			redirect action: show, id: person.id
		}
		else {
			render view: 'edit', model: buildPersonModel(person)
		}
	}

	def create = {
        def person = new User()
        person.properties = params
		[person: person, authorityList: Role.list()]
	}

	/**
	 * Person save action.
	 */
	def save = {

      def person = new User()
      person.properties = params

      def roleCount = params.findAll{ it.key.contains('ROLE') }.size()
      if (roleCount == 0) {
          person.password = ''
          flash.message = 'Default Role not found.'
          render view: 'create', model: [person: person, authorityList: Role.list() ]
          return
      }

      if (params.passwd != params.repasswd) {
          person.password = ''
          flash.message = 'The passwords you entered do not match.'
          render view: 'create', model: [person: person, authorityList: Role.list() ]
          return
      }

      def pass = springSecurityService.encodePassword(params.passwd)
      person.password = pass
      person.enabled = true
      if (person.save()) {
          addRoles(person)
          // TODO - send email to new user

          person.save(flush: true)
          redirect action: show, id: person.id

      } else {
          person.password = ''
          render view: 'create', model: [authorityList: Role.list(), person: person]
      }
	}

	private void addRoles(person) {
		for (String key in params.keySet()) {
			if (key.contains('ROLE') && 'on' == params.get(key)) {
				def role = Role.findByAuthority(key)
                if (role) UserRole.create(person, role, true)
			}
		}
	}

	private Map buildPersonModel(person) {

		List roles = Role.list()
		roles.sort { r1, r2 ->
			r1.authority <=> r2.authority
		}
		def userRoleNames = new HashSet([]) as Set
		for (role in person.authorities) {
			userRoleNames << role.authority
		}
		def roleMap = [:] as Map  //map of Role -> boolean
		for (role in roles) {
			roleMap[(role)] = userRoleNames.contains(role.authority)
		}
      
		return [person: person, roleMap: roleMap]
	}
}

