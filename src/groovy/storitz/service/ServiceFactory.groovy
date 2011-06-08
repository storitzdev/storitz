package storitz.service

import com.storitz.service.IService
import com.storitz.StorageSite
import com.storitz.ServiceMap
import com.storitz.service.ICostService
import com.storitz.service.IMoveInService
import com.storitz.service.IFeedService

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 5/25/11
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
class ServiceFactory {

    private static HashMap<String,IService> serviceHashMap = new HashMap<String,IService>();

    /**
     *
     * @param site
     * @return
     */

    private static IService getServiceInstance (StorageSite site) {
        IService iService = null;
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

        println "Adding new IService to map: ${serviceMapKey}"
        serviceHashMap.put(serviceMapKey,iService);

        return iService;
    }

    /**
     *
     * @param site
     * @return
     */
    public static ICostService getCostServiceInstance (StorageSite site) {
        return (ICostService)getServiceInstance(site);
    }

    /**
     *
     * @param site
     * @return
     */
    public static IMoveInService getMoveInServiceInstance (StorageSite site) {
        return (IMoveInService)getServiceInstance(site);
    }

    /**
     *
     * @param site
     * @return
     */
    public static IFeedService getFeedServiceInstance (StorageSite site) {
        return (IFeedService)getServiceInstance(site);
    }

}
