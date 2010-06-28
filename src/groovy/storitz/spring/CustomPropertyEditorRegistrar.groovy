package storitz.spring

import storitz.constants.Country

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Jun 27, 2010
 * Time: 11:29:02 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Date
import java.text.SimpleDateFormat
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
  public void registerCustomEditors(PropertyEditorRegistry registry) {
    registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true));
    registry.registerCustomEditor(Country, new CountryClassPropertyEditor())
   }
}




