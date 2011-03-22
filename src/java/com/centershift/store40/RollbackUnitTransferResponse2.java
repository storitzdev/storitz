package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RollbackUnitTransfer_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RollbackUnitTransfer_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Succeeded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RollbackUnitTransfer_Response", propOrder = {
        "succeeded"
})
public class RollbackUnitTransferResponse2 {

    @XmlElement(name = "Succeeded")
    protected boolean succeeded;

    /**
     * Gets the value of the succeeded property.
     */
    public boolean isSucceeded() {
        return succeeded;
    }

    /**
     * Sets the value of the succeeded property.
     */
    public void setSucceeded(boolean value) {
        this.succeeded = value;
    }

}
