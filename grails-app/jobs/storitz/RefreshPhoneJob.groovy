package storitz


class RefreshPhoneJob {

  def feedService
  def emailService

  static triggers = {
    //cron name: 'refreshPhones', cronExpression: "0 30 2 1 * ?"
  }

  def execute(context) {
      RefreshPhone refreshPhone = new RefreshPhone(feedService,emailService)
      refreshPhone.execute(context)
  }
}
