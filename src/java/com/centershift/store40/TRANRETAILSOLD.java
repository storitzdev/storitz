package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for TRAN_RETAIL_SOLD complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_RETAIL_SOLD">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_RETAIL_SOLDColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="TNX_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TNX_DETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RETAIL_OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TNX_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ITEM_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TAX_CHARGED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EXTENDED" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="FULFILLED" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ASS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ASS_REF" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLASS_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ITEM_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QTY" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RETURNED" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PART_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BARCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ITEM_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TAX_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_RETAIL_SOLD", propOrder = {
        "tnxid",
        "siteid",
        "acctid",
        "acctname",
        "accttype",
        "retailid",
        "tnxdetailid",
        "retailobjectid",
        "tnxdate",
        "amt",
        "itemprice",
        "taxcharged",
        "tax",
        "extended",
        "fulfilled",
        "assid",
        "assref",
        "icon",
        "classdesc",
        "itemname",
        "description",
        "qty",
        "returned",
        "partnumber",
        "sku",
        "barcode",
        "itemtype",
        "taxgroupid",
        "status"
})
public class TRANRETAILSOLD
        extends BaseEntityOfCollectionTRANRETAILSOLDColumnIndexes {

    @XmlElement(name = "TNX_ID")
    protected long tnxid;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "ACCT_TYPE")
    protected int accttype;
    @XmlElement(name = "RETAIL_ID")
    protected long retailid;
    @XmlElement(name = "TNX_DETAIL_ID")
    protected long tnxdetailid;
    @XmlElement(name = "RETAIL_OBJECT_ID")
    protected long retailobjectid;
    @XmlElement(name = "TNX_DATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tnxdate;
    @XmlElement(name = "AMT", required = true)
    protected BigDecimal amt;
    @XmlElement(name = "ITEM_PRICE", required = true)
    protected BigDecimal itemprice;
    @XmlElement(name = "TAX_CHARGED")
    protected String taxcharged;
    @XmlElement(name = "TAX", required = true, nillable = true)
    protected BigDecimal tax;
    @XmlElement(name = "EXTENDED", required = true)
    protected BigDecimal extended;
    @XmlElement(name = "FULFILLED", required = true)
    protected BigDecimal fulfilled;
    @XmlElement(name = "ASS_ID")
    protected long assid;
    @XmlElement(name = "ASS_REF")
    protected long assref;
    @XmlElement(name = "ICON")
    protected String icon;
    @XmlElement(name = "CLASS_DESC")
    protected String classdesc;
    @XmlElement(name = "ITEM_NAME")
    protected String itemname;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElement(name = "QTY", required = true)
    protected BigDecimal qty;
    @XmlElement(name = "RETURNED", required = true, nillable = true)
    protected BigDecimal returned;
    @XmlElement(name = "PART_NUMBER")
    protected String partnumber;
    @XmlElement(name = "SKU")
    protected String sku;
    @XmlElement(name = "BARCODE")
    protected String barcode;
    @XmlElement(name = "ITEM_TYPE")
    protected int itemtype;
    @XmlElement(name = "TAX_GROUP_ID", required = true, nillable = true)
    protected BigDecimal taxgroupid;
    @XmlElement(name = "STATUS")
    protected int status;

    /**
     * Gets the value of the tnxid property.
     */
    public long getTNXID() {
        return tnxid;
    }

    /**
     * Sets the value of the tnxid property.
     */
    public void setTNXID(long value) {
        this.tnxid = value;
    }

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
     * Gets the value of the retailid property.
     */
    public long getRETAILID() {
        return retailid;
    }

    /**
     * Sets the value of the retailid property.
     */
    public void setRETAILID(long value) {
        this.retailid = value;
    }

    /**
     * Gets the value of the tnxdetailid property.
     */
    public long getTNXDETAILID() {
        return tnxdetailid;
    }

    /**
     * Sets the value of the tnxdetailid property.
     */
    public void setTNXDETAILID(long value) {
        this.tnxdetailid = value;
    }

    /**
     * Gets the value of the retailobjectid property.
     */
    public long getRETAILOBJECTID() {
        return retailobjectid;
    }

    /**
     * Sets the value of the retailobjectid property.
     */
    public void setRETAILOBJECTID(long value) {
        this.retailobjectid = value;
    }

    /**
     * Gets the value of the tnxdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTNXDATE() {
        return tnxdate;
    }

    /**
     * Sets the value of the tnxdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setTNXDATE(XMLGregorianCalendar value) {
        this.tnxdate = value;
    }

    /**
     * Gets the value of the amt property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getAMT() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setAMT(BigDecimal value) {
        this.amt = value;
    }

    /**
     * Gets the value of the itemprice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getITEMPRICE() {
        return itemprice;
    }

    /**
     * Sets the value of the itemprice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setITEMPRICE(BigDecimal value) {
        this.itemprice = value;
    }

    /**
     * Gets the value of the taxcharged property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getTAXCHARGED() {
        return taxcharged;
    }

    /**
     * Sets the value of the taxcharged property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTAXCHARGED(String value) {
        this.taxcharged = value;
    }

    /**
     * Gets the value of the tax property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTAX() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTAX(BigDecimal value) {
        this.tax = value;
    }

    /**
     * Gets the value of the extended property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getEXTENDED() {
        return extended;
    }

    /**
     * Sets the value of the extended property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setEXTENDED(BigDecimal value) {
        this.extended = value;
    }

    /**
     * Gets the value of the fulfilled property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getFULFILLED() {
        return fulfilled;
    }

    /**
     * Sets the value of the fulfilled property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setFULFILLED(BigDecimal value) {
        this.fulfilled = value;
    }

    /**
     * Gets the value of the assid property.
     */
    public long getASSID() {
        return assid;
    }

    /**
     * Sets the value of the assid property.
     */
    public void setASSID(long value) {
        this.assid = value;
    }

    /**
     * Gets the value of the assref property.
     */
    public long getASSREF() {
        return assref;
    }

    /**
     * Sets the value of the assref property.
     */
    public void setASSREF(long value) {
        this.assref = value;
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
     * Gets the value of the classdesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCLASSDESC() {
        return classdesc;
    }

    /**
     * Sets the value of the classdesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCLASSDESC(String value) {
        this.classdesc = value;
    }

    /**
     * Gets the value of the itemname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getITEMNAME() {
        return itemname;
    }

    /**
     * Sets the value of the itemname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setITEMNAME(String value) {
        this.itemname = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDESCRIPTION() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the qty property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getQTY() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setQTY(BigDecimal value) {
        this.qty = value;
    }

    /**
     * Gets the value of the returned property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRETURNED() {
        return returned;
    }

    /**
     * Sets the value of the returned property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRETURNED(BigDecimal value) {
        this.returned = value;
    }

    /**
     * Gets the value of the partnumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPARTNUMBER() {
        return partnumber;
    }

    /**
     * Sets the value of the partnumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPARTNUMBER(String value) {
        this.partnumber = value;
    }

    /**
     * Gets the value of the sku property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSKU() {
        return sku;
    }

    /**
     * Sets the value of the sku property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSKU(String value) {
        this.sku = value;
    }

    /**
     * Gets the value of the barcode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getBARCODE() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBARCODE(String value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the itemtype property.
     */
    public int getITEMTYPE() {
        return itemtype;
    }

    /**
     * Sets the value of the itemtype property.
     */
    public void setITEMTYPE(int value) {
        this.itemtype = value;
    }

    /**
     * Gets the value of the taxgroupid property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTAXGROUPID() {
        return taxgroupid;
    }

    /**
     * Sets the value of the taxgroupid property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTAXGROUPID(BigDecimal value) {
        this.taxgroupid = value;
    }

    /**
     * Gets the value of the status property.
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

}
