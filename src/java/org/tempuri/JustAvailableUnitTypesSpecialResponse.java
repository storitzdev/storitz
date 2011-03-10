
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
 *         &lt;element name="JustAvailableUnitTypesSpecialResult" type="{http://tempuri.org/}ArrayOfAvailableUnitTypesSpecial_ST" minOccurs="0"/>
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
    "justAvailableUnitTypesSpecialResult"
})
@XmlRootElement(name = "JustAvailableUnitTypesSpecialResponse")
public class JustAvailableUnitTypesSpecialResponse {

    @XmlElement(name = "JustAvailableUnitTypesSpecialResult")
    protected ArrayOfAvailableUnitTypesSpecialST justAvailableUnitTypesSpecialResult;

    /**
     * Gets the value of the justAvailableUnitTypesSpecialResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAvailableUnitTypesSpecialST }
     *     
     */
    public ArrayOfAvailableUnitTypesSpecialST getJustAvailableUnitTypesSpecialResult() {
        return justAvailableUnitTypesSpecialResult;
    }

    /**
     * Sets the value of the justAvailableUnitTypesSpecialResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAvailableUnitTypesSpecialST }
     *     
     */
    public void setJustAvailableUnitTypesSpecialResult(ArrayOfAvailableUnitTypesSpecialST value) {
        this.justAvailableUnitTypesSpecialResult = value;
    }

}
