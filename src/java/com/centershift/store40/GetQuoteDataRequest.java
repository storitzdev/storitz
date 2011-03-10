
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetQuoteData_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetQuoteData_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PromoID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetQuoteData_Request", propOrder = {
    "orgID",
    "siteID",
    "unitID",
    "rentRate",
    "promoID"
})
public class GetQuoteDataRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "RentRate", required = true)
    protected BigDecimal rentRate;
    @XmlElement(name = "PromoID", required = true, type = Long.class, nillable = true)
    protected Long promoID;

    /**
     * Gets the value of the orgID property.
     * 
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the siteID property.
     * 
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     * 
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the unitID property.
     * 
     */
    public long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     * 
     */
    public void setUnitID(long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the rentRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRentRate() {
        return rentRate;
    }

    /**
     * Sets the value of the rentRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRentRate(BigDecimal value) {
        this.rentRate = value;
    }

    /**
     * Gets the value of the promoID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPromoID() {
        return promoID;
    }

    /**
     * Sets the value of the promoID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPromoID(Long value) {
        this.promoID = value;
    }

}
