package storitz

import com.storitz.CollegeLanding
import javax.servlet.http.*

class CollegeLandingController {

    def fileUploadService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

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
