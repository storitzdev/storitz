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
 *         &lt;element name="MoveInSourceListResult" type="{http://tempuri.org/}ArrayOfAnyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "moveInSourceListResult"
})
@XmlRootElement(name = "MoveInSourceListResponse")
public class MoveInSourceListResponse {

    @XmlElement(name = "MoveInSourceListResult")
    protected ArrayOfAnyType moveInSourceListResult;

    /**
     * Gets the value of the moveInSourceListResult property.
     *
     * @return possible object is
     *         {@link ArrayOfAnyType }
     */
    public ArrayOfAnyType getMoveInSourceListResult() {
        return moveInSourceListResult;
    }

    /**
     * Sets the value of the moveInSourceListResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAnyType }
     */
    public void setMoveInSourceListResult(ArrayOfAnyType value) {
        this.moveInSourceListResult = value;
    }

}
