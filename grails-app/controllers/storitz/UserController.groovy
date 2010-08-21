package storitz

import com.storitz.Role
import com.storitz.User
import grails.plugins.springsecurity.Secured
import com.storitz.UserRole
import grails.converters.JSON

import com.storitz.SiteUser
import com.storitz.StorageSite
import com.storitz.UserNotificationType
import com.storitz.NotificationType

/**
 * User controller.
 */
@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
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
        def count = 0

        def user  = session["user"]

        if (params.username) {
          def query
          def criteria = User.createCriteria()

          count = criteria.get {
            projections {
                countDistinct("id")
            }
            and {
              like("username", params.username+ '%')
              if (!UserRole.userHasRole(user, 'ROLE_ADMIN')) {
                eq("manager", user)
              }
            }
          }

          query = {
            and {
              like("username", params.username+ '%')
              if (!UserRole.userHasRole(user, 'ROLE_ADMIN')) {
                eq("manager", user)
              }
            }
          }
          results = criteria.list(params, query)

        } else {
          if (UserRole.userHasRole(user, 'ROLE_ADMIN')) {
            results = User.list(params)
            count = User.count()
          } else {
            count = User.countByManager(user)
            results = User.findAllByManager(user, [max:params.max, sort:"username", order:"asc"])
          }
        }
		[personList: results, personListCount: count]
	}

  def autocompleteContact= {

    def user = session["user"]

    def results
    if (UserRole.userHasRole(user, 'ROLE_ADMIN')) {
      results = User.findAllByUsernameLike(params.term +'%', params).collect{it.username}
    } else {
      results = User.findAllByManagerAndUsernameLike(user, params.term + '%', [max:100, sort:"username", order:"asc"]).collect{it.username}
    }
    render (status: 200, contentType:"application/json", text: results as JSON )
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
        List notificationTypes = UserNotificationType.findAllByUser(person).collect{ it.notificationType }
        def siteNames = SiteUser.findAllByUser(person).collect{ it.site.title }.sort()
		[person: person, roleNames: roleNames, siteNames: siteNames, notificationTypes: notificationTypes]
	}

	/**
	 * Person delete action. Before removing an existing person,
	 * he should be removed from those authorities which he is involved.
	 */

	def delete = {

		def person = User.get(params.id)
        if (UserRole.userHasRole(session["user"], 'ROLE_ADMIN') || person.manager == session["user"]) {
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
        } else {
          flash.message = "No permission to delete user."
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
        flash.message = 'The old password is incorrect.'
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
            SiteUser.removeAll(person)
            addSites(person)
            addNotificationTypes(person)
			redirect action: show, id: person.id
		}
		else {
			render view: 'edit', model: buildPersonModel(person)
		}
	}

	def create = {
        def person = new User()
        person.properties = params
        def siteList = null
        def user = session["user"]
        if (!UserRole.userHasRole(user, 'ROLE_ADMIN')) {
          siteList = SiteUser.findAllByUser(user).collect{ it.site }
        }
        def notificationTypeList = NotificationType.list()
		[person: person, authorityList: Role.list(), siteList: siteList, notificationTypeList: notificationTypeList]
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
          addSites(person)
          addNotificationTypes(person)
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

    private void addSites(person) {
      for (String key in params.keySet()) {
        if (key.contains('SITE') && 'on' == params.get(key)) {
          def siteId = key.substring(5) as Long
          def site = StorageSite.get(siteId)
          SiteUser.link(site, person)
        }
      }
    }

    private void addNotificationTypes(person) {
      for (String key in params.keySet()) {
        if (key.contains('NOTIFICATION') && 'on' == params.get(key)) {
          def notificationType = NotificationType.findByNotificationType(key)
          UserNotificationType.create(person, notificationType, true)
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
        List sites = SiteUser.findAllByUser(session["user"]).collect{ it.site }
        List userSites = SiteUser.findAllByUser(person).collect{ it.site}
        def siteMap = [:] as Map  //map of site -> boolean
        for (site in sites) {
            siteMap[(site)] = userSites.contains(site)
        }
        def notificationMap = [:]
        def userNotifications = UserNotificationType.findAllByUser(person).collect{ it.notificationType }
        for (nt in NotificationType.findAll()) {
          notificationMap[(nt)] = userNotifications.contains(nt)
        }
		return [person: person, roleMap: roleMap, siteMap: siteMap, notificationMap: notificationMap]
	}
}

