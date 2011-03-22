package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellRetailNoAccountMultiple_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SellRetailNoAccountMultiple_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RetailItems" type="{http://www.centershift.com/STORE40/}ArrayOfSellRetailNoAccount_Request" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRetailNoAccountMultiple_Request", propOrder = {
        "retailItems"
})
public class SellRetailNoAccountMultipleRequest {

    @XmlElement(name = "RetailItems")
    protected ArrayOfSellRetailNoAccountRequest retailItems;

    /**
     * Gets the value of the retailItems property.
     *
     * @return possible object is
     *         {@link ArrayOfSellRetailNoAccountRequest }
     */
    public ArrayOfSellRetailNoAccountRequest getRetailItems() {
        return retailItems;
    }

    /**
     * Sets the value of the retailItems property.
     *
     * @param value allowed object is
     *              {@link ArrayOfSellRetailNoAccountRequest }
     */
    public void setRetailItems(ArrayOfSellRetailNoAccountRequest value) {
        this.retailItems = value;
    }

}
