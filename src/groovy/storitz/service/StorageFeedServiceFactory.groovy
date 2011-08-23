package storitz.service

import com.storitz.service.IStorageFeedService
import com.storitz.StorageSite
import com.storitz.ServiceMap
import com.storitz.service.ICostStorageFeedService
import com.storitz.service.IMoveInStorageFeedService
import com.storitz.service.IFeedStorageFeedService

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 5/25/11
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
class StorageFeedServiceFactory {

    private static HashMap<String,IStorageFeedService> serviceInstanceMap = new HashMap<String,IStorageFeedService>();
    private static final HashMap<String,IStorageFeedService> serviceClassMap = new HashMap<String,IStorageFeedService>();

    static { // maps codes from storage_site table to class names
        serviceClassMap.put("SL", "storitz.SiteLinkStorageFeedService");
        serviceClassMap.put("CS3", "storitz.CShiftStorageFeedService");
        serviceClassMap.put("CS4", "storitz.CShift4StorageFeedService");
        serviceClassMap.put("QS", "storitz.QuikStorStorageFeedService");
        serviceClassMap.put("EX", "storitz.ExrsStorageFeedService");
        serviceClassMap.put("USI", "storitz.UsiStorageFeedService");
        serviceClassMap.put("DOM", "storitz.EDomicoStorageFeedService");
        serviceClassMap.put("BOB", "storitz.UncleBobsStorageFeedService");
        serviceClassMap.put("STM", "storitz.StorageMartStorageFeedService");
    }

    /**
     *
     * @param site
     * @return
     */

    private static synchronized IStorageFeedService getServiceInstance (StorageSite site) {
        String key = site.source + ":" + site.feed.id;
        if (serviceInstanceMap.containsKey(key)) {
            return serviceInstanceMap.get(key);
        }
        Class klass = Class.forName(serviceClassMap.get(site.source), false, Thread.currentThread().contextClassLoader);
        IStorageFeedService iService = klass.newInstance();
        iService.init(site);
        serviceInstanceMap.put(key, iService);
        return iService;
    }

    /**
     *
     * @param site
     * @return
     */
    public static ICostStorageFeedService getCostServiceInstance (StorageSite site) {
        return (ICostStorageFeedService)getServiceInstance(site);
    }

    /**
     *
     * @param site
     * @return
     */
    public static IMoveInStorageFeedService getMoveInServiceInstance (StorageSite site) {
        return (IMoveInStorageFeedService)getServiceInstance(site);
    }

    /**
     *
     * @param site
     * @return
     */
    public static IFeedStorageFeedService getFeedServiceInstance (StorageSite site) {
        return (IFeedStorageFeedService)getServiceInstance(site);
    }

}
