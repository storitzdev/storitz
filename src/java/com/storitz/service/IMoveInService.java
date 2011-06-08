package com.storitz.service;

import com.storitz.RentalTransaction;
import storitz.MoveInDetails;

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 5/25/11
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IMoveInService extends IService {

    /**
     *
     * @param trans
     * @return
     */
    public boolean checkRented(RentalTransaction trans);

    /**
     *
     * @param trans
     * @return
     */
    public MoveInDetails moveInDetail(RentalTransaction trans);

    /**
     *
     * @param trans
     * @return
     */
    public boolean moveIn(RentalTransaction trans);

    /**
     *
     * @param trans
     * @return
     */
    public boolean reserve(RentalTransaction trans);
}
