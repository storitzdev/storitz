package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetSiteList_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetSiteList_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfSOA_GET_SITE_LIST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSiteList_Response", propOrder = {
        "details"
})
public class GetSiteListResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfSOAGETSITELIST details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfSOAGETSITELIST }
     */
    public ArrayOfSOAGETSITELIST getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfSOAGETSITELIST }
     */
    public void setDetails(ArrayOfSOAGETSITELIST value) {
        this.details = value;
    }

}
