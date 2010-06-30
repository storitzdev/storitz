import com.storitz.SpecialOffer
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class SpecialOfferController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ specialOfferInstanceList: SpecialOffer.list( params ), specialOfferInstanceTotal: SpecialOffer.count() ]
    }

    def show = {
        def specialOfferInstance = SpecialOffer.get( params.id )

        if(!specialOfferInstance) {
            flash.message = "SpecialOffer not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ specialOfferInstance : specialOfferInstance ] }
    }

    def delete = {
        def specialOfferInstance = SpecialOffer.get( params.id )
        if(specialOfferInstance) {
            try {
                specialOfferInstance.delete(flush:true)
                flash.message = "SpecialOffer ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "SpecialOffer ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "SpecialOffer not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def specialOfferInstance = SpecialOffer.get( params.id )

        if(!specialOfferInstance) {
            flash.message = "SpecialOffer not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ specialOfferInstance : specialOfferInstance ]
        }
    }

    def update = {
        def specialOfferInstance = SpecialOffer.get( params.id )
        if(specialOfferInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(specialOfferInstance.version > version) {
                    
                    specialOfferInstance.errors.rejectValue("version", "specialOffer.optimistic.locking.failure", "Another user has updated this com.storitz.SpecialOffer while you were editing.")
                    render(view:'edit',model:[specialOfferInstance:specialOfferInstance])
                    return
                }
            }
            specialOfferInstance.properties = params
            if(!specialOfferInstance.hasErrors() && specialOfferInstance.save()) {
                flash.message = "SpecialOffer ${params.id} updated"
                redirect(action:show,id:specialOfferInstance.id)
            }
            else {
                render(view:'edit',model:[specialOfferInstance:specialOfferInstance])
            }
        }
        else {
            flash.message = "SpecialOffer not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def specialOfferInstance = new SpecialOffer()
        specialOfferInstance.properties = params
        return ['specialOfferInstance':specialOfferInstance]
    }

    def save = {
        def specialOfferInstance = new SpecialOffer(params)
        if(!specialOfferInstance.hasErrors() && specialOfferInstance.save()) {
            flash.message = "SpecialOffer ${specialOfferInstance.id} created"
            redirect(action:show,id:specialOfferInstance.id)
        }
        else {
            render(view:'create',model:[specialOfferInstance:specialOfferInstance])
        }
    }
}
