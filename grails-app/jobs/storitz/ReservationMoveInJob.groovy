package storitz

import com.storitz.RentalTransaction


class ReservationMoveInJob {

    def CShiftService
    def emailService

    static triggers = {
      cron name:'reservationMoveIn', cronExpression:"0 01 1 * * ?"
    }

    def execute(context) {

      def buf = new ByteArrayOutputStream()
      def newOut = new PrintStream(buf)
      def saveOut = System.out

      System.out  = newOut


      def startTime = System.currentTimeMillis()
      if (context.mergedJobDataMap.get('from')) {
        println "Called from ${context.mergedJobDataMap.get('from')}"
      }
      def target = new Date()
      if (context.mergedJobDataMap.get('target')) {
        target = Date.parse("MM/dd/yy", context.mergedJobDataMap.get('target'))
      }
      println "----------------- Starting reservation to move-in... ----------------------------"

      println "Target date ${target.format('MM/dd/yy')}"
      
      def c = RentalTransaction.createCriteria()
      def results = c.list {
        and {
          eq("reserved", true)
          le("moveInDate", target)
        }
      }
      for(rt in results) {
        println "Processing reservation id: ${rt.id} moveInDate: ${rt.moveInDate.format('MM/dd/yy')}"
        if (rt.site.source.startsWith('CS')) {
          if (CShiftService.moveIn(rt)) {
            rt.reserved = false
            rt.save()
          } else {
            println "Error performing MoveIn for Transaction: ${rt.id} - reservation = ${rt.reservationId} accountId = ${rt.tenantId} contactId = ${rt.contactId}"
          }
        }
      }
      println "----------------- Complete ${results.size()} reservations ${System.currentTimeMillis() - startTime} millis ----------------------------"

      System.out = saveOut

      String subject = "Centershift reservation to movein ${new Date().format('yyyy-MM-dd')}"

      emailService.sendTextEmail(to: 'tech@storitz.com',
        from: 'no-reply@storitz.com',
        subject: subject,
        body: buf.toString())
    }
}
