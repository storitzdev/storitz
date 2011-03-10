
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendEmailWithPassword_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendEmailWithPassword_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EcommID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EmailType" type="{http://www.centershift.com/STORE40/}emailMsgTemplateIds"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendEmailWithPassword_Request", propOrder = {
    "orgID",
    "siteID",
    "accountID",
    "ecommID",
    "emailType",
    "email",
    "password"
})
public class SendEmailWithPasswordRequest {

    @XmlElement(name = "OrgID", required = true, type = Long.class, nillable = true)
    protected Long orgID;
    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "AccountID", required = true, type = Long.class, nillable = true)
    protected Long accountID;
    @XmlElement(name = "EcommID", required = true, type = Long.class, nillable = true)
    protected Long ecommID;
    @XmlElement(name = "EmailType", required = true)
    protected EmailMsgTemplateIds emailType;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Password")
    protected String password;

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
     * Gets the value of the accountID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountID(Long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the ecommID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEcommID() {
        return ecommID;
    }

    /**
     * Sets the value of the ecommID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEcommID(Long value) {
        this.ecommID = value;
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
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

}
