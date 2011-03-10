
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
 *         &lt;element name="GetUnitFeaturesResult" type="{http://www.centershift.com/STORE40/}GetUnitFeatures_Response"/>
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
    "getUnitFeaturesResult"
})
@XmlRootElement(name = "GetUnitFeaturesResponse")
public class GetUnitFeaturesResponse {

    @XmlElement(name = "GetUnitFeaturesResult", required = true)
    protected GetUnitFeaturesResponse2 getUnitFeaturesResult;

    /**
     * Gets the value of the getUnitFeaturesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetUnitFeaturesResponse2 }
     *     
     */
    public GetUnitFeaturesResponse2 getGetUnitFeaturesResult() {
        return getUnitFeaturesResult;
    }

    /**
     * Sets the value of the getUnitFeaturesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUnitFeaturesResponse2 }
     *     
     */
    public void setGetUnitFeaturesResult(GetUnitFeaturesResponse2 value) {
        this.getUnitFeaturesResult = value;
    }

}
