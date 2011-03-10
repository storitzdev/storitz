
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPL_ACCT_CFLEX_DATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPL_ACCT_CFLEX_DATA">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionAPPL_ACCT_CFLEX_DATAColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EXT_COLUMN_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LABEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOOKUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EXT_DATA_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "APPL_ACCT_CFLEX_DATA", propOrder = {
    "acctid",
    "orgid",
    "extcolumnname",
    "label",
    "value",
    "lookupid",
    "extdataid",
    "createdby",
    "updatedby"
})
public class APPLACCTCFLEXDATA
    extends BaseEntityOfCollectionAPPLACCTCFLEXDATAColumnIndexes
{

    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "EXT_COLUMN_NAME")
    protected String extcolumnname;
    @XmlElement(name = "LABEL")
    protected String label;
    @XmlElement(name = "VALUE")
    protected String value;
    @XmlElement(name = "LOOKUP_ID", required = true, type = Long.class, nillable = true)
    protected Long lookupid;
    @XmlElement(name = "EXT_DATA_ID")
    protected long extdataid;
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
     * Gets the value of the orgid property.
     * 
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     * 
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the extcolumnname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXTCOLUMNNAME() {
        return extcolumnname;
    }

    /**
     * Sets the value of the extcolumnname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXTCOLUMNNAME(String value) {
        this.extcolumnname = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLABEL() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLABEL(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUE() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUE(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the lookupid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLOOKUPID() {
        return lookupid;
    }

    /**
     * Sets the value of the lookupid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLOOKUPID(Long value) {
        this.lookupid = value;
    }

    /**
     * Gets the value of the extdataid property.
     * 
     */
    public long getEXTDATAID() {
        return extdataid;
    }

    /**
     * Sets the value of the extdataid property.
     * 
     */
    public void setEXTDATAID(long value) {
        this.extdataid = value;
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
