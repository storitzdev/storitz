package storitz

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 3/29/11
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */

// This class is used by inventory, promos, phones update scripts

class LocalContext {
  def mergedJobDataMap

    LocalContext(name, src) {
        mergedJobDataMap = [from : name , source : src ]
    }
}
