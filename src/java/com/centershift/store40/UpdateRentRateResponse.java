
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
 *         &lt;element name="UpdateRentRateResult" type="{http://www.centershift.com/STORE40/}UpdateRentRate_Response"/>
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
    "updateRentRateResult"
})
@XmlRootElement(name = "UpdateRentRateResponse")
public class UpdateRentRateResponse {

    @XmlElement(name = "UpdateRentRateResult", required = true)
    protected UpdateRentRateResponse2 updateRentRateResult;

    /**
     * Gets the value of the updateRentRateResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateRentRateResponse2 }
     *     
     */
    public UpdateRentRateResponse2 getUpdateRentRateResult() {
        return updateRentRateResult;
    }

    /**
     * Sets the value of the updateRentRateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateRentRateResponse2 }
     *     
     */
    public void setUpdateRentRateResult(UpdateRentRateResponse2 value) {
        this.updateRentRateResult = value;
    }

}
