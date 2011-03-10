
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TRAN_RENTAL_LEDGER complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TRAN_RENTAL_LEDGER">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_RENTAL_LEDGERColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TRANSACTION_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRAN_TYPE_VALUE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TNX_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TNX_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TNX_DETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATUS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VOIDSTAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CHILD_RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASS_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ASS_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PARENT_ASS_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="REF_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PAY_REF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESCRIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBJ_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ITEM_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="QTY" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EXTENDED" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PAY_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CREATED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GL" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CLASS_REF" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="GL_MAP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GL_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LASTFOUR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_RENTAL_LEDGER", propOrder = {
    "siteid",
    "acctid",
    "transactiontype",
    "trantypevalue",
    "tnxdate",
    "tnxid",
    "tnxdetailid",
    "status",
    "statusval",
    "voidstat",
    "rentalid",
    "childrentalid",
    "contactid",
    "addrid",
    "assdate",
    "assid",
    "parentassid",
    "reftype",
    "payref",
    "descrip",
    "objname",
    "itemprice",
    "qty",
    "extended",
    "payamt",
    "tax",
    "created",
    "createdby",
    "createdname",
    "gl",
    "classref",
    "glmap",
    "gldesc",
    "lastfour"
})
public class TRANRENTALLEDGER
    extends BaseEntityOfCollectionTRANRENTALLEDGERColumnIndexes
{

    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "TRANSACTION_TYPE")
    protected String transactiontype;
    @XmlElement(name = "TRAN_TYPE_VALUE", required = true, nillable = true)
    protected BigDecimal trantypevalue;
    @XmlElement(name = "TNX_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tnxdate;
    @XmlElement(name = "TNX_ID", required = true, nillable = true)
    protected BigDecimal tnxid;
    @XmlElement(name = "TNX_DETAIL_ID", required = true, nillable = true)
    protected BigDecimal tnxdetailid;
    @XmlElement(name = "STATUS", required = true, type = Integer.class, nillable = true)
    protected Integer status;
    @XmlElement(name = "STATUS_VAL")
    protected String statusval;
    @XmlElement(name = "VOIDSTAT")
    protected String voidstat;
    @XmlElement(name = "RENTAL_ID", required = true, nillable = true)
    protected BigDecimal rentalid;
    @XmlElement(name = "CHILD_RENTAL_ID")
    protected String childrentalid;
    @XmlElement(name = "CONTACT_ID")
    protected String contactid;
    @XmlElement(name = "ADDR_ID")
    protected String addrid;
    @XmlElement(name = "ASS_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assdate;
    @XmlElement(name = "ASS_ID", required = true, nillable = true)
    protected BigDecimal assid;
    @XmlElement(name = "PARENT_ASS_ID", required = true, nillable = true)
    protected BigDecimal parentassid;
    @XmlElement(name = "REF_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer reftype;
    @XmlElement(name = "PAY_REF")
    protected String payref;
    @XmlElement(name = "DESCRIP")
    protected String descrip;
    @XmlElement(name = "OBJ_NAME")
    protected String objname;
    @XmlElement(name = "ITEM_PRICE", required = true, nillable = true)
    protected BigDecimal itemprice;
    @XmlElement(name = "QTY", required = true, nillable = true)
    protected BigDecimal qty;
    @XmlElement(name = "EXTENDED", required = true, nillable = true)
    protected BigDecimal extended;
    @XmlElement(name = "PAY_AMT", required = true, nillable = true)
    protected BigDecimal payamt;
    @XmlElement(name = "TAX", required = true, nillable = true)
    protected BigDecimal tax;
    @XmlElement(name = "CREATED", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "CREATED_BY", required = true, type = Long.class, nillable = true)
    protected Long createdby;
    @XmlElement(name = "CREATED_NAME")
    protected String createdname;
    @XmlElement(name = "GL", required = true, nillable = true)
    protected BigDecimal gl;
    @XmlElement(name = "CLASS_REF", required = true, nillable = true)
    protected BigDecimal classref;
    @XmlElement(name = "GL_MAP")
    protected String glmap;
    @XmlElement(name = "GL_DESC")
    protected String gldesc;
    @XmlElement(name = "LASTFOUR")
    protected String lastfour;

    /**
     * Gets the value of the siteid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSITEID(Long value) {
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
     * Gets the value of the transactiontype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSACTIONTYPE() {
        return transactiontype;
    }

    /**
     * Sets the value of the transactiontype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSACTIONTYPE(String value) {
        this.transactiontype = value;
    }

    /**
     * Gets the value of the trantypevalue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTRANTYPEVALUE() {
        return trantypevalue;
    }

    /**
     * Sets the value of the trantypevalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTRANTYPEVALUE(BigDecimal value) {
        this.trantypevalue = value;
    }

    /**
     * Gets the value of the tnxdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTNXDATE() {
        return tnxdate;
    }

    /**
     * Sets the value of the tnxdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTNXDATE(XMLGregorianCalendar value) {
        this.tnxdate = value;
    }

    /**
     * Gets the value of the tnxid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTNXID() {
        return tnxid;
    }

    /**
     * Sets the value of the tnxid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTNXID(BigDecimal value) {
        this.tnxid = value;
    }

    /**
     * Gets the value of the tnxdetailid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTNXDETAILID() {
        return tnxdetailid;
    }

    /**
     * Sets the value of the tnxdetailid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTNXDETAILID(BigDecimal value) {
        this.tnxdetailid = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSTATUS(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUSVAL() {
        return statusval;
    }

    /**
     * Sets the value of the statusval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUSVAL(String value) {
        this.statusval = value;
    }

    /**
     * Gets the value of the voidstat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVOIDSTAT() {
        return voidstat;
    }

    /**
     * Sets the value of the voidstat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVOIDSTAT(String value) {
        this.voidstat = value;
    }

    /**
     * Gets the value of the rentalid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRENTALID(BigDecimal value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the childrentalid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHILDRENTALID() {
        return childrentalid;
    }

    /**
     * Sets the value of the childrentalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHILDRENTALID(String value) {
        this.childrentalid = value;
    }

    /**
     * Gets the value of the contactid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTACTID() {
        return contactid;
    }

    /**
     * Sets the value of the contactid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTACTID(String value) {
        this.contactid = value;
    }

    /**
     * Gets the value of the addrid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRID() {
        return addrid;
    }

    /**
     * Sets the value of the addrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRID(String value) {
        this.addrid = value;
    }

    /**
     * Gets the value of the assdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getASSDATE() {
        return assdate;
    }

    /**
     * Sets the value of the assdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setASSDATE(XMLGregorianCalendar value) {
        this.assdate = value;
    }

    /**
     * Gets the value of the assid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getASSID() {
        return assid;
    }

    /**
     * Sets the value of the assid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setASSID(BigDecimal value) {
        this.assid = value;
    }

    /**
     * Gets the value of the parentassid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPARENTASSID() {
        return parentassid;
    }

    /**
     * Sets the value of the parentassid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPARENTASSID(BigDecimal value) {
        this.parentassid = value;
    }

    /**
     * Gets the value of the reftype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getREFTYPE() {
        return reftype;
    }

    /**
     * Sets the value of the reftype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setREFTYPE(Integer value) {
        this.reftype = value;
    }

    /**
     * Gets the value of the payref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYREF() {
        return payref;
    }

    /**
     * Sets the value of the payref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYREF(String value) {
        this.payref = value;
    }

    /**
     * Gets the value of the descrip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIP() {
        return descrip;
    }

    /**
     * Sets the value of the descrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCRIP(String value) {
        this.descrip = value;
    }

    /**
     * Gets the value of the objname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJNAME() {
        return objname;
    }

    /**
     * Sets the value of the objname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJNAME(String value) {
        this.objname = value;
    }

    /**
     * Gets the value of the itemprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getITEMPRICE() {
        return itemprice;
    }

    /**
     * Sets the value of the itemprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setITEMPRICE(BigDecimal value) {
        this.itemprice = value;
    }

    /**
     * Gets the value of the qty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQTY() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQTY(BigDecimal value) {
        this.qty = value;
    }

    /**
     * Gets the value of the extended property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEXTENDED() {
        return extended;
    }

    /**
     * Sets the value of the extended property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEXTENDED(BigDecimal value) {
        this.extended = value;
    }

    /**
     * Gets the value of the payamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPAYAMT() {
        return payamt;
    }

    /**
     * Sets the value of the payamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPAYAMT(BigDecimal value) {
        this.payamt = value;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTAX() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTAX(BigDecimal value) {
        this.tax = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCREATED() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCREATED(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the createdby property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCREATEDBY(Long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the createdname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREATEDNAME() {
        return createdname;
    }

    /**
     * Sets the value of the createdname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREATEDNAME(String value) {
        this.createdname = value;
    }

    /**
     * Gets the value of the gl property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGL() {
        return gl;
    }

    /**
     * Sets the value of the gl property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGL(BigDecimal value) {
        this.gl = value;
    }

    /**
     * Gets the value of the classref property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCLASSREF() {
        return classref;
    }

    /**
     * Sets the value of the classref property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCLASSREF(BigDecimal value) {
        this.classref = value;
    }

    /**
     * Gets the value of the glmap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLMAP() {
        return glmap;
    }

    /**
     * Sets the value of the glmap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLMAP(String value) {
        this.glmap = value;
    }

    /**
     * Gets the value of the gldesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLDESC() {
        return gldesc;
    }

    /**
     * Sets the value of the gldesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLDESC(String value) {
        this.gldesc = value;
    }

    /**
     * Gets the value of the lastfour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTFOUR() {
        return lastfour;
    }

    /**
     * Sets the value of the lastfour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTFOUR(String value) {
        this.lastfour = value;
    }

}
