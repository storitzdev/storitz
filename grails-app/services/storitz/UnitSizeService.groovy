package storitz

import com.storitz.StorageSize
import storitz.constants.SearchType

class UnitSizeService {

  boolean transactional = false

  def getUnitSize(width, length, SearchType searchType) {
    def unitSize
    if (searchType == SearchType.STORAGE) {
      def unitSizes = StorageSize.findAllByWidthAndLength(width, length)
      unitSize = unitSizes.find {it.searchType == searchType}
    }
    if (unitSize == null) {

      def unitArea = width * length
      if (searchType == SearchType.STORAGE) {
        unitSize = StorageSize.findAllBySearchType(searchType).findAll { it.length * it.width <= unitArea}?.min { unitArea - it.width * it.length }
      } else if (searchType == SearchType.PARKING) {
        unitSize = StorageSize.findAllBySearchType(searchType).findAll { it.length <= length }.min { length - it.length }
      }
      // JM: 2011-06-22
      // Sanity check. We are seeing some units that are massive. For example
      // a 72 x 62 mini warehouse for $3505/Month. Obviously we are not yet
      // equipped to rent such a location, however our system thinks that this
      // is a "10 x 30" since that's the largest unit we rent!
      //
      // What!?! It's ok for the actual unit size to be a bit larger than we
      // expect, but this is ridiculous.
      //
      // Here we assume that if we double the area of a given unitSize
      // (StorageSize domain object) and the resulting value is STILL less than
      // the actual unit area, then we have some major disconnect and we return
      // a null unitSize.
      if (unitSize && unitSize.width * unitSize.length * 2 <= unitArea) {
        unitSize = null
      }
    }
    return unitSize
  }
}
