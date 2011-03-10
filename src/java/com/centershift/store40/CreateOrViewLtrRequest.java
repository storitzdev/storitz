
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createOrViewLtr_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createOrViewLtr_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LtrData" type="{http://www.centershift.com/STORE40/}swsLtrParams"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createOrViewLtr_Request", propOrder = {
    "ltrData"
})
public class CreateOrViewLtrRequest {

    @XmlElement(name = "LtrData", required = true)
    protected SwsLtrParams ltrData;

    /**
     * Gets the value of the ltrData property.
     * 
     * @return
     *     possible object is
     *     {@link SwsLtrParams }
     *     
     */
    public SwsLtrParams getLtrData() {
        return ltrData;
    }

    /**
     * Sets the value of the ltrData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SwsLtrParams }
     *     
     */
    public void setLtrData(SwsLtrParams value) {
        this.ltrData = value;
    }

}
