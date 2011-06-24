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

    private static HashMap<String,IStorageFeedService> serviceHashMap = new HashMap<String,IStorageFeedService>();

    /**
     *
     * @param site
     * @return
     */

    private static synchronized IStorageFeedService getServiceInstance (StorageSite site) {
        IStorageFeedService iService = null;
        Class klass = null;
        ServiceMap serviceMap = null;

        serviceMap = ServiceMap.findByServiceName(site.source);

        String serviceMapKey = serviceMap.serviceName + ":" + site.feed.id + ":" + serviceMap.serviceHandler;

        if (serviceHashMap.containsKey(serviceMapKey)) {
            return serviceHashMap.get(serviceMapKey);
        }

        klass = Class.forName(serviceMap.serviceHandler,false,Thread.currentThread().contextClassLoader);
        iService = klass.newInstance();
        iService.init(site);

        println "Adding new IStorageFeedService to map: ${serviceMapKey}"
        serviceHashMap.put(serviceMapKey,iService);

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
