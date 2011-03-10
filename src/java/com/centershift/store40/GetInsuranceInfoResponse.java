
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
 *         &lt;element name="GetInsuranceInfoResult" type="{http://www.centershift.com/STORE40/}GetInsuranceInfo_Response"/>
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
    "getInsuranceInfoResult"
})
@XmlRootElement(name = "GetInsuranceInfoResponse")
public class GetInsuranceInfoResponse {

    @XmlElement(name = "GetInsuranceInfoResult", required = true)
    protected GetInsuranceInfoResponse2 getInsuranceInfoResult;

    /**
     * Gets the value of the getInsuranceInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetInsuranceInfoResponse2 }
     *     
     */
    public GetInsuranceInfoResponse2 getGetInsuranceInfoResult() {
        return getInsuranceInfoResult;
    }

    /**
     * Sets the value of the getInsuranceInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInsuranceInfoResponse2 }
     *     
     */
    public void setGetInsuranceInfoResult(GetInsuranceInfoResponse2 value) {
        this.getInsuranceInfoResult = value;
    }

}
