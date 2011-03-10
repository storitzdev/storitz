
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateUnitStatus_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateUnitStatus_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PutOnHold" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateUnitStatus_Request", propOrder = {
    "siteID",
    "unitID",
    "version",
    "putOnHold"
})
public class UpdateUnitStatusRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "Version", required = true)
    protected BigDecimal version;
    @XmlElement(name = "PutOnHold")
    protected boolean putOnHold;

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
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVersion(BigDecimal value) {
        this.version = value;
    }

    /**
     * Gets the value of the putOnHold property.
     * 
     */
    public boolean isPutOnHold() {
        return putOnHold;
    }

    /**
     * Sets the value of the putOnHold property.
     * 
     */
    public void setPutOnHold(boolean value) {
        this.putOnHold = value;
    }

}
