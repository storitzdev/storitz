package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getScheduledLetterList_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="getScheduledLetterList_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getScheduledLetterList_Request", propOrder = {
        "siteID",
        "acctID",
        "rentalID"
})
public class GetScheduledLetterListRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AcctID")
    protected long acctID;
    @XmlElement(name = "RentalID")
    protected long rentalID;

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
     * Gets the value of the acctID property.
     */
    public long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     */
    public void setAcctID(long value) {
        this.acctID = value;
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

}
