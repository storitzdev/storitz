package storitz

import com.storitz.ContactUs
import grails.plugins.springsecurity.Secured
import storitz.constants.SoftwareType

class ContactUsController {

  def mailService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST", operatorsignup: "POST"]

  def index = {
    redirect(action: "list", params: params)
  }

  @Secured(['ROLE_ADMIN'])
  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    [contactUsInstanceList: ContactUs.list(params), contactUsInstanceTotal: ContactUs.count()]
  }

  def create = {
    def contactUsInstance = new ContactUs()
    contactUsInstance.properties = params
    return [contactUsInstance: contactUsInstance]
  }

  def save = {
    def contactUsInstance = new ContactUs(params)

    contactUsInstance.entered = new Date()
    contactUsInstance.serviced = false

    if (contactUsInstance.validate() && contactUsInstance.save(flush: true)) {

      String subj = contactUsInstance.contactType.display
      String toField = contactUsInstance.contactType.email
      String message = contactUsInstance.message
      String fromField = contactUsInstance.userEmail

      try {
        mailService.sendMail {
                to        toField
                from      fromField
                subject   subj
                body      message
        }

      } catch (Exception e) {
        log.error("${e}", e)
      }

      render(view: "complete")
    }
    else {
      render(view: "create", model: [contactUsInstance: contactUsInstance])
    }
  }

  @Secured(['ROLE_ADMIN'])
  def show = {
    def contactUsInstance = ContactUs.get(params.id)
    if (!contactUsInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
      redirect(action: "list")
    }
    else {
      [contactUsInstance: contactUsInstance]
    }
  }

  @Secured(['ROLE_ADMIN'])
  def edit = {
    def contactUsInstance = ContactUs.get(params.id)
    if (!contactUsInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
      redirect(action: "list")
    }
    else {
      return [contactUsInstance: contactUsInstance]
    }
  }

  @Secured(['ROLE_ADMIN'])
  def update = {
    def contactUsInstance = ContactUs.get(params.id)
    if (contactUsInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (contactUsInstance.version > version) {

          contactUsInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'contactUs.label', default: 'ContactUs')] as Object[], "Another user has updated this ContactUs while you were editing")
          render(view: "edit", model: [contactUsInstance: contactUsInstance])
          return
        }
      }
      contactUsInstance.properties = params
      if (!contactUsInstance.hasErrors() && contactUsInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), contactUsInstance.id])}"
        redirect(action: "show", id: contactUsInstance.id)
      }
      else {
        render(view: "edit", model: [contactUsInstance: contactUsInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
      redirect(action: "list")
    }
  }

  @Secured(['ROLE_ADMIN'])
  def delete = {
    def contactUsInstance = ContactUs.get(params.id)
    if (contactUsInstance) {
      try {
        contactUsInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contactUs.label', default: 'ContactUs'), params.id])}"
      redirect(action: "list")
    }
  }

  def operatorSignup = {

    SoftwareType softwareType = SoftwareType.getEnumFromId(params.softwareType)

    String subj = "Add Your Facility Signup"
    String toField = "sales@storitz.com"
    String message = "New Customer via add your facility.\n\nFirst Name: ${params.firstName}\nLast Name: ${params.lastName}\nCompany: ${params.companyName}\nEmail: ${params.email}\nPhone: ${params.phone}\nSoftware: ${softwareType.display} ${params.otherSoftware ? params.otherSoftware : ''}"
    String fromField = "${params.email}"

    try {
      mailService.sendMail {
              to        toField
              from      fromField
              subject   subj
              body      message
      }
    } catch (Exception e) {
      log.error("${e}", e)
    }

    render(view: "operatorcomplete")
  }
}
