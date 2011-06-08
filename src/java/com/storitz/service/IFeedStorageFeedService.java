package com.storitz.service;

import com.storitz.StorageSite;
import storitz.SiteStats;

import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 5/25/11
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IFeedStorageFeedService extends IStorageFeedService {

    /**
     *
     * @param storageSiteInstance
     * @param stats
     * @param writer
     */
    public void updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer);

    /**
     *
     * @param storageSiteInstance
     * @param stats
     * @param writer
     */
    public void updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer);

    /**
     *
     * @param storageSiteInstance
     * @param writer
     */
    public void loadPromos(StorageSite storageSiteInstance, PrintWriter writer);

    /**
     *
     * @param storageSiteInstance
     * @param writer
     */
    public void addSitePhone(StorageSite storageSiteInstance, PrintWriter writer);
}
