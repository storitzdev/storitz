package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for TRAN_QUOTE_PCD_DETAIL complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_QUOTE_PCD_DETAIL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_QUOTE_PCD_DETAILColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="QUOTE_PCD_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="QUOTE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PCD_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PCD_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_CLASS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AMT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PCD_AMT_DEFAULT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_AMT_MAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_AMT_MIN" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DISC_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_PERIODS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_QUOTE_PCD_DETAIL", propOrder = {
        "quotepcdid",
        "quoteid",
        "pcdid",
        "active",
        "pcdname",
        "pcddesc",
        "pcdclass",
        "amttype",
        "pcdamtdefault",
        "pcdamtmax",
        "pcdamtmin",
        "discamt",
        "pcdperiods",
        "createdby",
        "updatedby"
})
public class TRANQUOTEPCDDETAIL
        extends BaseEntityOfCollectionTRANQUOTEPCDDETAILColumnIndexes {

    @XmlElement(name = "QUOTE_PCD_ID")
    protected long quotepcdid;
    @XmlElement(name = "QUOTE_ID")
    protected long quoteid;
    @XmlElement(name = "PCD_ID")
    protected long pcdid;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "PCD_NAME")
    protected String pcdname;
    @XmlElement(name = "PCD_DESC")
    protected String pcddesc;
    @XmlElement(name = "PCD_CLASS", required = true, type = Integer.class, nillable = true)
    protected Integer pcdclass;
    @XmlElement(name = "AMT_TYPE")
    protected int amttype;
    @XmlElement(name = "PCD_AMT_DEFAULT", required = true)
    protected BigDecimal pcdamtdefault;
    @XmlElement(name = "PCD_AMT_MAX", required = true)
    protected BigDecimal pcdamtmax;
    @XmlElement(name = "PCD_AMT_MIN", required = true)
    protected BigDecimal pcdamtmin;
    @XmlElement(name = "DISC_AMT", required = true)
    protected BigDecimal discamt;
    @XmlElement(name = "PCD_PERIODS")
    protected int pcdperiods;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

    /**
     * Gets the value of the quotepcdid property.
     */
    public long getQUOTEPCDID() {
        return quotepcdid;
    }

    /**
     * Sets the value of the quotepcdid property.
     */
    public void setQUOTEPCDID(long value) {
        this.quotepcdid = value;
    }

    /**
     * Gets the value of the quoteid property.
     */
    public long getQUOTEID() {
        return quoteid;
    }

    /**
     * Sets the value of the quoteid property.
     */
    public void setQUOTEID(long value) {
        this.quoteid = value;
    }

    /**
     * Gets the value of the pcdid property.
     */
    public long getPCDID() {
        return pcdid;
    }

    /**
     * Sets the value of the pcdid property.
     */
    public void setPCDID(long value) {
        this.pcdid = value;
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
     * Gets the value of the pcdname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPCDNAME() {
        return pcdname;
    }

    /**
     * Sets the value of the pcdname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPCDNAME(String value) {
        this.pcdname = value;
    }

    /**
     * Gets the value of the pcddesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPCDDESC() {
        return pcddesc;
    }

    /**
     * Sets the value of the pcddesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPCDDESC(String value) {
        this.pcddesc = value;
    }

    /**
     * Gets the value of the pcdclass property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getPCDCLASS() {
        return pcdclass;
    }

    /**
     * Sets the value of the pcdclass property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPCDCLASS(Integer value) {
        this.pcdclass = value;
    }

    /**
     * Gets the value of the amttype property.
     */
    public int getAMTTYPE() {
        return amttype;
    }

    /**
     * Sets the value of the amttype property.
     */
    public void setAMTTYPE(int value) {
        this.amttype = value;
    }

    /**
     * Gets the value of the pcdamtdefault property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPCDAMTDEFAULT() {
        return pcdamtdefault;
    }

    /**
     * Sets the value of the pcdamtdefault property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPCDAMTDEFAULT(BigDecimal value) {
        this.pcdamtdefault = value;
    }

    /**
     * Gets the value of the pcdamtmax property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPCDAMTMAX() {
        return pcdamtmax;
    }

    /**
     * Sets the value of the pcdamtmax property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPCDAMTMAX(BigDecimal value) {
        this.pcdamtmax = value;
    }

    /**
     * Gets the value of the pcdamtmin property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPCDAMTMIN() {
        return pcdamtmin;
    }

    /**
     * Sets the value of the pcdamtmin property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPCDAMTMIN(BigDecimal value) {
        this.pcdamtmin = value;
    }

    /**
     * Gets the value of the discamt property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDISCAMT() {
        return discamt;
    }

    /**
     * Sets the value of the discamt property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDISCAMT(BigDecimal value) {
        this.discamt = value;
    }

    /**
     * Gets the value of the pcdperiods property.
     */
    public int getPCDPERIODS() {
        return pcdperiods;
    }

    /**
     * Sets the value of the pcdperiods property.
     */
    public void setPCDPERIODS(int value) {
        this.pcdperiods = value;
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
