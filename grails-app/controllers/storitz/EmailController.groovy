package storitz

import com.storitz.Commission
import storitz.constants.CommissionSourceType

class EmailController {

  def emailService
  def unitSizeService

  def email = {


    def cost = 64 as BigDecimal

    def c = Commission.createCriteria()
    def ctype = c.get {
      and {
        eq("commissionSource", CommissionSourceType.WEBSITE)
        lt("lowerBound", cost)
        ge("upperBound", cost)
      }
    }
    println "Cost = ${cost} Result = ${ctype}"
    
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
        flash.message = "Mail sent Test format ${g.formatNumber(number:99.00, type:'currency', currencyCode:'USD')} Theft: ${g.formatNumber(number:0.50, type:'percent')}"
    }

    def sizeTest = {
      def dimensions = params.dimensions
      def m = dimensions =~ /(\d+\.*\d*)\s*X\s*(\d+\.*\d*)/
      if (m.matches()) {
        def width = m[0][1] as Double
        def length = m[0][2] as Double

        def unitSize = unitSizeService.getUnitSize(width, length)

        flash.message = "Unitsize id=${unitSize?.id} width:${unitSize?.width} length:${unitSize?.length} dimension area: ${width * length} "
      } else {
        flash.message = "No match for dimensions ${dimensions}"
      }
      render view:"email"
    }
}
