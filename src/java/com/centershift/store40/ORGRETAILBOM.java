package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_RETAIL_BOM complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_RETAIL_BOM">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_RETAIL_BOMColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="BOM_RETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ITEM_QTY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_RETAIL_BOM", propOrder = {
        "updatedby",
        "bomretailid",
        "retailid",
        "itemqty",
        "active",
        "createdby"
})
public class ORGRETAILBOM
        extends BaseEntityOfCollectionORGRETAILBOMColumnIndexes {

    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "BOM_RETAIL_ID")
    protected long bomretailid;
    @XmlElement(name = "RETAIL_ID")
    protected long retailid;
    @XmlElement(name = "ITEM_QTY")
    protected int itemqty;
    @XmlElement(name = "ACTIVE")
    protected String active;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;

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

    /**
     * Gets the value of the bomretailid property.
     */
    public long getBOMRETAILID() {
        return bomretailid;
    }

    /**
     * Sets the value of the bomretailid property.
     */
    public void setBOMRETAILID(long value) {
        this.bomretailid = value;
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
     * Gets the value of the itemqty property.
     */
    public int getITEMQTY() {
        return itemqty;
    }

    /**
     * Sets the value of the itemqty property.
     */
    public void setITEMQTY(int value) {
        this.itemqty = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACTIVE(String value) {
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

}
