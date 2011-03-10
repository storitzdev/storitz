
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_RETAIL_PO_DETAIL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ORG_RETAIL_PO_DETAIL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_RETAIL_PO_DETAILColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="PO_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="QTY_ORDERED" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="QTY_RECEIVED" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ITEM_COST" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
@XmlType(name = "ORG_RETAIL_PO_DETAIL", propOrder = {
    "poid",
    "retailid",
    "qtyordered",
    "qtyreceived",
    "itemcost",
    "createdby",
    "updatedby"
})
public class ORGRETAILPODETAIL
    extends BaseEntityOfCollectionORGRETAILPODETAILColumnIndexes
{

    @XmlElement(name = "PO_ID")
    protected long poid;
    @XmlElement(name = "RETAIL_ID")
    protected long retailid;
    @XmlElement(name = "QTY_ORDERED")
    protected int qtyordered;
    @XmlElement(name = "QTY_RECEIVED")
    protected int qtyreceived;
    @XmlElement(name = "ITEM_COST", required = true, nillable = true)
    protected BigDecimal itemcost;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

    /**
     * Gets the value of the poid property.
     * 
     */
    public long getPOID() {
        return poid;
    }

    /**
     * Sets the value of the poid property.
     * 
     */
    public void setPOID(long value) {
        this.poid = value;
    }

    /**
     * Gets the value of the retailid property.
     * 
     */
    public long getRETAILID() {
        return retailid;
    }

    /**
     * Sets the value of the retailid property.
     * 
     */
    public void setRETAILID(long value) {
        this.retailid = value;
    }

    /**
     * Gets the value of the qtyordered property.
     * 
     */
    public int getQTYORDERED() {
        return qtyordered;
    }

    /**
     * Sets the value of the qtyordered property.
     * 
     */
    public void setQTYORDERED(int value) {
        this.qtyordered = value;
    }

    /**
     * Gets the value of the qtyreceived property.
     * 
     */
    public int getQTYRECEIVED() {
        return qtyreceived;
    }

    /**
     * Sets the value of the qtyreceived property.
     * 
     */
    public void setQTYRECEIVED(int value) {
        this.qtyreceived = value;
    }

    /**
     * Gets the value of the itemcost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getITEMCOST() {
        return itemcost;
    }

    /**
     * Sets the value of the itemcost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setITEMCOST(BigDecimal value) {
        this.itemcost = value;
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
