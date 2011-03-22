package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for EndRental_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="EndRental_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MoveOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PaymentData" type="{http://www.centershift.com/STORE40/}MakePayment_Request"/>
 *         &lt;element name="RefundData" type="{http://www.centershift.com/STORE40/}RefundData" minOccurs="0"/>
 *         &lt;element name="ContactData" type="{http://www.centershift.com/STORE40/}ContactInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndRental_Request", propOrder = {
        "orgID",
        "siteID",
        "accountID",
        "rentalID",
        "moveOutDate",
        "paymentData",
        "refundData",
        "contactData"
})
public class EndRentalRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AccountID")
    protected long accountID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "MoveOutDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar moveOutDate;
    @XmlElement(name = "PaymentData", required = true, nillable = true)
    protected MakePaymentRequest paymentData;
    @XmlElement(name = "RefundData")
    protected RefundData refundData;
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
     * Gets the value of the accountID property.
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     */
    public void setAccountID(long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the rentalID property.
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the moveOutDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getMoveOutDate() {
        return moveOutDate;
    }

    /**
     * Sets the value of the moveOutDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setMoveOutDate(XMLGregorianCalendar value) {
        this.moveOutDate = value;
    }

    /**
     * Gets the value of the paymentData property.
     *
     * @return possible object is
     *         {@link MakePaymentRequest }
     */
    public MakePaymentRequest getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     *
     * @param value allowed object is
     *              {@link MakePaymentRequest }
     */
    public void setPaymentData(MakePaymentRequest value) {
        this.paymentData = value;
    }

    /**
     * Gets the value of the refundData property.
     *
     * @return possible object is
     *         {@link RefundData }
     */
    public RefundData getRefundData() {
        return refundData;
    }

    /**
     * Sets the value of the refundData property.
     *
     * @param value allowed object is
     *              {@link RefundData }
     */
    public void setRefundData(RefundData value) {
        this.refundData = value;
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
