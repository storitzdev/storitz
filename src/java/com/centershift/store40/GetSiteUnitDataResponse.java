package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetSiteUnitData_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetSiteUnitData_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfSiteUnitData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSiteUnitData_Response", propOrder = {
        "details"
})
public class GetSiteUnitDataResponse {

    @XmlElement(name = "Details")
    protected ArrayOfSiteUnitData details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfSiteUnitData }
     */
    public ArrayOfSiteUnitData getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfSiteUnitData }
     */
    public void setDetails(ArrayOfSiteUnitData value) {
        this.details = value;
    }

}
