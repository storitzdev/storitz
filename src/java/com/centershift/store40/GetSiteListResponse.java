
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
 *         &lt;element name="GetSiteListResult" type="{http://www.centershift.com/STORE40/}GetSiteList_Response"/>
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
    "getSiteListResult"
})
@XmlRootElement(name = "GetSiteListResponse")
public class GetSiteListResponse {

    @XmlElement(name = "GetSiteListResult", required = true)
    protected GetSiteListResponse2 getSiteListResult;

    /**
     * Gets the value of the getSiteListResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetSiteListResponse2 }
     *     
     */
    public GetSiteListResponse2 getGetSiteListResult() {
        return getSiteListResult;
    }

    /**
     * Sets the value of the getSiteListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSiteListResponse2 }
     *     
     */
    public void setGetSiteListResult(GetSiteListResponse2 value) {
        this.getSiteListResult = value;
    }

}
