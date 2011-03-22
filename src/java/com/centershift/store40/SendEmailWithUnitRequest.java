package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendEmailWithUnit_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SendEmailWithUnit_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EmailType" type="{http://www.centershift.com/STORE40/}emailMsgTemplateIds"/>
 *         &lt;element name="UnitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendEmailWithUnit_Request", propOrder = {
        "orgID",
        "siteID",
        "rentalID",
        "emailType",
        "unitNumber"
})
public class SendEmailWithUnitRequest {

    @XmlElement(name = "OrgID", required = true, type = Long.class, nillable = true)
    protected Long orgID;
    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "RentalID", required = true, type = Long.class, nillable = true)
    protected Long rentalID;
    @XmlElement(name = "EmailType", required = true)
    protected EmailMsgTemplateIds emailType;
    @XmlElement(name = "UnitNumber")
    protected String unitNumber;

    /**
     * Gets the value of the orgID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setOrgID(Long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the siteID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSiteID(Long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the rentalID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRentalID(Long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the emailType property.
     *
     * @return possible object is
     *         {@link EmailMsgTemplateIds }
     */
    public EmailMsgTemplateIds getEmailType() {
        return emailType;
    }

    /**
     * Sets the value of the emailType property.
     *
     * @param value allowed object is
     *              {@link EmailMsgTemplateIds }
     */
    public void setEmailType(EmailMsgTemplateIds value) {
        this.emailType = value;
    }

    /**
     * Gets the value of the unitNumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * Sets the value of the unitNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUnitNumber(String value) {
        this.unitNumber = value;
    }

}
