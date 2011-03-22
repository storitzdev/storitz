package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="eUnitAccessTypeResult" type="{http://www.centershift.com/STORE40/}ArrayOfCFG_LOOKUPS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "eUnitAccessTypeResult"
})
@XmlRootElement(name = "eUnitAccessTypeResponse")
public class EUnitAccessTypeResponse {

    protected ArrayOfCFGLOOKUPS eUnitAccessTypeResult;

    /**
     * Gets the value of the eUnitAccessTypeResult property.
     *
     * @return possible object is
     *         {@link ArrayOfCFGLOOKUPS }
     */
    public ArrayOfCFGLOOKUPS getEUnitAccessTypeResult() {
        return eUnitAccessTypeResult;
    }

    /**
     * Sets the value of the eUnitAccessTypeResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfCFGLOOKUPS }
     */
    public void setEUnitAccessTypeResult(ArrayOfCFGLOOKUPS value) {
        this.eUnitAccessTypeResult = value;
    }

}
