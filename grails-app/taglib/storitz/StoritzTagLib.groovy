package storitz

import java.text.DecimalFormat

class StoritzTagLib {

    def mapService

      static namespace = 'storitz'
      def calcDistance = { attrs ->
        out << mapService.calcDistance(attrs['lat1'], attrs['lat2'], attrs['lng1'], attrs['lng2'])        
      }

      def joinMember = { attrs ->
        def member = attrs['member']
        out << attrs['set'].collect{ it."$member" }.join('<BR/>')
      }

      def printMin = { attrs ->
        def member = attrs['member']
        def format = attrs['format']
        def val = attrs['set'].collect{ it."$member" }.min()
        if (format) {
          out << new DecimalFormat(format).format(val)
        } else {
          out << val
        }
      }
}
