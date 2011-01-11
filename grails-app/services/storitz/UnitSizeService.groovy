package storitz

import com.storitz.StorageSize
import storitz.constants.SearchType

class UnitSizeService {

    boolean transactional = false

    def getUnitSize(width, length, SearchType searchType) {
      def unitSizes = StorageSize.findAllByWidthAndLength(width, length)
      def unitSize = unitSizes.find{it.searchType == searchType}
      if (unitSize == null) {

        def unitArea = width * length
        unitSize = StorageSize.findAllBySearchType(searchType).findAll { it.length * it.width <= unitArea}?.min{ unitArea - it.width * it.length }
      }
      return unitSize
    }
}
