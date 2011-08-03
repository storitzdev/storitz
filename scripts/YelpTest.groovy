package storitz

import com.storitz.StorageSite
import com.storitz.StoritzUtil
import com.storitz.yelp.Yelp
import com.storitz.yelp.YelpReview
import java.text.SimpleDateFormat
import com.storitz.*
import grails.converters.JSON

/* Script for generating yelp review comparisons */

try {
  def storageSites = StorageSite.findAllByDisabled(0);
  def random = new Random();
  int max = storageSites.size();
  int counter = 0;
  def siteList = [ ];
    while (siteList.size() < 10) {
      int temp = random.nextInt(max+1);
      StorageSite site = storageSites[temp];
      Yelp yelp = Yelp.newInstance(); //start the yelp request (local search)
      def request = yelp.search(site.lat, site.lng, "")
      def searchResponse = JSON.parse(request)
      def bizTotal = searchResponse.total
      println(bizTotal);
    }
  println("done.");
}
catch (Exception e) {
    println("ERROR:")
    e.printStackTrace()
}