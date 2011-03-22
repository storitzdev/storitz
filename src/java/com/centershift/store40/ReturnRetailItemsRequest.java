package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnRetailItems_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ReturnRetailItems_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ReturnRetailData" type="{http://www.centershift.com/STORE40/}ArrayOfReturnRetailItem" minOccurs="0"/>
 *         &lt;element name="RefundType" type="{http://www.centershift.com/STORE40/}RefundTypes"/>
 *         &lt;element name="ContactData" type="{http://www.centershift.com/STORE40/}ContactInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnRetailItems_Request", propOrder = {
        "orgID",
        "siteID",
        "transactionID",
        "returnRetailData",
        "refundType",
        "contactData"
})
public class ReturnRetailItemsRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "TransactionID", required = true, type = Long.class, nillable = true)
    protected Long transactionID;
    @XmlElement(name = "ReturnRetailData")
    protected ArrayOfReturnRetailItem returnRetailData;
    @XmlElement(name = "RefundType", required = true)
    protected RefundTypes refundType;
    @XmlElement(name = "ContactData")
    protected ContactInfo contactData;

    /**
     * Gets the value of the orgID property.
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the siteID property.
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the transactionID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setTransactionID(Long value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the returnRetailData property.
     *
     * @return possible object is
     *         {@link ArrayOfReturnRetailItem }
     */
    public ArrayOfReturnRetailItem getReturnRetailData() {
        return returnRetailData;
    }

    /**
     * Sets the value of the returnRetailData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfReturnRetailItem }
     */
    public void setReturnRetailData(ArrayOfReturnRetailItem value) {
        this.returnRetailData = value;
    }

    /**
     * Gets the value of the refundType property.
     *
     * @return possible object is
     *         {@link RefundTypes }
     */
    public RefundTypes getRefundType() {
        return refundType;
    }

    /**
     * Sets the value of the refundType property.
     *
     * @param value allowed object is
     *              {@link RefundTypes }
     */
    public void setRefundType(RefundTypes value) {
        this.refundType = value;
    }

    /**
     * Gets the value of the contactData property.
     *
     * @return possible object is
     *         {@link ContactInfo }
     */
    public ContactInfo getContactData() {
        return contactData;
    }

    /**
     * Sets the value of the contactData property.
     *
     * @param value allowed object is
     *              {@link ContactInfo }
     */
    public void setContactData(ContactInfo value) {
        this.contactData = value;
    }

}
