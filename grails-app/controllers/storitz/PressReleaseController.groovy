package storitz

import grails.plugins.springsecurity.Secured
import com.storitz.PressRelease

class PressReleaseController {

    def fileUploadService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    @Secured(['ROLE_ADMIN'])
    def index = {
        redirect(action: "list", params: params)
    }

    @Secured(['ROLE_ADMIN'])
    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        params.sort = 'releaseDate'
        params.order = 'desc'
        [pressReleaseInstanceList: PressRelease.list(params), pressReleaseInstanceTotal: PressRelease.count()]
    }

    def pressRoom = {
        [pressReleaseInstanceList: PressRelease.list(sort:'releaseDate', order:'desc'), pressReleaseInstanceTotal: PressRelease.count()]
    }

    def release = {
        def pressReleaseInstance = PressRelease.get(params.id)
        if (!pressReleaseInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), params.id])}"
            redirect(action: "pressRoom")
        }
        else {
            [pressReleaseInstance: pressReleaseInstance]
        }
    }

    @Secured(['ROLE_ADMIN'])
    def create = {
        def pressReleaseInstance = new PressRelease()
        pressReleaseInstance.properties = params
        return [pressReleaseInstance: pressReleaseInstance]
    }

    @Secured(['ROLE_ADMIN'])
    def save = {
        def pressReleaseInstance = new PressRelease(params)
        def pdfFile = request.getFile("pdfFile_0")
        if (pdfFile.size > 0 ) {
          pressReleaseInstance.pdfLocation = '/pdfs/pressReleases/' + pdfFile.originalFilename
          def destFile = new File(request.getRealPath(pressReleaseInstance.pdfLocation))
          pdfFile.transferTo(destFile)
        } else {
          flash.message = "Missing PDF file"
          render(view: "create", model: [pressReleaseInstance: pressReleaseInstance])
          return
        }
        if (pressReleaseInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), pressReleaseInstance.id])}"
            redirect(action: "show", id: pressReleaseInstance.id)
        }
        else {
            render(view: "create", model: [pressReleaseInstance: pressReleaseInstance])
        }
    }

    @Secured(['ROLE_ADMIN'])
    def show = {
        def pressReleaseInstance = PressRelease.get(params.id)
        if (!pressReleaseInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), params.id])}"
            redirect(action: "list")
        }
        else {
            [pressReleaseInstance: pressReleaseInstance]
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit = {
        def pressReleaseInstance = PressRelease.get(params.id)
        if (!pressReleaseInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [pressReleaseInstance: pressReleaseInstance]
        }
    }

    @Secured(['ROLE_ADMIN'])
    def update = {
        def pressReleaseInstance = PressRelease.get(params.id)
        if (pressReleaseInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (pressReleaseInstance.version > version) {
                    
                    pressReleaseInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'pressRelease.label', default: 'PressRelease')] as Object[], "Another user has updated this PressRelease while you were editing")
                    render(view: "edit", model: [pressReleaseInstance: pressReleaseInstance])
                    return
                }
            }
            pressReleaseInstance.properties = params
            def pdfFile = request.getFile("pdfFile_0")
            if (pdfFile.size > 0 ) {
              File oldPdfFile = request.getRealPath(pressReleaseInstance.pdfLocation)
              oldPdfFile.delete()
              pressReleaseInstance.pdfLocation = '/pdfs/pressReleases/' + pdfFile.originalFilename
              def destFile = request.getRealPath(pressReleaseInstance.pdfLocation)
              pdfFile.transferTo(destFile)
            }
            if (!pressReleaseInstance.hasErrors() && pressReleaseInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), pressReleaseInstance.id])}"
                redirect(action: "show", id: pressReleaseInstance.id)
            }
            else {
                render(view: "edit", model: [pressReleaseInstance: pressReleaseInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), params.id])}"
            redirect(action: "list")
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete = {
        def pressReleaseInstance = PressRelease.get(params.id)
        if (pressReleaseInstance) {
            try {
                File pdfFile = request.getRealPath(pressReleaseInstance.pdfLocation)
                pdfFile.delete()
                pressReleaseInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pressRelease.label', default: 'PressRelease'), params.id])}"
            redirect(action: "list")
        }
    }
}
