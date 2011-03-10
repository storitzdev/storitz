
package org.tempuri;

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
 *         &lt;element name="ReserveInCostResult" type="{http://tempuri.org/}Charge_ST"/>
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
    "reserveInCostResult"
})
@XmlRootElement(name = "ReserveInCostResponse")
public class ReserveInCostResponse {

    @XmlElement(name = "ReserveInCostResult", required = true)
    protected ChargeST reserveInCostResult;

    /**
     * Gets the value of the reserveInCostResult property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeST }
     *     
     */
    public ChargeST getReserveInCostResult() {
        return reserveInCostResult;
    }

    /**
     * Sets the value of the reserveInCostResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeST }
     *     
     */
    public void setReserveInCostResult(ChargeST value) {
        this.reserveInCostResult = value;
    }

}
