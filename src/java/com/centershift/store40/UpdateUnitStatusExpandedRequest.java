package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateUnitStatusExpanded_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateUnitStatusExpanded_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitStatusUpdateData" type="{http://www.centershift.com/STORE40/}ArrayOfUpdateUnitStatusExpanded_RequestData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateUnitStatusExpanded_Request", propOrder = {
        "unitStatusUpdateData"
})
public class UpdateUnitStatusExpandedRequest {

    @XmlElement(name = "UnitStatusUpdateData")
    protected ArrayOfUpdateUnitStatusExpandedRequestData unitStatusUpdateData;

    /**
     * Gets the value of the unitStatusUpdateData property.
     *
     * @return possible object is
     *         {@link ArrayOfUpdateUnitStatusExpandedRequestData }
     */
    public ArrayOfUpdateUnitStatusExpandedRequestData getUnitStatusUpdateData() {
        return unitStatusUpdateData;
    }

    /**
     * Sets the value of the unitStatusUpdateData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfUpdateUnitStatusExpandedRequestData }
     */
    public void setUnitStatusUpdateData(ArrayOfUpdateUnitStatusExpandedRequestData value) {
        this.unitStatusUpdateData = value;
    }

}
