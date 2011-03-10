
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateRentRate_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateRentRate_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseData" type="{http://www.centershift.com/STORE40/}ArrayOfRentRateRespData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateRentRate_Response", propOrder = {
    "responseData"
})
public class UpdateRentRateResponse2 {

    @XmlElement(name = "ResponseData")
    protected ArrayOfRentRateRespData responseData;

    /**
     * Gets the value of the responseData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRentRateRespData }
     *     
     */
    public ArrayOfRentRateRespData getResponseData() {
        return responseData;
    }

    /**
     * Sets the value of the responseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRentRateRespData }
     *     
     */
    public void setResponseData(ArrayOfRentRateRespData value) {
        this.responseData = value;
    }

}
