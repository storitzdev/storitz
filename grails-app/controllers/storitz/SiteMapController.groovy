package storitz

import com.storitz.Metro
import com.storitz.MetroEntry
import com.storitz.StorageSite
import com.storitz.CollegeLanding
import com.storitz.Video

class SiteMapController {

  def index = {

    withFormat {
      html {
        def sites = StorageSite.findAllByDisabled(false, [sort: "city"]).groupBy { StorageSite site -> site.state.display }

        // Converting to TreeMap so keys (state names) will iterate in alphabetical order.
        [storageSiteStateMap: sites as TreeMap]
      }

      xml {
        render(view: "sitemapIndex", contentType: 'text/html; charset=utf-8', model: [])
      }
    }
  }

  def url = {
    withFormat {
      xml {
        def siteList = StorageSite.findAllByDisabled(false)
        def metroList = Metro.list().unique(new MetroComparator())
        def metroEntryList = MetroEntry.list()
        render(view: "sitemap", contentType: 'text/html; charset=utf-8', model: [siteList: siteList, metroList: metroList, metroEntryList: metroEntryList])
      }
    }
  }

  def geo = {
    withFormat {
      xml {
        def siteList = StorageSite.findAllByDisabled(false)
        render(view: "sitemapGeo", contentType: 'text/html; charset=utf-8', model: [siteList: siteList])
      }
    }
  }

  def image = {
    withFormat {
      xml {
        def siteList = StorageSite.findAllByDisabled(false)
        render(view: "sitemapImage", contentType: 'text/html; charset=utf-8', model: [siteList: siteList])
      }
    }
  }

  def college = {
    withFormat {
      xml {
        def collegeList = CollegeLanding.findAll()
        render(view: "sitemapCollege", contentType: 'text/html; charset=utf-8', model: [collegeList: collegeList])
      }
    }
  }

  def videos = {
    withFormat {
      xml {
        def videoList = Video.findAll()
        render(view: "sitemapVideo", contentType: 'text/html; charset=utf-8', model: [videoList : videoList])
      }
    }
  }
}
