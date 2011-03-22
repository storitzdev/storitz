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
 *         &lt;element name="MoveInCostResult" type="{http://tempuri.org/}ArrayOfCharge_ST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "moveInCostResult"
})
@XmlRootElement(name = "MoveInCostResponse")
public class MoveInCostResponse {

    @XmlElement(name = "MoveInCostResult")
    protected ArrayOfChargeST moveInCostResult;

    /**
     * Gets the value of the moveInCostResult property.
     *
     * @return possible object is
     *         {@link ArrayOfChargeST }
     */
    public ArrayOfChargeST getMoveInCostResult() {
        return moveInCostResult;
    }

    /**
     * Sets the value of the moveInCostResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfChargeST }
     */
    public void setMoveInCostResult(ArrayOfChargeST value) {
        this.moveInCostResult = value;
    }

}
