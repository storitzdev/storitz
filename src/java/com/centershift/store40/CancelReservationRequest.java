
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelReservation_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelReservation_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalIDs" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="QuoteIDs" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LostDemandReason" type="{http://www.centershift.com/STORE40/}Lost_Demand_Reasons"/>
 *         &lt;element name="LostDemandNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelReservation_Request", propOrder = {
    "acctID",
    "rentalIDs",
    "quoteIDs",
    "lostDemandReason",
    "lostDemandNotes"
})
public class CancelReservationRequest {

    @XmlElement(name = "AcctID")
    protected long acctID;
    @XmlElement(name = "RentalIDs", nillable = true)
    protected List<Long> rentalIDs;
    @XmlElement(name = "QuoteIDs", nillable = true)
    protected List<Long> quoteIDs;
    @XmlElement(name = "LostDemandReason", required = true)
    protected LostDemandReasons lostDemandReason;
    @XmlElement(name = "LostDemandNotes")
    protected String lostDemandNotes;

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
     * Gets the value of the rentalIDs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalIDs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalIDs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getRentalIDs() {
        if (rentalIDs == null) {
            rentalIDs = new ArrayList<Long>();
        }
        return this.rentalIDs;
    }

    /**
     * Gets the value of the quoteIDs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the quoteIDs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuoteIDs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getQuoteIDs() {
        if (quoteIDs == null) {
            quoteIDs = new ArrayList<Long>();
        }
        return this.quoteIDs;
    }

    /**
     * Gets the value of the lostDemandReason property.
     * 
     * @return
     *     possible object is
     *     {@link LostDemandReasons }
     *     
     */
    public LostDemandReasons getLostDemandReason() {
        return lostDemandReason;
    }

    /**
     * Sets the value of the lostDemandReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link LostDemandReasons }
     *     
     */
    public void setLostDemandReason(LostDemandReasons value) {
        this.lostDemandReason = value;
    }

    /**
     * Gets the value of the lostDemandNotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLostDemandNotes() {
        return lostDemandNotes;
    }

    /**
     * Sets the value of the lostDemandNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLostDemandNotes(String value) {
        this.lostDemandNotes = value;
    }

}
