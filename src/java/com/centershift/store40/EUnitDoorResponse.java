
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
 *         &lt;element name="eUnitDoorResult" type="{http://www.centershift.com/STORE40/}ArrayOfCFG_LOOKUPS" minOccurs="0"/>
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
    "eUnitDoorResult"
})
@XmlRootElement(name = "eUnitDoorResponse")
public class EUnitDoorResponse {

    protected ArrayOfCFGLOOKUPS eUnitDoorResult;

    /**
     * Gets the value of the eUnitDoorResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCFGLOOKUPS }
     *     
     */
    public ArrayOfCFGLOOKUPS getEUnitDoorResult() {
        return eUnitDoorResult;
    }

    /**
     * Sets the value of the eUnitDoorResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCFGLOOKUPS }
     *     
     */
    public void setEUnitDoorResult(ArrayOfCFGLOOKUPS value) {
        this.eUnitDoorResult = value;
    }

}
