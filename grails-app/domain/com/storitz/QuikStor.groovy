package com.storitz

class QuikStor extends Feed {

  static hasMany = [locations: QuikStorLocation]

  String url = "https://ecom.quikstor.com:443/eCom3ServiceSS/QuikStorWebServiceSS.asmx?WSDL"

  static mapping = {
    locations cascade: "all,delete-orphan"
  }

  static constraints = {
  }
}
