
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
 *         &lt;element name="GetUnitDataResult" type="{http://www.centershift.com/STORE40/}GetUnitData_Response"/>
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
    "getUnitDataResult"
})
@XmlRootElement(name = "GetUnitDataResponse")
public class GetUnitDataResponse {

    @XmlElement(name = "GetUnitDataResult", required = true)
    protected GetUnitDataResponse2 getUnitDataResult;

    /**
     * Gets the value of the getUnitDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetUnitDataResponse2 }
     *     
     */
    public GetUnitDataResponse2 getGetUnitDataResult() {
        return getUnitDataResult;
    }

    /**
     * Sets the value of the getUnitDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUnitDataResponse2 }
     *     
     */
    public void setGetUnitDataResult(GetUnitDataResponse2 value) {
        this.getUnitDataResult = value;
    }

}
