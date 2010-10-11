package storitz.spring

import java.beans.PropertyEditorSupport
import storitz.constants.Country
import storitz.constants.State

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Jun 27, 2010
 * Time: 4:55:37 PM
 * To change this template use File | Settings | File Templates.
 */
class StateClassPropertyEditor extends PropertyEditorSupport {

  String getAsText() {
    return ((State)value).key
  }

  void setAsText(String text) {
    value = State.fromText(text)
  }
}
