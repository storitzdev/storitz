
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessRefund_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessRefund_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RefundInfo" type="{http://www.centershift.com/STORE40/}RefundData" minOccurs="0"/>
 *         &lt;element name="ContactData" type="{http://www.centershift.com/STORE40/}ContactInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessRefund_Request", propOrder = {
    "orgID",
    "siteID",
    "refundInfo",
    "contactData"
})
public class ProcessRefundRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "RefundInfo")
    protected RefundData refundInfo;
    @XmlElement(name = "ContactData")
    protected ContactInfo contactData;

    /**
     * Gets the value of the orgID property.
     * 
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

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
     * Gets the value of the refundInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RefundData }
     *     
     */
    public RefundData getRefundInfo() {
        return refundInfo;
    }

    /**
     * Sets the value of the refundInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundData }
     *     
     */
    public void setRefundInfo(RefundData value) {
        this.refundInfo = value;
    }

    /**
     * Gets the value of the contactData property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *     
     */
    public ContactInfo getContactData() {
        return contactData;
    }

    /**
     * Sets the value of the contactData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *     
     */
    public void setContactData(ContactInfo value) {
        this.contactData = value;
    }

}
