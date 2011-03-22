package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionRentalItemData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AuctionRentalItemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitContents" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionRentalItemData", propOrder = {
        "rentalID",
        "unitContents",
        "notes"
})
public class AuctionRentalItemData {

    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "UnitContents")
    protected String unitContents;
    @XmlElement(name = "Notes")
    protected String notes;

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
     * Gets the value of the unitContents property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUnitContents() {
        return unitContents;
    }

    /**
     * Sets the value of the unitContents property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUnitContents(String value) {
        this.unitContents = value;
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

}
