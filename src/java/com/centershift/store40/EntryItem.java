package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for EntryItem complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="EntryItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Debit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Credit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntryItem", propOrder = {
        "siteID",
        "account",
        "notes",
        "batchID",
        "debit",
        "credit",
        "status"
})
public class EntryItem {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "Account")
    protected String account;
    @XmlElement(name = "Notes")
    protected String notes;
    @XmlElement(name = "BatchID")
    protected long batchID;
    @XmlElement(name = "Debit", required = true)
    protected BigDecimal debit;
    @XmlElement(name = "Credit", required = true)
    protected BigDecimal credit;
    @XmlElement(name = "Status")
    protected String status;

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
     * Gets the value of the account property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the notes property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the batchID property.
     */
    public long getBatchID() {
        return batchID;
    }

    /**
     * Sets the value of the batchID property.
     */
    public void setBatchID(long value) {
        this.batchID = value;
    }

    /**
     * Gets the value of the debit property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDebit() {
        return debit;
    }

    /**
     * Sets the value of the debit property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDebit(BigDecimal value) {
        this.debit = value;
    }

    /**
     * Gets the value of the credit property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setCredit(BigDecimal value) {
        this.credit = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
