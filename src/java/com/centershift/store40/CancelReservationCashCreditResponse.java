
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CancelReservationCashCreditResult" type="{http://www.centershift.com/STORE40/}CancelReservationCashCredit_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cancelReservationCashCreditResult"
})
@XmlRootElement(name = "CancelReservationCashCreditResponse")
public class CancelReservationCashCreditResponse {

    @XmlElement(name = "CancelReservationCashCreditResult", required = true)
    protected CancelReservationCashCreditResponse2 cancelReservationCashCreditResult;

    /**
     * Gets the value of the cancelReservationCashCreditResult property.
     * 
     * @return
     *     possible object is
     *     {@link CancelReservationCashCreditResponse2 }
     *     
     */
    public CancelReservationCashCreditResponse2 getCancelReservationCashCreditResult() {
        return cancelReservationCashCreditResult;
    }

    /**
     * Sets the value of the cancelReservationCashCreditResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelReservationCashCreditResponse2 }
     *     
     */
    public void setCancelReservationCashCreditResult(CancelReservationCashCreditResponse2 value) {
        this.cancelReservationCashCreditResult = value;
    }

}
