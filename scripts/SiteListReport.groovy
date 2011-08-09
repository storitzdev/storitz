package storitz

import com.storitz.StorageSite
import com.storitz.StoritzUtil
import com.storitz.*


try {
  def storageSites = StorageSite.findAllByDisabled(0)
  def max = storageSites.size()
  printf("%s \t %s \t %s \t %s \t %s \n", "PDP URL", "Property Name", "Street Address", "City", "Zip")
  for(int i=0; i < max; i++) {
    def pdpUrl = "http://www.storitz.com/self-storage-"+storageSites[i].siteTitle.replaceAll("-", "").replaceAll(/\s/, "-")+"/"+storageSites[i].id
    def propName = storageSites[i].feed.operatorName
    def address = storageSites[i].address
    def city = storageSites[i].city
    def zip = storageSites[i].zipcode
    printf("%s \t %s \t %s \t %s \t %s \n", pdpUrl, propName, address, city, zip)
  }
  println("Job Complete.")
}
catch (Exception e) {
  println("ERROR:" + e)
  println(e.stackTrace)
  e.printStackTrace()
}