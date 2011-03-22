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
 *         &lt;element name="eUnitClassResult" type="{http://www.centershift.com/STORE40/}ArrayOfSITE_CLASSES" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "eUnitClassResult"
})
@XmlRootElement(name = "eUnitClassResponse")
public class EUnitClassResponse {

    protected ArrayOfSITECLASSES eUnitClassResult;

    /**
     * Gets the value of the eUnitClassResult property.
     *
     * @return possible object is
     *         {@link ArrayOfSITECLASSES }
     */
    public ArrayOfSITECLASSES getEUnitClassResult() {
        return eUnitClassResult;
    }

    /**
     * Sets the value of the eUnitClassResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfSITECLASSES }
     */
    public void setEUnitClassResult(ArrayOfSITECLASSES value) {
        this.eUnitClassResult = value;
    }

}
