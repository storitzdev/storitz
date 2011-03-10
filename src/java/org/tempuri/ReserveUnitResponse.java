
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
 *         &lt;element name="ReserveUnitResult" type="{http://tempuri.org/}NewAccountResult"/>
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
    "reserveUnitResult"
})
@XmlRootElement(name = "ReserveUnitResponse")
public class ReserveUnitResponse {

    @XmlElement(name = "ReserveUnitResult", required = true)
    protected NewAccountResult reserveUnitResult;

    /**
     * Gets the value of the reserveUnitResult property.
     * 
     * @return
     *     possible object is
     *     {@link NewAccountResult }
     *     
     */
    public NewAccountResult getReserveUnitResult() {
        return reserveUnitResult;
    }

    /**
     * Sets the value of the reserveUnitResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NewAccountResult }
     *     
     */
    public void setReserveUnitResult(NewAccountResult value) {
        this.reserveUnitResult = value;
    }

}
