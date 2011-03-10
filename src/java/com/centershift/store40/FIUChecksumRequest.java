
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FIUChecksum_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FIUChecksum_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LogID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Checksum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIUChecksum_Request", propOrder = {
    "siteID",
    "logID",
    "checksum"
})
public class FIUChecksumRequest {

    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "LogID", required = true, type = Long.class, nillable = true)
    protected Long logID;
    @XmlElement(name = "Checksum")
    protected String checksum;

    /**
     * Gets the value of the siteID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSiteID(Long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the logID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogID() {
        return logID;
    }

    /**
     * Sets the value of the logID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogID(Long value) {
        this.logID = value;
    }

    /**
     * Gets the value of the checksum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * Sets the value of the checksum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChecksum(String value) {
        this.checksum = value;
    }

}
