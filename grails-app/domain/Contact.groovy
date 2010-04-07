import storagetech.constants.StreetType;
import storagetech.constants.PhoneType;
import storagetech.constants.State;
import storagetech.constants.Country;

class Contact {

    String firstName
    String lastName
    String streetNumber
    String street
    StreetType streetType
    String unit
    String city
    State state
    String province
    String zipcode
    Country country
    String phone
    PhoneType phoneType
    String email

    static constraints = {
      email(email:true)
      zipcode(size:5..10)
      unit(nullable:true)
      province(nullable:true)
      country(nullable:true)
    }

    static belongsTo = [rental:RentalTransaction]
}