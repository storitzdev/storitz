package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for GetTotalDue_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetTotalDue_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Cycles" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IsRetail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MoveOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IsRetailAndRental" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTotalDue_Request", propOrder = {
        "rentalID",
        "acctID",
        "siteID",
        "cycles",
        "isRetail",
        "moveOutDate",
        "isRetailAndRental"
})
public class GetTotalDueRequest {

    @XmlElement(name = "RentalID", type = Long.class)
    protected List<Long> rentalID;
    @XmlElement(name = "AcctID", required = true, type = Long.class, nillable = true)
    protected Long acctID;
    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "Cycles", type = Integer.class)
    protected List<Integer> cycles;
    @XmlElement(name = "IsRetail", required = true, type = Boolean.class, nillable = true)
    protected Boolean isRetail;
    @XmlElement(name = "MoveOutDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar moveOutDate;
    @XmlElement(name = "IsRetailAndRental", required = true, type = Boolean.class, nillable = true)
    protected Boolean isRetailAndRental;

    /**
     * Gets the value of the rentalID property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalID property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalID().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     */
    public List<Long> getRentalID() {
        if (rentalID == null) {
            rentalID = new ArrayList<Long>();
        }
        return this.rentalID;
    }

    /**
     * Gets the value of the acctID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setAcctID(Long value) {
        this.acctID = value;
    }

    /**
     * Gets the value of the siteID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSiteID(Long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the cycles property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cycles property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCycles().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     */
    public List<Integer> getCycles() {
        if (cycles == null) {
            cycles = new ArrayList<Integer>();
        }
        return this.cycles;
    }

    /**
     * Gets the value of the isRetail property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isIsRetail() {
        return isRetail;
    }

    /**
     * Sets the value of the isRetail property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsRetail(Boolean value) {
        this.isRetail = value;
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
     * Gets the value of the isRetailAndRental property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isIsRetailAndRental() {
        return isRetailAndRental;
    }

    /**
     * Sets the value of the isRetailAndRental property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsRetailAndRental(Boolean value) {
        this.isRetailAndRental = value;
    }

}
