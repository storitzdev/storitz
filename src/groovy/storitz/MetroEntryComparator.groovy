package storitz

import com.storitz.MetroEntry

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Nov 3, 2010
 * Time: 10:25:55 AM
 * To change this template use File | Settings | File Templates.
 */
class MetroEntryComparator implements Comparator {

  public int compare(Object o1, Object o2) {
    MetroEntry m1 = (MetroEntry) o1
    MetroEntry m2 = (MetroEntry) o2

    if (m1.state == m2.state) {
      return m1.city.compareTo(m2.city)
    }
    return m1.state.display.compareTo(m2.state.display)
  }
}
