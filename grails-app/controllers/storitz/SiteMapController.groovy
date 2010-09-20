package storitz

import com.storitz.StorageSite

import groovy.xml.StreamingMarkupBuilder;

class SiteMapController
{

  def index = {
    withFormat {
      html {
        def sites = StorageSite.listOrderByCity().groupBy { StorageSite site -> site.stateName }

        // Converting to TreeMap so keys (state names) will iterate in alphabetical order.
        [storageSiteStateMap: sites as TreeMap]
      }

      xml {
        def siteList = StorageSite.findAllByDisabled(false)
        render(view:"sitemap", model:[siteList:siteList])
      }
    }
  }
}
