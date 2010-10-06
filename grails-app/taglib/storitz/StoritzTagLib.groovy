package storitz

import java.text.DecimalFormat

class StoritzTagLib {
      static namespace = 'storitz'
      final double R = 3958.761; // mi

      def calcDistance(lat1, lat2, lng1, lng2) {
        def d = Math.acos(Math.sin(lat1/57.2958)*Math.sin(lat2/57.2958) +
                    Math.cos(lat1/57.2958)*Math.cos(lat2/57.2958) *
                    Math.cos(lng2/57.2958-lng1/57.2958)) * R;
        return Math.round(100 * d) / 100;
      }

      def calcDistance = { attrs ->
        out << calcDistance(attrs['lat1'], attrs['lat2'], attrs['lng1'], attrs['lng2'])        
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
