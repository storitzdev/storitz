package storitz

import com.storitz.StorageSite
import com.storitz.geoip.GeoIp
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import org.hibernate.FetchMode
import storitz.constants.SearchType
import com.storitz.StorageUnit
import storitz.constants.QueryMode

class MapService {
  def geoIp;

  boolean transactional = false

  final double R = 3958.761; // mi

  def calcDistance(lat1, lat2, lng1, lng2) {
    def d = Math.acos(Math.sin(lat1 / 57.2958) * Math.sin(lat2 / 57.2958) +
            Math.cos(lat1 / 57.2958) * Math.cos(lat2 / 57.2958) *
            Math.cos(lng2 / 57.2958 - lng1 / 57.2958)) * R;
    return Math.round(100 * d) / 100;
  }

  def countSites(SearchCriteria criteria) {
    // TODO: Support minInventory

    def sites = StorageSite.createCriteria()

    return sites.get {
      projections {
        countDistinct("id")
      }
      and {
        between("lat", criteria.bounds.sw.lat, criteria.bounds.ne.lat)
        between("lng", criteria.bounds.sw.lng, criteria.bounds.ne.lng)
        eq("disabled", false)
      }
      if (criteria.searchSize && criteria.searchSize != 1) {
        fetchMode('units', FetchMode.EAGER)
        units {
          unitsize {
            eq("id", criteria.searchSize)
          }
        }
      } else {
        fetchMode('units', FetchMode.EAGER)
        units {
          unitsize {
            eq("searchType", criteria.searchType)
          }
        }
      }
    }

  }

//  def getSites(Long searchSize, SearchType searchType, BigDecimal swLat, BigDecimal swLng, BigDecimal neLat, BigDecimal neLng, Integer minInventory) {
  def getSites(SearchCriteria criteria) {

    log.info("Bounding box: " + criteria.bounds.sw.lat + "," + criteria.bounds.sw.lng + " " + criteria.bounds.ne.lat + "," + criteria.bounds.ne.lng);

    def sites = StorageSite.createCriteria()

    def storageSites = sites.listDistinct {
      and {
        eq("disabled", false)
        or {
          and {
            between("lat", criteria.bounds.sw.lat, criteria.bounds.ne.lat)
            between("lng", criteria.bounds.sw.lng, criteria.bounds.ne.lng)
          }
          switch (criteria.queryMode) {
            case QueryMode.BROWSE_CITY:
              and {
                eq("city", criteria.city)
                eq("state", criteria.state)
              }
              break;
          }
        }
      }
      //Note: maxResults won't work when combined with FetchMode.EAGER
      //Our goal is to find 20 good matches. We throttle at 50 here to
      //account for sites without applicable units. Note: 50 is almost
      //certainly overkill.
      maxResults(50)

      //fetchMode('units', FetchMode.EAGER)
      //fetchMode('specialOffers', FetchMode.EAGER)
    }
    log.info("FIRST CUT: " + storageSites.size() + " sites");

    // We now have all of the sites in this rectangle. Now we need to filter
    // out the ones that do not contain applicable inventory.
    Integer minInventory = criteria.minInventory();

    def results = []
    storageSites.each { site ->
      site.units.find { unit ->
        def foundit = false
        if (criteria.searchSize && criteria.searchSize != 1 && unit.unitsize.id == criteria.searchSize && unit.unitCount >= minInventory) {
          results.add(site);
          foundit = true
        }
        else if (unit.unitsize.searchType == criteria.searchType && unit.unitCount >= minInventory) {
          results.add(site);
          foundit = true
        }
        foundit // breaks the find loop when true
      }
    }

    return results.unique();
  }

  def getGeoIp(ServletContext servletContext, HttpServletRequest request) {
    def geoLoc

    if (!geoIp) {
      geoIp = new GeoIp(servletContext)
    }

    return geoIp.getLocation(request.getRemoteAddr())

  }

  public void optimizeZoom(SearchCriteria criteria, Integer width, Integer height) {
    // TODO: Delete this method when we move to grid-based search
    Integer zoom = 11;

    criteria.setBounds(zoom, width, height)
    def count = countSites(criteria)
    if (count > 20) {
      // loop and shrink
      while (count > 20) {
        zoom++
        criteria.setBounds(zoom, width, height)
        count = countSites(criteria)
      }
    } else if (count == 0) {
      // grow
      while (zoom > zoomMin && count == 0) {
        zoom--
        criteria.setBounds(zoom, width, height)
        count = countSites(criteria)
      }
      if (count == 0) {
        zoom = 11
      }
    } else if (count <= 3) {
      // grow up to a couple of notches
      def targetZoom = zoom - 3
      while (zoom > targetZoom && count <= 3) {
        zoom--
        criteria.setBounds(zoom, width, height)
        count = countSites(criteria)
      }
      if (count == 1) {
        zoom = 11
      }
    }
  }

}
