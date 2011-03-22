package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for RentalActivityReport complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RentalActivityReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SiteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalUnits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BeginningOccupancy" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NewRentals" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TerminatedRentals" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EndOccupancy" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Net" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RevenueChange" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PercentOccupancy" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SQFTOccupancy" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RentalActivityCollection" type="{http://www.centershift.com/STORE40/}ArrayOfRentalActivityReport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentalActivityReport", propOrder = {
        "siteID",
        "siteNumber",
        "siteName",
        "totalUnits",
        "beginningOccupancy",
        "newRentals",
        "terminatedRentals",
        "endOccupancy",
        "net",
        "revenueChange",
        "percentOccupancy",
        "sqftOccupancy",
        "rentalActivityCollection"
})
public class RentalActivityReport {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "SiteNumber")
    protected String siteNumber;
    @XmlElement(name = "SiteName")
    protected String siteName;
    @XmlElement(name = "TotalUnits")
    protected int totalUnits;
    @XmlElement(name = "BeginningOccupancy")
    protected int beginningOccupancy;
    @XmlElement(name = "NewRentals")
    protected int newRentals;
    @XmlElement(name = "TerminatedRentals")
    protected int terminatedRentals;
    @XmlElement(name = "EndOccupancy")
    protected int endOccupancy;
    @XmlElement(name = "Net")
    protected int net;
    @XmlElement(name = "RevenueChange", required = true)
    protected BigDecimal revenueChange;
    @XmlElement(name = "PercentOccupancy", required = true)
    protected BigDecimal percentOccupancy;
    @XmlElement(name = "SQFTOccupancy", required = true)
    protected BigDecimal sqftOccupancy;
    @XmlElement(name = "RentalActivityCollection")
    protected ArrayOfRentalActivityReport rentalActivityCollection;

    /**
     * Gets the value of the siteID property.
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the siteNumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSiteNumber() {
        return siteNumber;
    }

    /**
     * Sets the value of the siteNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSiteNumber(String value) {
        this.siteNumber = value;
    }

    /**
     * Gets the value of the siteName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * Sets the value of the siteName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSiteName(String value) {
        this.siteName = value;
    }

    /**
     * Gets the value of the totalUnits property.
     */
    public int getTotalUnits() {
        return totalUnits;
    }

    /**
     * Sets the value of the totalUnits property.
     */
    public void setTotalUnits(int value) {
        this.totalUnits = value;
    }

    /**
     * Gets the value of the beginningOccupancy property.
     */
    public int getBeginningOccupancy() {
        return beginningOccupancy;
    }

    /**
     * Sets the value of the beginningOccupancy property.
     */
    public void setBeginningOccupancy(int value) {
        this.beginningOccupancy = value;
    }

    /**
     * Gets the value of the newRentals property.
     */
    public int getNewRentals() {
        return newRentals;
    }

    /**
     * Sets the value of the newRentals property.
     */
    public void setNewRentals(int value) {
        this.newRentals = value;
    }

    /**
     * Gets the value of the terminatedRentals property.
     */
    public int getTerminatedRentals() {
        return terminatedRentals;
    }

    /**
     * Sets the value of the terminatedRentals property.
     */
    public void setTerminatedRentals(int value) {
        this.terminatedRentals = value;
    }

    /**
     * Gets the value of the endOccupancy property.
     */
    public int getEndOccupancy() {
        return endOccupancy;
    }

    /**
     * Sets the value of the endOccupancy property.
     */
    public void setEndOccupancy(int value) {
        this.endOccupancy = value;
    }

    /**
     * Gets the value of the net property.
     */
    public int getNet() {
        return net;
    }

    /**
     * Sets the value of the net property.
     */
    public void setNet(int value) {
        this.net = value;
    }

    /**
     * Gets the value of the revenueChange property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRevenueChange() {
        return revenueChange;
    }

    /**
     * Sets the value of the revenueChange property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRevenueChange(BigDecimal value) {
        this.revenueChange = value;
    }

    /**
     * Gets the value of the percentOccupancy property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPercentOccupancy() {
        return percentOccupancy;
    }

    /**
     * Sets the value of the percentOccupancy property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPercentOccupancy(BigDecimal value) {
        this.percentOccupancy = value;
    }

    /**
     * Gets the value of the sqftOccupancy property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getSQFTOccupancy() {
        return sqftOccupancy;
    }

    /**
     * Sets the value of the sqftOccupancy property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setSQFTOccupancy(BigDecimal value) {
        this.sqftOccupancy = value;
    }

    /**
     * Gets the value of the rentalActivityCollection property.
     *
     * @return possible object is
     *         {@link ArrayOfRentalActivityReport }
     */
    public ArrayOfRentalActivityReport getRentalActivityCollection() {
        return rentalActivityCollection;
    }

    /**
     * Sets the value of the rentalActivityCollection property.
     *
     * @param value allowed object is
     *              {@link ArrayOfRentalActivityReport }
     */
    public void setRentalActivityCollection(ArrayOfRentalActivityReport value) {
        this.rentalActivityCollection = value;
    }

}
