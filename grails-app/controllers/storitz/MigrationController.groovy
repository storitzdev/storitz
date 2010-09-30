package storitz

import grails.converters.deep.JSON
import com.storitz.StorageSite
import com.storitz.Feed

class MigrationController {

  def index = { }

  def owner = {
    def myFeed = Feed.get(params.id as Long)

    if (myFeed) {
      def sites = StorageSite.findAllByFeed(myFeed)
      render(status: 200, contentType: "application/json", text: "{ \"sites\": ${sites as JSON} }")
    }
  }
}
