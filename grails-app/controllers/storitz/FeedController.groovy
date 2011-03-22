package storitz

import com.storitz.Feed

class FeedController {

  def feedService
  def imageService

  def index = { }

  def uploadLogo = {

    def logoFile = request.getFile('logoFile')
    Long feedId = params.long('id')

    imageService.feedLogo(logoFile, feedId)

    flash.message = "Logo uploaded."
    redirect(action: "list")
  }

  def updateInventory = {

    Feed feed = Feed.get(params.id as Long)
    def writer = new PrintWriter(System.out)
    for (site in feed.sites) {
      def stats = new storitz.SiteStats()
      feedService.updateUnits(site, stats, writer)
    }
    flash.message = "Feed Inventory Updated."
    redirect(action: "list")
  }

  def seoLinks = {
    Feed feed = Feed.get(params.id as Long)
    render(view: "seoLinks", model: [feed: feed])
  }

  def refreshInsurance = {
    Feed feed = Feed.get(params.id as Long)
    feedService.refreshInsurance(feed)
    flash.message = "Insurance Updated."
    redirect(action: "list")
  }

  def refreshPromos = {
    Feed feed = Feed.get(params.id as Long)
    def writer = new PrintWriter(System.out)
    for (site in feed.sites) {
      feedService.refreshPromos(site, writer)
    }
    flash.message = "Promos Updated."
    redirect(action: "list")
  }
}
