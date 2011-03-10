
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateStreetRate_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateStreetRate_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="StreetRateData" type="{http://www.centershift.com/STORE40/}ArrayOfUpdateStreetReqData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateStreetRate_Request", propOrder = {
    "siteID",
    "streetRateData"
})
public class UpdateStreetRateRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "StreetRateData")
    protected ArrayOfUpdateStreetReqData streetRateData;

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
     * Gets the value of the streetRateData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUpdateStreetReqData }
     *     
     */
    public ArrayOfUpdateStreetReqData getStreetRateData() {
        return streetRateData;
    }

    /**
     * Sets the value of the streetRateData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUpdateStreetReqData }
     *     
     */
    public void setStreetRateData(ArrayOfUpdateStreetReqData value) {
        this.streetRateData = value;
    }

}
