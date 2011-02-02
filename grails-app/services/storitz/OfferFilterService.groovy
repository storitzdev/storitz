package storitz

import com.storitz.StorageSite
import com.storitz.StorageUnit

class OfferFilterService {

    static transactional = false

    def getValidOffers(StorageSite site, StorageUnit unit) {
      List results = site.specialOffers()

      return results
    }

    def getValidFeaturedOffers(StorageSite site, StorageUnit unit) {
      List results = site.featuredOffers()

      return results
    }

    def getValidNonFeaturedOffers(StorageSite site, StorageUnit unit) {
      List results = site.nonFeaturedOffers()

      return results
    }
}
