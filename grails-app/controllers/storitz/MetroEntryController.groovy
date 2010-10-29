package storitz

import com.storitz.MetroEntry
import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import com.storitz.Metro

@Secured(['ROLE_ADMIN'])
class MetroEntryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
      if (!params.max) {
          params.max = 10
      }

      def results
      def count

      if (params.city) {
        def query
        def criteria = MetroEntry.createCriteria()

        count = criteria.get {
          projections {
              countDistinct("id")
          }
          and {
            ilike("city", params.city + '%')
          }
        }

        results = MetroEntry.createCriteria().list(params) {
          and {
            ilike("city", params.city + '%')
          }
        }


      } else {
          results = MetroEntry.list(params)
          count = MetroEntry.count()
      }
      [metroEntryList: results, metroEntryListCount: count]
    }

    def autocompleteMetro = {
      def retList = []
      def results = Metro.findAllByCityIlike(params.term +'%', params).each{
        retList.add([id:it.id, label:"${it.city}, ${it.state.display}", value:"${it.city}, ${it.state.display}"])
      }
      render (status: 200, contentType:"application/json", text: retList as JSON )
    }

    def autocompleteMetroEntry = {

      def results = MetroEntry.findAllByCityIlike(params.term +'%', params).collect{it.city}
      render (status: 200, contentType:"application/json", text: results as JSON )
    }


    def create = {
        def metroEntryInstance = new MetroEntry()
        metroEntryInstance.properties = params
        return [metroEntryInstance: metroEntryInstance]
    }

    def save = {
        params.remove("metro")
        def metroEntryInstance = new MetroEntry(params)
        if (params.metro_id && params.metro_id.size() > 0) {
          metroEntryInstance.metro = Metro.get(params.metro_id as Long)
        }
        if (metroEntryInstance.validate() && metroEntryInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'metroEntry.label', default: 'MetroEntry'), metroEntryInstance.id])}"
            redirect(action: "show", id: metroEntryInstance.id)
        }
        else {
            render(view: "create", model: [metroEntryInstance: metroEntryInstance])
        }
    }

    def show = {
        def metroEntryInstance = MetroEntry.get(params.id)
        if (!metroEntryInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'metroEntry.label', default: 'MetroEntry'), params.id])}"
            redirect(action: "list")
        }
        else {
            [metroEntryInstance: metroEntryInstance]
        }
    }

    def edit = {
        def metroEntryInstance = MetroEntry.get(params.id)
        if (!metroEntryInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'metroEntry.label', default: 'MetroEntry'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [metroEntryInstance: metroEntryInstance]
        }
    }

    def update = {
        def metroEntryInstance = MetroEntry.get(params.id)
        if (metroEntryInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (metroEntryInstance.version > version) {
                    
                    metroEntryInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'metroEntry.label', default: 'MetroEntry')] as Object[], "Another user has updated this MetroEntry while you were editing")
                    render(view: "edit", model: [metroEntryInstance: metroEntryInstance])
                    return
                }
            }
            metroEntryInstance.properties = params
            if (!metroEntryInstance.hasErrors() && metroEntryInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'metroEntry.label', default: 'MetroEntry'), metroEntryInstance.id])}"
                redirect(action: "show", id: metroEntryInstance.id)
            }
            else {
                render(view: "edit", model: [metroEntryInstance: metroEntryInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'metroEntry.label', default: 'MetroEntry'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def metroEntryInstance = MetroEntry.get(params.id)
        if (metroEntryInstance) {
            try {
                metroEntryInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'metroEntry.label', default: 'MetroEntry'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'metroEntry.label', default: 'MetroEntry'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'metroEntry.label', default: 'MetroEntry'), params.id])}"
            redirect(action: "list")
        }
    }
}
