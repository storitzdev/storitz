import ar.com.fdvs.dj.domain.constants.Font
import ar.com.fdvs.dj.domain.constants.Border
import java.awt.Color
import ar.com.fdvs.dj.domain.constants.Transparency
import ar.com.fdvs.dj.domain.constants.HorizontalAlign
import ar.com.fdvs.dj.domain.constants.VerticalAlign
import ar.com.fdvs.dj.domain.constants.Rotation
import ar.com.fdvs.dj.domain.constants.Stretching
import ar.com.fdvs.dj.domain.constants.Page

dynamicJasper {

    useFullPageWidth = true

    page = Page.Page_Letter_Landscape()

    isUsingImagesToAlign = true

    intPattern = '#0'
    floatPattern = '#0.00'
    datePattern = 'dd/MM/yyyy'

}