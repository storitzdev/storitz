package storitz

import com.storitz.StorageSite

class SiteMapController
{

  def index = {
    withFormat {
      html {
        //def sites = StorageSite.findAllByDisabled(false, [sort:"city"]).groupBy { StorageSite site -> site.stateName }
        def sites = []
        // Converting to TreeMap so keys (state names) will iterate in alphabetical order.
        [storageSiteStateMap: sites as TreeMap]
      }

      xml {
        //def siteList = StorageSite.findAllByDisabled(false)
        def siteList = []
        render(view:"sitemap", contentType:'text/xml; charset=utf-8', model:[siteList:siteList])
      }
    }
  }
}
