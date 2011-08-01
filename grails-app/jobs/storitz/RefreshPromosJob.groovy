package storitz

class RefreshPromosJob {

  static triggers = {
    //disable cron for grails script testing
    //cron name: 'refreshPromos', cronExpression: "0 30 2 ? * 1"
  }

  def feedService
  def mailService

  def execute(context) {
      RefreshPromos refreshPromos = new RefreshPromos(feedService,mailService)
      refreshPromos.execute(context)
  }
}
