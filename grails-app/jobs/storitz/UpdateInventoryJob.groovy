package storitz

class UpdateInventoryJob {

    static triggers = {
      //disable cron for grails script testing
      //cron name:'nightlyUpdate', cronExpression:"0 30 1 * * ?"
    }

    def feedService
    def mailService

    def execute(context) {
        UpdateInventory updateInventory = new UpdateInventory(feedService, mailService)
        updateInventory.execute(context)
    }
}
