
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MoveOutInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MoveOutInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MoveOutDetailObjects" type="{http://www.centershift.com/STORE40/}ArrayOfMoveOutDetail" minOccurs="0"/>
 *         &lt;element name="MoveOutSummary" type="{http://www.centershift.com/STORE40/}MoveOutSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MoveOutInfo", propOrder = {
    "moveOutDetailObjects",
    "moveOutSummary"
})
public class MoveOutInfo {

    @XmlElement(name = "MoveOutDetailObjects")
    protected ArrayOfMoveOutDetail moveOutDetailObjects;
    @XmlElement(name = "MoveOutSummary")
    protected MoveOutSummary moveOutSummary;

    /**
     * Gets the value of the moveOutDetailObjects property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMoveOutDetail }
     *     
     */
    public ArrayOfMoveOutDetail getMoveOutDetailObjects() {
        return moveOutDetailObjects;
    }

    /**
     * Sets the value of the moveOutDetailObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMoveOutDetail }
     *     
     */
    public void setMoveOutDetailObjects(ArrayOfMoveOutDetail value) {
        this.moveOutDetailObjects = value;
    }

    /**
     * Gets the value of the moveOutSummary property.
     * 
     * @return
     *     possible object is
     *     {@link MoveOutSummary }
     *     
     */
    public MoveOutSummary getMoveOutSummary() {
        return moveOutSummary;
    }

    /**
     * Sets the value of the moveOutSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoveOutSummary }
     *     
     */
    public void setMoveOutSummary(MoveOutSummary value) {
        this.moveOutSummary = value;
    }

}
