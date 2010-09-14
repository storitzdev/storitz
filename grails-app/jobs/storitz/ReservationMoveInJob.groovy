package storitz

import com.storitz.RentalTransaction


class ReservationMoveInJob {
    private static final boolean AUTOMATIC_FLUSH = true;
    private static final String DEFAULT_CHARSET = "utf8";

    def CShiftService
    def emailService

    static triggers = {
      cron name:'reservationMoveIn', cronExpression:"0 01 1 * * ?"
    }

    def execute(context) {

      def buf = new ByteArrayOutputStream()
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(buf, DEFAULT_CHARSET), AUTOMATIC_FLUSH);

      def startTime = System.currentTimeMillis()
      if (context.mergedJobDataMap.get('from')) {
        writer.println "Called from ${context.mergedJobDataMap.get('from')}"
      }
      def target = new Date()
      if (context.mergedJobDataMap.get('target')) {
        target = Date.parse("MM/dd/yy", context.mergedJobDataMap.get('target'))
      }
      writer.println "----------------- Starting reservation to move-in... ----------------------------"

      writer.println "Target date ${target.format('MM/dd/yy')}"
      
      def c = RentalTransaction.createCriteria()
      def results = c.list {
        and {
          eq("reserved", true)
          le("moveInDate", target)
        }
      }
      for(rt in results) {
        writer.println "Processing reservation id: ${rt.id} moveInDate: ${rt.moveInDate.format('MM/dd/yy')}"
        if (rt.site.source.startsWith('CS')) {
          if (CShiftService.moveIn(rt, writer)) {
            rt.reserved = false
            rt.save()
          } else {
            writer.println "Error performing MoveIn for Transaction: ${rt.id} - reservation = ${rt.reservationId} accountId = ${rt.tenantId} contactId = ${rt.contactId}"
          }
        }
      }
      writer.println "----------------- Complete ${results.size()} reservations ${System.currentTimeMillis() - startTime} millis ----------------------------"

      String subject = "Centershift reservation to movein ${new Date().format('yyyy-MM-dd')}"

      writer.flush()
      writer.close()

      emailService.sendTextEmail(to: 'tech@storitz.com',
        from: 'no-reply@storitz.com',
        subject: subject,
        body: buf.toString())

    }
}
