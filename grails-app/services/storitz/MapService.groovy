package storitz

import com.storitz.StorageSite
import com.storitz.geoip.GeoIp
import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest

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

  private static enum CRITERIA_MODE {
    COUNT,
    FETCH
  }

  def getSitesClosure = { criteria, mode ->
    return {
      if (mode == CRITERIA_MODE.COUNT) {
        projections {
          countDistinct("id")
        }
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
      units {
        if (criteria.queryMode == QueryMode.FIND_UNITS) {
          unitsize {
            and {
              eq("searchType", criteria.searchType)
              if (criteria.searchSize && criteria.searchSize != 1) {
                eq("id", criteria.searchSize)
              }
            }
          }
          sqlRestriction("unit_count >= min_inventory")
        }
      }
      if (mode == CRITERIA_MODE.FETCH) {
        specialOffers {
          eq("active", true)
          eq("featured", true)
          restrictions {

          }
          tags {

          }
        }
        insurances {
          eq("active", true)
        }
        images {
          eq("isCover", true)
        }
      }
    }
  }

  def countSites(SearchCriteria criteria) {
    def c = StorageSite.createCriteria()
    return c.get(getSitesClosure(criteria, CRITERIA_MODE.COUNT))
  }

  def getSites(SearchCriteria criteria) {
    def c = StorageSite.createCriteria();
    return c.listDistinct(getSitesClosure(criteria, CRITERIA_MODE.FETCH))
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
    } else if (count <= 3) {
      // grow up to a couple of notches
      def targetZoom = zoom - 3
      while (zoom > targetZoom && count <= 3) {
        zoom--
        criteria.setBounds(zoom, width, height)
        count = countSites(criteria)
      }
    }
  }
}
