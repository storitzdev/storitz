package storitz.spring

import java.beans.PropertyEditorSupport
import storitz.constants.Country

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Jun 27, 2010
 * Time: 4:55:37 PM
 * To change this template use File | Settings | File Templates.
 */
class CountryClassPropertyEditor extends PropertyEditorSupport {

  String getAsText() {
    return ((Country) value).key
  }

  void setAsText(String text) {
    value = Country.fromText(text)
  }
}
