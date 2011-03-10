
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
 *         &lt;element name="JustAvailableUnitTypesResult" type="{http://tempuri.org/}ArrayOfAvailableUnitTypes_ST" minOccurs="0"/>
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
    "justAvailableUnitTypesResult"
})
@XmlRootElement(name = "JustAvailableUnitTypesResponse")
public class JustAvailableUnitTypesResponse {

    @XmlElement(name = "JustAvailableUnitTypesResult")
    protected ArrayOfAvailableUnitTypesST justAvailableUnitTypesResult;

    /**
     * Gets the value of the justAvailableUnitTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAvailableUnitTypesST }
     *     
     */
    public ArrayOfAvailableUnitTypesST getJustAvailableUnitTypesResult() {
        return justAvailableUnitTypesResult;
    }

    /**
     * Sets the value of the justAvailableUnitTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAvailableUnitTypesST }
     *     
     */
    public void setJustAvailableUnitTypesResult(ArrayOfAvailableUnitTypesST value) {
        this.justAvailableUnitTypesResult = value;
    }

}
