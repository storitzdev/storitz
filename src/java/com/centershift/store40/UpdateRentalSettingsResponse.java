
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
 *         &lt;element name="UpdateRentalSettingsResult" type="{http://www.centershift.com/STORE40/}UpdateRentalSettings_Response"/>
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
    "updateRentalSettingsResult"
})
@XmlRootElement(name = "UpdateRentalSettingsResponse")
public class UpdateRentalSettingsResponse {

    @XmlElement(name = "UpdateRentalSettingsResult", required = true)
    protected UpdateRentalSettingsResponse2 updateRentalSettingsResult;

    /**
     * Gets the value of the updateRentalSettingsResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateRentalSettingsResponse2 }
     *     
     */
    public UpdateRentalSettingsResponse2 getUpdateRentalSettingsResult() {
        return updateRentalSettingsResult;
    }

    /**
     * Sets the value of the updateRentalSettingsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateRentalSettingsResponse2 }
     *     
     */
    public void setUpdateRentalSettingsResult(UpdateRentalSettingsResponse2 value) {
        this.updateRentalSettingsResult = value;
    }

}
