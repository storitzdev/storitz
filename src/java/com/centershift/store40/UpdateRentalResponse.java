package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateRentalResult" type="{http://www.centershift.com/STORE40/}UpdateRental_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updateRentalResult"
})
@XmlRootElement(name = "UpdateRentalResponse")
public class UpdateRentalResponse {

    @XmlElement(name = "UpdateRentalResult", required = true)
    protected UpdateRentalResponse2 updateRentalResult;

    /**
     * Gets the value of the updateRentalResult property.
     *
     * @return possible object is
     *         {@link UpdateRentalResponse2 }
     */
    public UpdateRentalResponse2 getUpdateRentalResult() {
        return updateRentalResult;
    }

    /**
     * Sets the value of the updateRentalResult property.
     *
     * @param value allowed object is
     *              {@link UpdateRentalResponse2 }
     */
    public void setUpdateRentalResult(UpdateRentalResponse2 value) {
        this.updateRentalResult = value;
    }

}
