
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
 *         &lt;element name="getLeaseTemplateInfoResult" type="{http://www.centershift.com/STORE40/}getLeaseTemplateInfo_Response"/>
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
    "getLeaseTemplateInfoResult"
})
@XmlRootElement(name = "getLeaseTemplateInfoResponse")
public class GetLeaseTemplateInfoResponse {

    @XmlElement(required = true)
    protected GetLeaseTemplateInfoResponse2 getLeaseTemplateInfoResult;

    /**
     * Gets the value of the getLeaseTemplateInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetLeaseTemplateInfoResponse2 }
     *     
     */
    public GetLeaseTemplateInfoResponse2 getGetLeaseTemplateInfoResult() {
        return getLeaseTemplateInfoResult;
    }

    /**
     * Sets the value of the getLeaseTemplateInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetLeaseTemplateInfoResponse2 }
     *     
     */
    public void setGetLeaseTemplateInfoResult(GetLeaseTemplateInfoResponse2 value) {
        this.getLeaseTemplateInfoResult = value;
    }

}
