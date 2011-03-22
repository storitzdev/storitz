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
 *         &lt;element name="UpdateStreetRateResult" type="{http://www.centershift.com/STORE40/}UpdateStreetRate_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updateStreetRateResult"
})
@XmlRootElement(name = "UpdateStreetRateResponse")
public class UpdateStreetRateResponse {

    @XmlElement(name = "UpdateStreetRateResult", required = true)
    protected UpdateStreetRateResponse2 updateStreetRateResult;

    /**
     * Gets the value of the updateStreetRateResult property.
     *
     * @return possible object is
     *         {@link UpdateStreetRateResponse2 }
     */
    public UpdateStreetRateResponse2 getUpdateStreetRateResult() {
        return updateStreetRateResult;
    }

    /**
     * Sets the value of the updateStreetRateResult property.
     *
     * @param value allowed object is
     *              {@link UpdateStreetRateResponse2 }
     */
    public void setUpdateStreetRateResult(UpdateStreetRateResponse2 value) {
        this.updateStreetRateResult = value;
    }

}
