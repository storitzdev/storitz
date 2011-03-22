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
 *         &lt;element name="ReserveInCostResult" type="{http://tempuri.org/}Charge_ST"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
     * @return possible object is
     *         {@link ChargeST }
     */
    public ChargeST getReserveInCostResult() {
        return reserveInCostResult;
    }

    /**
     * Sets the value of the reserveInCostResult property.
     *
     * @param value allowed object is
     *              {@link ChargeST }
     */
    public void setReserveInCostResult(ChargeST value) {
        this.reserveInCostResult = value;
    }

}
