/* One-Shot script. Replicate Uncle Bob's logo across all their sites. */

import com.storitz.*;
import storitz.*;

def alexandria_site = StorageSite.get(4547)
def alexandria_site_logo = alexandria_site.logo

StorageSite.findAllBySource('BOB').each { bob ->
    if (bob.id == 4547) {
        println "Skipping Alexandria Site..."
    }
    else {
        println "Processing ${bob.title}"
        bob.logo = new SiteImage();
        bob.logo.imgOrder = alexandria_site_logo.imgOrder;
        bob.logo.isCover = alexandria_site_logo.isCover;
        bob.logo.isLogo = alexandria_site_logo.isLogo;
        bob.logo.hasThumbnail = alexandria_site_logo.hasThumbnail;
        bob.logo.fileLocation = alexandria_site_logo.fileLocation;
        bob.logo.basename = alexandria_site_logo.basename;
        bob.logo.caption = alexandria_site_logo.caption;
        bob.logo.tags = alexandria_site_logo.tags;
        bob.logo.site = bob;
        bob.logo.save(flush:true);
        bob.save(flush:true);
    }
}
