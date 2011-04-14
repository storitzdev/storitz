package storitz

import com.storitz.EDomico
import com.storitz.CommissionSchedule
import grails.plugins.springsecurity.Secured
import storitz.constants.FeedType
import com.storitz.EDomicoLocation

class EDomicoController extends FeedController {

    def index = {
        redirect(action: list)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [edomicoInstanceList: EDomico.list(params), edomicoInstanceTotal: EDomico.count()]
    }

    def create = {
        def edomicoInstance = new EDomico()
        edomicoInstance.properties = params
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [edomicInstance: edomicoInstance, commissionScheduleList: CommissionSchedule.list()]
    }


    def edit = {
        def edomicoInstance = EDomico.get(params.id)
        if (!edomicoInstance) {
          flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cshift.label', default: 'com.storitz.cshift'), params.id])}"
          redirect(action: "list")
        }
        else {
          return [edomicoInstance: edomicoInstance, commissionScheduleList: CommissionSchedule.list()]
        }

    }

    def update = {
      def edomicoInstance = EDomico.get(params.id)
      if (edomicoInstance) {
        if (params.version) {
          def version = params.version.toLong()
          if (edomicoInstance.version > version) {
            edomicoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'edomico.label', default: 'com.storitz.EDomico')] as Object[], "Another user has updated this com.storitz.EDomico while you were editing")
            render(view: "edit", model: [edomicoInstance: edomicoInstance])
            return
          }
        }
        edomicoInstance.properties = params

          for (param in params.keySet()) {
            if (param.startsWith('newSiteID:_')) {
              def idx = param.substring(11)
              def loc = new EDomicoLocation()
              loc.siteID   = params['newSiteID:_' + idx]
              loc.siteName = params['newSiteName:_' + idx]
              loc.address1 = params['newAddress1:_' + idx]
              loc.city     = params['newCity:_' + idx]
              loc.zipcode  = params['newZipcode:_' + idx]
              loc.edomico  = edomicoInstance
              loc.save(flush: true)
              edomicoInstance.addToLocations(loc)
            }
          }
          for (loc in edomicoInstance.locations) {
            def siteIDString = "siteid:_" + loc.id
            def siteNameString = "sitename:_" + loc.id
            def address1String = "address1:_" + loc.id
            def cityString = "city:_" + loc.id
            def zipcodeString = "zipcode:_" + loc.id

            def changed = false
            if (params[siteIDString]) {
              loc.siteID = params[siteIDString]
              changed = true
            }
            if (params[siteNameString]) {
              loc.siteName = params[siteNameString]
              changed = true
            }
            if (params[address1String]) {
              loc.address1 = params[address1String]
              changed = true
            }
            if (params[cityString]) {
              loc.city = params[cityString]
              changed = true
            }
            if (params[zipcodeString]) {
              loc.zipcode = params[zipcodeString]
              changed = true
            }
            if (changed) {
              loc.save(flush: true)
            }
          }

       if (!edomicoInstance.hasErrors() && edomicoInstance.save(flush: true)) {
          flash.message = "${message(code: 'default.updated.message', args: [message(code: 'edomico.label', default: 'com.storitz.EDomico'), edomicoInstance.id])}"
          redirect(action: "show", id: edomicoInstance.id)
        }
        else {
          render(view: "edit", model: [edomicoInstance: edomicoInstance])
        }
      }
      else {
        flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'edomico.label', default: 'com.storitz.EDomico'), params.id])}"
        redirect(action: "list")
      }
    }

    def removeLocation = {
      def loc = EDomicoLocation.get(params.locId as Long)
      if (loc) {
        def eDomico = loc.edomico
        eDomico.removeFromLocations(loc)
        eDomico.save(flush: true)
        // TODO remove the site from the system - cascade everything
      }
      render(status: 200, contentType: "application/json", text: "{ 'locId': ${loc?.id} }")
    }





    def delete = {
    }

    def refresh = {
    }

    def updateInventory = {
    }

    def refreshPromos = {
    }

    def refreshInsurance = {
    }

    def createContacts = {
    }

    def refreshPhones = {
    }

    def show = {
        def edomicoInstance = EDomico.get(params.id)
        if (!edomicoInstance) {
          flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'edomico.label', default: 'com.storitz.EDomico'), params.id])}"
          redirect(action: "list")
        }
        else {
          [edomicoInstance: edomicoInstance]
        }
    }

    def save = {
        def edomicoInstance = new EDomico(params)
        edomicoInstance.feedType = FeedType.EDOMICO
        if (edomicoInstance.validate() && edomicoInstance.save(flush: true)) {
            // read in sites
            def stats = new storitz.SiteStats()
            def writer = new PrintWriter(System.out)
            EDomicoService eDomicoService = new EDomicoService(edomicoInstance.edomicoClientID,edomicoInstance.edomicoWebServicesKey)
            eDomicoService.loadSites(edomicoInstance, "DOM", stats, writer)
            flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
            redirect(action: "show", id: edomicoInstance.id)
        }
        else {
          render(view: "create", model: [edomicoInstance: edomicoInstance])
        }

    }

}
