package storitz

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import com.storitz.Nacha
import java.math.RoundingMode

class NachaService {

    boolean transactional = false
    String nachaDir = ConfigurationHolder.config?.storitz?.nacha?.dir
    String fileId = ConfigurationHolder.config?.storitz.nacha?.fileId
    String companyId = ConfigurationHolder.config?.storitz.nacha?.companyId


    def buildFile(transactions) {


      // create nacha file
      // populate header
      // loop through transactions - flag missing ACH information
      // populate footer
      // update transactions - mark transferred

      def now = new Date()
      def suffix = now.format('yyyy-MM-dd-hh-mm-ss.txt')

      def daySent = now.format('yyyyMMdd')
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
      def settlementDate = cal.time.format('yyyyMMdd')

      def file = new File(nachaDir, "nacha-${suffix}")
      file.mkdirs()
      def nacha = new Nacha(daySent:daySent, seq:dayCount, filePath: file.canonicalPath()).save(flush: true)
      def writer = new FileWriter(file)

      // ONE Record
      writer << sprintf("101 091000019%10s%s%1d094101WELLS FARGO            STORITZ INC.           %8d", fileId, now.format('yyyyMMddHHmm'), dayCount, nacha.id)
      // FIVE Record - note used for debits only (225)
      writer << sprintf("5225STORITZ INC.    OPERATOR CREDITS    %10sPPDRENTALS   %s%s   1091000010000001", companyId, daySent, settlementDate)

      def routeNumberSum = 0
      def debitSum = 0
      // SIX Record loop
      for(trans in transactions) {
        // use the 8 digit route number and sum
      }

      // EIGHT Record
      writer << sprintf("8225%06d%010d%012d000000000000%10s                         091000010000001", transactions.size(), routeNumberSum, debitSum as Long, companyId)

      // NINE Record
      writer << sprintf("9000001%06d%08d%010d%012d000000000000                                        ", (((transactions.size() + 4) as BigDecimal) /10.0).setScale(0, RoundingMode.HALF_UP), transactions.size(), routeNumberSum, debitSum)

      writer.close()

      // assuming all went well, mark the transactions
      for (trans in transactions) {
        nacha.addToTransactions(trans)
        trans.achTransferDate = now
      }

    }
}
