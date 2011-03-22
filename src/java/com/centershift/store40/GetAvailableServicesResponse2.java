package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAvailableServices_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetAvailableServices_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfORG_SERVICE_SITE_OFFERINGS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAvailableServices_Response", propOrder = {
        "details"
})
public class GetAvailableServicesResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfORGSERVICESITEOFFERINGS details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfORGSERVICESITEOFFERINGS }
     */
    public ArrayOfORGSERVICESITEOFFERINGS getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfORGSERVICESITEOFFERINGS }
     */
    public void setDetails(ArrayOfORGSERVICESITEOFFERINGS value) {
        this.details = value;
    }

}
