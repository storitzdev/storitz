package storitz

import com.storitz.StorageSize

class UnitSizeService {

    boolean transactional = false

    def getUnitSize(width, length) {
      def unitSize = StorageSize.findByWidthAndLength(width, length)
      if (unitSize == null) {

        def unitArea = width * length
        def foundSize = 0
        StorageSize.findAll().each {u ->
          if (Math.abs(unitArea - foundSize) > Math.abs(unitArea - u.width * u.length)) {
            unitSize = u
            foundSize = u.width * u.length
          }
        }
      }
      return unitSize
    }
}
