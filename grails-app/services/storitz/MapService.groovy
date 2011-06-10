package storitz

import com.storitz.StorageSite
import com.storitz.geoip.GeoIp
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest

import storitz.constants.QueryMode
import storitz.constants.GeoType
import org.hibernate.FetchMode

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

  private static enum CRITERIA_MODE {
    COUNT,
    FETCH
  }

  def unitsCriteria = { criteria ->
    return {
      units {
        unitsize {
          and {
            eq("searchType", criteria.searchType)
            if (criteria.searchSize && criteria.searchSize != 1) {
              eq("id", criteria.searchSize)
            }
          }
        }
        sqlRestriction("unit_count >= min_inventory")
        //order("currentPrice", "asc") // TODO: uncomment when used by getUnitsClosure
      }
    }
  }
  def getSitesClosure = { criteria ->
    return {
      projections {
        groupProperty("id")
      }
      and {
        eq("disabled", false)
        or { // geo filters (must satisfy *any*)
          and {
            between("lat", criteria.bounds.sw.lat, criteria.bounds.ne.lat)
            between("lng", criteria.bounds.sw.lng, criteria.bounds.ne.lng)
          }
          switch (criteria.geoType) { // TODO: Do string matching for neighborhood names, too?
            case GeoType.CITY:
              and {
                eq("city", criteria.city);
                eq("state", criteria.state);
              }
              break;
            case GeoType.ZIP_CODE:
              eq("zipcode", criteria.zip_code);
              break;
          }
        }
      }
      if (criteria.queryMode == QueryMode.FIND_UNITS) {
        unitsCriteria(criteria)
      }
    }
  }
//  // TODO: use this to avoid in-app sorting of sites by price (in best-unit calculation in SearchController)
//  //       n.b. order() clause must be uncommented in unitsCriteria for this to work here, and currentPrice
//  //       must be set (to either price or pushRate) by the ETL process, and stored in the DB
//  def getUnitsClosure = { siteId, criteria ->
//    return {
//      eq("id", siteId)
//      maxResults(1)
//      unitsCriteria(criteria)
//    }
//  }

  def countSites(SearchCriteria criteria) {
    return StorageSite.withCriteria(getSitesClosure(criteria)).size()
  }

  def getSites(SearchCriteria criteria) {
    // zoom setings
    Integer zoom = 11;
    Integer zoomMin = 7;
    criteria.setBounds(zoom, 617, 284)
    def c = StorageSite.createCriteria();
    def siteIds = c.list(getSitesClosure(criteria));

    // adjust zoom if too many/few sitse were returned
    if (siteIds.size() > 20) {
      // loop and shrink
      while (siteIds.size() > 20) {
        zoom++
        criteria.setBounds(zoom, width, height)
        siteIds = c.list(getSitesClosure(criteria));
      }
    } else if (siteIds.size() == 0) {
      // grow
      while (zoom > zoomMin && siteIds.size() == 0) {
        zoom--
        criteria.setBounds(zoom, width, height)
        siteIds = c.list(getSitesClosure(criteria));
      }
    } else if (siteIds.size() <= 3) {
      // grow up to a couple of notches
      def targetZoom = zoom - 3
      while (zoom > targetZoom && siteIds.size() <= 3) {
        zoom--
        criteria.setBounds(zoom, width, height)
        siteIds = c.list(getSitesClosure(criteria));
      }
    }
    // retrieve StorageSite instances from ORM
    return StorageSite.findAllByIdInList(siteIds);
  }

  def getGeoIp(ServletContext servletContext, HttpServletRequest request) {
    def geoLoc

    if (!geoIp) {
      geoIp = new GeoIp(servletContext)
    }

    return geoIp.getLocation(request.getRemoteAddr())

  }

}
