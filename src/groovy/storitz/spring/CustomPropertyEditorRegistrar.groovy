package storitz.spring

import storitz.constants.Country
import grails.util.GrailsConfig;

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
import storitz.constants.State
import storitz.constants.CenterShiftVersion
import storitz.constants.CenterShiftLocations
import storitz.constants.CommissionSourceType
import storitz.constants.IdType
import storitz.constants.NotificationEventType
import storitz.constants.FeedType
import storitz.constants.CreditCardType
import storitz.constants.ContactType
import storitz.constants.CommissionType
import storitz.constants.UnitType
import storitz.constants.TruckType
import storitz.constants.TransactionStatus
import storitz.constants.StreetType
import storitz.constants.ReportOutputType
import storitz.constants.RentalUse
import storitz.constants.PromoType
import storitz.constants.PhoneType

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

  private static final String REQUIRED_METHOD_NAME = 'getEnumFromId'
  
  private static final BINDABLE_ENUMS = [CenterShiftLocations, CenterShiftVersion, CommissionSourceType, CommissionType, ContactType, CreditCardType, FeedType, IdType, NotificationEventType,
    PhoneType, PromoType, RentalUse, ReportOutputType, StreetType, TransactionStatus, TruckType, UnitType]

  public void registerCustomEditors(PropertyEditorRegistry registry) {
    registry.registerCustomEditor(Date.class, new CustomDateClassPropertyEditor(GrailsConfig.get("grails.date.formats", List.class)));
    registry.registerCustomEditor(Country, new CountryClassPropertyEditor())
    registry.registerCustomEditor(State, new CountryClassPropertyEditor())

    BINDABLE_ENUMS.each {enumClass ->
        registerEnum(registry, enumClass)
    }

   }

  /**
     * Register an enum to be bound by ID from a request parameter
     * @param registry Registry of types eligible for data binding
     * @param enumClass Class of the enum
     */
    private registerEnum(PropertyEditorRegistry registry, Class<? extends Enum<?>> enumClass) {

        boolean hasRequiredMethod = enumClass.metaClass.methods.any {MetaMethod method ->
            method.isStatic() && method.name == REQUIRED_METHOD_NAME && method.parameterTypes.size() == 1
        }

        if (!hasRequiredMethod) {
            throw new MissingMethodException(REQUIRED_METHOD_NAME, enumClass, [String].toArray())
        }
        registry.registerCustomEditor(enumClass, new EnumEditor(enumClass))
    }
}




