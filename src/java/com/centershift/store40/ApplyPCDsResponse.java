
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
 *         &lt;element name="ApplyPCDsResult" type="{http://www.centershift.com/STORE40/}ApplyPCDs_Response"/>
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
    "applyPCDsResult"
})
@XmlRootElement(name = "ApplyPCDsResponse")
public class ApplyPCDsResponse {

    @XmlElement(name = "ApplyPCDsResult", required = true)
    protected ApplyPCDsResponse2 applyPCDsResult;

    /**
     * Gets the value of the applyPCDsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ApplyPCDsResponse2 }
     *     
     */
    public ApplyPCDsResponse2 getApplyPCDsResult() {
        return applyPCDsResult;
    }

    /**
     * Sets the value of the applyPCDsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplyPCDsResponse2 }
     *     
     */
    public void setApplyPCDsResult(ApplyPCDsResponse2 value) {
        this.applyPCDsResult = value;
    }

}
