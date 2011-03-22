package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateRentRate_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateRentRate_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestData" type="{http://www.centershift.com/STORE40/}ArrayOfRentRateReqData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateRentRate_Request", propOrder = {
        "requestData"
})
public class UpdateRentRateRequest {

    @XmlElement(name = "RequestData")
    protected ArrayOfRentRateReqData requestData;

    /**
     * Gets the value of the requestData property.
     *
     * @return possible object is
     *         {@link ArrayOfRentRateReqData }
     */
    public ArrayOfRentRateReqData getRequestData() {
        return requestData;
    }

    /**
     * Sets the value of the requestData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfRentRateReqData }
     */
    public void setRequestData(ArrayOfRentRateReqData value) {
        this.requestData = value;
    }

}
