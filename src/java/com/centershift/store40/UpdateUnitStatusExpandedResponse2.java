package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateUnitStatusExpanded_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateUnitStatusExpanded_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitStatusResponseData" type="{http://www.centershift.com/STORE40/}ArrayOfUpdateUnitStatusExpanded_ResponseData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateUnitStatusExpanded_Response", propOrder = {
        "unitStatusResponseData"
})
public class UpdateUnitStatusExpandedResponse2 {

    @XmlElement(name = "UnitStatusResponseData")
    protected ArrayOfUpdateUnitStatusExpandedResponseData unitStatusResponseData;

    /**
     * Gets the value of the unitStatusResponseData property.
     *
     * @return possible object is
     *         {@link ArrayOfUpdateUnitStatusExpandedResponseData }
     */
    public ArrayOfUpdateUnitStatusExpandedResponseData getUnitStatusResponseData() {
        return unitStatusResponseData;
    }

    /**
     * Sets the value of the unitStatusResponseData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfUpdateUnitStatusExpandedResponseData }
     */
    public void setUnitStatusResponseData(ArrayOfUpdateUnitStatusExpandedResponseData value) {
        this.unitStatusResponseData = value;
    }

}
