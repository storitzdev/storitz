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
 *         &lt;element name="MoveInCost2Result" type="{http://tempuri.org/}ArrayOfCharge_ST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "moveInCost2Result"
})
@XmlRootElement(name = "MoveInCost2Response")
public class MoveInCost2Response {

    @XmlElement(name = "MoveInCost2Result")
    protected ArrayOfChargeST moveInCost2Result;

    /**
     * Gets the value of the moveInCost2Result property.
     *
     * @return possible object is
     *         {@link ArrayOfChargeST }
     */
    public ArrayOfChargeST getMoveInCost2Result() {
        return moveInCost2Result;
    }

    /**
     * Sets the value of the moveInCost2Result property.
     *
     * @param value allowed object is
     *              {@link ArrayOfChargeST }
     */
    public void setMoveInCost2Result(ArrayOfChargeST value) {
        this.moveInCost2Result = value;
    }

}
