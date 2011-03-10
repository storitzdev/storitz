
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetRefundTypes_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRefundTypes_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RefundData" type="{http://www.centershift.com/STORE40/}ArrayOfGetRefundTypes_RequestData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRefundTypes_Request", propOrder = {
    "siteID",
    "refundData"
})
public class GetRefundTypesRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "RefundData")
    protected ArrayOfGetRefundTypesRequestData refundData;

    /**
     * Gets the value of the siteID property.
     * 
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     * 
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the refundData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGetRefundTypesRequestData }
     *     
     */
    public ArrayOfGetRefundTypesRequestData getRefundData() {
        return refundData;
    }

    /**
     * Sets the value of the refundData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGetRefundTypesRequestData }
     *     
     */
    public void setRefundData(ArrayOfGetRefundTypesRequestData value) {
        this.refundData = value;
    }

}
