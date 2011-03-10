
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessableRentals complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccessableRentals">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccessableRentals", propOrder = {
    "rentalID",
    "unitID",
    "unitNumber"
})
public class AccessableRentals {

    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "UnitNumber")
    protected String unitNumber;

    /**
     * Gets the value of the rentalID property.
     * 
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     * 
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the unitID property.
     * 
     */
    public long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     * 
     */
    public void setUnitID(long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the unitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * Sets the value of the unitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitNumber(String value) {
        this.unitNumber = value;
    }

}
