package storitz

import com.storitz.Nacha
import java.math.RoundingMode
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import storitz.constants.NotificationEventType

class NachaService {

  def mailService
  def notificationService

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
    def nacha = new Nacha(daySent: daySent, seq: dayCount, filePath: file.canonicalPath, generatedDate: new Date()).save(flush: true)
    def writer = new FileWriter(file)

    bodyWriter.println "NACHA File Date:${settlementDate} Sequence:${dayCount} File: ${file.canonicalPath}\n\n"

    // ONE Record
    writer << sprintf("101 091000019%10s%s%c094101WELLS FARGO            STORITZ INC.           %8d\r\n", fileId, now.format('yyMMddHHmm'), (dayCount > 10 ? ('A' as Character) + (dayCount - 10) : dayCount + ('0' as Character)), nacha.id)
    // FIVE Record - note used for debits only (225)
    writer << sprintf("5220STORITZ INC.    OPERATOR CREDITS    %10sCCDRENTALS   %s%s   1091000010000001\r\n", companyId, daySent, settlementDate)

    def routeNumberSum = 0
    def creditSum = 0
    def itemCount = 0
    // SIX Record loop
    for (trans in transactions) {
      // use the 8 digit route number and sum
      def bankInfo = trans.site.bankAccount
      def credit = (trans.cost - (trans.site.netCommission && trans.commission ? trans.commission : 0))
      if (bankInfo) {
        def routeCode = bankInfo.routeCode.substring(0, 8) as Long
        def routeChkSum = bankInfo.routeCode.substring(8)
        routeNumberSum += routeCode
        if (credit > 0) {
          creditSum += credit
          itemCount++

          bodyWriter.println "${itemCount} Credit for site ${trans.site.title} id = ${trans.id} Amount ${credit}"

          writer << sprintf("622%08d%s%17s%010d%-15s%-22s00009100001%07d\r\n", routeCode, routeChkSum, bankInfo.acctNo, (credit * 100) as Long, trans.site.id as String, bankInfo.accountName, itemCount)
        } else {
          bodyWriter.println "Bad debit for rentalTransaction id = ${trans.id} amount ${credit} site: ${trans.site.title}"
        }
      } else {
        bodyWriter.println "Missing bank info for transation id: ${trans.id} - site: ${trans.site.title} - Amount ${credit}"
      }
    }

    // EIGHT Record
    writer << sprintf("8220%06d%010d000000000000%012d%10s                         091000010000001\r\n", itemCount, routeNumberSum, (creditSum * 100) as Long, companyId)

    // NINE Record
    writer << sprintf("9000001%06d%08d%010d000000000000%012d                                       \r\n", (((itemCount + 4) as BigDecimal) / 10.0).setScale(0, RoundingMode.HALF_UP).longValue(), itemCount as Long, routeNumberSum as Long, (creditSum * 100) as Long)

    if ((itemCount + 4) % 10 != 0) {
      for (i in 1..(10 - ((itemCount + 4) % 10))) {
        writer << "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999\r\n"
      }
    }
    writer.close()

    // assuming all went well, mark the transactions
    for (trans in transactions) {
      if (trans.cost && trans.site.bankAccount) {
        def debit = (trans.cost - (trans.site.netCommission && trans.commission ? trans.commission : 0))
        if (debit > 0) {
          nacha.addToTransactions(trans)
          trans.achTransferDate = now
          trans.achAmount = debit
          trans.save()
          notificationService.notify(NotificationEventType.ACH_TRANSFER, trans)
        }
      }
    }

    bodyWriter.println "Total number of transactions: ${itemCount} - total debit ${creditSum}"

    bodyWriter.close()

    def body = buf.toString()
    String title = "Storitz - NACHA file generated ${settlementDate}-${dayCount}"

    mailService.sendMail {
            to        'wells@storitz.com'
            from      'no-reply@storitz.com'
            subject   title
            body      body
    }

  }
}
