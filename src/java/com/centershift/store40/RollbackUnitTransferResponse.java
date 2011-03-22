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
 *         &lt;element name="RollbackUnitTransferResult" type="{http://www.centershift.com/STORE40/}RollbackUnitTransfer_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "rollbackUnitTransferResult"
})
@XmlRootElement(name = "RollbackUnitTransferResponse")
public class RollbackUnitTransferResponse {

    @XmlElement(name = "RollbackUnitTransferResult", required = true)
    protected RollbackUnitTransferResponse2 rollbackUnitTransferResult;

    /**
     * Gets the value of the rollbackUnitTransferResult property.
     *
     * @return possible object is
     *         {@link RollbackUnitTransferResponse2 }
     */
    public RollbackUnitTransferResponse2 getRollbackUnitTransferResult() {
        return rollbackUnitTransferResult;
    }

    /**
     * Sets the value of the rollbackUnitTransferResult property.
     *
     * @param value allowed object is
     *              {@link RollbackUnitTransferResponse2 }
     */
    public void setRollbackUnitTransferResult(RollbackUnitTransferResponse2 value) {
        this.rollbackUnitTransferResult = value;
    }

}
