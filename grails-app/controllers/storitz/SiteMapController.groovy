package storitz

import com.storitz.StorageSite

import groovy.xml.StreamingMarkupBuilder;

class SiteMapController
{

  def index = {

    withFormat {
      html {
        def sites = StorageSite.findAllByDisabled(false, [sort:"city"]).groupBy { StorageSite site -> site.stateName }

        // Converting to TreeMap so keys (state names) will iterate in alphabetical order.
        [storageSiteStateMap: sites as TreeMap]
      }

      xml {
        render(view:"sitemapIndex", contentType:'text/html; charset=utf-8', model:[])
      }
    }
  }

  def url = {
    withFormat {
      xml {
        def siteList = StorageSite.findAllByDisabled(false)
        render(view:"sitemapGeo", contentType:'text/html; charset=utf-8', model:[siteList:siteList])
      }
    }
  }

  def geo = {
    withFormat {
      xml {
        def siteList = StorageSite.findAllByDisabled(false)
        render(view:"sitemapGeo", contentType:'text/html; charset=utf-8', model:[siteList:siteList])
      }
    }
  }

  def image = {
    withFormat {
      xml {
        def siteList = StorageSite.findAllByDisabled(false)
        render(view:"sitemapImage", contentType:'text/html; charset=utf-8', model:[siteList:siteList])
      }
    }
  }
}
