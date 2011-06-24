package com.storitz.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 5/25/11
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class CostTotals {

    private boolean extended;
    private double  duration;
    private double  discountTotal;
    private double  feesTotal;
    private double  rentTotal;
    private double  insuranceCost;
    private double  tax;
    private double  deposit;
    private double  moveInTotal;
    private Date    paidThruDate;
    private int     durationMonths;
    private int     durationDays;

    public boolean isExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(double discountTotal) {
        this.discountTotal = discountTotal;
    }

    public double getFeesTotal() {
        return feesTotal;
    }

    public void setFeesTotal(double feesTotal) {
        this.feesTotal = feesTotal;
    }

    public double getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(double rentTotal) {
        this.rentTotal = rentTotal;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getMoveInTotal() {
        return moveInTotal;
    }

    public void setMoveInTotal(double moveInTotal) {
        this.moveInTotal = moveInTotal;
    }

    public Date getPaidThruDate() {
        return paidThruDate;
    }

    public String getPaidThruDateString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");
        return simpleDateFormat.format(getPaidThruDate());
    }

    public void setPaidThruDate(Date paidThruDate) {
        this.paidThruDate = paidThruDate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }
}
