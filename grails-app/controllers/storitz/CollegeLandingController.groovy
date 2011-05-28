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

        def searchType = SearchType.STORAGE

        // optimize zoom level
        Long searchSize = 1
        def zoom = mapService.optimizeZoom(searchSize, searchType, lat, lng, 617, 284)
        def dim = mapService.getDimensions(zoom, lat, lng, 617, 284)
        def sites = mapService.getSites(searchSize, searchType, dim.swLat, dim.swLng, dim.neLat, dim.neLng).sort { mapService.calcDistance(lat, it.lat, lng, it.lng)} as List

        def siteMoveInPrice = [:]
        def sitesToRemove = []
        Date moveInDate = new Date()

        // TODO: collect result statistics (# found, avg distance, min/max price, etc) to be reported to GA, pass to view (somehow), so browser can send to GA as CustomVars
        for (site in sites) {
            Insurance ins = null
            if (site.noInsuranceWaiver) {
                ins = site.insurances.findAll { it.active }.min { it.premium }
            }
            def availableUnitsMap = [:] // using a map because I don't know how to use a set, and I don't want to do linear search thru an ArrayList
            site.units.findAll { it.unitCount > site.minInventory }.each { unit ->
                availableUnitsMap[unit.id] = unit
            }
            // find all college specials for the facility; then find all available units that are valid for the special
            def collegeOffersMap = [:] // maps units to lists of special offers
            if (availableUnitsMap.size()) { // premature optimization: don't bother looking for specials if the site has no inventory
                def collegeOffers = site.specialOffers().findAll { it.tags.any { it.tag.equals("college_special_2011") } }
                for (offer in collegeOffers) {
                    for (validUnit in offerFilterService.getValidUnitsForOffer(site, offer)) { // we may find many units that are valid for the offer
                        if (availableUnitsMap.getAt(validUnit.id)) {
                            if (!collegeOffersMap.getAt(validUnit)) {
                                collegeOffersMap[validUnit] = []
                            }
                            collegeOffersMap[validUnit] << offer
                        }
                    }
                }
            }
            else {
                // TODO: Emit warnings here?
            }

            // if we found any units to which college specials are valid, select the "best unit" from those
            def collegeUnits = collegeOffersMap.keySet()
            log.info("${site.title} - found ${collegeUnits.size()} units with college specials")
            def unitList = collegeUnits.size() ? collegeUnits : availableUnitsMap.values();
            def bestUnit = unitList.min { site.allowPushPrice ? it.pushRate : it.price }
            if (bestUnit) {
                def yourPrice = null
                def listPrice = null
                log.info("${site.title} - allowPushPrice: ${site.allowPushPrice} (bestUnit -  pushRate: ${bestUnit.pushRate} bestUnit listPrice: ${bestUnit.price})")

                if (site.allowPushPrice) {
                  yourPrice = bestUnit.pushRate
                  if (bestUnit.pushRate < bestUnit.price) {
                    listPrice = bestUnit.price
                  }
                }
                else {
                    yourPrice = bestUnit.price
                }

                // if there's a college special available for the unit, use it
                def featuredOffers = collegeOffersMap.getAt(bestUnit)
                if (!featuredOffers) {
                    featuredOffers = offerFilterService.getValidFeaturedOffers(site, bestUnit)
                }
                if (featuredOffers.size() == 0) {
                    def totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
                    siteMoveInPrice[site.id] = [cost: totals['moveInTotal'], promo: null, promoName: null, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
                } else {
                    def totals = costService.calculateTotals(site, bestUnit, null, ins, moveInDate)
                    siteMoveInPrice[site.id] = [cost: totals['moveInTotal'], promo: null, promoName: null, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
                    def oldMoveInCost = siteMoveInPrice[site.id].cost
                    siteMoveInPrice[site.id].cost = 100000
                    for (promo in featuredOffers) {
                        if (!(promo.promoName ==~ /(?i).*(military|senior).*/)) {
                            totals = costService.calculateTotals(site, bestUnit, promo, ins, moveInDate)
                            if (siteMoveInPrice[site.id].cost > totals['moveInTotal']) {
                                siteMoveInPrice[site.id] = [cost: totals['moveInTotal'], promo: promo.id, promoName: promo.promoName, monthly: bestUnit?.price, pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), paidThruDate: totals['paidThruDate'], sizeDescription: bestUnit?.displaySize, unitType: bestUnit?.unitType?.display, cc: bestUnit?.isTempControlled, yourPrice: yourPrice, listPrice: listPrice]
                            }
                        }
                    }
                    if (siteMoveInPrice[site.id].cost == 100000) {
                        siteMoveInPrice[site.id].cost = oldMoveInCost
                    }
                }
            } else {
                sitesToRemove << site
            }
            sitesToRemove.each { s -> sites.remove(s) }
        }

        [college: college, title: title, lat: lat, lng: lng, sites: sites, siteMoveInPrice: siteMoveInPrice, isAdmin: isAdmin]
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
