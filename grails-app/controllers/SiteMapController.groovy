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
        def sites = StorageSite.listOrderByTitle()

//        render(contentType: "text/xml") {
//          urlset(xmlns: "http://www.sitemaps.org/schemas/sitemap/0.9") {
//            sites.each { StorageSite site ->
//              loc(createLink(absolute: true, mapping: "siteLink", controller: "storageSite", action: "detail", id: site.id, params: [city: site.city, site_title: site.siteTitle]) + "\n")
//
//            }
//          }
//        }

        // Google Sitemap <http://www.google.com/support/webmasters/bin/answer.py?hl=en&answer=183668#2>
        
        // Can't use nice simple MarkupBuilder for XML because it won't give us an XML declaration.
        response.contentType = "text/xml"
        response.outputStream << new StreamingMarkupBuilder().bind {
          mkp.xmlDeclaration()
          urlset(xmlns: "http://www.sitemaps.org/schemas/sitemap/0.9") {
            sites.each { StorageSite site ->
              // The '+ "\n"' is an ugly hack to make the output more easily viewed.
              loc(createLink(absolute: true, controller: "storageSite", action: "detail", id: site.id, params: [city: site.city, site_title: site.siteTitle]) + "\n")
              // TODO: Add <image> for each site.
              // TODO: Add <geo> for each site.
            }
          }
        }
      }
    }
  }
}
