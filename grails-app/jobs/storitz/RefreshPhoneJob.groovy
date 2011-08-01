package storitz


class RefreshPhoneJob {

  def feedService
  def mailService

  static triggers = {
    //cron name: 'refreshPhones', cronExpression: "0 30 2 1 * ?"
  }

  def execute(context) {
      RefreshPhone refreshPhone = new RefreshPhone(feedService,mailService)
      refreshPhone.execute(context)
  }
}
