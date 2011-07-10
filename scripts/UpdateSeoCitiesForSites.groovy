package storitz

import com.storitz.StorageSite
import com.storitz.StoritzUtil

try {
    def storageSites = StorageSite.findAllByDisabled(0);
    println "  -> Found ${storageSites.size()} sites"
    storageSites.each { site ->
        if (site.seoCity == null) {
          site.seoCity = StoritzUtil.seoEncode(site.city); // TODO: is this even necessary? Should be done automatically by beforeUpdate when we call save?
          site.save(flush: true)
        }
    }
    println "Job complete."
}
catch (Exception e) {
    println("ERROR:")
    e.printStackTrace()
}
