
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetSiteAttributes_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetSiteAttributes_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfORG_EXT_ATTRIBUTES" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSiteAttributes_Response", propOrder = {
    "details"
})
public class GetSiteAttributesResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfORGEXTATTRIBUTES details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfORGEXTATTRIBUTES }
     *     
     */
    public ArrayOfORGEXTATTRIBUTES getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfORGEXTATTRIBUTES }
     *     
     */
    public void setDetails(ArrayOfORGEXTATTRIBUTES value) {
        this.details = value;
    }

}
