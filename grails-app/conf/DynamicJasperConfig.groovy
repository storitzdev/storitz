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

    titleStyle {
        font = new Font(18, Font._FONT_VERDANA, false)
        textColor = Color.white
        border = Border.NO_BORDER
        borderColor = new Color(5, 109, 186)
        horizontalAlign = HorizontalAlign.LEFT
        verticalAlign = VerticalAlign.MIDDLE
        backgroundColor = new Color(5, 109, 186)
        transparency = Transparency.OPAQUE
        transparent = false
        blankWhenNull = true
        padding = 2
        pattern = ''
        radius = 1
        rotation = Rotation.NONE
        stretching = Stretching.NO_STRETCH
        stretchWithOverflow = false
    }

    subtitleStyle {
        textColor = new Color(5, 109, 186)
        backgroundColor = Color.white
    }

    headerStyle {
        font = Font.ARIAL_MEDIUM_BOLD
        textColor = Color.white
        border = Border.NO_BORDER
        borderColor = new Color(5, 109, 186)
        horizontalAlign = HorizontalAlign.CENTER
        verticalAlign = VerticalAlign.MIDDLE
        backgroundColor = new Color(5, 109, 186)
        transparency = Transparency.OPAQUE
        transparent = false
        blankWhenNull = true
        padding = 2
        pattern = ''
        rotation = Rotation.NONE
        stretching = Stretching.NO_STRETCH
        stretchWithOverflow = false
    }

    detailStyle {
        font = Font.ARIAL_MEDIUM
        textColor = Color.black
        borderTop = Border.NO_BORDER
        borderBottom = Border.THIN
        borderLeft = Border.NO_BORDER
        borderRight = Border.NO_BORDER
        borderColor = Color.black
        horizontalAlign = HorizontalAlign.LEFT
        verticalAlign = VerticalAlign.MIDDLE
        backgroundColor = Color.white
        transparency = Transparency.OPAQUE
        //transparent = false
        blankWhenNull = true
        rotation = Rotation.NONE
        stretching = Stretching.NO_STRETCH
        stretchWithOverflow = false
    }

}