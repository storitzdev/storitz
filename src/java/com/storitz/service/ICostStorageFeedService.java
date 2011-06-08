package com.storitz.service;

import com.storitz.Insurance;
import com.storitz.SpecialOffer;
import com.storitz.StorageSite;
import com.storitz.StorageUnit;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 5/25/11
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ICostStorageFeedService extends IStorageFeedService {

    /**
     *
     * @param site
     * @param unit
     * @param promo
     * @param ins
     * @param moveInDate
     * @param extended
     * @return
     */
    public double calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended);

    /**
     *
     * @param site
     * @param unit
     * @param promo
     * @param ins
     * @param moveInDate
     * @return
     */
    public CostTotals calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate);

    /**
     *
     * @param site
     * @param promo
     * @param moveInDate
     * @param allowExtension
     * @return
     */
    public Date calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate, boolean allowExtension);
}
