
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateNewAccount_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateNewAccount_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountClass" type="{http://www.centershift.com/STORE40/}AccountClass"/>
 *         &lt;element name="ContactType" type="{http://www.centershift.com/STORE40/}ContactType"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactAddress" type="{http://www.centershift.com/STORE40/}ArrayOfContactAddress" minOccurs="0"/>
 *         &lt;element name="ContactPhone" type="{http://www.centershift.com/STORE40/}ArrayOfACCT_CONTACT_PHONES" minOccurs="0"/>
 *         &lt;element name="EcommCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateNewAccount_Request", propOrder = {
    "orgID",
    "siteID",
    "firstName",
    "lastName",
    "accountName",
    "accountClass",
    "contactType",
    "email",
    "contactAddress",
    "contactPhone",
    "ecommCode"
})
public class CreateNewAccountRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "AccountName")
    protected String accountName;
    @XmlElement(name = "AccountClass", required = true)
    protected AccountClass accountClass;
    @XmlElement(name = "ContactType", required = true)
    protected ContactType contactType;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "ContactAddress")
    protected ArrayOfContactAddress contactAddress;
    @XmlElement(name = "ContactPhone")
    protected ArrayOfACCTCONTACTPHONES contactPhone;
    @XmlElement(name = "EcommCode")
    protected String ecommCode;

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
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the accountClass property.
     * 
     * @return
     *     possible object is
     *     {@link AccountClass }
     *     
     */
    public AccountClass getAccountClass() {
        return accountClass;
    }

    /**
     * Sets the value of the accountClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountClass }
     *     
     */
    public void setAccountClass(AccountClass value) {
        this.accountClass = value;
    }

    /**
     * Gets the value of the contactType property.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getContactType() {
        return contactType;
    }

    /**
     * Sets the value of the contactType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setContactType(ContactType value) {
        this.contactType = value;
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
     * Gets the value of the contactAddress property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfContactAddress }
     *     
     */
    public ArrayOfContactAddress getContactAddress() {
        return contactAddress;
    }

    /**
     * Sets the value of the contactAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfContactAddress }
     *     
     */
    public void setContactAddress(ArrayOfContactAddress value) {
        this.contactAddress = value;
    }

    /**
     * Gets the value of the contactPhone property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfACCTCONTACTPHONES }
     *     
     */
    public ArrayOfACCTCONTACTPHONES getContactPhone() {
        return contactPhone;
    }

    /**
     * Sets the value of the contactPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfACCTCONTACTPHONES }
     *     
     */
    public void setContactPhone(ArrayOfACCTCONTACTPHONES value) {
        this.contactPhone = value;
    }

    /**
     * Gets the value of the ecommCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcommCode() {
        return ecommCode;
    }

    /**
     * Sets the value of the ecommCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcommCode(String value) {
        this.ecommCode = value;
    }

}
