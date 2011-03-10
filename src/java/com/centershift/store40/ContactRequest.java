
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Contact_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Contact_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContactId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KnownAs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactType" type="{http://www.centershift.com/STORE40/}ContactType"/>
 *         &lt;element name="Employer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DLNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DLState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EcommCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex04" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex05" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Addresses" type="{http://www.centershift.com/STORE40/}ArrayOfContactAddress" minOccurs="0"/>
 *         &lt;element name="Phones" type="{http://www.centershift.com/STORE40/}ArrayOfContactPhone" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact_Request", propOrder = {
    "acctID",
    "contactId",
    "firstName",
    "lastName",
    "knownAs",
    "contactType",
    "employer",
    "active",
    "email",
    "dlNumber",
    "dlState",
    "dob",
    "ssn",
    "ecommCode",
    "cflex01",
    "cflex02",
    "cflex03",
    "cflex04",
    "cflex05",
    "addresses",
    "phones"
})
public class ContactRequest {

    @XmlElement(name = "AcctID", required = true, type = Long.class, nillable = true)
    protected Long acctID;
    @XmlElement(name = "ContactId", required = true, type = Long.class, nillable = true)
    protected Long contactId;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "KnownAs")
    protected String knownAs;
    @XmlElement(name = "ContactType", required = true, nillable = true)
    protected ContactType contactType;
    @XmlElement(name = "Employer")
    protected String employer;
    @XmlElement(name = "Active", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "DLNumber")
    protected String dlNumber;
    @XmlElement(name = "DLState")
    protected String dlState;
    @XmlElement(name = "DOB")
    protected String dob;
    @XmlElement(name = "SSN")
    protected String ssn;
    @XmlElement(name = "EcommCode")
    protected String ecommCode;
    @XmlElement(name = "Cflex01")
    protected String cflex01;
    @XmlElement(name = "Cflex02")
    protected String cflex02;
    @XmlElement(name = "Cflex03")
    protected String cflex03;
    @XmlElement(name = "Cflex04")
    protected String cflex04;
    @XmlElement(name = "Cflex05")
    protected String cflex05;
    @XmlElement(name = "Addresses")
    protected ArrayOfContactAddress addresses;
    @XmlElement(name = "Phones")
    protected ArrayOfContactPhone phones;

    /**
     * Gets the value of the acctID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAcctID(Long value) {
        this.acctID = value;
    }

    /**
     * Gets the value of the contactId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * Sets the value of the contactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContactId(Long value) {
        this.contactId = value;
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
     * Gets the value of the knownAs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKnownAs() {
        return knownAs;
    }

    /**
     * Sets the value of the knownAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKnownAs(String value) {
        this.knownAs = value;
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
     * Gets the value of the employer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * Sets the value of the employer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployer(String value) {
        this.employer = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
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
     * Gets the value of the dlNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDLNumber() {
        return dlNumber;
    }

    /**
     * Sets the value of the dlNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDLNumber(String value) {
        this.dlNumber = value;
    }

    /**
     * Gets the value of the dlState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDLState() {
        return dlState;
    }

    /**
     * Sets the value of the dlState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDLState(String value) {
        this.dlState = value;
    }

    /**
     * Gets the value of the dob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOB() {
        return dob;
    }

    /**
     * Sets the value of the dob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOB(String value) {
        this.dob = value;
    }

    /**
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSN(String value) {
        this.ssn = value;
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

    /**
     * Gets the value of the cflex01 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCflex01() {
        return cflex01;
    }

    /**
     * Sets the value of the cflex01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCflex01(String value) {
        this.cflex01 = value;
    }

    /**
     * Gets the value of the cflex02 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCflex02() {
        return cflex02;
    }

    /**
     * Sets the value of the cflex02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCflex02(String value) {
        this.cflex02 = value;
    }

    /**
     * Gets the value of the cflex03 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCflex03() {
        return cflex03;
    }

    /**
     * Sets the value of the cflex03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCflex03(String value) {
        this.cflex03 = value;
    }

    /**
     * Gets the value of the cflex04 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCflex04() {
        return cflex04;
    }

    /**
     * Sets the value of the cflex04 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCflex04(String value) {
        this.cflex04 = value;
    }

    /**
     * Gets the value of the cflex05 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCflex05() {
        return cflex05;
    }

    /**
     * Sets the value of the cflex05 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCflex05(String value) {
        this.cflex05 = value;
    }

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfContactAddress }
     *     
     */
    public ArrayOfContactAddress getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfContactAddress }
     *     
     */
    public void setAddresses(ArrayOfContactAddress value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the phones property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfContactPhone }
     *     
     */
    public ArrayOfContactPhone getPhones() {
        return phones;
    }

    /**
     * Sets the value of the phones property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfContactPhone }
     *     
     */
    public void setPhones(ArrayOfContactPhone value) {
        this.phones = value;
    }

}
