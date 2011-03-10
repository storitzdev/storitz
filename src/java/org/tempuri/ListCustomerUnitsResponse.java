
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListCustomerUnitsResult" type="{http://tempuri.org/}ArrayOfListCustomerUnits_ST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listCustomerUnitsResult"
})
@XmlRootElement(name = "ListCustomerUnitsResponse")
public class ListCustomerUnitsResponse {

    @XmlElement(name = "ListCustomerUnitsResult")
    protected ArrayOfListCustomerUnitsST listCustomerUnitsResult;

    /**
     * Gets the value of the listCustomerUnitsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfListCustomerUnitsST }
     *     
     */
    public ArrayOfListCustomerUnitsST getListCustomerUnitsResult() {
        return listCustomerUnitsResult;
    }

    /**
     * Sets the value of the listCustomerUnitsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfListCustomerUnitsST }
     *     
     */
    public void setListCustomerUnitsResult(ArrayOfListCustomerUnitsST value) {
        this.listCustomerUnitsResult = value;
    }

}
