
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_RETAIL_ITEMS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ORG_RETAIL_ITEMS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_RETAIL_ITEMSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ORG_CLASS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="VENDOR_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="COLOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COST_OF_GOODS" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MIN_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MAX_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SUGGESTED_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PACKAGE_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PART_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ITEM_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="QTY_PER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ITEM_SIZE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WEIGHT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BARCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ITEM_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MIN_ORDER_QTY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CATEGORY_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ORG_RETAIL_BULK" type="{http://www.centershift.com/STORE40/}ArrayOfORG_RETAIL_BULK" minOccurs="0"/>
 *         &lt;element name="ORG_RETAIL_BOM" type="{http://www.centershift.com/STORE40/}ArrayOfORG_RETAIL_BOM" minOccurs="0"/>
 *         &lt;element name="ORG_RETAIL_PO_DETAIL" type="{http://www.centershift.com/STORE40/}ArrayOfORG_RETAIL_PO_DETAIL" minOccurs="0"/>
 *         &lt;element name="ORG_SITE_RETAIL_OBJECTS" type="{http://www.centershift.com/STORE40/}ArrayOfORG_SITE_RETAIL_OBJECTS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_RETAIL_ITEMS", propOrder = {
    "orgclassid",
    "vendorid",
    "color",
    "costofgoods",
    "description",
    "minprice",
    "maxprice",
    "suggestedprice",
    "packagetype",
    "partnumber",
    "itemtype",
    "qtyper",
    "uom",
    "itemsize",
    "weight",
    "barcode",
    "sku",
    "active",
    "createdby",
    "updatedby",
    "itemname",
    "minorderqty",
    "categoryid",
    "orgretailbulk",
    "orgretailbom",
    "orgretailpodetail",
    "orgsiteretailobjects"
})
public class ORGRETAILITEMS
    extends BaseEntityOfCollectionORGRETAILITEMSColumnIndexes
{

    @XmlElement(name = "ORG_CLASS_ID", required = true, type = Long.class, nillable = true)
    protected Long orgclassid;
    @XmlElement(name = "VENDOR_ID")
    protected long vendorid;
    @XmlElement(name = "COLOR")
    protected String color;
    @XmlElement(name = "COST_OF_GOODS", required = true)
    protected BigDecimal costofgoods;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElement(name = "MIN_PRICE", required = true)
    protected BigDecimal minprice;
    @XmlElement(name = "MAX_PRICE", required = true)
    protected BigDecimal maxprice;
    @XmlElement(name = "SUGGESTED_PRICE", required = true)
    protected BigDecimal suggestedprice;
    @XmlElement(name = "PACKAGE_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer packagetype;
    @XmlElement(name = "PART_NUMBER")
    protected String partnumber;
    @XmlElement(name = "ITEM_TYPE")
    protected int itemtype;
    @XmlElement(name = "QTY_PER", required = true, type = Integer.class, nillable = true)
    protected Integer qtyper;
    @XmlElement(name = "UOM")
    protected String uom;
    @XmlElement(name = "ITEM_SIZE")
    protected String itemsize;
    @XmlElement(name = "WEIGHT")
    protected String weight;
    @XmlElement(name = "BARCODE")
    protected String barcode;
    @XmlElement(name = "SKU")
    protected String sku;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "ITEM_NAME")
    protected String itemname;
    @XmlElement(name = "MIN_ORDER_QTY", required = true, type = Integer.class, nillable = true)
    protected Integer minorderqty;
    @XmlElement(name = "CATEGORY_ID")
    protected int categoryid;
    @XmlElement(name = "ORG_RETAIL_BULK")
    protected ArrayOfORGRETAILBULK orgretailbulk;
    @XmlElement(name = "ORG_RETAIL_BOM")
    protected ArrayOfORGRETAILBOM orgretailbom;
    @XmlElement(name = "ORG_RETAIL_PO_DETAIL")
    protected ArrayOfORGRETAILPODETAIL orgretailpodetail;
    @XmlElement(name = "ORG_SITE_RETAIL_OBJECTS")
    protected ArrayOfORGSITERETAILOBJECTS orgsiteretailobjects;

    /**
     * Gets the value of the orgclassid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getORGCLASSID() {
        return orgclassid;
    }

    /**
     * Sets the value of the orgclassid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setORGCLASSID(Long value) {
        this.orgclassid = value;
    }

    /**
     * Gets the value of the vendorid property.
     * 
     */
    public long getVENDORID() {
        return vendorid;
    }

    /**
     * Sets the value of the vendorid property.
     * 
     */
    public void setVENDORID(long value) {
        this.vendorid = value;
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
     * Gets the value of the packagetype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPACKAGETYPE() {
        return packagetype;
    }

    /**
     * Sets the value of the packagetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPACKAGETYPE(Integer value) {
        this.packagetype = value;
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
     * Gets the value of the qtyper property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQTYPER() {
        return qtyper;
    }

    /**
     * Sets the value of the qtyper property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQTYPER(Integer value) {
        this.qtyper = value;
    }

    /**
     * Gets the value of the uom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUOM() {
        return uom;
    }

    /**
     * Sets the value of the uom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUOM(String value) {
        this.uom = value;
    }

    /**
     * Gets the value of the itemsize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITEMSIZE() {
        return itemsize;
    }

    /**
     * Sets the value of the itemsize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITEMSIZE(String value) {
        this.itemsize = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWEIGHT() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWEIGHT(String value) {
        this.weight = value;
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
     * Gets the value of the itemname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITEMNAME() {
        return itemname;
    }

    /**
     * Sets the value of the itemname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITEMNAME(String value) {
        this.itemname = value;
    }

    /**
     * Gets the value of the minorderqty property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMINORDERQTY() {
        return minorderqty;
    }

    /**
     * Sets the value of the minorderqty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMINORDERQTY(Integer value) {
        this.minorderqty = value;
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
     * Gets the value of the orgretailbulk property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfORGRETAILBULK }
     *     
     */
    public ArrayOfORGRETAILBULK getORGRETAILBULK() {
        return orgretailbulk;
    }

    /**
     * Sets the value of the orgretailbulk property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfORGRETAILBULK }
     *     
     */
    public void setORGRETAILBULK(ArrayOfORGRETAILBULK value) {
        this.orgretailbulk = value;
    }

    /**
     * Gets the value of the orgretailbom property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfORGRETAILBOM }
     *     
     */
    public ArrayOfORGRETAILBOM getORGRETAILBOM() {
        return orgretailbom;
    }

    /**
     * Sets the value of the orgretailbom property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfORGRETAILBOM }
     *     
     */
    public void setORGRETAILBOM(ArrayOfORGRETAILBOM value) {
        this.orgretailbom = value;
    }

    /**
     * Gets the value of the orgretailpodetail property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfORGRETAILPODETAIL }
     *     
     */
    public ArrayOfORGRETAILPODETAIL getORGRETAILPODETAIL() {
        return orgretailpodetail;
    }

    /**
     * Sets the value of the orgretailpodetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfORGRETAILPODETAIL }
     *     
     */
    public void setORGRETAILPODETAIL(ArrayOfORGRETAILPODETAIL value) {
        this.orgretailpodetail = value;
    }

    /**
     * Gets the value of the orgsiteretailobjects property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfORGSITERETAILOBJECTS }
     *     
     */
    public ArrayOfORGSITERETAILOBJECTS getORGSITERETAILOBJECTS() {
        return orgsiteretailobjects;
    }

    /**
     * Sets the value of the orgsiteretailobjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfORGSITERETAILOBJECTS }
     *     
     */
    public void setORGSITERETAILOBJECTS(ArrayOfORGSITERETAILOBJECTS value) {
        this.orgsiteretailobjects = value;
    }

}
