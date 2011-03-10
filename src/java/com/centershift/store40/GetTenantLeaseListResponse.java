
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
 *         &lt;element name="getTenantLeaseListResult" type="{http://www.centershift.com/STORE40/}getTenantLeaseList_Response"/>
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
    "getTenantLeaseListResult"
})
@XmlRootElement(name = "getTenantLeaseListResponse")
public class GetTenantLeaseListResponse {

    @XmlElement(required = true)
    protected GetTenantLeaseListResponse2 getTenantLeaseListResult;

    /**
     * Gets the value of the getTenantLeaseListResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetTenantLeaseListResponse2 }
     *     
     */
    public GetTenantLeaseListResponse2 getGetTenantLeaseListResult() {
        return getTenantLeaseListResult;
    }

    /**
     * Sets the value of the getTenantLeaseListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTenantLeaseListResponse2 }
     *     
     */
    public void setGetTenantLeaseListResult(GetTenantLeaseListResponse2 value) {
        this.getTenantLeaseListResult = value;
    }

}
