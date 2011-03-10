
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VoidFee_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoidFee_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "VoidFee_Request", propOrder = {
    "orgID",
    "siteID",
    "acctID",
    "assessmentID"
})
public class VoidFeeRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AcctID")
    protected long acctID;
    @XmlElement(name = "AssessmentID")
    protected long assessmentID;

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
     * Gets the value of the acctID property.
     * 
     */
    public long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     * 
     */
    public void setAcctID(long value) {
        this.acctID = value;
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
