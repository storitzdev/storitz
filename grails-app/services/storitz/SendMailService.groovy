package storitz

class SendMailService {

  boolean transactional = false

  //Tell the JMS plugin that this is a message endpoint
  static expose = ['jms']
  static destination = "sendMail"

  //The Mail plugin service
  def mailService

  def onMessage(emailMessage) {
      println "Got queued message - sending via mail service"
      try {
          mailService.sendMail {
              to emailMessage.to
              from emailMessage.from
              subject emailMessage.subject
              body(view: emailMessage.view, model: emailMessage.model)

          }
      } catch (Exception e) {
          log.error("Failed to send email ${emailMessage}", e)
      }
      //Return null to avoid poison messages
      return null
  }
}
