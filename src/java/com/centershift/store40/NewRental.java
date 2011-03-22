package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NewRental complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="NewRental">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="QuoteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewRental", propOrder = {
        "unitID",
        "unitVersion",
        "rentalID",
        "rentalVersion",
        "quoteID"
})
public class NewRental {

    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "UnitVersion")
    protected int unitVersion;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "RentalVersion")
    protected int rentalVersion;
    @XmlElement(name = "QuoteID")
    protected long quoteID;

    /**
     * Gets the value of the unitID property.
     */
    public long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     */
    public void setUnitID(long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the unitVersion property.
     */
    public int getUnitVersion() {
        return unitVersion;
    }

    /**
     * Sets the value of the unitVersion property.
     */
    public void setUnitVersion(int value) {
        this.unitVersion = value;
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
     * Gets the value of the rentalVersion property.
     */
    public int getRentalVersion() {
        return rentalVersion;
    }

    /**
     * Sets the value of the rentalVersion property.
     */
    public void setRentalVersion(int value) {
        this.rentalVersion = value;
    }

    /**
     * Gets the value of the quoteID property.
     */
    public long getQuoteID() {
        return quoteID;
    }

    /**
     * Sets the value of the quoteID property.
     */
    public void setQuoteID(long value) {
        this.quoteID = value;
    }

}
