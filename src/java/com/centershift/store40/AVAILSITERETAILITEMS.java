
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AVAIL_SITE_RETAIL_ITEMS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AVAIL_SITE_RETAIL_ITEMS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionAVAIL_SITE_RETAIL_ITEMSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="RETAIL_OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="QTY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COLOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PART_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BARCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CATEGORY_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SITE_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SUGGESTED_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MIN_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MAX_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TAX_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ITEM_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BUNDLED_ITEM" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="COST_OF_GOODS" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AVAIL_SITE_RETAIL_ITEMS", propOrder = {
    "retailobjectid",
    "siteid",
    "qty",
    "description",
    "color",
    "partnumber",
    "sku",
    "barcode",
    "categoryid",
    "siteprice",
    "suggestedprice",
    "minprice",
    "maxprice",
    "taxgroupid",
    "active",
    "itemtype",
    "bundleditem",
    "costofgoods",
    "retailid"
})
public class AVAILSITERETAILITEMS
    extends BaseEntityOfCollectionAVAILSITERETAILITEMSColumnIndexes
{

    @XmlElement(name = "RETAIL_OBJECT_ID")
    protected long retailobjectid;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "QTY", required = true, type = Integer.class, nillable = true)
    protected Integer qty;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElement(name = "COLOR")
    protected String color;
    @XmlElement(name = "PART_NUMBER")
    protected String partnumber;
    @XmlElement(name = "SKU")
    protected String sku;
    @XmlElement(name = "BARCODE")
    protected String barcode;
    @XmlElement(name = "CATEGORY_ID")
    protected int categoryid;
    @XmlElement(name = "SITE_PRICE", required = true, nillable = true)
    protected BigDecimal siteprice;
    @XmlElement(name = "SUGGESTED_PRICE", required = true)
    protected BigDecimal suggestedprice;
    @XmlElement(name = "MIN_PRICE", required = true)
    protected BigDecimal minprice;
    @XmlElement(name = "MAX_PRICE", required = true)
    protected BigDecimal maxprice;
    @XmlElement(name = "TAX_GROUP_ID", required = true, nillable = true)
    protected BigDecimal taxgroupid;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "ITEM_TYPE")
    protected int itemtype;
    @XmlElement(name = "BUNDLED_ITEM", required = true, type = Boolean.class, nillable = true)
    protected Boolean bundleditem;
    @XmlElement(name = "COST_OF_GOODS", required = true)
    protected BigDecimal costofgoods;
    @XmlElement(name = "RETAIL_ID")
    protected long retailid;

    /**
     * Gets the value of the retailobjectid property.
     * 
     */
    public long getRETAILOBJECTID() {
        return retailobjectid;
    }

    /**
     * Sets the value of the retailobjectid property.
     * 
     */
    public void setRETAILOBJECTID(long value) {
        this.retailobjectid = value;
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
     * Gets the value of the qty property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQTY() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQTY(Integer value) {
        this.qty = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIPTION() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLOR() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLOR(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the partnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTNUMBER() {
        return partnumber;
    }

    /**
     * Sets the value of the partnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTNUMBER(String value) {
        this.partnumber = value;
    }

    /**
     * Gets the value of the sku property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSKU() {
        return sku;
    }

    /**
     * Sets the value of the sku property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSKU(String value) {
        this.sku = value;
    }

    /**
     * Gets the value of the barcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBARCODE() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBARCODE(String value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the categoryid property.
     * 
     */
    public int getCATEGORYID() {
        return categoryid;
    }

    /**
     * Sets the value of the categoryid property.
     * 
     */
    public void setCATEGORYID(int value) {
        this.categoryid = value;
    }

    /**
     * Gets the value of the siteprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSITEPRICE() {
        return siteprice;
    }

    /**
     * Sets the value of the siteprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSITEPRICE(BigDecimal value) {
        this.siteprice = value;
    }

    /**
     * Gets the value of the suggestedprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSUGGESTEDPRICE() {
        return suggestedprice;
    }

    /**
     * Sets the value of the suggestedprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSUGGESTEDPRICE(BigDecimal value) {
        this.suggestedprice = value;
    }

    /**
     * Gets the value of the minprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMINPRICE() {
        return minprice;
    }

    /**
     * Sets the value of the minprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMINPRICE(BigDecimal value) {
        this.minprice = value;
    }

    /**
     * Gets the value of the maxprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMAXPRICE() {
        return maxprice;
    }

    /**
     * Sets the value of the maxprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMAXPRICE(BigDecimal value) {
        this.maxprice = value;
    }

    /**
     * Gets the value of the taxgroupid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTAXGROUPID() {
        return taxgroupid;
    }

    /**
     * Sets the value of the taxgroupid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTAXGROUPID(BigDecimal value) {
        this.taxgroupid = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setACTIVE(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the itemtype property.
     * 
     */
    public int getITEMTYPE() {
        return itemtype;
    }

    /**
     * Sets the value of the itemtype property.
     * 
     */
    public void setITEMTYPE(int value) {
        this.itemtype = value;
    }

    /**
     * Gets the value of the bundleditem property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBUNDLEDITEM() {
        return bundleditem;
    }

    /**
     * Sets the value of the bundleditem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBUNDLEDITEM(Boolean value) {
        this.bundleditem = value;
    }

    /**
     * Gets the value of the costofgoods property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCOSTOFGOODS() {
        return costofgoods;
    }

    /**
     * Sets the value of the costofgoods property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCOSTOFGOODS(BigDecimal value) {
        this.costofgoods = value;
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

}
