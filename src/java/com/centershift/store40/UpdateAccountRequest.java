
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateAccount_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateAccount_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcctId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AcctType" type="{http://www.centershift.com/STORE40/}AccountType"/>
 *         &lt;element name="AcctClass" type="{http://www.centershift.com/STORE40/}AccountClass"/>
 *         &lt;element name="Cflex01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex04" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cflex05" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateAccount_Request", propOrder = {
    "acctId",
    "acctName",
    "acctType",
    "acctClass",
    "cflex01",
    "cflex02",
    "cflex03",
    "cflex04",
    "cflex05"
})
public class UpdateAccountRequest {

    @XmlElement(name = "AcctId")
    protected long acctId;
    @XmlElement(name = "AcctName")
    protected String acctName;
    @XmlElement(name = "AcctType", required = true, nillable = true)
    protected AccountType acctType;
    @XmlElement(name = "AcctClass", required = true, nillable = true)
    protected AccountClass acctClass;
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

    /**
     * Gets the value of the acctId property.
     * 
     */
    public long getAcctId() {
        return acctId;
    }

    /**
     * Sets the value of the acctId property.
     * 
     */
    public void setAcctId(long value) {
        this.acctId = value;
    }

    /**
     * Gets the value of the acctName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctName() {
        return acctName;
    }

    /**
     * Sets the value of the acctName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctName(String value) {
        this.acctName = value;
    }

    /**
     * Gets the value of the acctType property.
     * 
     * @return
     *     possible object is
     *     {@link AccountType }
     *     
     */
    public AccountType getAcctType() {
        return acctType;
    }

    /**
     * Sets the value of the acctType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountType }
     *     
     */
    public void setAcctType(AccountType value) {
        this.acctType = value;
    }

    /**
     * Gets the value of the acctClass property.
     * 
     * @return
     *     possible object is
     *     {@link AccountClass }
     *     
     */
    public AccountClass getAcctClass() {
        return acctClass;
    }

    /**
     * Sets the value of the acctClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountClass }
     *     
     */
    public void setAcctClass(AccountClass value) {
        this.acctClass = value;
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

}
