
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
 *         &lt;element name="UnitTypeInfoResult" type="{http://tempuri.org/}UnitTypeInfo_ST"/>
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
    "unitTypeInfoResult"
})
@XmlRootElement(name = "UnitTypeInfoResponse")
public class UnitTypeInfoResponse {

    @XmlElement(name = "UnitTypeInfoResult", required = true)
    protected UnitTypeInfoST unitTypeInfoResult;

    /**
     * Gets the value of the unitTypeInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link UnitTypeInfoST }
     *     
     */
    public UnitTypeInfoST getUnitTypeInfoResult() {
        return unitTypeInfoResult;
    }

    /**
     * Sets the value of the unitTypeInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitTypeInfoST }
     *     
     */
    public void setUnitTypeInfoResult(UnitTypeInfoST value) {
        this.unitTypeInfoResult = value;
    }

}
