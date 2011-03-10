
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
 *         &lt;element name="getTenantLetterListResult" type="{http://www.centershift.com/STORE40/}getTenantLetterList_Response"/>
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
    "getTenantLetterListResult"
})
@XmlRootElement(name = "getTenantLetterListResponse")
public class GetTenantLetterListResponse {

    @XmlElement(required = true)
    protected GetTenantLetterListResponse2 getTenantLetterListResult;

    /**
     * Gets the value of the getTenantLetterListResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetTenantLetterListResponse2 }
     *     
     */
    public GetTenantLetterListResponse2 getGetTenantLetterListResult() {
        return getTenantLetterListResult;
    }

    /**
     * Sets the value of the getTenantLetterListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTenantLetterListResponse2 }
     *     
     */
    public void setGetTenantLetterListResult(GetTenantLetterListResponse2 value) {
        this.getTenantLetterListResult = value;
    }

}
