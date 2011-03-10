
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
 *         &lt;element name="UpdateGatePINResult" type="{http://www.centershift.com/STORE40/}UpdateGatePIN_Response"/>
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
    "updateGatePINResult"
})
@XmlRootElement(name = "UpdateGatePINResponse")
public class UpdateGatePINResponse {

    @XmlElement(name = "UpdateGatePINResult", required = true)
    protected UpdateGatePINResponse2 updateGatePINResult;

    /**
     * Gets the value of the updateGatePINResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateGatePINResponse2 }
     *     
     */
    public UpdateGatePINResponse2 getUpdateGatePINResult() {
        return updateGatePINResult;
    }

    /**
     * Sets the value of the updateGatePINResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateGatePINResponse2 }
     *     
     */
    public void setUpdateGatePINResult(UpdateGatePINResponse2 value) {
        this.updateGatePINResult = value;
    }

}
