package storitz

import ar.com.fdvs.dj.core.DynamicJasperHelper
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager
import ar.com.fdvs.dj.domain.DJCalculation
import ar.com.fdvs.dj.domain.DJGroupLabel
import ar.com.fdvs.dj.domain.DynamicReport
import ar.com.fdvs.dj.domain.Style
import ar.com.fdvs.dj.domain.builders.ColumnBuilder
import ar.com.fdvs.dj.domain.builders.FastReportBuilder
import ar.com.fdvs.dj.domain.builders.GroupBuilder
import ar.com.fdvs.dj.domain.builders.StyleBuilder
import ar.com.fdvs.dj.domain.entities.DJGroup
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn
import ar.com.fdvs.dj.domain.entities.columns.PropertyColumn
import ar.com.fdvs.dj.domain.entities.columns.SimpleColumn
import ar.com.fdvs.dj.output.ReportWriter
import ar.com.fdvs.dj.output.ReportWriterFactory
import com.storitz.RentalTransaction
import com.storitz.ReportPeriod
import com.storitz.StorageSite
import grails.plugins.springsecurity.Secured
import grails.util.GrailsUtil
import net.sf.jasperreports.engine.JRDataSource
import net.sf.jasperreports.engine.JRExporter
import net.sf.jasperreports.engine.JRExporterParameter
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter
import net.sf.jasperreports.j2ee.servlets.ImageServlet
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import storitz.constants.ReportName
import storitz.constants.TransactionStatus
import storitz.constants.UnitType
import ar.com.fdvs.dj.domain.constants.*
import storitz.reports.*
import com.storitz.User
import com.storitz.UserRole
import com.storitz.Feed

import storitz.constants.FeedType
import java.awt.Color
import storitz.constants.ReportOutputType
import storitz.constants.TransactionType

@Secured(['ROLE_USER','ROLE_MANAGER','ROLE_ADMIN'])
class ReportsController {

    def fileUploadService
    def springSecurityService

    static allowedMethods = [balk: "POST"]


    def index = {
      def feedList = []
      def username  = springSecurityService.principal.username
      def user = User.findByUsername(username as String)
      if (UserRole.userHasRole(user, 'ROLE_ADMIN')) {
        feedList = Feed.list()
      } else {
        if (UserRole.userHasRole(user, 'ROLE_MANAGER')) {
          feedList = Feed.findAllByManager(user)
        } else {
          feedList = Feed.findAllByManager(user.manager)
        }
      }
      [feedList:feedList]
    }

  GregorianCalendar startDate = new GregorianCalendar()
  GregorianCalendar endDate = new GregorianCalendar()

  Style titleStyle = new Style("titleStyle")
  Style headerStyle = new Style("headerStyle")
  Style detailStyle = new Style("detailStyle")
  Style headerVariableStyle = new Style("headerVariableStyle")
  Style groupHeaderStyle = new Style("groupHeaderStyle")
  Style subtotalStyle = new Style("subtotalStyle")
  Style moneyStyle = new Style("moneyStyle")
  Style moneyTotalStyle = new Style("moneyTotalStyle")
  Style facilityHeaderStyle = new Style("facilityHeaderStyle")
  Style detailCenterStyle = new Style("detailCenterStyle")
  Style dateHeaderStyle = new Style("dateHeaderStyle")

  def site = {

    ReportPeriod period = new ReportPeriod(params)

    if (!period.validate()) {
      period.errors.allErrors.each {
        println "Error in report validation: ${it}"
      }
      flash.message = "Bad report parameters - please re-enter dates and output type."
      render view: "index", model: [reportPeriod: period]
      return
    }

    startDate.setTime(Date.parse('MM/dd/yyyy', params.startDate))
    startDate.clearTime()
    endDate.setTime(Date.parse('MM/dd/yyyy', params.endDate) + 1)
    endDate.clearTime()


    FastReportBuilder drb = new FastReportBuilder();
    def config = loadConfig()

    // Footer definition
    drb.setTemplateFile(request.getRealPath('/WEB-INF/reports/storitz_template.jrxml'))

    def reportParams = [
      logo_header: request.getRealPath("/images/logo_storitz_small.gif"),
      logo_footer: request.getRealPath("/images/storitz-footer-logo-grayscale-small.png"),
      date_range: "${params.startDate} to ${params.endDate}"
    ]

    Page page = Page.Page_Legal_Landscape()
    
    drb.setDefaultStyles(titleStyle, null, headerStyle, detailStyle)
      .setDetailHeight(15)                                            //defines the height for each record of the report
      .setPageSizeAndOrientation(page)
      .setMargins(20, 20, 15, 15)                                                     //define the margin space for each side (top, bottom, left and right)
      .setColumnsPerPage(1)
      .setPrintBackgroundOnOddRows(true)
      .setUseFullPageWidth(true)


    def results
    switch (period.reportName) {
      case ReportName.BALK:

        results = buildBalkReport(drb, reportParams, startDate, endDate)
        break

      case ReportName.ACTIVITY:
      case ReportName.PENDING:
      case ReportName.MOVEIN:
        period.site = StorageSite.findByTitle(params.sitename)
        if (!period.site) {
          flash.message = "Bad report parameters - missing site for report."
          render view: "index", model: [reportPeriod: period]
          return
        }
        results = buildSiteReport(drb, reportParams, startDate, endDate, period)
        break

      case ReportName.CORP_TRANSACTION:
        results = buildCorpTransactionReport(drb, reportParams, startDate, endDate, period)
        break

      case ReportName.CORP_PAYMENT:
        results = buildCorpPaymentReport(drb, reportParams, startDate, endDate, period)
        break

      case ReportName.INVOICE:
        results = buildInvoice(drb, reportParams, startDate, endDate, period)
        break
    }

    JRDataSource ds = new JRBeanCollectionDataSource(results);

    DynamicReport dr = drb.build()

    JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds, reportParams);
    ReportWriter reportWriter = ReportWriterFactory.getInstance().getReportWriter(jp, period.outputType.value, [(net.sf.jasperreports.engine.export.JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN):false,
            (JRHtmlExporterParameter.IMAGES_URI): "${request.contextPath}/reports/image/"]);

    
    def imagesMap = new HashMap()
    JRExporter exporter = reportWriter.getExporter();
    exporter.setParameters([(net.sf.jasperreports.engine.export.JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN):false, (JRHtmlExporterParameter.IMAGES_URI): "${request.contextPath}/reports/image/"]);
    exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
    exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath() + "/reports/image/?image=");
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);

    session.setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jp);
    session.setAttribute("net.sf.jasperreports.j2ee.jasper_print", jp);

    if (period.outputType != ReportOutputType.HTML) {
      response.setContentType(period.outputType.contentType)
    }
    reportWriter.writeTo(response);

  }

  private buildBalkReport(drb, reportParams, startDate, endDate) {

    reportParams["report_name"] = "Storitz Balk Report"
    reportParams["footer_text"] = "User Balk Report"
    reportParams["report_dates"] = "${reportParams['date_range']}"

    drb.addField("contactPrimary.firstName", String.class.getName())
    drb.addField("contactPrimary.lastName", String.class.getName())
    drb.addField("contactPrimary.suffixName", String.class.getName())
    drb.addField("unitType", UnitType.class.getName())

    SimpleColumn columnDate = ColumnBuilder.getInstance().
      setColumnProperty("bookingDate", Date.class.getName()).
      setTitle("Date").setWidth(30).build()

    SimpleColumn columnSite = ColumnBuilder.getInstance().
      setColumnProperty("site.title", String.class.getName()).
      setTitle("Site").setWidth(35).build()

    AbstractColumn columnName = ColumnBuilder.getInstance().setCustomExpression(new NameExpression())
      .setTitle("Customer").setHeaderStyle(headerStyle).setWidth(32).build();

    SimpleColumn columnEmail = ColumnBuilder.getInstance().
      setColumnProperty("contactPrimary.email", String.class.getName()).
      setTitle("Email").setWidth(45).build()

    SimpleColumn columnSize = ColumnBuilder.getInstance().
      setColumnProperty("searchSize.description", String.class.getName()).
      setTitle("Unit Size").setWidth(15).build()

    AbstractColumn columnUnitType = ColumnBuilder.getInstance().setCustomExpression(new UnitTypeExpression())
      .setTitle("Unit Type").setHeaderStyle(headerStyle).setWidth(15).build();

    drb.addColumn(columnDate)
      .addColumn(columnSite)
      .addColumn(columnName)
      .addColumn(columnEmail)
      .addColumn(columnSize)
      .addColumn(columnUnitType)

    def c = RentalTransaction.createCriteria()

    def results = c.list() {
      eq('status', TransactionStatus.BEGUN)
      between('bookingDate', startDate.time, endDate.time)
      order('bookingDate', 'desc')
    }
    return results
  }

  private buildSiteReport(drb, reportParams, startDate, endDate, period) {

    def dateField
    def dateName
    def transTitle
    def results

    def c = RentalTransaction.createCriteria()

    switch(period.reportName) {
      case ReportName.ACTIVITY:
        if (period.site.transactionType == TransactionType.RESERVATION) {
          reportParams["report_name"] = "Reservation Activity Report - ${period.site.title}"
        } else {
          reportParams["report_name"] = "Activity Report - ${period.site.title}"
        }
        reportParams["footer_text"] = ""
        reportParams["report_dates"] = "${reportParams['date_range']}"
        dateField = "bookingDate"
        dateName = "Transaction Date"
        transTitle = "Trans #"

        results = c.list() {
          or {
            eq('status', TransactionStatus.COMPLETE)
            eq('status', TransactionStatus.PAID)
          }
          site{
            eq('id', period.site.id)
          }
          between('bookingDate', startDate.time, endDate.time)
          order('bookingDate', 'desc')
        }
        break

      case ReportName.PENDING:
        if (period.site.transactionType == TransactionType.RESERVATION) {
          reportParams["report_name"] = "Pending Reservations Report - ${period.site.title}"
        } else {
          reportParams["report_name"] = "Pending Move In Report - ${period.site.title}"
        }
        reportParams["footer_text"] = ""
        reportParams["report_dates"] = "${reportParams['date_range']}"
        dateField = "moveInDate"
        dateName = "Move-In Date"
        transTitle = "Reservation #"

        results = c.list() {
          or {
            eq('status', TransactionStatus.COMPLETE)
            eq('status', TransactionStatus.PAID)
          }
          site{
            eq('id', period.site.id)
          }
          between('bookingDate', startDate.time, endDate.time)
          gt('moveInDate', new Date())
          order('moveInDate', 'desc')
        }
        break

      case ReportName.MOVEIN:
        if (period.site.transactionType == TransactionType.RESERVATION) {
          reportParams["report_name"] = "Reservations Report - ${period.site.title}"
        } else {
          reportParams["report_name"] = "Move In Report - ${period.site.title}"
        }
        reportParams["footer_text"] = ""
        reportParams["report_dates"] = "${reportParams['date_range']}"
        dateField = "moveInDate"
        dateName = "Move-In Date"
        transTitle = "Trans #"

        results = c.list() {
          or {
            eq('status', TransactionStatus.COMPLETE)
            eq('status', TransactionStatus.PAID)
          }
          site{
            eq('id', period.site.id)
          }
          between('moveInDate', startDate.time, endDate.time)
          order('moveInDate', 'desc')
        }
        break

    }

    drb
      .setGrandTotalLegend("Grand Total")
      .setGrandTotalLegendStyle(subtotalStyle)
      .setPrintColumnNames(false)

    drb.addField("contactPrimary.firstName", String.class.getName())
    drb.addField("contactPrimary.lastName", String.class.getName())
    drb.addField("contactPrimary.suffixName", String.class.getName())
    drb.addField("bookingDate", Date.class.getName())
    drb.addField("moveInDate", Date.class.getName())
    drb.addField("reserved", Boolean.class.getName())
    drb.addField("reservationId", String.class.getName())
    drb.addField("idNumber", String.class.getName())


    AbstractColumn columnDate = ColumnBuilder.getInstance().setCustomExpression(new DateExpression(dateField))
            .setTitle(dateName).setWidth(85).setStyle(groupHeaderStyle).setHeaderStyle(groupHeaderStyle).build();

    AbstractColumn columnMoveInDate = ColumnBuilder.getInstance().setCustomExpression(new DateExpression('moveInDate'))
            .setTitle(period.site.transactionType == TransactionType.RESERVATION ? "Reserved Move-In Date": "Move-In Date").setStyle(detailCenterStyle).setHeaderStyle(headerStyle).build();

    SimpleColumn columnUnitNumber = ColumnBuilder.getInstance().
      setColumnProperty("feedUnitNumber", String.class.getName()).setStyle(detailCenterStyle).setTitle("Unit #").build()

    AbstractColumn columnReservationId = ColumnBuilder.getInstance().setCustomExpression(new ReservationIdExpression())
            .setTitle(transTitle).setStyle(detailCenterStyle).setHeaderStyle(headerStyle).build();

    AbstractColumn columnName = ColumnBuilder.getInstance().setCustomExpression(new NameExpression())
            .setTitle("Customer").setHeaderStyle(headerStyle).build();

    SimpleColumn columnEmail = ColumnBuilder.getInstance().
      setColumnProperty("contactPrimary.email", String.class.getName()).
      setTitle("Email").setWidth(85).build()

    SimpleColumn columnPhone = ColumnBuilder.getInstance().
      setColumnProperty("contactPrimary.phone", String.class.getName()).
      setTitle("Phone").setWidth(60).build()

    SimpleColumn columnMonthly = ColumnBuilder.getInstance().
      setColumnProperty("monthlyRate", BigDecimal.class.getName()).
      setTitle("Monthly Rent").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnGross = ColumnBuilder.getInstance().
      setColumnProperty("moveInCost", BigDecimal.class.getName()).
      setTitle("Gross").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnInsurance = ColumnBuilder.getInstance().
      setColumnProperty("insuranceCost", BigDecimal.class.getName()).
      setTitle("Insurance").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnFees = ColumnBuilder.getInstance().
      setColumnProperty("fees", BigDecimal.class.getName()).
      setTitle("Fees").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnTax = ColumnBuilder.getInstance().
      setColumnProperty("tax", BigDecimal.class.getName()).
      setTitle("Taxes").setStyle(moneyStyle).setPattern("\$0.00").build()

    drb
            .addGlobalFooterVariable(columnGross, DJCalculation.SUM, moneyTotalStyle)
            .addGlobalFooterVariable(columnInsurance, DJCalculation.SUM, moneyTotalStyle)
            .addGlobalFooterVariable(columnFees, DJCalculation.SUM, moneyTotalStyle)
            .addGlobalFooterVariable(columnTax, DJCalculation.SUM, moneyTotalStyle)

	drb.setGlobalFooterVariableHeight(new Integer(25));

    GroupBuilder gb1 = new GroupBuilder();

    DJGroupLabel dailySubLabel = new DJGroupLabel("Daily Subtotal", subtotalStyle, LabelPosition.LEFT);

    DJGroup g1 = gb1.setCriteriaColumn((PropertyColumn) columnDate)
                .setFooterLabel(dailySubLabel)
                .setFooterVariablesHeight(new Integer(30))
                .addFooterVariable(columnGross, DJCalculation.SUM, moneyTotalStyle)
                .addFooterVariable(columnInsurance, DJCalculation.SUM, moneyTotalStyle)
                .addFooterVariable(columnFees, DJCalculation.SUM, moneyTotalStyle)
                .addFooterVariable(columnTax, DJCalculation.SUM, moneyTotalStyle)
                .setGroupLayout(GroupLayout.VALUE_IN_HEADER_WITH_HEADERS_AND_COLUMN_NAME)
                .build();

    drb.addColumn(columnDate)
      .addColumn(columnUnitNumber)
      .addColumn(columnReservationId)

    if (period.reportName == ReportName.ACTIVITY) {
      drb.addColumn(columnMoveInDate)
    }

    drb
      .addColumn(columnName)
      .addColumn(columnEmail)
      .addColumn(columnPhone)
      .addColumn(columnMonthly)
      .addColumn(columnGross)
      .addColumn(columnInsurance)
      .addColumn(columnFees)
      .addColumn(columnTax)
      .addGroup(g1)

    return results
  }

  private buildCorpTransactionReport(drb, reportParams, startDate, endDate, period) {

    def dateField
    def transTitle
    def results

    def c = RentalTransaction.createCriteria()

    if (period.site.transactionType == TransactionType.RESERVATION) {
      reportParams["report_name"] = "Reservation Transaction History Report - ${period.feed.operatorName}"
    } else {
      reportParams["report_name"] = "Transaction History Report - ${period.feed.operatorName}"
    }
    reportParams["footer_text"] = ""
    reportParams["report_dates"] = "${reportParams['date_range']}"
    dateField = "bookingDate"

    Feed reportFeed = Feed.get(period.feed.id)
    switch(reportFeed.feedType) {
      case FeedType.CENTERSHIFT:
        transTitle = "Centershift Trans #"
        break

      case FeedType.SITELINK:
        transTitle = "SiteLink Trans #"
        break

      default:
        transTitle = "Trans #"
    }

    results = c.list() {
      or {
        eq('status', TransactionStatus.COMPLETE)
        eq('status', TransactionStatus.PAID)
      }
      site{
        feed {
          eq('id', period.feed.id)
        }
      }
      between('bookingDate', startDate.time, endDate.time)
      order('bookingDate', 'desc')
    }

    drb
      .setGrandTotalLegend("Grand Total")
      .setGrandTotalLegendStyle(subtotalStyle)
      .setPrintColumnNames(false)

    drb.addField("contactPrimary.firstName", String.class.getName())
    drb.addField("contactPrimary.lastName", String.class.getName())
    drb.addField("contactPrimary.suffixName", String.class.getName())
    drb.addField("site.bankAccount.acctNo", String.class.getName())
    drb.addField("bookingDate", Date.class.getName())
    drb.addField("moveInDate", Date.class.getName())
    drb.addField("paidThruDate", Date.class.getName())
    drb.addField("reserved", Boolean.class.getName())
    drb.addField("reservationId", String.class.getName())
    drb.addField("idNumber", String.class.getName())


    SimpleColumn columnSite = ColumnBuilder.getInstance().
      setColumnProperty("site.title", String.class.getName()).
      setTitle("Facility Name:").setStyle(groupHeaderStyle).setHeaderStyle(facilityHeaderStyle).build()

    AbstractColumn columnDate = ColumnBuilder.getInstance().setCustomExpression(new DateExpression(dateField))
            .setTitle(period.site.transactionType == TransactionType.RESERVATION ? "Reservation Date" : "Transaction Date").setStyle(dateHeaderStyle).setHeaderStyle(headerStyle).build();

    AbstractColumn columnMoveInDate = ColumnBuilder.getInstance().setCustomExpression(new DateExpression('moveInDate'))
            .setTitle("Move-In Date").setHeaderStyle(headerStyle).build();

    AbstractColumn columnPaidThruDate = ColumnBuilder.getInstance().setCustomExpression(new DateExpression('paidThruDate'))
            .setTitle("Paid Through").setHeaderStyle(headerStyle).build();

    SimpleColumn columnUnitNumber = ColumnBuilder.getInstance().
      setColumnProperty("feedUnitNumber", String.class.getName()).setStyle(detailCenterStyle).setTitle("Unit #").build()

    AbstractColumn columnReservationId = ColumnBuilder.getInstance().setCustomExpression(new ReservationIdExpression())
            .setTitle(transTitle).setHeaderStyle(headerStyle).build();

    AbstractColumn columnName = ColumnBuilder.getInstance().setCustomExpression(new NameExpression())
            .setTitle("Tenant Name").setHeaderStyle(headerStyle).build();

    SimpleColumn columnPromo = ColumnBuilder.getInstance().
      setColumnProperty("promoName", String.class.getName()).
      setTitle("Promo Name").build()

    SimpleColumn columnMonthly = ColumnBuilder.getInstance().
      setColumnProperty("monthlyRate", BigDecimal.class.getName()).
      setTitle("Monthly Rent").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnGross = ColumnBuilder.getInstance().
      setColumnProperty("cost", BigDecimal.class.getName()).
      setTitle("Move-In Gross").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnInsurance = ColumnBuilder.getInstance().
      setColumnProperty("insuranceCost", BigDecimal.class.getName()).
      setTitle("Insurance").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnFees = ColumnBuilder.getInstance().
      setColumnProperty("fees", BigDecimal.class.getName()).
      setTitle("Fees").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnTax = ColumnBuilder.getInstance().
      setColumnProperty("tax", BigDecimal.class.getName()).
      setTitle("Taxes").setStyle(moneyStyle).setPattern("\$0.00").build()

    drb
            .addGlobalFooterVariable(columnGross, DJCalculation.SUM, moneyTotalStyle)
            .addGlobalFooterVariable(columnInsurance, DJCalculation.SUM, moneyTotalStyle)
            .addGlobalFooterVariable(columnFees, DJCalculation.SUM, moneyTotalStyle)
            .addGlobalFooterVariable(columnTax, DJCalculation.SUM, moneyTotalStyle)

  	drb.setGlobalFooterVariableHeight(new Integer(25));

    GroupBuilder gb1 = new GroupBuilder();

    DJGroupLabel dailySubLabel = new DJGroupLabel("Daily Subtotal", subtotalStyle, LabelPosition.LEFT);

    DJGroup g1 = gb1.setCriteriaColumn((PropertyColumn) columnDate)
                .setFooterLabel(dailySubLabel)
                .setDefaultFooterVariableStyle(moneyTotalStyle)
                .setFooterVariablesHeight(new Integer(30))
                .addFooterVariable(columnGross, DJCalculation.SUM, moneyTotalStyle)
                .addFooterVariable(columnInsurance, DJCalculation.SUM, moneyTotalStyle)
                .addFooterVariable(columnFees, DJCalculation.SUM, moneyTotalStyle)
                .addFooterVariable(columnTax, DJCalculation.SUM, moneyTotalStyle)
                .setGroupLayout(GroupLayout.DEFAULT)
                .build();

    GroupBuilder gb2 = new GroupBuilder();

    DJGroup g2 = gb2.setCriteriaColumn((PropertyColumn) columnSite)
                .setGroupLayout(GroupLayout.VALUE_IN_HEADER_WITH_HEADERS_AND_COLUMN_NAME)
                .setHeaderHeight(new Integer(30))
                .build();

    drb
      .addColumn(columnSite)
      .addColumn(columnDate)
      .addColumn(columnUnitNumber)
      .addColumn(columnMonthly)
      .addColumn(columnReservationId)
      .addColumn(columnName)
      .addColumn(columnMoveInDate)
      .addColumn(columnPaidThruDate)
      .addColumn(columnGross)
      .addColumn(columnInsurance)
      .addColumn(columnFees)
      .addColumn(columnTax)
      .addColumn(columnPromo)
      .addGroup(g2)
      .addGroup(g1)

    return results
  }

  private buildCorpPaymentReport(drb, reportParams, startDate, endDate, period) {

    def dateField
    def transTitle
    def results

    def c = RentalTransaction.createCriteria()

    reportParams["report_name"] = "Commission Report - ${period.feed.operatorName}"
    reportParams["footer_text"] = ""
    reportParams["report_dates"] = "${reportParams['date_range']}"
    dateField = "bookingDate"

    Feed reportFeed = Feed.get(period.feed.id)
    switch(reportFeed.feedType) {
      case FeedType.CENTERSHIFT:
        transTitle = "Centershift Trans #"
        break

      case FeedType.SITELINK:
        transTitle = "SiteLink Trans #"
        break

      default:
        transTitle = "Trans #"
    }

    results = c.list() {
      or {
        eq('status', TransactionStatus.COMPLETE)
        eq('status', TransactionStatus.PAID)
      }
      site{
        feed {
          eq('id', period.feed.id)
        }
      }
      between('bookingDate', startDate.time, endDate.time)
      order('bookingDate', 'desc')
    }

    drb
      .setGrandTotalLegend("Grand Total")
      .setGrandTotalLegendStyle(subtotalStyle)
      .setPrintColumnNames(false)

    drb.addField("site.bankAccount.acctNo", String.class.getName())
    drb.addField("bookingDate", Date.class.getName())
    drb.addField("achTransferDate", Date.class.getName())
    drb.addField("reserved", Boolean.class.getName())
    drb.addField("reservationId", String.class.getName())
    drb.addField("idNumber", String.class.getName())
    drb.addField("invoice.invoiceId", String.class.getName())
    drb.addField("site.netCommission", Boolean.class.getName())


    SimpleColumn columnSite = ColumnBuilder.getInstance().
      setColumnProperty("site.title", String.class.getName()).
      setTitle("Facility Name:").setStyle(groupHeaderStyle).setHeaderStyle(facilityHeaderStyle).build()

    AbstractColumn columnDate = ColumnBuilder.getInstance().setCustomExpression(new DateExpression(dateField))
            .setTitle("Transaction Date").setStyle(dateHeaderStyle).setHeaderStyle(headerStyle).build();

    AbstractColumn columnAchDate = ColumnBuilder.getInstance().setCustomExpression(new DateExpression('achTransferDate'))
            .setTitle("ACH Date").setStyle(detailCenterStyle).setHeaderStyle(headerStyle).build();

    AbstractColumn columnAchAccount = ColumnBuilder.getInstance().setCustomExpression(new AccountExpression('site.bankAccount.acctNo'))
            .setTitle("ACH Account").setHeaderStyle(headerStyle).build();

    SimpleColumn columnUnitNumber = ColumnBuilder.getInstance().
      setColumnProperty("feedUnitNumber", String.class.getName()).setStyle(detailCenterStyle).setTitle("Unit #").build()

    AbstractColumn columnReservationId = ColumnBuilder.getInstance().setCustomExpression(new ReservationIdExpression())
            .setTitle(transTitle).setHeaderStyle(headerStyle).build();

    AbstractColumn columnPaymentType = ColumnBuilder.getInstance().setCustomExpression(new PaymentTypeExpression())
            .setTitle("Net/Gross Transfer").setStyle(detailCenterStyle).setHeaderStyle(headerStyle).build();

    AbstractColumn columnInvoiceNumber = ColumnBuilder.getInstance().setCustomExpression(new InvoiceNumberExpression())
            .setTitle("Storitz Invoice #").setStyle(detailCenterStyle).setHeaderStyle(headerStyle).build();

    SimpleColumn columnStoritzId = ColumnBuilder.getInstance().
      setColumnProperty("id", String.class.getName()).setStyle(detailCenterStyle).setTitle("Storitz Trans#").build()

    SimpleColumn columnGross = ColumnBuilder.getInstance().
      setColumnProperty("cost", BigDecimal.class.getName()).
      setTitle("Move-In Cost").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnCommission = ColumnBuilder.getInstance().
      setColumnProperty("commission", BigDecimal.class.getName()).
      setTitle("Commission").setStyle(moneyStyle).setPattern("\$0.00").build()

    SimpleColumn columnAchAmount = ColumnBuilder.getInstance().
      setColumnProperty("achAmount", BigDecimal.class.getName()).
      setTitle("ACH Amount (if applicable)").setWidth(new Integer(55)).setStyle(moneyStyle).setPattern("\$0.00").build()

    AbstractColumn columnNet = ColumnBuilder.getInstance().setCustomExpression(new NetCostExpression())
            .setTitle("Net").setStyle(moneyStyle).setHeaderStyle(headerStyle).setPattern("\$0.00").build();

    drb.addGlobalFooterVariable(columnGross, DJCalculation.SUM, moneyTotalStyle);
	drb.addGlobalFooterVariable(columnCommission, DJCalculation.SUM, moneyTotalStyle);
	drb.addGlobalFooterVariable(columnNet, DJCalculation.SUM, moneyTotalStyle);
    drb.addGlobalFooterVariable(columnAchAmount, DJCalculation.SUM, moneyTotalStyle);
	drb.setGlobalFooterVariableHeight(new Integer(25));

    GroupBuilder gb1 = new GroupBuilder();

    DJGroupLabel dailySubLabel = new DJGroupLabel("Daily Subtotal", subtotalStyle, LabelPosition.LEFT);

    DJGroup g1 = gb1.setCriteriaColumn((PropertyColumn) columnDate)
                .setFooterLabel(dailySubLabel)
                .setFooterVariablesHeight(new Integer(30))
                .addFooterVariable(columnGross, DJCalculation.SUM, moneyTotalStyle)
                .addFooterVariable(columnCommission, DJCalculation.SUM, moneyTotalStyle)
                .addFooterVariable(columnNet, DJCalculation.SUM, moneyTotalStyle)
                .setGroupLayout(GroupLayout.DEFAULT)
                .build();

    GroupBuilder gb2 = new GroupBuilder();

    DJGroup g2 = gb2.setCriteriaColumn((PropertyColumn) columnSite)
                .setGroupLayout(GroupLayout.VALUE_IN_HEADER_WITH_HEADERS_AND_COLUMN_NAME)
                .build();

    drb
      .addColumn(columnSite)
      .addColumn(columnDate)
      .addColumn(columnUnitNumber)
      .addColumn(columnStoritzId)
      .addColumn(columnReservationId)
      .addColumn(columnGross)
      .addColumn(columnCommission)
      .addColumn(columnNet)
      .addColumn(columnPaymentType)
      .addColumn(columnInvoiceNumber)
      .addColumn(columnAchAmount)
      .addColumn(columnAchDate)
      .addColumn(columnAchAccount)
      .addGroup(g2)
      .addGroup(g1)

    return results
  }

  private buildInvoice(drb, reportParams, startDate, endDate, period) {
    def results = buildCorpPaymentReport(drb, reportParams, startDate, endDate, period)

    reportParams["report_name"] = "Storitz Invoice - ${period.feed.operatorName}"
    reportParams["invoice_num"] = "${startDate.format('MM-yyyy')}-${period.feed.id}"
    reportParams["addr1"] = "${period.feed.operatorName}"
    reportParams["addr2"] = "${period.feed.address1}"
    reportParams["addr3"] = "${period.feed.city}, ${period.feed.state?.display} ${period.feed.zipcode}"
    reportParams["invoice_total"] = "${g.formatNumber(number:results.sum{ it.commission }, type:'currency', currencyCode:'USD')}"
    reportParams
    drb.setTemplateFile(request.getRealPath('/WEB-INF/reports/storitz_invoice_template.jrxml'))

    return results
  }

  /*
      Below method pulled from the DjReportController
      They allow this controller to use the styles defined in:
      DynamicJasperConfig.groovy
   */
  private ConfigObject loadConfig() {
      def config = ConfigurationHolder.config
      GroovyClassLoader classLoader = new GroovyClassLoader(getClass().classLoader)
      config.merge(new ConfigSlurper(GrailsUtil.environment).parse(classLoader.loadClass('DefaultDynamicJasperConfig')))
      try {
          config.merge(new ConfigSlurper(GrailsUtil.environment).parse(classLoader.loadClass('DynamicJasperConfig')))
      } catch (Exception ignored) {
          // ignore, just use the defaults
      }
      return new ConfigSlurper(GrailsUtil.environment).parse(new Properties()).merge(config.dynamicJasper)
  }

}
