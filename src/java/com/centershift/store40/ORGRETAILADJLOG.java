
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_RETAIL_ADJ_LOG complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ORG_RETAIL_ADJ_LOG">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_RETAIL_ADJ_LOGColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="RETAIL_OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ADJ_REASON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADJ_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PRE_ADJ_QTY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="POST_ADJ_QTY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_RETAIL_ADJ_LOG", propOrder = {
    "retailobjectid",
    "adjreason",
    "adjtype",
    "preadjqty",
    "createdby",
    "updatedby",
    "postadjqty"
})
public class ORGRETAILADJLOG
    extends BaseEntityOfCollectionORGRETAILADJLOGColumnIndexes
{

    @XmlElement(name = "RETAIL_OBJECT_ID", required = true, type = Long.class, nillable = true)
    protected Long retailobjectid;
    @XmlElement(name = "ADJ_REASON")
    protected String adjreason;
    @XmlElement(name = "ADJ_TYPE")
    protected int adjtype;
    @XmlElement(name = "PRE_ADJ_QTY")
    protected int preadjqty;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "POST_ADJ_QTY")
    protected int postadjqty;

    /**
     * Gets the value of the retailobjectid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRETAILOBJECTID() {
        return retailobjectid;
    }

    /**
     * Sets the value of the retailobjectid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRETAILOBJECTID(Long value) {
        this.retailobjectid = value;
    }

    /**
     * Gets the value of the adjreason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADJREASON() {
        return adjreason;
    }

    /**
     * Sets the value of the adjreason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADJREASON(String value) {
        this.adjreason = value;
    }

    /**
     * Gets the value of the adjtype property.
     * 
     */
    public int getADJTYPE() {
        return adjtype;
    }

    /**
     * Sets the value of the adjtype property.
     * 
     */
    public void setADJTYPE(int value) {
        this.adjtype = value;
    }

    /**
     * Gets the value of the preadjqty property.
     * 
     */
    public int getPREADJQTY() {
        return preadjqty;
    }

    /**
     * Sets the value of the preadjqty property.
     * 
     */
    public void setPREADJQTY(int value) {
        this.preadjqty = value;
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

    /**
     * Gets the value of the postadjqty property.
     * 
     */
    public int getPOSTADJQTY() {
        return postadjqty;
    }

    /**
     * Sets the value of the postadjqty property.
     * 
     */
    public void setPOSTADJQTY(int value) {
        this.postadjqty = value;
    }

}
