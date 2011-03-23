package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellRetailWithAccountMultiple_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SellRetailWithAccountMultiple_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RetailItems" type="{http://www.centershift.com/STORE40/}ArrayOfSellRetailWithAccount_Request" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRetailWithAccountMultiple_Request", propOrder = {
        "retailItems"
})
public class SellRetailWithAccountMultipleRequest {

    @XmlElement(name = "RetailItems")
    protected ArrayOfSellRetailWithAccountRequest retailItems;

    /**
     * Gets the value of the retailItems property.
     *
     * @return possible object is
     *         {@link ArrayOfSellRetailWithAccountRequest }
     */
    public ArrayOfSellRetailWithAccountRequest getRetailItems() {
        return retailItems;
    }

    /**
     * Sets the value of the retailItems property.
     *
     * @param value allowed object is
     *              {@link ArrayOfSellRetailWithAccountRequest }
     */
    public void setRetailItems(ArrayOfSellRetailWithAccountRequest value) {
        this.retailItems = value;
    }

}