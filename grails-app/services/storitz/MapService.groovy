package storitz

import com.storitz.StorageSite
import com.storitz.geoip.GeoIp
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import org.hibernate.FetchMode
import storitz.constants.SearchType
import com.storitz.StorageUnit
import storitz.constants.QueryMode
import storitz.constants.GeoType

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
    // TODO: Support QueryMode

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

  def getSites(SearchCriteria criteria) {

    log.info("Bounding box: " + criteria.bounds.sw.lat + "," + criteria.bounds.sw.lng + " " + criteria.bounds.ne.lat + "," + criteria.bounds.ne.lng);

    // select site.id, sum(units.unitCount) from StorageSite as site
    // left join site.units as units
    // where << geo constraints >>
    // and site.disabled = 0
    // and units.unitCount > 0
    // group by site.id

    String basicFilters = "site.disabled = ? and ((site.lat > ? and site.lat < ? and site.lng > ? and site.lng < ?) ";
    def qparams = [false, criteria.bounds.sw.lat, criteria.bounds.ne.lat, criteria.bounds.sw.lng, criteria.bounds.ne.lng]
    StringBuilder qbuf = new StringBuilder();
    if (criteria.queryMode == QueryMode.FIND_UNITS) {
      qbuf.append("select site.id from StorageSite as site left join site.units as units");
    }
    else {
      qbuf.append("from StorageSite as site")
    }
    qbuf.append(" where ");
    qbuf.append(basicFilters);
    switch (criteria.geoType) {
      case GeoType.CITY:
        qbuf.append(" or (site.city = ? and site.state = ?) ")
        qparams << criteria.city;
        qparams << criteria.state;
        break;
      case GeoType.ZIP_CODE:
        qbuf.append(" or (site.zipcode = ?) ")
        qparams << criteria.zip_code;
        break;
      case GeoType.NEIGHBORHOOD:
        // TODO: Implement neighborhood matching?
        break;
    }
    qbuf.append(")");
    if (criteria.queryMode == QueryMode.FIND_UNITS) {
      qbuf.append(" and (units.unitsize.searchType = ?) ")
      qparams << criteria.searchType;
      qbuf.append(" and (units.unitCount > 0) ");
      qbuf.append(" and (units.unitCount > site.minInventory) ");
      log.info("SEARCHSIZE ..................................... " + criteria.searchSize);
      if (criteria.searchSize && criteria.searchSize != 1) {
        qbuf.append(" and (units.unitsize.id = ?) ");
        qparams << criteria.searchSize;
      }
      qbuf.append(" group by site.id")
    }

    String hql = qbuf.toString();
    log.info(hql);

    def result = StorageSite.executeQuery(hql, qparams);
    if (criteria.queryMode == QueryMode.FIND_UNITS) {
      return StorageSite.findAllByIdInList(result);
    }
    return result; // result is an array of StorageSites

/*
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
*/
    log.info("FIRST CUT: " + storageSites.size() + " sites");

    // We now have all of the sites in this rectangle. Now we need to filter
    // out the ones that do not contain applicable inventory.
//    Integer minInventory = criteria.minInventory();
//
//    def results = []
//    storageSites.each { site ->
//      site.units.find { unit ->
//        def foundit = false
//        if (criteria.searchSize && criteria.searchSize != 1 && unit.unitsize.id == criteria.searchSize && unit.unitCount >= minInventory) {
//          results.add(site);
//          foundit = true
//        }
//        else if (unit.unitsize.searchType == criteria.searchType && unit.unitCount >= minInventory) {
//          results.add(site);
//          foundit = true
//        }
//        foundit // breaks the find loop when true
//      }
//    }
//
//    return results.unique();
    return storageSites;
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
    Integer zoomMin = 7;

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
