package storitz

class UpdateInventoryJob {

    static triggers = {
      cron name:'nightlyUpdate', cronExpression:"0 30 1 * * ?"
    }

    def feedService
    def emailService

    def execute(context) {
        UpdateInventory updateInventory = new UpdateInventory(feedService,emailService)
        updateInventory.execute(context)
    }
}
