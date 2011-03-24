package storitz

class UpdateInventoryJob {

    static triggers = {
      //disable cron for grails script testing
      //cron name:'nightlyUpdate', cronExpression:"0 30 1 * * ?"
    }

    def feedService
    def emailService

    def execute(context) {
        UpdateInventory updateInventory = new UpdateInventory(feedService,emailService)
        updateInventory.execute(context)
    }
}
