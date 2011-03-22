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
 *         &lt;element name="UpdateInsuranceResult" type="{http://www.centershift.com/STORE40/}UpdateInsurance_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updateInsuranceResult"
})
@XmlRootElement(name = "UpdateInsuranceResponse")
public class UpdateInsuranceResponse {

    @XmlElement(name = "UpdateInsuranceResult", required = true)
    protected UpdateInsuranceResponse2 updateInsuranceResult;

    /**
     * Gets the value of the updateInsuranceResult property.
     *
     * @return possible object is
     *         {@link UpdateInsuranceResponse2 }
     */
    public UpdateInsuranceResponse2 getUpdateInsuranceResult() {
        return updateInsuranceResult;
    }

    /**
     * Sets the value of the updateInsuranceResult property.
     *
     * @param value allowed object is
     *              {@link UpdateInsuranceResponse2 }
     */
    public void setUpdateInsuranceResult(UpdateInsuranceResponse2 value) {
        this.updateInsuranceResult = value;
    }

}
