package org.tempuri;

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
 *         &lt;element name="OnlineMoveInReconciliationResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "onlineMoveInReconciliationResult"
})
@XmlRootElement(name = "OnlineMoveInReconciliationResponse")
public class OnlineMoveInReconciliationResponse {

    @XmlElement(name = "OnlineMoveInReconciliationResult")
    protected boolean onlineMoveInReconciliationResult;

    /**
     * Gets the value of the onlineMoveInReconciliationResult property.
     */
    public boolean isOnlineMoveInReconciliationResult() {
        return onlineMoveInReconciliationResult;
    }

    /**
     * Sets the value of the onlineMoveInReconciliationResult property.
     */
    public void setOnlineMoveInReconciliationResult(boolean value) {
        this.onlineMoveInReconciliationResult = value;
    }

}
