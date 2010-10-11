package storitz

import grails.converters.JSON
import com.storitz.StorageSite
import com.storitz.Feed
import storitz.constants.FeedType
import com.storitz.SiteLink
import com.storitz.CenterShift
import com.storitz.User
import org.codehaus.groovy.grails.web.json.JSONObject
import com.storitz.Bullet
import com.storitz.SiteImage
import com.storitz.Insurance
import com.storitz.SpecialOffer
import com.storitz.SiteUser

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
        render(status: 200, contentType: "application/json", text: "{ \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"manager\":\"${myFeed.manager.username}\", \"siteUsers\": ${siteUsers as JSON} }")
      } else if (myFeed.feedType == FeedType.CENTERSHIFT) {
        CenterShift f = myFeed as CenterShift
        println "Beginning output"
        render(status: 200, contentType: "application/json", text: "{ \"feed\": ${f as JSON}, \"users\": ${users as JSON} }, \"manager\":\"${myFeed.manager.username}\", \"siteUsers\": ${siteUsers as JSON} }")
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
      clearNulls(resp)
      def feed
      if (resp.feed.feedType == 'SITELINK') {
        feed = new SiteLink(params['feed'])
        feed.properties = resp.feed
        feed.feedType = FeedType.SITELINK

      } else if (resp.feedType == 'CENTERSHIFT') {
        feed = new CenterShift(params['feed'])
        feed.properties = resp.feed
        feed.feedType = FeedType.CENTERSHIFT

      }
      def sites = []
      for (s in feed.sites) {
        def site = new StorageSite()
        for (i in s.securityItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush:true)
          site.addToSecurityItems(si)
        }
        for (i in s.convenienceItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush:true)
          site.addToConvenienceItems(si)
        }
        for (i in s.amenityItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush:true)
          site.addToAmenityItems(si)
        }
        def images = []
        for (i in s.images) {
          def si = new SiteImage()
          bindData(si, i)
          si.site = site
          images.add(si)
        }
        for (i in s.insurances) {
          def si = new Insurance()
          bindData(si, i)
          si.save(flush:true)
          site.addToInsurances(si)
        }
        for (i in s.specialOffers) {
          def si = new SpecialOffer()
          bindData(si, i)
          si.save(flush:true)
          site.addToSpecialOffers(si)
        }
        s.amenityItems.clear()
        s.securityItems.clear()
        s.convenienceItems.clear()
        s.images.clear()
        s.insurances.clear()
        s.specialOffers.clear()
        bindData(site, s)
        site.save(flush:true)
        for (image in images) {
          image.site = site
          site.addToImages(image)
          image.save(flush:true)
        }
        sites.add(site)
      }
      feed.sites.clear()
      feed.save(flush: true)
      for(site in sites) {
        feed.addToSites(site)
      }

      // handle users
      def users = []
      for (u in resp.users) {
        def user = new User()
        bindData(user, u)
        user.save(flush: true)
        users.add(user)
      }
      def manager = User.findByUsername(resp.manager)
      for (u in users) {
        u.manager = manager
      }
      for (su in resp.siteUsers) {
        def site = StorageSite.findByTitle(su.site)
        def user = User.findByUsername(su.user)
        def siteUser = SiteUser.link(site, user)
      }
    } else {
      println "Bad connection got response ${conn.responseCode}"
    }
    render(status: 200, text: "Done!")
  }

  private clearNulls(Object obj) {

    if (obj instanceof Map) {
      def map = (Map)obj
      for (r in map.entrySet()) {
        println "Examining map key=${r.key} value=${r.value}"
        if (r.value == JSONObject.NULL) {
          r.value = null
        } else if (r.value instanceof Map || r.value instanceof List) {
          clearNulls(r.value)
        }
      }
    } else if (obj instanceof List) {
      def list = (List)obj
      for (l in list) {
        if (l == JSONObject.NULL) {
          l = null
        } else if (l instanceof Map || l instanceof List) {
          clearNulls(l)
        }
      }
    }

  }
}
