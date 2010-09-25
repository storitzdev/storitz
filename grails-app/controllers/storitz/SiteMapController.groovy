package storitz

import com.storitz.StorageSite

import groovy.xml.StreamingMarkupBuilder;

class SiteMapController
{

  def index = {

    println request.getHeader("accept")
    println request.getFormat()

    withFormat {
      html {
        def sites = StorageSite.findAllByDisabled(false, [sort:"city"]).groupBy { StorageSite site -> site.stateName }

        // Converting to TreeMap so keys (state names) will iterate in alphabetical order.
        [storageSiteStateMap: sites as TreeMap]
      }

      xml {
        def siteList = StorageSite.findAllByDisabled(false)
        render(view:"sitemap", contentType:'text/html; charset=utf-8', model:[siteList:siteList])
      }
    }
  }
}
