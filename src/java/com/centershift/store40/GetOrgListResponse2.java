
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetOrgList_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetOrgList_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfOrganization" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOrgList_Response", propOrder = {
    "details"
})
public class GetOrgListResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfOrganization details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOrganization }
     *     
     */
    public ArrayOfOrganization getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOrganization }
     *     
     */
    public void setDetails(ArrayOfOrganization value) {
        this.details = value;
    }

}
