package storitz

import com.storitz.RentalAgreement
import grails.plugins.springsecurity.Secured
import com.storitz.UserRole
import com.storitz.User

@Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
class RentalAgreementController {

    def fileUploadService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
      def user = session["user"]

      params.max = Math.min(params.max ? params.int('max') : 10, 100)

      def results
      def count = 0

      if (UserRole.userHasRole(user, 'ROLE_ADMIN')) {
        results = RentalAgreement.listOrderByTitle(params)
        count = RentalAgreement.count()
      } else {
        results = RentalAgreement.findAllByOwner(user)
        count = RentalAgreement.countByOwner(user)
      }
      [rentalAgreementInstanceList: results, rentalAgreementInstanceTotal: count]
    }

    def create = {
        def rentalAgreementInstance = new RentalAgreement()
        rentalAgreementInstance.properties = params
        return [rentalAgreementInstance: rentalAgreementInstance]
    }

    def save = {
        def rentalAgreementInstance = new RentalAgreement(params)

        if (params?.manager?.id) {

          def user = params.manager.id != 'null' ? User.get(params.manager.id as Long) : null

          if (user) {
            rentalAgreementInstance.owner = user
          } else {
            flash.message = "Unable to assign owner to selected user"
            render(view: "create", model: [rentalAgreementInstance: rentalAgreementInstance])
            return
          }
        } else {
          rentalAgreementInstance.owner = session["user"]
        }
        def userId = rentalAgreementInstance.owner.id
        def pdfFile = request.getFile("pdfFile_0")
        if (pdfFile.size > 0 && fileUploadService.moveFile(pdfFile, '/pdfs/agreements', pdfFile.originalFilename, userId)) {
          rentalAgreementInstance.fileLocation = pdfFile.originalFilename
          rentalAgreementInstance.basename = '/pdfs/agreements' + fileUploadService.getWebIdPath(userId)
        } else {
          flash.message = "Missing PDF file"
          render(view: "create", model: [rentalAgreementInstance: rentalAgreementInstance])
          return
        }
        if (rentalAgreementInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'rentalAgreement.label', default: 'RentalAgreement'), rentalAgreementInstance.id])}"
            redirect(action: "show", id: rentalAgreementInstance.id)
        }
        else {
            render(view: "create", model: [rentalAgreementInstance: rentalAgreementInstance])
        }
    }

    def show = {
        def rentalAgreementInstance = RentalAgreement.get(params.id)
        if (!rentalAgreementInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalAgreement.label', default: 'RentalAgreement'), params.id])}"
            redirect(action: "list")
        }
        else {
            [rentalAgreementInstance: rentalAgreementInstance]
        }
    }

    def edit = {
        def rentalAgreementInstance = RentalAgreement.get(params.id)
        if (!rentalAgreementInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalAgreement.label', default: 'RentalAgreement'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [rentalAgreementInstance: rentalAgreementInstance]
        }
    }

    def update = {
        def rentalAgreementInstance = RentalAgreement.get(params.id)
        if (rentalAgreementInstance) {
          if (params.version) {
              def version = params.version.toLong()
              if (rentalAgreementInstance.version > version) {

                  rentalAgreementInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'rentalAgreement.label', default: 'RentalAgreement')] as Object[], "Another user has updated this RentalAgreement while you were editing")
                  render(view: "edit", model: [rentalAgreementInstance: rentalAgreementInstance])
                  return
              }
          }
          rentalAgreementInstance.properties = params
          if (params.manager.id) {

            def user = params.manager.id != 'null' ? User.get(params.manager.id as Long) : null

            if (user) {
              rentalAgreementInstance.owner = user
            } else {
              flash.message = "Unable to assign owner to selected user"
              render(view: "edit", model: [rentalAgreementInstance: rentalAgreementInstance])
              return
            }
          } else {
            rentalAgreementInstance.owner = session["user"]
          }
          if (!rentalAgreementInstance.hasErrors() && rentalAgreementInstance.save(flush: true)) {
              flash.message = "${message(code: 'default.updated.message', args: [message(code: 'rentalAgreement.label', default: 'RentalAgreement'), rentalAgreementInstance.id])}"
              redirect(action: "show", id: rentalAgreementInstance.id)
          }
          else {
              render(view: "edit", model: [rentalAgreementInstance: rentalAgreementInstance])
          }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalAgreement.label', default: 'RentalAgreement'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def rentalAgreementInstance = RentalAgreement.get(params.id)
        if (rentalAgreementInstance) {

          def file = new File(fileUploadService.getFilePath('/pdfs/agreements', rentalAgreementInstance.fileLocation, rentalAgreementInstance.owner.id))
          file.delete()
          try {
              rentalAgreementInstance.delete(flush: true)
              flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'rentalAgreement.label', default: 'RentalAgreement'), params.id])}"
              redirect(action: "list")
          }
          catch (org.springframework.dao.DataIntegrityViolationException e) {
              flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'rentalAgreement.label', default: 'RentalAgreement'), params.id])}"
              redirect(action: "show", id: params.id)
          }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalAgreement.label', default: 'RentalAgreement'), params.id])}"
            redirect(action: "list")
        }
    }
}
