
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelReservationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelReservationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ObjectID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TranID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HasDeposit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AvailableRefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Succeeded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelReservationData", propOrder = {
    "objectID",
    "tranID",
    "hasDeposit",
    "availableRefundAmount",
    "succeeded",
    "errorMessage"
})
public class CancelReservationData {

    @XmlElement(name = "ObjectID")
    protected long objectID;
    @XmlElement(name = "TranID")
    protected String tranID;
    @XmlElement(name = "HasDeposit")
    protected boolean hasDeposit;
    @XmlElement(name = "AvailableRefundAmount", required = true)
    protected BigDecimal availableRefundAmount;
    @XmlElement(name = "Succeeded")
    protected boolean succeeded;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;

    /**
     * Gets the value of the objectID property.
     * 
     */
    public long getObjectID() {
        return objectID;
    }

    /**
     * Sets the value of the objectID property.
     * 
     */
    public void setObjectID(long value) {
        this.objectID = value;
    }

    /**
     * Gets the value of the tranID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranID() {
        return tranID;
    }

    /**
     * Sets the value of the tranID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranID(String value) {
        this.tranID = value;
    }

    /**
     * Gets the value of the hasDeposit property.
     * 
     */
    public boolean isHasDeposit() {
        return hasDeposit;
    }

    /**
     * Sets the value of the hasDeposit property.
     * 
     */
    public void setHasDeposit(boolean value) {
        this.hasDeposit = value;
    }

    /**
     * Gets the value of the availableRefundAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAvailableRefundAmount() {
        return availableRefundAmount;
    }

    /**
     * Sets the value of the availableRefundAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAvailableRefundAmount(BigDecimal value) {
        this.availableRefundAmount = value;
    }

    /**
     * Gets the value of the succeeded property.
     * 
     */
    public boolean isSucceeded() {
        return succeeded;
    }

    /**
     * Sets the value of the succeeded property.
     * 
     */
    public void setSucceeded(boolean value) {
        this.succeeded = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

}
