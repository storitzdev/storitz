package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAuctions_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetAuctions_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfTRAN_AUCTION_SETUP" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAuctions_Response", propOrder = {
        "details"
})
public class GetAuctionsResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfTRANAUCTIONSETUP details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfTRANAUCTIONSETUP }
     */
    public ArrayOfTRANAUCTIONSETUP getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfTRANAUCTIONSETUP }
     */
    public void setDetails(ArrayOfTRANAUCTIONSETUP value) {
        this.details = value;
    }

}
