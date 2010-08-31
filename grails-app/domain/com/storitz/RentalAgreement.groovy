package com.storitz

class RentalAgreement {

    User agreementOwner
    String title
    String fileLocation
    String basename

    static constraints = {
      title(nullable:false)
      agreementOwner(nullable:true)
      fileLocation(nullable:true)
      basename(nullable:true)
    }



  def src() {
    return basename +  fileLocation
  }

}
