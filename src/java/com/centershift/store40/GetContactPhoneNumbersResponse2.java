package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetContactPhoneNumbers_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetContactPhoneNumbers_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfACCT_CONTACT_PHONES" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetContactPhoneNumbers_Response", propOrder = {
        "details"
})
public class GetContactPhoneNumbersResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfACCTCONTACTPHONES details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfACCTCONTACTPHONES }
     */
    public ArrayOfACCTCONTACTPHONES getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfACCTCONTACTPHONES }
     */
    public void setDetails(ArrayOfACCTCONTACTPHONES value) {
        this.details = value;
    }

}
