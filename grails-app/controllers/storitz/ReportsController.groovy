package storitz

import ar.com.fdvs.dj.core.DynamicJasperHelper
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager
import ar.com.fdvs.dj.domain.builders.ColumnBuilder
import ar.com.fdvs.dj.domain.builders.FastReportBuilder
import ar.com.fdvs.dj.domain.builders.GroupBuilder
import ar.com.fdvs.dj.domain.constants.Font
import ar.com.fdvs.dj.domain.constants.GroupLayout
import ar.com.fdvs.dj.domain.constants.HorizontalAlign
import ar.com.fdvs.dj.domain.constants.VerticalAlign
import ar.com.fdvs.dj.domain.entities.DJGroup
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn
import ar.com.fdvs.dj.domain.entities.columns.PropertyColumn
import ar.com.fdvs.dj.domain.entities.columns.SimpleColumn
import ar.com.fdvs.dj.output.ReportWriter
import ar.com.fdvs.dj.output.ReportWriterFactory
import ar.com.fdvs.dj.domain.builders.StyleBuilder
import com.storitz.RentalTransaction
import com.storitz.ReportPeriod
import grails.plugins.springsecurity.Secured
import grails.util.GrailsUtil
import java.awt.Color
import net.sf.jasperreports.engine.JRDataSource
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import storitz.constants.TransactionStatus
import storitz.reports.DateExpression
import storitz.reports.NameExpression
import storitz.reports.NetCostExpression
import storitz.reports.ReservationIdExpression
import ar.com.fdvs.dj.domain.*
import storitz.reports.UnitTypeExpression
import storitz.constants.UnitType
import ar.com.fdvs.dj.domain.constants.Border
import ar.com.fdvs.dj.domain.constants.LabelPosition
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter
import storitz.constants.ReportOutputType
import net.sf.jasperreports.engine.JRExporter
import net.sf.jasperreports.j2ee.servlets.ImageServlet
import net.sf.jasperreports.engine.JRExporterParameter

class ReportsController {

    def fileUploadService
    def springSecurityService

    static allowedMethods = [balk: "POST"]


    def index = { }

    GregorianCalendar startDate = new GregorianCalendar()
    GregorianCalendar endDate = new GregorianCalendar()

    @Secured(['ROLE_ADMIN'])
    def balk = {

      ReportPeriod period = new ReportPeriod(params)
      
      if (!period.validate()) {
        flash.message = "Bad report parameters - please re-enter dates and output type."
        redirect(action: "index", model: [reportPeriod: period])
      }

      startDate.setTime(Date.parse('MM/dd/yyyy', params.startDate))
      startDate.clearTime()
      endDate.setTime(Date.parse('MM/dd/yyyy', params.endDate) + 1)
      endDate.clearTime()


      FastReportBuilder drb = new FastReportBuilder();
      def config = loadConfig()

      Style titleStyle = getStyle(config.titleStyle)
      // MMA - there is something broken about subtitle background text and about getting the style from the config file
      Style subtitleStyle = new Style()
      subtitleStyle.setTextColor(new Color(5, 109, 186))
      subtitleStyle.setBackgroundColor(Color.white)
      subtitleStyle.setHorizontalAlign(HorizontalAlign.RIGHT)
      Style headerStyle = getStyle(config.headerStyle)
      Style detailStyle = getStyle(config.detailStyle)

      String subtitle = "From ${params.startDate} to ${params.endDate}"

       drb.setTitle("Customer Balk Report")                                      //defines the title of the report
         .setSubtitle(subtitle)
         .setDefaultStyles(titleStyle, subtitleStyle, headerStyle, detailStyle)
         .setDetailHeight(15)                                            //defines the height for each record of the report
         .setMargins(30, 20, 30, 15)                                                     //define the margin space for each side (top, bottom, left and right)
         .setColumnsPerPage(1)
         .addFirstPageImageBanner(fileUploadService.getAbsolutePath("/images", "logo_storitz_small.gif"), new Integer(200), new Integer(50), ImageBanner.ALIGN_LEFT)
         .addImageBanner(fileUploadService.getAbsolutePath("/images", "logo_storitz_small.gif"), new Integer(100), new Integer(25), ImageBanner.ALIGN_LEFT)
         .setPrintBackgroundOnOddRows(true)
         .setUseFullPageWidth(true)

      // Footer definition
      drb.addAutoText(AutoText.AUTOTEXT_CREATED_ON, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_LEFT, AutoText.PATTERN_DATE_DATE_ONLY, 120, 30)
      drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_RIGHT)

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

      DynamicReport dr = drb.build()

      def c = RentalTransaction.createCriteria()

      def results = c.list() {
        eq('status', TransactionStatus.BEGUN)
        between('bookingDate', startDate.time, endDate.time)
        order('bookingDate', 'desc')
      }

      JRDataSource ds = new JRBeanCollectionDataSource(results);   
      JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
      ReportWriter reportWriter = ReportWriterFactory.getInstance().getReportWriter(jp, period.outputType.getValue(), [:]);
      reportWriter.writeTo(response);
    }

  @Secured(['ROLE_USER','ROLE_MANAGER','ROLE_ADMIN'])
  def site = {

    ReportPeriod period = new ReportPeriod(params)

    if (!period.validate()) {
      flash.message = "Bad report parameters - please re-enter dates and output type."
      redirect(action: "index", model: [reportPeriod: period])
    }

    startDate.setTime(Date.parse('MM/dd/yyyy', params.startDate))
    startDate.clearTime()
    endDate.setTime(Date.parse('MM/dd/yyyy', params.endDate) + 1)
    endDate.clearTime()


    FastReportBuilder drb = new FastReportBuilder();
    def config = loadConfig()

    Style titleStyle = getStyle(config.titleStyle)
    // MMA - there is something broken about subtitle background text and about getting the style from the config file
    Style subtitleStyle = new Style()
    subtitleStyle.setTextColor(new Color(5, 109, 186))
    subtitleStyle.setBackgroundColor(Color.white)
    subtitleStyle.setHorizontalAlign(HorizontalAlign.RIGHT)
    Style headerStyle = getStyle(config.headerStyle)
    Style detailStyle = getStyle(config.detailStyle)

    Style headerVariables = new Style();
  	headerVariables.setFont(Font.ARIAL_MEDIUM_BOLD);
  	headerVariables.setHorizontalAlign(HorizontalAlign.RIGHT);
  	headerVariables.setVerticalAlign(VerticalAlign.MIDDLE);

    String subtitle = "From ${params.startDate} to ${params.endDate}"

     drb.setTitle("Site Activity Report")                                      //defines the title of the report
      .setSubtitle(subtitle)
      .setDefaultStyles(titleStyle, subtitleStyle, headerStyle, detailStyle)
      .setDetailHeight(15)                                            //defines the height for each record of the report
      .setMargins(30, 20, 30, 15)                                                     //define the margin space for each side (top, bottom, left and right)
      .setColumnsPerPage(1)
      .addFirstPageImageBanner(fileUploadService.getAbsolutePath("/images", "logo_storitz_small.gif"), new Integer(200), new Integer(50), ImageBanner.ALIGN_LEFT)
      .addImageBanner(fileUploadService.getAbsolutePath("/images", "logo_storitz_small.gif"), new Integer(100), new Integer(25), ImageBanner.ALIGN_LEFT)
      .setGrandTotalLegend("Grand Total")
      .setGrandTotalLegendStyle(headerVariables)
      .setPrintBackgroundOnOddRows(true)
      .setUseFullPageWidth(true)

    // Footer definition
    drb.addAutoText(AutoText.AUTOTEXT_CREATED_ON, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_LEFT, AutoText.PATTERN_DATE_DATE_ONLY, 120, 30)
    drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_RIGHT)

    drb.addField("contactPrimary.firstName", String.class.getName())
    drb.addField("contactPrimary.lastName", String.class.getName())
    drb.addField("contactPrimary.suffixName", String.class.getName())
    drb.addField("bookingDate", Date.class.getName())
    drb.addField("reserved", Boolean.class.getName())
    drb.addField("reservationId", String.class.getName())
    drb.addField("idNumber", String.class.getName())


    AbstractColumn columnDate = ColumnBuilder.getInstance().setCustomExpression(new DateExpression())
            .setTitle("Date").setHeaderStyle(headerStyle).setWidth(18).build();

    SimpleColumn columnUnitNumber = ColumnBuilder.getInstance().
      setColumnProperty("feedUnitNumber", String.class.getName()).
      setTitle("Unit #").setWidth(15).build()

    AbstractColumn columnReservationId = ColumnBuilder.getInstance().setCustomExpression(new ReservationIdExpression())
            .setTitle("Res #").setHeaderStyle(headerStyle).setWidth(22).build();

    AbstractColumn columnName = ColumnBuilder.getInstance().setCustomExpression(new NameExpression())
            .setTitle("Customer").setHeaderStyle(headerStyle).setWidth(32).build();

    SimpleColumn columnEmail = ColumnBuilder.getInstance().
      setColumnProperty("contactPrimary.email", String.class.getName()).
      setTitle("Email").setWidth(45).build()

    SimpleColumn columnPhone = ColumnBuilder.getInstance().
      setColumnProperty("contactPrimary.phone", String.class.getName()).
      setTitle("Phone").setWidth(25).build()

    SimpleColumn columnGross = ColumnBuilder.getInstance().
      setColumnProperty("cost", BigDecimal.class.getName()).
      setTitle("Gross").setPattern("\$ 0.00").setWidth(18).build()

    SimpleColumn columnCommission = ColumnBuilder.getInstance().
      setColumnProperty("commission", BigDecimal.class.getName()).
      setTitle("Commission").setPattern("\$ 0.00").setWidth(18).build()

    AbstractColumn columnNet = ColumnBuilder.getInstance().setCustomExpression(new NetCostExpression())
            .setTitle("Net").setHeaderStyle(headerStyle).setWidth(18).setPattern("\$ 0.00").build();

    drb.addGlobalFooterVariable(columnGross, DJCalculation.SUM,headerVariables);
	drb.addGlobalFooterVariable(columnCommission, DJCalculation.SUM,headerVariables);
	drb.addGlobalFooterVariable(columnNet, DJCalculation.SUM,headerVariables);
	drb.setGlobalFooterVariableHeight(new Integer(25));

    GroupBuilder gb1 = new GroupBuilder();

    Style dailyFooterStyle = new StyleBuilder(false).setFont(Font.ARIAL_SMALL)
 			.setHorizontalAlign(HorizontalAlign.RIGHT)
 			.setVerticalAlign(VerticalAlign.MIDDLE)
 			.setPadding(new Integer(0))
 			.setStretchWithOverflow(false)
 			.build();

    DJGroupLabel dailySubLabel = new DJGroupLabel("Daily Subtotal", dailyFooterStyle, LabelPosition.LEFT);

    DJGroup g1 = gb1.setCriteriaColumn((PropertyColumn) columnDate)
                .setFooterLabel(dailySubLabel)
                .setFooterVariablesHeight(new Integer(30))
                .addFooterVariable(columnGross, DJCalculation.SUM, headerVariables)
                .addFooterVariable(columnCommission, DJCalculation.SUM, headerVariables)
                .addFooterVariable(columnNet, DJCalculation.SUM, headerVariables)
                .setGroupLayout(GroupLayout.DEFAULT)
                .build();

    drb.addColumn(columnDate)
      .addColumn(columnUnitNumber)
      .addColumn(columnReservationId)
      .addColumn(columnName)
      .addColumn(columnEmail)
      .addColumn(columnPhone)
      .addColumn(columnGross)
      .addColumn(columnCommission)
      .addColumn(columnNet)
      .addGroup(g1)

    DynamicReport dr = drb.build()

    def c = RentalTransaction.createCriteria()

    def results = c.list() {
      or {
        eq('status', TransactionStatus.COMPLETE)
        eq('status', TransactionStatus.PAID)
      }
      between('bookingDate', startDate.time, endDate.time)
      order('bookingDate', 'desc')
    }

    JRDataSource ds = new JRBeanCollectionDataSource(results);
    JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
    ReportWriter reportWriter = ReportWriterFactory.getInstance().getReportWriter(jp, period.outputType.value,
            [(net.sf.jasperreports.engine.export.JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN):false, (JRHtmlExporterParameter.IMAGES_URI): "${request.contextPath}/reports/image/"]);

    def imagesMap = new HashMap()
    JRExporter exporter = reportWriter.getExporter();
    exporter.setParameters([(net.sf.jasperreports.engine.export.JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN):false, (JRHtmlExporterParameter.IMAGES_URI): "${request.contextPath}/reports/image/"]);
    exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
    exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath() + "/reports/image/?image=");
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);

    session.setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jp);
    session.setAttribute("net.sf.jasperreports.j2ee.jasper_print", jp);
    
    reportWriter.writeTo(response);

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

  def getStyle(def styleConfig) {
      def style = new Style()
      style.font = styleConfig.font
      if (styleConfig.border) {
          style.border = styleConfig.border
      } else {
          style.borderTop = styleConfig.borderTop
          style.borderBottom = styleConfig.borderBottom
          style.borderLeft = styleConfig.borderLeft
          style.borderRight = styleConfig.borderRight
      }
      style.backgroundColor = styleConfig.backgroundColor
      style.transparency = styleConfig.transparency
      style.textColor = styleConfig.textColor
      style.horizontalAlign = styleConfig.horizontalAlign
      style.verticalAlign = styleConfig.verticalAlign
      style.blankWhenNull = styleConfig.blankWhenNull
      style.borderColor = styleConfig.borderColor
      if (style.padding) {
          style.padding = styleConfig.padding
      } else {
          style.paddingTop = styleConfig.paddingTop
          style.paddingBotton = styleConfig.paddingBotton
          style.paddingLeft = styleConfig.paddingLeft
          style.paddingRight = styleConfig.paddingRight
      }
      //style.pattern = styleConfig.pattern
      style.radius = styleConfig.radius
      style.rotation = styleConfig.rotation
      //FIXME typo in DJ API
      //style.streching = styleConfig.stretching
      //style.stretchWithOverflow = styleConfig.stretchWithOverflow
      style
  }

}
