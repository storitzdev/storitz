package storitz

import com.storitz.Nacha
import java.math.RoundingMode
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class NachaService {

  def emailService

    boolean transactional = false
    String nachaDir = ConfigurationHolder.config?.storitz?.nacha?.dir
    String fileId = ConfigurationHolder.config?.storitz.nacha?.fileId
    String companyId = ConfigurationHolder.config?.storitz.nacha?.companyId


    def buildFile(transactions) {

      def buf = new ByteArrayOutputStream()
      PrintWriter bodyWriter = new PrintWriter(new OutputStreamWriter(buf, "utf8"), true);

      def now = new Date()
      def suffix = now.format('yyyy-MM-dd-hh-mm-ss')

      def daySent = now.format('yyMMdd')
      def dayCount = Nacha.countByDaySent(daySent)

      // compute settlement date - cannot be sat/sun, holiday
      def cal = new GregorianCalendar()
      cal.setTime(now)
      def settlementDays = 1
      if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
        settlementDays = 3
      } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
        settlementDays = 2
      }
      cal.add(Calendar.DATE, settlementDays)
      def settlementDate = cal.time.format('yyMMdd')

      def dirFile = new File(nachaDir)
      if (!dirFile.exists()) {
        dirFile.mkdirs()
      }
      def file = new File(nachaDir, "nacha-${suffix}.txt")
      def nacha = new Nacha(daySent:daySent, seq:dayCount, filePath: file.canonicalPath).save(flush: true)
      def writer = new FileWriter(file)

      bodyWriter.println "NACHA File Date:${settlementDate} Sequence:${dayCount} File: ${file.canonicalPath}\n\n"

      // ONE Record
      writer << sprintf("101 091000019%10s%s%c094101WELLS FARGO            STORITZ INC.           %8d", fileId, now.format('yyMMddHHmm'), (dayCount > 10 ? ('A' as Character) + (dayCount - 10) : dayCount + ('0' as Character)), nacha.id)
      // FIVE Record - note used for debits only (225)
      writer << sprintf("5225STORITZ INC.    OPERATOR DEBITS     %10sPPDRENTALS   %s%s   1091000010000001", companyId, daySent, settlementDate)

      def routeNumberSum = 0
      def debitSum = 0
      def itemCount = 0
      // SIX Record loop
      for(trans in transactions) {
        // use the 8 digit route number and sum
        def bankInfo = trans.site.bankAccount
        if (bankInfo) {
          def routeCode = bankInfo.routeCode.substring(0,8) as Long
          def routeChkSum = bankInfo.routeCode.substring(8)
          routeNumberSum += routeCode
          def debit = (trans.moveInCost - (trans.site.netCommission && trans.commission ? trans.commission : 0))
          if (debit > 0) {
            debitSum += debit
            itemCount++

            bodyWriter.println "${itemCount} Debit for site ${trans.site.title} Amount ${debit}"

            writer << sprintf("627%08d%s%17s%010d%-15s%-22s000091000010000001", routeCode, routeChkSum, bankInfo.acctNo, (debit * 100) as Long, trans.site.id as String, bankInfo.accountName)
          } else {
            bodyWriter.println "Bad debit for rentalTransaction id = ${trans.id} amount ${debit} site: ${trans.site.title}"
          }
        } else {
          bodyWriter.println "Missing bank info for transation id: ${trans.id} - site: ${trans.site.title}"
        }
      }

      // EIGHT Record
      writer << sprintf("8225%06d%010d%012d000000000000%10s                         091000010000001", itemCount, routeNumberSum, (debitSum * 100) as Long, companyId)

      // NINE Record
      writer << sprintf("9000001%06d%08d%010d%012d000000000000                                       ", (((itemCount + 4) as BigDecimal) /10.0).setScale(0, RoundingMode.HALF_UP).longValue(), itemCount as Long, routeNumberSum as Long, (debitSum * 100) as Long)

      writer.close()

      // assuming all went well, mark the transactions
      for (trans in transactions) {
        if (trans.moveInCost) {
          def debit = (trans.moveInCost - (trans.site.netCommission && trans.commission ? trans.commission : 0))
          if (debit > 0) {
            nacha.addToTransactions(trans)
            trans.achTransferDate = now
          }
        }
      }

      bodyWriter.println "Total number of transactions: ${itemCount} - total debit ${debitSum}"

      bodyWriter.close()

      def body = buf.toString()
      String title = "Storitz - NACHA file generated ${settlementDate}-${dayCount}"

      emailService.sendTextEmail(
              to: 'wells@storitz.com',
              from: 'no-reply@storitz.com',
              subject: title,
              body: body
      )

    }
}
