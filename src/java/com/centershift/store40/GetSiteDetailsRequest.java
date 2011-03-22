package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetSiteDetails_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetSiteDetails_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.centershift.com/STORE40/}ArrayOfLong" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSiteDetails_Request", propOrder = {
        "siteID"
})
public class GetSiteDetailsRequest {

    @XmlElement(name = "SiteID")
    protected ArrayOfLong siteID;

    /**
     * Gets the value of the siteID property.
     *
     * @return possible object is
     *         {@link ArrayOfLong }
     */
    public ArrayOfLong getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     *
     * @param value allowed object is
     *              {@link ArrayOfLong }
     */
    public void setSiteID(ArrayOfLong value) {
        this.siteID = value;
    }

}
