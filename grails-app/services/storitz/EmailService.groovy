package storitz

class EmailService {

    boolean transactional = false

  def sendEmail(attrs) {

     println "Sending jms message to sendMail now"
    
     sendJMSMessage("sendMail",
       [to: attrs.to,
        from: attrs.from,
        subject: attrs.subject,
        view: attrs.view,
        model: attrs.model])
  }
}
