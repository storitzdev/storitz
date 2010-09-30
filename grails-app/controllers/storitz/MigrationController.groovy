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

  def consume = {
    def urlString = 'http://preview.storitz.com/migrate/owner/' + params.id
    if (params.url) {
      urlString = params.url
    }

    println "URL = ${urlString}"

    def url = new URL(urlString)
    def conn = url.openConnection()
    if (conn.responseCode == 200) {
      def sites = JSON.parse(conn.content.text)
      for (s in sites) {
        def  site = new StorageSite(s)
        println "Retrieved site: ${site.title} id = ${site.id}"
      }
    } else {
      println "Bad connection got response ${conn.responseCode}"
    }
    render(status: 200, text: "Done!")
  }
}
