package storitz

import com.storitz.Metro
import com.storitz.MetroEntry

class SeoController {

    def state = {
      def searchState = storitz.constants.State.getEnumFromId(params.state)

      def metroList = Metro.findAllByState(searchState, [sort:"city", order:"asc"])
      def metroEntryList = MetroEntry.findAllByState(searchState, [sort:"city", order:"asc"]).unique (new MetroEntryComparator())

      [state:searchState, metroList:metroList, metroEntryList: metroEntryList]
    }
}
