
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="eUnitClimateResult" type="{http://www.centershift.com/STORE40/}ArrayOfCFG_LOOKUPS" minOccurs="0"/>
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
    "eUnitClimateResult"
})
@XmlRootElement(name = "eUnitClimateResponse")
public class EUnitClimateResponse {

    protected ArrayOfCFGLOOKUPS eUnitClimateResult;

    /**
     * Gets the value of the eUnitClimateResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCFGLOOKUPS }
     *     
     */
    public ArrayOfCFGLOOKUPS getEUnitClimateResult() {
        return eUnitClimateResult;
    }

    /**
     * Sets the value of the eUnitClimateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCFGLOOKUPS }
     *     
     */
    public void setEUnitClimateResult(ArrayOfCFGLOOKUPS value) {
        this.eUnitClimateResult = value;
    }

}
