
package com.centershift.store40;

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
 *         &lt;element name="GetRetailReceiptItemsResult" type="{http://www.centershift.com/STORE40/}GetRetailReceiptItems_Response"/>
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
    "getRetailReceiptItemsResult"
})
@XmlRootElement(name = "GetRetailReceiptItemsResponse")
public class GetRetailReceiptItemsResponse {

    @XmlElement(name = "GetRetailReceiptItemsResult", required = true)
    protected GetRetailReceiptItemsResponse2 getRetailReceiptItemsResult;

    /**
     * Gets the value of the getRetailReceiptItemsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetRetailReceiptItemsResponse2 }
     *     
     */
    public GetRetailReceiptItemsResponse2 getGetRetailReceiptItemsResult() {
        return getRetailReceiptItemsResult;
    }

    /**
     * Sets the value of the getRetailReceiptItemsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRetailReceiptItemsResponse2 }
     *     
     */
    public void setGetRetailReceiptItemsResult(GetRetailReceiptItemsResponse2 value) {
        this.getRetailReceiptItemsResult = value;
    }

}
