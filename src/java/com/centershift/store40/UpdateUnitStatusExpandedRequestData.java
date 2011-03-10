
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateUnitStatusExpanded_RequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateUnitStatusExpanded_RequestData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitVersion" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UnitStatus" type="{http://www.centershift.com/STORE40/}unitStsVals"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateUnitStatusExpanded_RequestData", propOrder = {
    "orgID",
    "siteID",
    "unitID",
    "unitVersion",
    "unitStatus"
})
public class UpdateUnitStatusExpandedRequestData {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "UnitVersion", required = true)
    protected BigDecimal unitVersion;
    @XmlElement(name = "UnitStatus", required = true)
    protected UnitStsVals unitStatus;

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
     * Gets the value of the unitVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitVersion() {
        return unitVersion;
    }

    /**
     * Sets the value of the unitVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitVersion(BigDecimal value) {
        this.unitVersion = value;
    }

    /**
     * Gets the value of the unitStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UnitStsVals }
     *     
     */
    public UnitStsVals getUnitStatus() {
        return unitStatus;
    }

    /**
     * Sets the value of the unitStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitStsVals }
     *     
     */
    public void setUnitStatus(UnitStsVals value) {
        this.unitStatus = value;
    }

}
