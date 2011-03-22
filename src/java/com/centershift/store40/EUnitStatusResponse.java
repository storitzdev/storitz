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
 *         &lt;element name="eUnitStatusResult" type="{http://www.centershift.com/STORE40/}ArrayOfCFG_LOOKUPS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "eUnitStatusResult"
})
@XmlRootElement(name = "eUnitStatusResponse")
public class EUnitStatusResponse {

    protected ArrayOfCFGLOOKUPS eUnitStatusResult;

    /**
     * Gets the value of the eUnitStatusResult property.
     *
     * @return possible object is
     *         {@link ArrayOfCFGLOOKUPS }
     */
    public ArrayOfCFGLOOKUPS getEUnitStatusResult() {
        return eUnitStatusResult;
    }

    /**
     * Sets the value of the eUnitStatusResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfCFGLOOKUPS }
     */
    public void setEUnitStatusResult(ArrayOfCFGLOOKUPS value) {
        this.eUnitStatusResult = value;
    }

}
