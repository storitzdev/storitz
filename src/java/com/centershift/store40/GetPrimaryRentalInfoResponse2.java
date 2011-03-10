
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetPrimaryRentalInfo_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPrimaryRentalInfo_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfSOA_GET_PRIMARY_RENTAL_INFO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPrimaryRentalInfo_Response", propOrder = {
    "details"
})
public class GetPrimaryRentalInfoResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfSOAGETPRIMARYRENTALINFO details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSOAGETPRIMARYRENTALINFO }
     *     
     */
    public ArrayOfSOAGETPRIMARYRENTALINFO getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSOAGETPRIMARYRENTALINFO }
     *     
     */
    public void setDetails(ArrayOfSOAGETPRIMARYRENTALINFO value) {
        this.details = value;
    }

}
