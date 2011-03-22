package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ACCT_CONTACT_ADDRESSES complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ACCT_CONTACT_ADDRESSES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionACCT_CONTACT_ADDRESSESColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACCT_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_CLASS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACCT_CLASS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CONTACT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CONTACT_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ADDR_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ADDR_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSTAL_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACCT_CONTACT_ADDRESSES", propOrder = {
        "orgid",
        "acctid",
        "accttype",
        "accttypeval",
        "acctclass",
        "acctclassval",
        "acctname",
        "contactid",
        "contacttype",
        "contacttypeval",
        "addrid",
        "addrtype",
        "addrtypeval",
        "address",
        "addr1",
        "addr2",
        "addr3",
        "city",
        "state",
        "postalcode",
        "country",
        "active",
        "createdby",
        "updatedby"
})
public class ACCTCONTACTADDRESSES
        extends BaseEntityOfCollectionACCTCONTACTADDRESSESColumnIndexes {

    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "ACCT_TYPE")
    protected int accttype;
    @XmlElement(name = "ACCT_TYPE_VAL")
    protected String accttypeval;
    @XmlElement(name = "ACCT_CLASS")
    protected int acctclass;
    @XmlElement(name = "ACCT_CLASS_VAL")
    protected String acctclassval;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "CONTACT_ID")
    protected long contactid;
    @XmlElement(name = "CONTACT_TYPE")
    protected int contacttype;
    @XmlElement(name = "CONTACT_TYPE_VAL")
    protected String contacttypeval;
    @XmlElement(name = "ADDR_ID")
    protected long addrid;
    @XmlElement(name = "ADDR_TYPE")
    protected int addrtype;
    @XmlElement(name = "ADDR_TYPE_VAL")
    protected String addrtypeval;
    @XmlElement(name = "ADDRESS")
    protected String address;
    @XmlElement(name = "ADDR1")
    protected String addr1;
    @XmlElement(name = "ADDR2")
    protected String addr2;
    @XmlElement(name = "ADDR3")
    protected String addr3;
    @XmlElement(name = "CITY")
    protected String city;
    @XmlElement(name = "STATE")
    protected String state;
    @XmlElement(name = "POSTAL_CODE")
    protected String postalcode;
    @XmlElement(name = "COUNTRY")
    protected String country;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

    /**
     * Gets the value of the orgid property.
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the acctid property.
     */
    public long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     */
    public void setACCTID(long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the accttype property.
     */
    public int getACCTTYPE() {
        return accttype;
    }

    /**
     * Sets the value of the accttype property.
     */
    public void setACCTTYPE(int value) {
        this.accttype = value;
    }

    /**
     * Gets the value of the accttypeval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCTTYPEVAL() {
        return accttypeval;
    }

    /**
     * Sets the value of the accttypeval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCTTYPEVAL(String value) {
        this.accttypeval = value;
    }

    /**
     * Gets the value of the acctclass property.
     */
    public int getACCTCLASS() {
        return acctclass;
    }

    /**
     * Sets the value of the acctclass property.
     */
    public void setACCTCLASS(int value) {
        this.acctclass = value;
    }

    /**
     * Gets the value of the acctclassval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCTCLASSVAL() {
        return acctclassval;
    }

    /**
     * Sets the value of the acctclassval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCTCLASSVAL(String value) {
        this.acctclassval = value;
    }

    /**
     * Gets the value of the acctname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCTNAME() {
        return acctname;
    }

    /**
     * Sets the value of the acctname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCTNAME(String value) {
        this.acctname = value;
    }

    /**
     * Gets the value of the contactid property.
     */
    public long getCONTACTID() {
        return contactid;
    }

    /**
     * Sets the value of the contactid property.
     */
    public void setCONTACTID(long value) {
        this.contactid = value;
    }

    /**
     * Gets the value of the contacttype property.
     */
    public int getCONTACTTYPE() {
        return contacttype;
    }

    /**
     * Sets the value of the contacttype property.
     */
    public void setCONTACTTYPE(int value) {
        this.contacttype = value;
    }

    /**
     * Gets the value of the contacttypeval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCONTACTTYPEVAL() {
        return contacttypeval;
    }

    /**
     * Sets the value of the contacttypeval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCONTACTTYPEVAL(String value) {
        this.contacttypeval = value;
    }

    /**
     * Gets the value of the addrid property.
     */
    public long getADDRID() {
        return addrid;
    }

    /**
     * Sets the value of the addrid property.
     */
    public void setADDRID(long value) {
        this.addrid = value;
    }

    /**
     * Gets the value of the addrtype property.
     */
    public int getADDRTYPE() {
        return addrtype;
    }

    /**
     * Sets the value of the addrtype property.
     */
    public void setADDRTYPE(int value) {
        this.addrtype = value;
    }

    /**
     * Gets the value of the addrtypeval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDRTYPEVAL() {
        return addrtypeval;
    }

    /**
     * Sets the value of the addrtypeval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDRTYPEVAL(String value) {
        this.addrtypeval = value;
    }

    /**
     * Gets the value of the address property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDRESS() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDRESS(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the addr1 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDR1() {
        return addr1;
    }

    /**
     * Sets the value of the addr1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDR1(String value) {
        this.addr1 = value;
    }

    /**
     * Gets the value of the addr2 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDR2() {
        return addr2;
    }

    /**
     * Sets the value of the addr2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDR2(String value) {
        this.addr2 = value;
    }

    /**
     * Gets the value of the addr3 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDR3() {
        return addr3;
    }

    /**
     * Sets the value of the addr3 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDR3(String value) {
        this.addr3 = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCITY() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCITY(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTATE() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTATE(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalcode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPOSTALCODE() {
        return postalcode;
    }

    /**
     * Sets the value of the postalcode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPOSTALCODE(String value) {
        this.postalcode = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCOUNTRY() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCOUNTRY(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the active property.
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     */
    public void setACTIVE(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the createdby property.
     */
    public long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     */
    public void setCREATEDBY(long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the updatedby property.
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
    }

}
