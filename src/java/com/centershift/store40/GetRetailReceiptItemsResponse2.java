
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetRetailReceiptItems_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRetailReceiptItems_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfTRAN_RETAIL_SOLD" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRetailReceiptItems_Response", propOrder = {
    "details"
})
public class GetRetailReceiptItemsResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfTRANRETAILSOLD details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTRANRETAILSOLD }
     *     
     */
    public ArrayOfTRANRETAILSOLD getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTRANRETAILSOLD }
     *     
     */
    public void setDetails(ArrayOfTRANRETAILSOLD value) {
        this.details = value;
    }

}
