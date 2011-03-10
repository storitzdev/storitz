
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
 *         &lt;element name="GetRefundTypesResult" type="{http://www.centershift.com/STORE40/}GetRefundTypes_Response"/>
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
    "getRefundTypesResult"
})
@XmlRootElement(name = "GetRefundTypesResponse")
public class GetRefundTypesResponse {

    @XmlElement(name = "GetRefundTypesResult", required = true)
    protected GetRefundTypesResponse2 getRefundTypesResult;

    /**
     * Gets the value of the getRefundTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetRefundTypesResponse2 }
     *     
     */
    public GetRefundTypesResponse2 getGetRefundTypesResult() {
        return getRefundTypesResult;
    }

    /**
     * Sets the value of the getRefundTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRefundTypesResponse2 }
     *     
     */
    public void setGetRefundTypesResult(GetRefundTypesResponse2 value) {
        this.getRefundTypesResult = value;
    }

}
