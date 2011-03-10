
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createOrViewReceipt_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createOrViewReceipt_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PdfTemplateID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createOrViewReceipt_Request", propOrder = {
    "siteID",
    "transactionID",
    "acctID",
    "pdfTemplateID"
})
public class CreateOrViewReceiptRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "TransactionID")
    protected long transactionID;
    @XmlElement(name = "AcctID")
    protected long acctID;
    @XmlElement(name = "PdfTemplateID")
    protected long pdfTemplateID;

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
     * Gets the value of the transactionID property.
     * 
     */
    public long getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     */
    public void setTransactionID(long value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the acctID property.
     * 
     */
    public long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     * 
     */
    public void setAcctID(long value) {
        this.acctID = value;
    }

    /**
     * Gets the value of the pdfTemplateID property.
     * 
     */
    public long getPdfTemplateID() {
        return pdfTemplateID;
    }

    /**
     * Sets the value of the pdfTemplateID property.
     * 
     */
    public void setPdfTemplateID(long value) {
        this.pdfTemplateID = value;
    }

}
