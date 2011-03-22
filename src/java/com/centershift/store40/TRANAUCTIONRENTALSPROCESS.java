package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for TRAN_AUCTION_RENTALS_PROCESS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_AUCTION_RENTALS_PROCESS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_AUCTION_RENTALS_PROCESSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AUCTION_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AUCTION_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUCTION_TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_CONTENTS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DEL_RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LIEN_STATE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LAST_PAYMENT_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TOTAL_DUE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LAST_PAYMENT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="AUCTION_OBJ_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UNIT_STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_AUCTION_RENTALS_PROCESS", propOrder = {
        "siteid",
        "acctid",
        "rentalid",
        "auctionid",
        "auctiondate",
        "auctiontime",
        "acctname",
        "unitnumber",
        "icon",
        "notes",
        "unitcontents",
        "ltd",
        "ptd",
        "delrentalid",
        "lienstate",
        "lastpaymentdate",
        "totaldue",
        "lastpaymentamount",
        "auctionobjid",
        "unitstatus"
})
public class TRANAUCTIONRENTALSPROCESS
        extends BaseEntityOfCollectionTRANAUCTIONRENTALSPROCESSColumnIndexes {

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "RENTAL_ID")
    protected long rentalid;
    @XmlElement(name = "AUCTION_ID")
    protected long auctionid;
    @XmlElement(name = "AUCTION_DATE")
    protected String auctiondate;
    @XmlElement(name = "AUCTION_TIME")
    protected String auctiontime;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "ICON")
    protected String icon;
    @XmlElement(name = "NOTES")
    protected String notes;
    @XmlElement(name = "UNIT_CONTENTS")
    protected String unitcontents;
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
    @XmlElement(name = "LAST_PAYMENT_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastpaymentdate;
    @XmlElement(name = "TOTAL_DUE", required = true, nillable = true)
    protected BigDecimal totaldue;
    @XmlElement(name = "LAST_PAYMENT_AMOUNT", required = true, nillable = true)
    protected BigDecimal lastpaymentamount;
    @XmlElement(name = "AUCTION_OBJ_ID")
    protected long auctionobjid;
    @XmlElement(name = "UNIT_STATUS")
    protected int unitstatus;

    /**
     * Gets the value of the siteid property.
     */
    public long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     */
    public void setSITEID(long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the acctid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setACCTID(Long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the rentalid property.
     */
    public long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     */
    public void setRENTALID(long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the auctionid property.
     */
    public long getAUCTIONID() {
        return auctionid;
    }

    /**
     * Sets the value of the auctionid property.
     */
    public void setAUCTIONID(long value) {
        this.auctionid = value;
    }

    /**
     * Gets the value of the auctiondate property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAUCTIONDATE() {
        return auctiondate;
    }

    /**
     * Sets the value of the auctiondate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAUCTIONDATE(String value) {
        this.auctiondate = value;
    }

    /**
     * Gets the value of the auctiontime property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAUCTIONTIME() {
        return auctiontime;
    }

    /**
     * Sets the value of the auctiontime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAUCTIONTIME(String value) {
        this.auctiontime = value;
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
     * Gets the value of the unitnumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITNUMBER() {
        return unitnumber;
    }

    /**
     * Sets the value of the unitnumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITNUMBER(String value) {
        this.unitnumber = value;
    }

    /**
     * Gets the value of the icon property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getICON() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setICON(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the notes property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getNOTES() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNOTES(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the unitcontents property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITCONTENTS() {
        return unitcontents;
    }

    /**
     * Sets the value of the unitcontents property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITCONTENTS(String value) {
        this.unitcontents = value;
    }

    /**
     * Gets the value of the ltd property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLTD() {
        return ltd;
    }

    /**
     * Sets the value of the ltd property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLTD(XMLGregorianCalendar value) {
        this.ltd = value;
    }

    /**
     * Gets the value of the ptd property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getPTD() {
        return ptd;
    }

    /**
     * Sets the value of the ptd property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setPTD(XMLGregorianCalendar value) {
        this.ptd = value;
    }

    /**
     * Gets the value of the delrentalid property.
     */
    public long getDELRENTALID() {
        return delrentalid;
    }

    /**
     * Sets the value of the delrentalid property.
     */
    public void setDELRENTALID(long value) {
        this.delrentalid = value;
    }

    /**
     * Gets the value of the lienstate property.
     */
    public int getLIENSTATE() {
        return lienstate;
    }

    /**
     * Sets the value of the lienstate property.
     */
    public void setLIENSTATE(int value) {
        this.lienstate = value;
    }

    /**
     * Gets the value of the lastpaymentdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLASTPAYMENTDATE() {
        return lastpaymentdate;
    }

    /**
     * Sets the value of the lastpaymentdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLASTPAYMENTDATE(XMLGregorianCalendar value) {
        this.lastpaymentdate = value;
    }

    /**
     * Gets the value of the totaldue property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTOTALDUE() {
        return totaldue;
    }

    /**
     * Sets the value of the totaldue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTOTALDUE(BigDecimal value) {
        this.totaldue = value;
    }

    /**
     * Gets the value of the lastpaymentamount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getLASTPAYMENTAMOUNT() {
        return lastpaymentamount;
    }

    /**
     * Sets the value of the lastpaymentamount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLASTPAYMENTAMOUNT(BigDecimal value) {
        this.lastpaymentamount = value;
    }

    /**
     * Gets the value of the auctionobjid property.
     */
    public long getAUCTIONOBJID() {
        return auctionobjid;
    }

    /**
     * Sets the value of the auctionobjid property.
     */
    public void setAUCTIONOBJID(long value) {
        this.auctionobjid = value;
    }

    /**
     * Gets the value of the unitstatus property.
     */
    public int getUNITSTATUS() {
        return unitstatus;
    }

    /**
     * Sets the value of the unitstatus property.
     */
    public void setUNITSTATUS(int value) {
        this.unitstatus = value;
    }

}
