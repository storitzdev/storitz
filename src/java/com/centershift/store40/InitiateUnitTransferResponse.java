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
 *         &lt;element name="InitiateUnitTransferResult" type="{http://www.centershift.com/STORE40/}InitiateUnitTransfer_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "initiateUnitTransferResult"
})
@XmlRootElement(name = "InitiateUnitTransferResponse")
public class InitiateUnitTransferResponse {

    @XmlElement(name = "InitiateUnitTransferResult", required = true)
    protected InitiateUnitTransferResponse2 initiateUnitTransferResult;

    /**
     * Gets the value of the initiateUnitTransferResult property.
     *
     * @return possible object is
     *         {@link InitiateUnitTransferResponse2 }
     */
    public InitiateUnitTransferResponse2 getInitiateUnitTransferResult() {
        return initiateUnitTransferResult;
    }

    /**
     * Sets the value of the initiateUnitTransferResult property.
     *
     * @param value allowed object is
     *              {@link InitiateUnitTransferResponse2 }
     */
    public void setInitiateUnitTransferResult(InitiateUnitTransferResponse2 value) {
        this.initiateUnitTransferResult = value;
    }

}
