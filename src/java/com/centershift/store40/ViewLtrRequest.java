
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ViewLtr_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ViewLtr_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LtrNum" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewLtr_Request", propOrder = {
    "siteID",
    "ltrNum",
    "rentalId",
    "acctId"
})
public class ViewLtrRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "LtrNum")
    protected long ltrNum;
    @XmlElement(name = "RentalId")
    protected long rentalId;
    @XmlElement(name = "AcctId")
    protected long acctId;

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
     * Gets the value of the ltrNum property.
     * 
     */
    public long getLtrNum() {
        return ltrNum;
    }

    /**
     * Sets the value of the ltrNum property.
     * 
     */
    public void setLtrNum(long value) {
        this.ltrNum = value;
    }

    /**
     * Gets the value of the rentalId property.
     * 
     */
    public long getRentalId() {
        return rentalId;
    }

    /**
     * Sets the value of the rentalId property.
     * 
     */
    public void setRentalId(long value) {
        this.rentalId = value;
    }

    /**
     * Gets the value of the acctId property.
     * 
     */
    public long getAcctId() {
        return acctId;
    }

    /**
     * Sets the value of the acctId property.
     * 
     */
    public void setAcctId(long value) {
        this.acctId = value;
    }

}
