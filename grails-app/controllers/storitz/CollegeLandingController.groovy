package storitz

import com.storitz.CollegeLanding
import javax.servlet.http.*
import com.storitz.Insurance
import storitz.constants.SearchType
import com.storitz.UserRole
import com.storitz.User

class CollegeLandingController extends SearchController  {

    def fileUploadService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def listSites = {

        def isAdmin = false
        if (!springSecurityService.principal.equals('anonymousUser')) {
          def user = User.findByUsername(springSecurityService.principal.username as String)
          isAdmin = (user && UserRole.userHasRole(user, 'ROLE_ADMIN'))
        }

        // display storage sites near campus
        def title = null
        def college = null
        if (params.college && (college = findCollege(params.college))) {
            params.address = college.address
            title = "Find Summer Self Storage near ${college.displayName} - Best Price Guaranteed on Storitz"
        }

        def geoResult
        def address = params.address
        if (params.address.class.isArray()) {
            address = params.address.join(' ');
        }
        geoResult = geocodeService.geocode(address)
        handleGeocode(geoResult)

        if (!lat || !lng) {
            lat = 39.8333333
            lng = -98.5833333
        }

        def searchResult = findClientSites(SearchType.STORAGE, lat, lng, "college_special_2011")

        [college: college, title: title, lat: lat, lng: lng, sites: searchResult.sites, siteMoveInPrice: searchResult.moveInPrices, isAdmin: isAdmin]
    }

    def storageTips = {
        [title: 'Storage 101: College Summer Storage Tips for Students']
    }


    private CollegeLanding findCollege(String url) {
        ArrayList<CollegeLanding> colleges = CollegeLanding.findAll()

        // Say we have two colleges: UCLA and Duclan College
        // It is possible for people typeing storitz.com/college/duclan-college
        // to get redirected to the UCLA landing page because "duclan" contains
        // "UCLA" as part of it's name. To work-around that use case
        // we first check if the URL starts with the given college name.
        // In this case "storitz.com/college/XYZ-Duclan-College-Self-Storage" would
        // still redirect to the UCLA page, but "storitz.com/college/Duclan-College-Self-Storage"
        // would be a perfect match and redirect exactly where you expect it to.

        // Exact (starts with) Match
        for (int i = 0; i < colleges.size(); i++) {
            CollegeLanding landing = colleges.get(i)
            String cleanUrl = url.toLowerCase().replaceAll("-", " ")
            String cleanName = landing.name.toLowerCase().replaceAll("-", " ")
            if (cleanUrl.startsWith(cleanName)) {
                return landing
            }
        }

        // Glob (contains) Match
        for (int i = 0; i < colleges.size(); i++) {
            CollegeLanding landing = colleges.get(i)
            String cleanUrl = url.toLowerCase().replaceAll("-", " ")
            String cleanName = landing.name.toLowerCase().replaceAll("-", " ")
            if (cleanUrl.contains(cleanName)) {
                return landing
            }
        }
        return null
    }


    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [collegeLandingInstanceList: CollegeLanding.list(params), collegeLandingInstanceTotal: CollegeLanding.count()]
    }

    def create = {
        def collegeLandingInstance = new CollegeLanding()
        collegeLandingInstance.properties = params
        return [collegeLandingInstance: collegeLandingInstance]
    }

    def save = {
        def collegeLandingInstance = new CollegeLanding(params)
        if (collegeLandingInstance.save()) {
            handleImage(request,collegeLandingInstance)
            collegeLandingInstance.save(flush: true)
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'collegeLanding.label', default: 'CollegeLanding'), collegeLandingInstance.id])}"
            redirect(action: "show", id: collegeLandingInstance.id)
        }
        else {
            render(view: "create", model: [collegeLandingInstance: collegeLandingInstance])
        }
    }

    def show = {
        def collegeLandingInstance = CollegeLanding.get(params.id)
        if (!collegeLandingInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'collegeLanding.label', default: 'CollegeLanding'), params.id])}"
            redirect(action: "list")
        }
        else {
            [collegeLandingInstance: collegeLandingInstance]
        }
    }

    def edit = {
        def collegeLandingInstance = CollegeLanding.get(params.id)
        if (!collegeLandingInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'collegeLanding.label', default: 'CollegeLanding'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [collegeLandingInstance: collegeLandingInstance]
        }
    }

    def update = {
        def collegeLandingInstance = CollegeLanding.get(params.id)
        if (collegeLandingInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (collegeLandingInstance.version > version) {
                    
                    collegeLandingInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'collegeLanding.label', default: 'CollegeLanding')] as Object[], "Another user has updated this CollegeLanding while you were editing")
                    render(view: "edit", model: [collegeLandingInstance: collegeLandingInstance])
                    return
                }
            }
            collegeLandingInstance.properties = params
            if (!collegeLandingInstance.hasErrors() && collegeLandingInstance.save()) {
                handleImage(request,collegeLandingInstance)
                collegeLandingInstance.save(flush: true)
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'collegeLanding.label', default: 'CollegeLanding'), collegeLandingInstance.id])}"
                redirect(action: "show", id: collegeLandingInstance.id)
            }
            else {
                render(view: "edit", model: [collegeLandingInstance: collegeLandingInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'collegeLanding.label', default: 'CollegeLanding'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def collegeLandingInstance = CollegeLanding.get(params.id)
        if (collegeLandingInstance) {
            try {
                collegeLandingInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'collegeLanding.label', default: 'CollegeLanding'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'collegeLanding.label', default: 'CollegeLanding'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'collegeLanding.label', default: 'CollegeLanding'), params.id])}"
            redirect(action: "list")
        }
    }

    def handleImage(HttpServletRequest req, CollegeLanding college) {
        def logoFile = req.getFile('logoFile')
        if (logoFile.size > 0) {
            Integer collegeId = college.id
            def ext = '.' + logoFile.originalFilename.tokenize('.')[-1]
            def newName = "logo-${college.name.toLowerCase()}${ext}"
            fileUploadService.moveFile(logoFile,'/images/college', newName, collegeId)
            college.logoBaseName='/images/college' + fileUploadService.getWebIdPath(collegeId)
            college.logoFileLoc=newName
        }
    }
}
