package storitz

import grails.converters.JSON
import com.storitz.StorageSite
import com.storitz.Feed
import storitz.constants.FeedType
import com.storitz.SiteLink
import com.storitz.CenterShift
import com.storitz.User
import org.codehaus.groovy.grails.web.json.JSONObject

class MigrationController {

  def index = { }

  def owner = {
    def myFeed = Feed.get(params.id as Long)

    if (myFeed) {
      def users = User.findAllByManager(myFeed.manager)
      def siteUsers = []
      for (user in users) {
        for (site in users.sites) {
          siteUsers.add(site)
        }
      }
      for (site in myFeed.manager.sites) {
        siteUsers.add(site)
      }
      JSON.use("default")
      if (myFeed.feedType == FeedType.SITELINK) {
        SiteLink f = myFeed as SiteLink
        render(status: 200, contentType: "application/json", text: "{ \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"siteUsers\": ${siteUsers as JSON} }")
      } else if (myFeed.feedType == FeedType.CENTERSHIFT) {
        CenterShift f = myFeed as CenterShift
        println "Beginning output"
        render(status: 200, contentType: "application/json", text: "{ \"feed\": ${f as JSON}, \"users\": ${users as JSON} }, \"siteUsers\": ${siteUsers as JSON} }")
      }
    }
  }

  def consume = {
    def urlString = 'http://preview.storitz.com/migration/owner/' + params.id
    if (params.url) {
      urlString = params.url
    }

    println "URL = ${urlString}"

    def url = new URL(urlString)
    def conn = url.openConnection()
    if (conn.responseCode == 200) {
      println "Response was 200"
      def respText = conn.content.text
      def resp = JSON.parse(respText)
      def feed
      if (resp.feed.feedType == 'SITELINK') {
        feed = new SiteLink(params['feed'])
        for (es in resp.feed.entrySet()) {
          println "Examining key=${es.key} value=${es.value}"
          if (es.value == JSONObject.NULL) {
            println "Changing null for ${es.key}"
            es.value = null
          }
        }
        feed.properties = resp.feed
        feed.feedType = FeedType.SITELINK

      } else if (resp.feedType == 'CENTERSHIFT') {
        feed = new CenterShift(params['feed'])
        for (es in resp.feed.entrySet()) {
          println "Examining key=${es.key} value=${es.value}"
          if (es.value == JSONObject.NULL) {
            println "Changing null for ${es.key}"
            es.value = null
          }
        }
        feed.properties = resp.feed
        feed.feedType = FeedType.CENTERSHIFT

      }
      for (s in feed.sites) {
        def site = new StorageSite()
        for (es in s.entrySet()) {
          println "Examining key=${es.key} value=${es.value}"
          if (es.value == JSONObject.NULL) {
            println "Changing null for ${es.key}"
            es.value = null
          }
        }
        bindData(site, s)
        site.save(flush:true)
      }
      feed.save(flush: true)
    } else {
      println "Bad connection got response ${conn.responseCode}"
    }
    render(status: 200, text: "Done!")
  }

}
