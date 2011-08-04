package storitz

import com.storitz.StorageSite
import com.storitz.StoritzUtil
import com.storitz.yelp.Yelp
import com.storitz.yelp.YelpReview
import java.text.SimpleDateFormat
import com.storitz.*
import grails.converters.JSON
import java.util.regex.Matcher
import java.util.regex.Pattern

class YelpTest extends GroovyTestCase{
  protected void setUp() {
    super.setUp()
  }

  protected void tearDown() {
    super.tearDown()
  }

  void testYelp1 ()
  {
    try {
      def storageSites = StorageSite.findAllByDisabled(0);
      def random = new Random();
      int max = storageSites.size();
      int counter = 0;
      while (counter < 100) {
        int temp = random.nextInt(max-1);
        StorageSite site = storageSites[temp];
        Yelp yelp = Yelp.newInstance(); //start the yelp request (local search)
        def request = yelp.search(site.lat, site.lng, "")
        def searchResponse = JSON.parse(request)
        def bizTotal = searchResponse.total
        def newResponse
        def yelp_serp_url = "http://www.yelp.com/search?find_desc="+site.feed.operatorName.replaceAll(/\s/, "+")+"&ns=1&find_loc="+site.city.replaceAll(/\s/, "+")+"%2C+"+site.state.display
        if (bizTotal > 0) {
          def bizId = searchResponse.businesses[0].id
          def bizRequest = yelp.search(site.lat, site.lng, bizId)
          newResponse = JSON.parse(bizRequest)
          def numReviews = newResponse.review_count
          def ratingUrl = newResponse.rating_img_url =~ /.*stars_([0-9])_?(half)?\.png/
          def aveRating = ratingUrl[0][1]
          def isHalf = ratingUrl[0][2]
          def yelp_detail_url = newResponse.url
          printf(counter+")"+"%s \t %s \t %s \t %s \t %s \t %s \t %s \t %s \t %s \t %s \n", site.id, site.title, site.address, site.city, site.state.display, site.zipcode, numReviews, aveRating+isHalf, yelp_detail_url, yelp_serp_url)
          counter += 1
        }
        else {
          printf(counter+")"+"%s \t %s \t %s \t %s \t %s \t %s \t %s \t %s \n",site.id, site.title, site.address, site.city, site.state.display, site.zipcode, "Yelp cannot find reviews for this site", yelp_serp_url);
          counter += 1;
        }
      }
      println("Job Complete.");
    }
    catch (Exception e) {
      println("ERROR:")
      e.printStackTrace()
    }

    assertTrue(true)
  }
}
