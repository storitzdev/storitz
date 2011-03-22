package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplyCreditToAssessments_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ApplyCreditToAssessments_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssessmentInfo" type="{http://www.centershift.com/STORE40/}ArrayOfAssessInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplyCreditToAssessments_Request", propOrder = {
        "orgID",
        "siteID",
        "rentalID",
        "assessmentInfo"
})
public class ApplyCreditToAssessmentsRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "AssessmentInfo")
    protected ArrayOfAssessInfo assessmentInfo;

    /**
     * Gets the value of the orgID property.
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

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
     * Gets the value of the rentalID property.
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the assessmentInfo property.
     *
     * @return possible object is
     *         {@link ArrayOfAssessInfo }
     */
    public ArrayOfAssessInfo getAssessmentInfo() {
        return assessmentInfo;
    }

    /**
     * Sets the value of the assessmentInfo property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAssessInfo }
     */
    public void setAssessmentInfo(ArrayOfAssessInfo value) {
        this.assessmentInfo = value;
    }

}
