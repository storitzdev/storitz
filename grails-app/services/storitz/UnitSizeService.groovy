package storitz

import com.storitz.StorageSize
import storitz.constants.SearchType

class UnitSizeService {

    boolean transactional = false

    def getUnitSize(width, length, SearchType searchType) {
      def unitSize
      if (searchType == SearchType.STORAGE) {
        def unitSizes = StorageSize.findAllByWidthAndLength(width, length)
        unitSize = unitSizes.find{it.searchType == searchType}
      }
      if (unitSize == null) {

        def unitArea = width * length
        if (searchType == SearchType.STORAGE) {
          unitSize = StorageSize.findAllBySearchType(searchType).findAll { it.length * it.width <= unitArea}?.min{ unitArea - it.width * it.length }
        } else if (searchType == SearchType.PARKING) {
          unitSize = StorageSize.findAllBySearchType(searchType).findAll { it.length >= length }.min{ it.length - length }
        }
      }
      return unitSize
    }
}
