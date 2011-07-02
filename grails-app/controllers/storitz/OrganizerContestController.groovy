package storitz

import com.storitz.OrganizerContest
import com.storitz.OrganizerContestStatus

class OrganizerContestController {

    def active
    def enabled
    def emailService
    def toEmailAddress
    def videoId
    def id

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        active=OrganizerContestController.isActive()
        enabled=OrganizerContestController.isEnabled()
        toEmailAddress=OrganizerContestController.getToEmailAddress()
        [organizerContestInstanceList: OrganizerContest.list(params), organizerContestInstanceTotal: OrganizerContest.count(), active: active, enabled: enabled, toEmailAddress : toEmailAddress]
    }

    def create = {
        if (params.zip && !com.storitz.StoritzUtil.isCaliforniaZip(params.zip)) {
          redirect(controller: "home", action:"index")
        }

        if (!OrganizerContestController.isEnabled()) {
           redirect(controller: "home", action:"index")
        }

        if (!OrganizerContestController.isActive()) {
            flash.closed = "true"
        }

        // These two lines are for testing only.
        //flash.saved = "true"                  // Simulate saving a record
        //flash.message = "some error occurred" // Simulate an error
        //flash.update = "yes"                  // send to page 2
        videoId = OrganizerContestController.getVideoId()
        OrganizerContest organizerContestInstance = new OrganizerContest()
        organizerContestInstance.properties = params
        return [title: "Storitz Organizer Contest with Justin Klosky", organizerContestInstance : organizerContestInstance, videoId : videoId]
    }

    def addEntry = {
        def organizerContestInstance = new OrganizerContest(params)
        try {
            if (organizerContestInstance.save(flush: true)) {
                sendEmail(organizerContestInstance)
                flash.message = "${message(code: 'default.created.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), organizerContestInstance.id])}"
                flash.saved = "saved"
//                flash.update = "yes"
                flash.id = organizerContestInstance.id // workaround for hsqlDB
                redirect(action: "create")
            }
            else {
                flash.message = "Failed to save entry. Please try again."
                render(view: "create", model: [title: "Storitz Organizer Contest with Justin Klosky", organizerContestInstance: organizerContestInstance])
            }
        } catch (Throwable t) {
            // TODO: Clean up.
            flash.message = "Failed to save entry. Please try again."
            render(view: "create", model: [title: "Storitz Organizer Contest with Justin Klosky", organizerContestInstance: organizerContestInstance])
        }
    }

    def updateEntry = {
      def organizerContestInstance = OrganizerContest.findById(params.id)
      organizerContestInstance.properties = params
      try {
          if (organizerContestInstance.save(flush: true)) {
              sendEmail(organizerContestInstance)
              flash.message = "${message(code: 'default.created.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), organizerContestInstance.id])}"
              flash.saved = "saved"
              flash.id = organizerContestInstance.id // workaround for hsqlDB
              redirect(action: "create")
          }
          else {
              flash.message = "Failed to save entry. Please try again."
              render(view: "create", model: [title: "Storitz Organizer Contest with Justin Klosky", organizerContestInstance: organizerContestInstance])
          }
      } catch (Throwable t) {
          // TODO: Clean up.
          flash.message = "Failed to save entry. Please try again."
          render(view: "create", model: [title: "Storitz Organizer Contest with Justin Klosky", organizerContestInstance: organizerContestInstance])
      }
    }

    def save = {
        def organizerContestInstance = new OrganizerContest(params)
        try {
            if (organizerContestInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.created.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), organizerContestInstance.id])}"
                redirect(action: "show", id: organizerContestInstance.id)
            }
            else {
                render(view: "create", model: [organizerContestInstance: organizerContestInstance])
            }
        } catch (Throwable t) {
            render(view: "create", model: [organizerContestInstance: organizerContestInstance])
        }
    }

    def show = {
        def organizerContestInstance = OrganizerContest.get(params.id)
        if (!organizerContestInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), params.id])}"
            redirect(action: "list")
        }
        else {
            [organizerContestInstance: organizerContestInstance]
        }
    }

    def edit = {
        def organizerContestInstance = OrganizerContest.get(params.id)
        if (!organizerContestInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [organizerContestInstance: organizerContestInstance]
        }
    }

    def update = {
        def organizerContestInstance = OrganizerContest.get(params.id)
        if (organizerContestInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (organizerContestInstance.version > version) {
                    
                    organizerContestInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'organizerContest.label', default: 'OrganizerContest')] as Object[], "Another user has updated this OrganizerContest while you were editing")
                    render(view: "edit", model: [organizerContestInstance: organizerContestInstance])
                    return
                }
            }
            organizerContestInstance.properties = params
            if (!organizerContestInstance.hasErrors() && organizerContestInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), organizerContestInstance.id])}"
                redirect(action: "show", id: organizerContestInstance.id)
            }
            else {
                render(view: "edit", model: [organizerContestInstance: organizerContestInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def organizerContestInstance = OrganizerContest.get(params.id)
        if (organizerContestInstance) {
            try {
                organizerContestInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'organizerContest.label', default: 'OrganizerContest'), params.id])}"
            redirect(action: "list")
        }
    }

    private static OrganizerContestStatus getContestStatus() {
        def slist = OrganizerContestStatus.findAll()
        if (!slist || slist.size() < 1) {
            OrganizerContestStatus s = new OrganizerContestStatus()
            s.enabled=s.active=false
            return s
        }

        return slist[0]
    }

    private static String getToEmailAddress () {
        def slist = OrganizerContestStatus.findAll()
        if (!slist || slist.size() < 1) {
            return null;
        }

        return slist[0].toEmailAddress
    }

    private static String getVideoId () {
        def slist = OrganizerContestStatus.findAll()
        if (!slist || slist.size() < 1) {
            return null;
        }

        return slist[0].videoId
    }

    private void sendEmail(OrganizerContest organizerContestInstance) {
        def buf = new ByteArrayOutputStream()

        PrintWriter bodyWriter = new PrintWriter(new OutputStreamWriter(buf, "utf8"), true);
        bodyWriter.println "Name    : ${organizerContestInstance.firstName} ${organizerContestInstance.lastName}"
//        bodyWriter.println "Address : ${organizerContestInstance.address1}"
//        bodyWriter.println "          ${organizerContestInstance.address2}"
//        bodyWriter.println "          ${organizerContestInstance.city}, ${organizerContestInstance.state} ${organizerContestInstance.zipcode}"
        bodyWriter.println "          ${organizerContestInstance.zipcode}"
        bodyWriter.println "Email   : ${organizerContestInstance.email}"
//        bodyWriter.println "Twitter : ${organizerContestInstance.twitterName}"
//        bodyWriter.println "Ref Src : ${organizerContestInstance.referralSource}"
        bodyWriter.println "Essay   : ${organizerContestInstance.essayWhyStorage}"
        def body = buf.toString()

        String title = "Storitz - New OrganizerContest Entry"

        def emailAddress = OrganizerContestController.getToEmailAddress()
        if (emailAddress) {
            emailService.sendTextEmail(
                to: emailAddress,
                from: 'no-reply@storitz.com',
                subject: title,
                body: body
            )
        }
    }

    def saveToEmailAddress = {
        def s = OrganizerContestController.getContestStatus()
        s.toEmailAddress=params.toEmailAddress
        s.save(flush:true)
        redirect(action: "list")
    }

    def saveVideoId = {
        def s = OrganizerContestController.getContestStatus()
        s.videoId=params.videoId
        s.save(flush:true)
        redirect(action: "list")
    }

    def activate = {
        def s = OrganizerContestController.getContestStatus()
        s.active=true;
        s.save(flush:true);
        redirect(action: "list")
    }

    def deactivate = {
        def s = OrganizerContestController.getContestStatus()
        s.active=false;
        s.save(flush:true);
        redirect(action: "list")
    }

    def enable = {
        def s = OrganizerContestController.getContestStatus()
        s.enabled=true;
        s.save(flush:true);
        redirect(action: "list")
    }

    def disable = {
        def s = OrganizerContestController.getContestStatus()
        s.enabled=false;
        s.save(flush:true);
        redirect(action: "list")
    }

    public static boolean isActive() {
       def s = OrganizerContestController.getContestStatus()
       return s.active
    }

    public static boolean isEnabled() {
        def s = OrganizerContestController.getContestStatus()
        return s.enabled
    }
}
