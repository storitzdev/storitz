
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TRAN_AUCTION_RENTALS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TRAN_AUCTION_RENTALS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_AUCTION_RENTALSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DEL_RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LIEN_STATE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DEL_SCHED" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DEL_SCHED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_PAYMENT_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TOTAL_DUE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LAST_PAYMENT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_AUCTION_RENTALS", propOrder = {
    "siteid",
    "acctid",
    "rentalid",
    "acctname",
    "unitnumber",
    "icon",
    "ltd",
    "ptd",
    "delrentalid",
    "lienstate",
    "delsched",
    "delschedname",
    "lastpaymentdate",
    "totaldue",
    "lastpaymentamount"
})
public class TRANAUCTIONRENTALS
    extends BaseEntityOfCollectionTRANAUCTIONRENTALSColumnIndexes
{

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "RENTAL_ID")
    protected long rentalid;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "ICON")
    protected String icon;
    @XmlElement(name = "LTD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ltd;
    @XmlElement(name = "PTD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ptd;
    @XmlElement(name = "DEL_RENTAL_ID")
    protected long delrentalid;
    @XmlElement(name = "LIEN_STATE")
    protected int lienstate;
    @XmlElement(name = "DEL_SCHED", required = true, nillable = true)
    protected BigDecimal delsched;
    @XmlElement(name = "DEL_SCHED_NAME")
    protected String delschedname;
    @XmlElement(name = "LAST_PAYMENT_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastpaymentdate;
    @XmlElement(name = "TOTAL_DUE", required = true, nillable = true)
    protected BigDecimal totaldue;
    @XmlElement(name = "LAST_PAYMENT_AMOUNT", required = true, nillable = true)
    protected BigDecimal lastpaymentamount;

    /**
     * Gets the value of the siteid property.
     * 
     */
    public long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     */
    public void setSITEID(long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the acctid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setACCTID(Long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the rentalid property.
     * 
     */
    public long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     * 
     */
    public void setRENTALID(long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the acctname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTNAME() {
        return acctname;
    }

    /**
     * Sets the value of the acctname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTNAME(String value) {
        this.acctname = value;
    }

    /**
     * Gets the value of the unitnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITNUMBER() {
        return unitnumber;
    }

    /**
     * Sets the value of the unitnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITNUMBER(String value) {
        this.unitnumber = value;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICON() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICON(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the ltd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLTD() {
        return ltd;
    }

    /**
     * Sets the value of the ltd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLTD(XMLGregorianCalendar value) {
        this.ltd = value;
    }

    /**
     * Gets the value of the ptd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPTD() {
        return ptd;
    }

    /**
     * Sets the value of the ptd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPTD(XMLGregorianCalendar value) {
        this.ptd = value;
    }

    /**
     * Gets the value of the delrentalid property.
     * 
     */
    public long getDELRENTALID() {
        return delrentalid;
    }

    /**
     * Sets the value of the delrentalid property.
     * 
     */
    public void setDELRENTALID(long value) {
        this.delrentalid = value;
    }

    /**
     * Gets the value of the lienstate property.
     * 
     */
    public int getLIENSTATE() {
        return lienstate;
    }

    /**
     * Sets the value of the lienstate property.
     * 
     */
    public void setLIENSTATE(int value) {
        this.lienstate = value;
    }

    /**
     * Gets the value of the delsched property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDELSCHED() {
        return delsched;
    }

    /**
     * Sets the value of the delsched property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDELSCHED(BigDecimal value) {
        this.delsched = value;
    }

    /**
     * Gets the value of the delschedname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELSCHEDNAME() {
        return delschedname;
    }

    /**
     * Sets the value of the delschedname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELSCHEDNAME(String value) {
        this.delschedname = value;
    }

    /**
     * Gets the value of the lastpaymentdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLASTPAYMENTDATE() {
        return lastpaymentdate;
    }

    /**
     * Sets the value of the lastpaymentdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLASTPAYMENTDATE(XMLGregorianCalendar value) {
        this.lastpaymentdate = value;
    }

    /**
     * Gets the value of the totaldue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTOTALDUE() {
        return totaldue;
    }

    /**
     * Sets the value of the totaldue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTOTALDUE(BigDecimal value) {
        this.totaldue = value;
    }

    /**
     * Gets the value of the lastpaymentamount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLASTPAYMENTAMOUNT() {
        return lastpaymentamount;
    }

    /**
     * Sets the value of the lastpaymentamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLASTPAYMENTAMOUNT(BigDecimal value) {
        this.lastpaymentamount = value;
    }

}
