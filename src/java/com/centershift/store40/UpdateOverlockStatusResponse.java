
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
 *         &lt;element name="UpdateOverlockStatusResult" type="{http://www.centershift.com/STORE40/}UpdateOverlockStatus_Response"/>
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
    "updateOverlockStatusResult"
})
@XmlRootElement(name = "UpdateOverlockStatusResponse")
public class UpdateOverlockStatusResponse {

    @XmlElement(name = "UpdateOverlockStatusResult", required = true)
    protected UpdateOverlockStatusResponse2 updateOverlockStatusResult;

    /**
     * Gets the value of the updateOverlockStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateOverlockStatusResponse2 }
     *     
     */
    public UpdateOverlockStatusResponse2 getUpdateOverlockStatusResult() {
        return updateOverlockStatusResult;
    }

    /**
     * Sets the value of the updateOverlockStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateOverlockStatusResponse2 }
     *     
     */
    public void setUpdateOverlockStatusResult(UpdateOverlockStatusResponse2 value) {
        this.updateOverlockStatusResult = value;
    }

}
