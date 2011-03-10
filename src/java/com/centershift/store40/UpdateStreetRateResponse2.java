
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateStreetRate_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateStreetRate_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StreetUpdateResponseData" type="{http://www.centershift.com/STORE40/}ArrayOfUpdateStreetRespData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateStreetRate_Response", propOrder = {
    "streetUpdateResponseData"
})
public class UpdateStreetRateResponse2 {

    @XmlElement(name = "StreetUpdateResponseData")
    protected ArrayOfUpdateStreetRespData streetUpdateResponseData;

    /**
     * Gets the value of the streetUpdateResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUpdateStreetRespData }
     *     
     */
    public ArrayOfUpdateStreetRespData getStreetUpdateResponseData() {
        return streetUpdateResponseData;
    }

    /**
     * Sets the value of the streetUpdateResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUpdateStreetRespData }
     *     
     */
    public void setStreetUpdateResponseData(ArrayOfUpdateStreetRespData value) {
        this.streetUpdateResponseData = value;
    }

}
