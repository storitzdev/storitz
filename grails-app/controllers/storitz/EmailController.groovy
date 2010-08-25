package storitz

import com.storitz.User

class EmailController {

  def emailService

  def email = {


    def siteManager = User.withCriteria {
      sites {
        eq("site.id", 1l)
      }
      notificationTypes {
        eq("notificationType.id", 1l)
      }
      maxResults(1)
    }
    println "Result = ${siteManager}"
    
    println "Sending email..."
    
        try {
            emailService.sendEmail(to: "mamster@storitz.com",
                from: "no-response@storitz.com",
                subject: "New Storitz Move-In",
                model: [transactionId: 1234,
                  siteName: "Test site",
                  unitNumber: "445A",
                  moveInDate: "10/1/10",
                  rentalRate: "\$99.00",
                  paidThruDate: "11/1/10",
                  promoName: "\$1 Move-In",
                  paymentTotal: "\$119.00",
                  tenantName: "John Doe",
                  phone: "310-555-1212",
                  email: "jdoe@gmail.com"],
                view: "/notifications/test")

        } catch (Exception e) {
            log.error("${e}", e)
            flash.message = "Mail not sent: ${e}"
            return
        }
        flash.message = "Mail sent"
    }
}