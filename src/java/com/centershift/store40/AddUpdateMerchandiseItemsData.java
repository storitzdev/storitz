
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddUpdateMerchandiseItemsData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddUpdateMerchandiseItemsData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RetailID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="VendorID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CostOfGoods" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RetailPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MinPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MaxPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PartNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddUpdateMerchandiseItemsData", propOrder = {
    "retailID",
    "vendorID",
    "itemName",
    "costOfGoods",
    "retailPrice",
    "minPrice",
    "maxPrice",
    "partNumber",
    "sku"
})
public class AddUpdateMerchandiseItemsData {

    @XmlElement(name = "RetailID", required = true, type = Long.class, nillable = true)
    protected Long retailID;
    @XmlElement(name = "VendorID", required = true, type = Long.class, nillable = true)
    protected Long vendorID;
    @XmlElement(name = "ItemName")
    protected String itemName;
    @XmlElement(name = "CostOfGoods", required = true, nillable = true)
    protected BigDecimal costOfGoods;
    @XmlElement(name = "RetailPrice", required = true, nillable = true)
    protected BigDecimal retailPrice;
    @XmlElement(name = "MinPrice", required = true, nillable = true)
    protected BigDecimal minPrice;
    @XmlElement(name = "MaxPrice", required = true, nillable = true)
    protected BigDecimal maxPrice;
    @XmlElement(name = "PartNumber")
    protected String partNumber;
    @XmlElement(name = "SKU")
    protected String sku;

    /**
     * Gets the value of the retailID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRetailID() {
        return retailID;
    }

    /**
     * Sets the value of the retailID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRetailID(Long value) {
        this.retailID = value;
    }

    /**
     * Gets the value of the vendorID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVendorID() {
        return vendorID;
    }

    /**
     * Sets the value of the vendorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVendorID(Long value) {
        this.vendorID = value;
    }

    /**
     * Gets the value of the itemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the value of the itemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * Gets the value of the costOfGoods property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCostOfGoods() {
        return costOfGoods;
    }

    /**
     * Sets the value of the costOfGoods property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCostOfGoods(BigDecimal value) {
        this.costOfGoods = value;
    }

    /**
     * Gets the value of the retailPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    /**
     * Sets the value of the retailPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRetailPrice(BigDecimal value) {
        this.retailPrice = value;
    }

    /**
     * Gets the value of the minPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    /**
     * Sets the value of the minPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinPrice(BigDecimal value) {
        this.minPrice = value;
    }

    /**
     * Gets the value of the maxPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    /**
     * Sets the value of the maxPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxPrice(BigDecimal value) {
        this.maxPrice = value;
    }

    /**
     * Gets the value of the partNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * Sets the value of the partNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartNumber(String value) {
        this.partNumber = value;
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

}
