package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetGateCodeInfo_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetGateCodeInfo_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfSOA_GET_GATE_INFO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetGateCodeInfo_Response", propOrder = {
        "details"
})
public class GetGateCodeInfoResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfSOAGETGATEINFO details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfSOAGETGATEINFO }
     */
    public ArrayOfSOAGETGATEINFO getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfSOAGETGATEINFO }
     */
    public void setDetails(ArrayOfSOAGETGATEINFO value) {
        this.details = value;
    }

}
