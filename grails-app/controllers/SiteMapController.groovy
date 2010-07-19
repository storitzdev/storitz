import com.storitz.StorageSite

class SiteMapController {

    def index = {
      def sites = StorageSite.listOrderByCity().groupBy { StorageSite site -> site.stateName }

      // Converting to TreeMap so keys (state names) will iterate in alphabetical order.
      [storageSiteStateMap: sites as TreeMap]
    }
}
