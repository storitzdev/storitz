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
 *         &lt;element name="MoveInSourceResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "moveInSourceResult"
})
@XmlRootElement(name = "MoveInSourceResponse")
public class MoveInSourceResponse {

    @XmlElement(name = "MoveInSourceResult")
    protected boolean moveInSourceResult;

    /**
     * Gets the value of the moveInSourceResult property.
     */
    public boolean isMoveInSourceResult() {
        return moveInSourceResult;
    }

    /**
     * Sets the value of the moveInSourceResult property.
     */
    public void setMoveInSourceResult(boolean value) {
        this.moveInSourceResult = value;
    }

}
