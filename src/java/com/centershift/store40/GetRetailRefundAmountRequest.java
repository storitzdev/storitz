package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetRetailRefundAmount_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetRetailRefundAmount_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ReturnRetailData" type="{http://www.centershift.com/STORE40/}ArrayOfReturnRetailItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRetailRefundAmount_Request", propOrder = {
        "siteID",
        "transactionID",
        "returnRetailData"
})
public class GetRetailRefundAmountRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "TransactionID")
    protected long transactionID;
    @XmlElement(name = "ReturnRetailData")
    protected ArrayOfReturnRetailItem returnRetailData;

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
     */
    public long getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     */
    public void setTransactionID(long value) {
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

}
