
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
 *         &lt;element name="GetEcommRentalInfoResult" type="{http://www.centershift.com/STORE40/}GetEcommRentalInfo_Response"/>
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
    "getEcommRentalInfoResult"
})
@XmlRootElement(name = "GetEcommRentalInfoResponse")
public class GetEcommRentalInfoResponse {

    @XmlElement(name = "GetEcommRentalInfoResult", required = true)
    protected GetEcommRentalInfoResponse2 getEcommRentalInfoResult;

    /**
     * Gets the value of the getEcommRentalInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetEcommRentalInfoResponse2 }
     *     
     */
    public GetEcommRentalInfoResponse2 getGetEcommRentalInfoResult() {
        return getEcommRentalInfoResult;
    }

    /**
     * Sets the value of the getEcommRentalInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetEcommRentalInfoResponse2 }
     *     
     */
    public void setGetEcommRentalInfoResult(GetEcommRentalInfoResponse2 value) {
        this.getEcommRentalInfoResult = value;
    }

}
