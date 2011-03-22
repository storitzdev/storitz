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
 *         &lt;element name="UpdateGatePINResult" type="{http://www.centershift.com/STORE40/}UpdateGatePIN_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
     * @return possible object is
     *         {@link UpdateGatePINResponse2 }
     */
    public UpdateGatePINResponse2 getUpdateGatePINResult() {
        return updateGatePINResult;
    }

    /**
     * Sets the value of the updateGatePINResult property.
     *
     * @param value allowed object is
     *              {@link UpdateGatePINResponse2 }
     */
    public void setUpdateGatePINResult(UpdateGatePINResponse2 value) {
        this.updateGatePINResult = value;
    }

}
