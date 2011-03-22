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
 *         &lt;element name="ReserveUnitNochargeResult" type="{http://tempuri.org/}NewAccountResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "reserveUnitNochargeResult"
})
@XmlRootElement(name = "ReserveUnitNochargeResponse")
public class ReserveUnitNochargeResponse {

    @XmlElement(name = "ReserveUnitNochargeResult", required = true)
    protected NewAccountResult reserveUnitNochargeResult;

    /**
     * Gets the value of the reserveUnitNochargeResult property.
     *
     * @return possible object is
     *         {@link NewAccountResult }
     */
    public NewAccountResult getReserveUnitNochargeResult() {
        return reserveUnitNochargeResult;
    }

    /**
     * Sets the value of the reserveUnitNochargeResult property.
     *
     * @param value allowed object is
     *              {@link NewAccountResult }
     */
    public void setReserveUnitNochargeResult(NewAccountResult value) {
        this.reserveUnitNochargeResult = value;
    }

}
