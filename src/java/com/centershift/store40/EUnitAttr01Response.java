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
 *         &lt;element name="eUnitAttr01Result" type="{http://www.centershift.com/STORE40/}ArrayOfCFG_LOOKUPS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "eUnitAttr01Result"
})
@XmlRootElement(name = "eUnitAttr01Response")
public class EUnitAttr01Response {

    protected ArrayOfCFGLOOKUPS eUnitAttr01Result;

    /**
     * Gets the value of the eUnitAttr01Result property.
     *
     * @return possible object is
     *         {@link ArrayOfCFGLOOKUPS }
     */
    public ArrayOfCFGLOOKUPS getEUnitAttr01Result() {
        return eUnitAttr01Result;
    }

    /**
     * Sets the value of the eUnitAttr01Result property.
     *
     * @param value allowed object is
     *              {@link ArrayOfCFGLOOKUPS }
     */
    public void setEUnitAttr01Result(ArrayOfCFGLOOKUPS value) {
        this.eUnitAttr01Result = value;
    }

}
