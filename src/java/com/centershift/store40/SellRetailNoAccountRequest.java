
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellRetailNoAccount_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellRetailNoAccount_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Item" type="{http://www.centershift.com/STORE40/}AVAIL_SITE_RETAIL_ITEMS" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TaxExemptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRetailNoAccount_Request", propOrder = {
    "orgID",
    "item",
    "quantity",
    "taxExemptNumber"
})
public class SellRetailNoAccountRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "Item")
    protected AVAILSITERETAILITEMS item;
    @XmlElement(name = "Quantity")
    protected int quantity;
    @XmlElement(name = "TaxExemptNumber")
    protected String taxExemptNumber;

    /**
     * Gets the value of the orgID property.
     * 
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link AVAILSITERETAILITEMS }
     *     
     */
    public AVAILSITERETAILITEMS getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link AVAILSITERETAILITEMS }
     *     
     */
    public void setItem(AVAILSITERETAILITEMS value) {
        this.item = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the taxExemptNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxExemptNumber() {
        return taxExemptNumber;
    }

    /**
     * Sets the value of the taxExemptNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxExemptNumber(String value) {
        this.taxExemptNumber = value;
    }

}
