
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ACCT_CONTACT_PHONES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ACCT_CONTACT_PHONES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionACCT_CONTACT_PHONESColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PHONE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PHONE_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PHONE_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACCT_CONTACT_PHONES", propOrder = {
    "acctid",
    "contactid",
    "phoneid",
    "phonetype",
    "phonetypeval",
    "phone",
    "active",
    "createdby",
    "updatedby"
})
public class ACCTCONTACTPHONES
    extends BaseEntityOfCollectionACCTCONTACTPHONESColumnIndexes
{

    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "CONTACT_ID")
    protected long contactid;
    @XmlElement(name = "PHONE_ID")
    protected long phoneid;
    @XmlElement(name = "PHONE_TYPE")
    protected int phonetype;
    @XmlElement(name = "PHONE_TYPE_VAL")
    protected String phonetypeval;
    @XmlElement(name = "PHONE")
    protected String phone;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

    /**
     * Gets the value of the acctid property.
     * 
     */
    public long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     * 
     */
    public void setACCTID(long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the contactid property.
     * 
     */
    public long getCONTACTID() {
        return contactid;
    }

    /**
     * Sets the value of the contactid property.
     * 
     */
    public void setCONTACTID(long value) {
        this.contactid = value;
    }

    /**
     * Gets the value of the phoneid property.
     * 
     */
    public long getPHONEID() {
        return phoneid;
    }

    /**
     * Sets the value of the phoneid property.
     * 
     */
    public void setPHONEID(long value) {
        this.phoneid = value;
    }

    /**
     * Gets the value of the phonetype property.
     * 
     */
    public int getPHONETYPE() {
        return phonetype;
    }

    /**
     * Sets the value of the phonetype property.
     * 
     */
    public void setPHONETYPE(int value) {
        this.phonetype = value;
    }

    /**
     * Gets the value of the phonetypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHONETYPEVAL() {
        return phonetypeval;
    }

    /**
     * Sets the value of the phonetypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHONETYPEVAL(String value) {
        this.phonetypeval = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHONE() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHONE(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setACTIVE(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the createdby property.
     * 
     */
    public long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     */
    public void setCREATEDBY(long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the updatedby property.
     * 
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     * 
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
    }

}
