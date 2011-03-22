package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateOverlockStatus_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateOverlockStatus_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseData" type="{http://www.centershift.com/STORE40/}ArrayOfUpdateOverlockStatusResponseData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateOverlockStatus_Response", propOrder = {
        "responseData"
})
public class UpdateOverlockStatusResponse2 {

    @XmlElement(name = "ResponseData")
    protected ArrayOfUpdateOverlockStatusResponseData responseData;

    /**
     * Gets the value of the responseData property.
     *
     * @return possible object is
     *         {@link ArrayOfUpdateOverlockStatusResponseData }
     */
    public ArrayOfUpdateOverlockStatusResponseData getResponseData() {
        return responseData;
    }

    /**
     * Sets the value of the responseData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfUpdateOverlockStatusResponseData }
     */
    public void setResponseData(ArrayOfUpdateOverlockStatusResponseData value) {
        this.responseData = value;
    }

}
