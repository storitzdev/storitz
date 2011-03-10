
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendEmailContact_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendEmailContact_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EmailType" type="{http://www.centershift.com/STORE40/}emailMsgTemplateIds"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendEmailContact_Request", propOrder = {
    "orgID",
    "siteID",
    "emailType",
    "name",
    "email",
    "message",
    "telephone",
    "unitNumber"
})
public class SendEmailContactRequest {

    @XmlElement(name = "OrgID", required = true, type = Long.class, nillable = true)
    protected Long orgID;
    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "EmailType", required = true)
    protected EmailMsgTemplateIds emailType;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Telephone")
    protected String telephone;
    @XmlElement(name = "UnitNumber")
    protected String unitNumber;

    /**
     * Gets the value of the orgID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgID(Long value) {
        this.orgID = value;
    }

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
     * Gets the value of the emailType property.
     * 
     * @return
     *     possible object is
     *     {@link EmailMsgTemplateIds }
     *     
     */
    public EmailMsgTemplateIds getEmailType() {
        return emailType;
    }

    /**
     * Sets the value of the emailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailMsgTemplateIds }
     *     
     */
    public void setEmailType(EmailMsgTemplateIds value) {
        this.emailType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the unitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * Sets the value of the unitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitNumber(String value) {
        this.unitNumber = value;
    }

}
