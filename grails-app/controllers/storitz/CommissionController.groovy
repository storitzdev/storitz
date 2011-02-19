package storitz

import com.storitz.Commission
import com.storitz.CommissionSchedule
import storitz.constants.CommissionSourceType
import storitz.constants.CommissionType

class CommissionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
        [commissionScheduleInstanceList: CommissionSchedule.list(params), commissionScheduleInstanceTotal: (CommissionSchedule.count() ? CommissionSchedule.count() : 0)]
    }

    def createSchedule = {

      def commissionScheduleInstance = new CommissionSchedule(params)
      if (commissionScheduleInstance.save(flush: true)) {
          flash.message = "${message(code: 'default.created.message', args: [message(code: 'commissionSchedule.label', default: 'Commission Schedule'), commissionScheduleInstance.id])}"
          redirect(action: "list", id: commissionScheduleInstance.id)
      }
      else {
          flash.message = "Error creating new Commission Schedule"
          render(view: "list")
      }
    }

    def create = {
        def commissionInstance = new Commission()
        commissionInstance.properties = params
        return [commissionInstance: commissionInstance]
    }

    def save = {
        def commissionInstance = new Commission(params)
        if (commissionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'commission.label', default: 'Commission'), commissionInstance.id])}"
            redirect(action: "show", id: commissionInstance.id)
        }
        else {
            render(view: "create", model: [commissionInstance: commissionInstance])
        }
    }

    def show = {
        def commissionInstance = Commission.get(params.id)
        if (!commissionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'commission.label', default: 'Commission'), params.id])}"
            redirect(action: "list")
        }
        else {
            [commissionInstance: commissionInstance]
        }
    }

    def edit = {
        def commissionScheduleInstance = CommissionSchedule.get(params.id)
        if (!commissionScheduleInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'commissionSchedule.label', default: 'Commission Schedule'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [commissionScheduleInstance: commissionScheduleInstance, entries: commissionScheduleInstance.entries.sort{ it.lowerBound }]
        }
    }

    def update = {
        def commissionScheduleInstance = CommissionSchedule.get(params.id)
        if (commissionScheduleInstance) {
          for(commission in commissionScheduleInstance.entries) {
            def lowerBoundString = "lowerBound_" + commission.id
            def upperBoundString = "upperBound_" + commission.id
            def amountString = "amount_" + commission.id
            def commissionTypeString = "commissionType_" + commission.id

            if (params.getAt(lowerBoundString)) {
              commission.lowerBound = params.getAt(lowerBoundString) as BigDecimal
            }
            if (params.getAt(upperBoundString)) {
              commission.upperBound = params.getAt(upperBoundString) as BigDecimal
            }
            if (params.getAt(amountString)) {
              commission.amount = params.getAt(amountString) as BigDecimal
            }
            if (params.getAt(commissionTypeString)) {
              commission.commissionType = CommissionType.getEnumFromId(params.getAt(commissionTypeString))
            }
            commission.commissionSource = CommissionSourceType.WEBSITE
            commission.save()
          }
          for (param in params.keySet()) {
            if (param.startsWith('new_lowerBound_')) {
              Long entryId = param.substring(15) as Long
              def lowerBoundString = "new_lowerBound_" + commission.id
              def upperBoundString = "new_upperBound_" + commission.id
              def amountString = "new_amount_" + commission.id
              def commissionTypeString = "new_commissionType_" + commission.id
              def entry = new Commission()
              entry.lowerBound = params.getAt(lowerBoundString) as BigDecimal
              entry.upperBound = params.getAt(upperBoundString) as BigDecimal
              entry.amount = params.getAt(amountString) as BigDecimal
              entry.commissionType = CommissionType.getEnumFromId(params.getAt(commissionTypeString))
              entry.commissionSource = CommissionSourceType.WEBSITE
              entry.save(flush:true)
              commissionScheduleInstance.addToEntries(entry)
            }
          }
          commissionScheduleInstance.save(flush:true)
          redirect(action: "show", id: commissionScheduleInstance.id)
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'commission.label', default: 'Commission'), params.id])}"
            redirect(action: "list")
        }
    }

    def removeEntry = {
      def commissionSchedule = CommissionSchedule.get(params.id)
      def commission = Commission.get(params.entryId)

      if (commissionSchedule && commission) {
        commissionSchedule.removeFromEntries(commission)
        render (status: 200, contentType:"application/json", text:"{ \"entryId\": ${params.entryId} }")
      }

    }

}
