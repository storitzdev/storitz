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
 *         &lt;element name="CompleteUnitTransferResult" type="{http://www.centershift.com/STORE40/}CompleteUnitTransfer_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "completeUnitTransferResult"
})
@XmlRootElement(name = "CompleteUnitTransferResponse")
public class CompleteUnitTransferResponse {

    @XmlElement(name = "CompleteUnitTransferResult", required = true)
    protected CompleteUnitTransferResponse2 completeUnitTransferResult;

    /**
     * Gets the value of the completeUnitTransferResult property.
     *
     * @return possible object is
     *         {@link CompleteUnitTransferResponse2 }
     */
    public CompleteUnitTransferResponse2 getCompleteUnitTransferResult() {
        return completeUnitTransferResult;
    }

    /**
     * Sets the value of the completeUnitTransferResult property.
     *
     * @param value allowed object is
     *              {@link CompleteUnitTransferResponse2 }
     */
    public void setCompleteUnitTransferResult(CompleteUnitTransferResponse2 value) {
        this.completeUnitTransferResult = value;
    }

}
