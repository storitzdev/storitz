
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VoidRetailAssessment_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoidRetailAssessment_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssessIDs" type="{http://www.centershift.com/STORE40/}ArrayOfLong1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoidRetailAssessment_Request", propOrder = {
    "siteID",
    "assessIDs"
})
public class VoidRetailAssessmentRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AssessIDs")
    protected ArrayOfLong1 assessIDs;

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
     * Gets the value of the assessIDs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong1 }
     *     
     */
    public ArrayOfLong1 getAssessIDs() {
        return assessIDs;
    }

    /**
     * Sets the value of the assessIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong1 }
     *     
     */
    public void setAssessIDs(ArrayOfLong1 value) {
        this.assessIDs = value;
    }

}
