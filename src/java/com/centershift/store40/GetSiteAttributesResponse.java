
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetSiteAttributesResult" type="{http://www.centershift.com/STORE40/}GetSiteAttributes_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getSiteAttributesResult"
})
@XmlRootElement(name = "GetSiteAttributesResponse")
public class GetSiteAttributesResponse {

    @XmlElement(name = "GetSiteAttributesResult", required = true)
    protected GetSiteAttributesResponse2 getSiteAttributesResult;

    /**
     * Gets the value of the getSiteAttributesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetSiteAttributesResponse2 }
     *     
     */
    public GetSiteAttributesResponse2 getGetSiteAttributesResult() {
        return getSiteAttributesResult;
    }

    /**
     * Sets the value of the getSiteAttributesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSiteAttributesResponse2 }
     *     
     */
    public void setGetSiteAttributesResult(GetSiteAttributesResponse2 value) {
        this.getSiteAttributesResult = value;
    }

}
