import storitz.constants.StreetType;
import storitz.constants.PhoneType;
import storitz.constants.State;
import storitz.constants.Country;

class Contact {

    String firstName
    String lastName
    String suffixName
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
      suffixName(nullable:true)
      unit(nullable:true)
      province(nullable:true)
      country(nullable:true)
    }

    static belongsTo = [rental:RentalTransaction]
}
