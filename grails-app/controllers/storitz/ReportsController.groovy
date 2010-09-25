package storitz

import ar.com.fdvs.dj.domain.builders.FastReportBuilder
import ar.com.fdvs.dj.domain.entities.columns.SimpleColumn
import ar.com.fdvs.dj.domain.builders.ColumnBuilder
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn
import ar.com.fdvs.dj.domain.CustomExpression
import storitz.reports.NameExpression
import ar.com.fdvs.dj.domain.DynamicReport
import com.storitz.RentalTransaction
import storitz.constants.TransactionStatus
import ar.com.fdvs.dj.output.ReportWriterFactory
import ar.com.fdvs.dj.output.ReportWriter
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager
import ar.com.fdvs.dj.core.DynamicJasperHelper
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.JRDataSource
import grails.util.GrailsUtil
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import ar.com.fdvs.dj.domain.Style
import grails.plugins.springsecurity.Secured
import ar.com.fdvs.dj.domain.ImageBanner
import ar.com.fdvs.dj.domain.constants.ImageScaleMode
import ar.com.fdvs.dj.domain.AutoText

class ReportsController {

    def fileUploadService

    def index = { }

    @Secured(['ROLE_ADMIN'])
    def balk = {
      FastReportBuilder drb = new FastReportBuilder();
      def config = loadConfig()

      Style titleStyle = getStyle(config.titleStyle)
      Style subtitleStyle = getStyle(config.subtitleStyle)
      Style headerStyle = getStyle(config.headerStyle)
      Style detailStyle = getStyle(config.detailStyle)

       drb.setTitle("Customer Balk Report")                                      //defines the title of the report
                .setSubtitle("Customers who fill out the form but leave before making payment")
                .setDetailHeight(15)                                            //defines the height for each record of the report
                .setMargins(30, 20, 30, 15)                                                     //define the margin space for each side (top, bottom, left and right)
                .setDefaultStyles(titleStyle, subtitleStyle, headerStyle, detailStyle)
                .setColumnsPerPage(1)
                .addFirstPageImageBanner(fileUploadService.getAbsolutePath("/images", "logo_storitz_small.gif"), new Integer(200), new Integer(50), ImageBanner.ALIGN_LEFT)
                .addImageBanner(fileUploadService.getAbsolutePath("/images", "logo_storitz_small.gif"), new Integer(100), new Integer(25), ImageBanner.ALIGN_LEFT)
                .setPrintBackgroundOnOddRows(true)
                .setUseFullPageWidth(true)

      // Footer definition
      drb.addAutoText(AutoText.AUTOTEXT_CREATED_ON, AutoText.POSITION_FOOTER, AutoText.ALIGMENT_LEFT, AutoText.PATTERN_DATE_DATE_ONLY)
      drb.addAutoText(AutoText.AUTOTEXT_PAGE_X, AutoText.POSITION_FOOTER, AutoText.ALIGMENT_RIGHT)

      SimpleColumn columnDate = ColumnBuilder.getInstance().
        setColumnProperty("bookingDate", Date.class.getName()).
        setTitle("Date").setWidth(30).build()

      SimpleColumn columnSite = ColumnBuilder.getInstance().
        setColumnProperty("site.title", String.class.getName()).
        setTitle("Site").setWidth(35).build()

      drb.addField("contactPrimary.firstName", String.class.getName())
      drb.addField("contactPrimary.lastName", String.class.getName())
      drb.addField("contactPrimary.suffixName", String.class.getName())      

      AbstractColumn columnName = ColumnBuilder.getInstance().setCustomExpression(new NameExpression())
              .setTitle("Customer").setHeaderStyle(headerStyle).setWidth(32).build();

      SimpleColumn columnEmail = ColumnBuilder.getInstance().
        setColumnProperty("contactPrimary.email", String.class.getName()).
        setTitle("Email").setWidth(45).build()

      SimpleColumn columnSize = ColumnBuilder.getInstance().
        setColumnProperty("searchSize.display", String.class.getName()).
        setTitle("Unit Size").setWidth(15).build()

      SimpleColumn columnUnitType = ColumnBuilder.getInstance().
        setColumnProperty("unitType", String.class.getName()).
        setTitle("Unit Type").setWidth(15).build()

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
        order('bookingDate', 'desc')
      }

      JRDataSource ds = new JRBeanCollectionDataSource(results);   
      JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
      ReportWriter reportWriter = ReportWriterFactory.getInstance().getReportWriter(jp, 'PDF', [:]);
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
      //style.transparent = styleConfig.transparent
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
