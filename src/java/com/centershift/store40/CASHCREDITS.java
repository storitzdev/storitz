
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CASH_CREDITS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CASH_CREDITS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionCASH_CREDITSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="BALANCE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CREDIT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CREDIT_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REF_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="REF_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ESCROW_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="REF_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TNX_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CASH_CREDITS", propOrder = {
    "amt",
    "balance",
    "credittype",
    "credittypeval",
    "reftype",
    "reftypeval",
    "escrowid",
    "refid",
    "tnxid",
    "version",
    "siteid",
    "acctid"
})
public class CASHCREDITS
    extends BaseEntityOfCollectionCASHCREDITSColumnIndexes
{

    @XmlElement(name = "AMT", required = true)
    protected BigDecimal amt;
    @XmlElement(name = "BALANCE", required = true)
    protected BigDecimal balance;
    @XmlElement(name = "CREDIT_TYPE")
    protected int credittype;
    @XmlElement(name = "CREDIT_TYPE_VAL")
    protected String credittypeval;
    @XmlElement(name = "REF_TYPE")
    protected int reftype;
    @XmlElement(name = "REF_TYPE_VAL")
    protected String reftypeval;
    @XmlElement(name = "ESCROW_ID")
    protected long escrowid;
    @XmlElement(name = "REF_ID")
    protected long refid;
    @XmlElement(name = "TNX_ID", required = true, type = Long.class, nillable = true)
    protected Long tnxid;
    @XmlElement(name = "VERSION")
    protected int version;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAMT() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAMT(BigDecimal value) {
        this.amt = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBALANCE() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBALANCE(BigDecimal value) {
        this.balance = value;
    }

    /**
     * Gets the value of the credittype property.
     * 
     */
    public int getCREDITTYPE() {
        return credittype;
    }

    /**
     * Sets the value of the credittype property.
     * 
     */
    public void setCREDITTYPE(int value) {
        this.credittype = value;
    }

    /**
     * Gets the value of the credittypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREDITTYPEVAL() {
        return credittypeval;
    }

    /**
     * Sets the value of the credittypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREDITTYPEVAL(String value) {
        this.credittypeval = value;
    }

    /**
     * Gets the value of the reftype property.
     * 
     */
    public int getREFTYPE() {
        return reftype;
    }

    /**
     * Sets the value of the reftype property.
     * 
     */
    public void setREFTYPE(int value) {
        this.reftype = value;
    }

    /**
     * Gets the value of the reftypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFTYPEVAL() {
        return reftypeval;
    }

    /**
     * Sets the value of the reftypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFTYPEVAL(String value) {
        this.reftypeval = value;
    }

    /**
     * Gets the value of the escrowid property.
     * 
     */
    public long getESCROWID() {
        return escrowid;
    }

    /**
     * Sets the value of the escrowid property.
     * 
     */
    public void setESCROWID(long value) {
        this.escrowid = value;
    }

    /**
     * Gets the value of the refid property.
     * 
     */
    public long getREFID() {
        return refid;
    }

    /**
     * Sets the value of the refid property.
     * 
     */
    public void setREFID(long value) {
        this.refid = value;
    }

    /**
     * Gets the value of the tnxid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTNXID() {
        return tnxid;
    }

    /**
     * Sets the value of the tnxid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTNXID(Long value) {
        this.tnxid = value;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVERSION() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVERSION(int value) {
        this.version = value;
    }

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

}
