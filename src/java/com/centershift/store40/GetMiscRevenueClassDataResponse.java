
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
 *         &lt;element name="GetMiscRevenueClassDataResult" type="{http://www.centershift.com/STORE40/}GetMiscRevenueClassData_Response"/>
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
    "getMiscRevenueClassDataResult"
})
@XmlRootElement(name = "GetMiscRevenueClassDataResponse")
public class GetMiscRevenueClassDataResponse {

    @XmlElement(name = "GetMiscRevenueClassDataResult", required = true)
    protected GetMiscRevenueClassDataResponse2 getMiscRevenueClassDataResult;

    /**
     * Gets the value of the getMiscRevenueClassDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetMiscRevenueClassDataResponse2 }
     *     
     */
    public GetMiscRevenueClassDataResponse2 getGetMiscRevenueClassDataResult() {
        return getMiscRevenueClassDataResult;
    }

    /**
     * Sets the value of the getMiscRevenueClassDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMiscRevenueClassDataResponse2 }
     *     
     */
    public void setGetMiscRevenueClassDataResult(GetMiscRevenueClassDataResponse2 value) {
        this.getMiscRevenueClassDataResult = value;
    }

}
