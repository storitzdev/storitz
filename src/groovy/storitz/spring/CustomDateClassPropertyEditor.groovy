package storitz.spring

import java.beans.PropertyEditorSupport
import java.text.SimpleDateFormat

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Jul 6, 2010
 * Time: 9:19:06 PM
 * To change this template use File | Settings | File Templates.
 */
class CustomDateClassPropertyEditor extends PropertyEditorSupport {

  def formatList = []

  CustomDateClassPropertyEditor(formatStrings) {
    formatStrings.each{ formatList.add(new SimpleDateFormat(it)) }
  }

  def String getAsText() {
    return this.value.toString()
  }

  def void setAsText(String s) {
    formatList.each {
      try {
        this.value = it.parse(s);
        return
      } catch (e) {
        // ignore
      }
    }
  }
}
