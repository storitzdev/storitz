package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for GetSiteUnitData_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetSiteUnitData_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Depth" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MinAvailable" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MinRentRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MaxRentRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SoftReservable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HardReservable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GetPromoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSiteUnitData_Request", propOrder = {
        "siteID",
        "width",
        "depth",
        "minAvailable",
        "minRentRate",
        "maxRentRate",
        "softReservable",
        "hardReservable",
        "getPromoData"
})
public class GetSiteUnitDataRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "Width", required = true, nillable = true)
    protected BigDecimal width;
    @XmlElement(name = "Depth", required = true, nillable = true)
    protected BigDecimal depth;
    @XmlElement(name = "MinAvailable", required = true, type = Integer.class, nillable = true)
    protected Integer minAvailable;
    @XmlElement(name = "MinRentRate", required = true, nillable = true)
    protected BigDecimal minRentRate;
    @XmlElement(name = "MaxRentRate", required = true, nillable = true)
    protected BigDecimal maxRentRate;
    @XmlElement(name = "SoftReservable")
    protected String softReservable;
    @XmlElement(name = "HardReservable")
    protected String hardReservable;
    @XmlElement(name = "GetPromoData")
    protected boolean getPromoData;

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
     * Gets the value of the width property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setWidth(BigDecimal value) {
        this.width = value;
    }

    /**
     * Gets the value of the depth property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDepth(BigDecimal value) {
        this.depth = value;
    }

    /**
     * Gets the value of the minAvailable property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMinAvailable() {
        return minAvailable;
    }

    /**
     * Sets the value of the minAvailable property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinAvailable(Integer value) {
        this.minAvailable = value;
    }

    /**
     * Gets the value of the minRentRate property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getMinRentRate() {
        return minRentRate;
    }

    /**
     * Sets the value of the minRentRate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setMinRentRate(BigDecimal value) {
        this.minRentRate = value;
    }

    /**
     * Gets the value of the maxRentRate property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getMaxRentRate() {
        return maxRentRate;
    }

    /**
     * Sets the value of the maxRentRate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setMaxRentRate(BigDecimal value) {
        this.maxRentRate = value;
    }

    /**
     * Gets the value of the softReservable property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSoftReservable() {
        return softReservable;
    }

    /**
     * Sets the value of the softReservable property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSoftReservable(String value) {
        this.softReservable = value;
    }

    /**
     * Gets the value of the hardReservable property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getHardReservable() {
        return hardReservable;
    }

    /**
     * Sets the value of the hardReservable property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHardReservable(String value) {
        this.hardReservable = value;
    }

    /**
     * Gets the value of the getPromoData property.
     */
    public boolean isGetPromoData() {
        return getPromoData;
    }

    /**
     * Sets the value of the getPromoData property.
     */
    public void setGetPromoData(boolean value) {
        this.getPromoData = value;
    }

}
