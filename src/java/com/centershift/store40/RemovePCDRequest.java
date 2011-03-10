
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RemovePCD_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RemovePCD_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssessmentID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemovePCD_Request", propOrder = {
    "siteID",
    "assessmentID"
})
public class RemovePCDRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AssessmentID")
    protected long assessmentID;

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
     * Gets the value of the assessmentID property.
     * 
     */
    public long getAssessmentID() {
        return assessmentID;
    }

    /**
     * Sets the value of the assessmentID property.
     * 
     */
    public void setAssessmentID(long value) {
        this.assessmentID = value;
    }

}
