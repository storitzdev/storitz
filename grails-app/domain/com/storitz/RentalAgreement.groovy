package com.storitz

class RentalAgreement {

    User owner
    String title
    String fileLocation
    String basename

    static constraints = {
      title(nullable:false)
      owner(nullable:true)
      fileLocation(nullable:true)
      basename(nullable:true)
    }



  def src() {
    return basename +  fileLocation
  }

}
