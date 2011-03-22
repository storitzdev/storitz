package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMiscRevenueClassData_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetMiscRevenueClassData_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfMiscellaneousRevenueClassData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMiscRevenueClassData_Response", propOrder = {
        "details"
})
public class GetMiscRevenueClassDataResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfMiscellaneousRevenueClassData details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfMiscellaneousRevenueClassData }
     */
    public ArrayOfMiscellaneousRevenueClassData getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfMiscellaneousRevenueClassData }
     */
    public void setDetails(ArrayOfMiscellaneousRevenueClassData value) {
        this.details = value;
    }

}
