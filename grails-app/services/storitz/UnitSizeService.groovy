package storitz

import com.storitz.StorageSize

class UnitSizeService {

    boolean transactional = false

    def getUnitSize(width, length) {
      def unitSize = StorageSize.findByWidthAndLength(width, length)
      if (unitSize == null) {

        def unitArea = width * length
        def foundSize = 0

        unitSize = StorageSize.findAll().findAll { it.length * it.width <= unitArea}?.min{ unitArea - it.width * it.length }
      }
      return unitSize
    }
}
