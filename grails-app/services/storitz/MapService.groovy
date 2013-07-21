package storitz

import com.maxmind.geoip.Location
import com.storitz.StorageSite
import com.storitz.geoip.GeoIp
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest

import storitz.constants.QueryMode
import storitz.constants.GeoType
import org.hibernate.FetchMode
import storitz.constants.TruckType
import org.hibernate.Hibernate
import org.hibernate.SessionFactory
import org.hibernate.Session

class MapService {
  def lookupService;

  def sessionFactory;
  boolean transactional = false

  final double R = 3958.761; // mi
  final int MAP_WIDTH = 617;
  final int MAP_HEIGHT = 284;

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
    return getSiteIds(criteria).size();
  }

  private String buildSearchQuery(SearchCriteria criteria) {
    StringBuilder qb = new StringBuilder("SELECT ss.id FROM storage_site ss LEFT OUTER JOIN storage_unit su ON su.site_id = ss.id");
    qb.append(" WHERE ss.disabled=0");
    qb.append(" AND ((ss.lat BETWEEN ").append(criteria.bounds.sw.lat).append(" AND ").append(criteria.bounds.ne.lat).append(" AND ").append("ss.lng BETWEEN ").append(criteria.bounds.sw.lng).append(" AND ").append(criteria.bounds.ne.lng).append(")");
    switch(criteria.geoType) {
      case GeoType.CITY:
        qb.append(" OR (ss.city='").append(criteria.city).append("' AND ss.state='").append(criteria.state).append("')");
        break;
      case GeoType.ZIP_CODE:
        qb.append(" OR zipcode='").append(criteria.zip_code).append("'");
        break;
    }
    qb.append(")");
    if (criteria.amenities) {
      if (criteria.amenities.get("freeTruck")) {
        qb.append(" AND free_truck = '").append(TruckType.FREE).append("'")
      }
    }
    if (criteria.queryMode == QueryMode.FIND_UNITS) {
      qb.append(" AND unit_count > min_inventory AND unitsize_id IN (SELECT id FROM storage_size sz WHERE sz.id > ").append(criteria.searchSize).append(" AND sz.search_type = '").append(criteria.searchType).append("')");
      if (criteria.unitType) {
        qb.append(" AND unit_type = '").append(criteria.unitType).append("'");
      }
      if (criteria.amenities) {
        if (criteria.amenities.get("cc")) {
          qb.append(" AND is_temp_controlled = 1")
        }
        if (criteria.amenities.get("24hr")) {
          qb.append(" AND is_twenty_four_hour = 1")
        }
        if (criteria.amenities.get("alarm")) {
          qb.append(" AND is_alarm = 1")
        }
      }
    }
    qb.append(" GROUP BY ss.id")
    return qb.toString();
  }

  private List<Long> getSiteIds(SearchCriteria criteria) {
    String q = buildSearchQuery(criteria);
    Session s = sessionFactory.getCurrentSession();
    return s.createSQLQuery(q).addScalar("ID", Hibernate.LONG).list()
  }

  def getSites(SearchCriteria criteria) {
    // zoom setings
    Integer zoom = 11;
    Integer zoomMin = 7;
    Integer zoomMax = 16;
    criteria.setBounds(zoom, MAP_WIDTH, MAP_HEIGHT)
    List siteIds = getSiteIds(criteria);

    // adjust zoom if too many/few sitse were returned
    if (siteIds.size() > 20) {
      // loop and shrink
      while (siteIds.size() > 20 && zoom <= zoomMax) {
        zoom++
        criteria.setBounds(zoom, MAP_WIDTH, MAP_HEIGHT)
        siteIds = getSiteIds(criteria);
      }
    } else if (siteIds.size() == 0) {
      // grow
      while (zoom > zoomMin && siteIds.size() == 0) {
        zoom--
        criteria.setBounds(zoom, MAP_WIDTH, MAP_HEIGHT)
        siteIds = getSiteIds(criteria);
      }
    } else if (siteIds.size() <= 3) {
      // grow up to a couple of notches
      def targetZoom = zoom - 3
      while (zoom > targetZoom && siteIds.size() <= 3) {
        zoom--
        criteria.setBounds(zoom, MAP_WIDTH, MAP_HEIGHT)
        siteIds = getSiteIds(criteria);
      }
    }

    // Sort by proximity before reducing
    def sites = StorageSite.findAllByIdInList(siteIds).sort { calcDistance(criteria.centroid.lat, it.lat, criteria.centroid.lng, it.lng)}
    if (sites.size() > 20) {
      sites = sites.subList(0,20)
    }

    return sites;
  }

  def Location getLocation(String ipAddr) {
    if (ipAddr.equals("127.0.0.1") || ipAddr.startsWith("192.168") || ipAddr.startsWith("10.")) {
      ipAddr = "71.118.52.85"
    }
    Location loc = lookupService.getLocation(ipAddr)
    return loc
  }

  def getGeoIp(ServletContext servletContext, HttpServletRequest request) {
    return getLocation(request.getRemoteAddr())

  }

}
