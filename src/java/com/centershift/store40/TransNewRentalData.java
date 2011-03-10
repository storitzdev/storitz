
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransNewRentalData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransNewRentalData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="QuoteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EscrowID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UnitAssessments" type="{http://www.centershift.com/STORE40/}ArrayOfTransUnitAssessments" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransNewRentalData", propOrder = {
    "rentalID",
    "rentalVersion",
    "unitID",
    "unitVersion",
    "quoteID",
    "escrowID",
    "unitTotal",
    "unitAssessments"
})
public class TransNewRentalData {

    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "RentalVersion")
    protected int rentalVersion;
    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "UnitVersion")
    protected int unitVersion;
    @XmlElement(name = "QuoteID")
    protected long quoteID;
    @XmlElement(name = "EscrowID")
    protected long escrowID;
    @XmlElement(name = "UnitTotal", required = true)
    protected BigDecimal unitTotal;
    @XmlElement(name = "UnitAssessments")
    protected ArrayOfTransUnitAssessments unitAssessments;

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
     * Gets the value of the rentalVersion property.
     * 
     */
    public int getRentalVersion() {
        return rentalVersion;
    }

    /**
     * Sets the value of the rentalVersion property.
     * 
     */
    public void setRentalVersion(int value) {
        this.rentalVersion = value;
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
     * Gets the value of the unitVersion property.
     * 
     */
    public int getUnitVersion() {
        return unitVersion;
    }

    /**
     * Sets the value of the unitVersion property.
     * 
     */
    public void setUnitVersion(int value) {
        this.unitVersion = value;
    }

    /**
     * Gets the value of the quoteID property.
     * 
     */
    public long getQuoteID() {
        return quoteID;
    }

    /**
     * Sets the value of the quoteID property.
     * 
     */
    public void setQuoteID(long value) {
        this.quoteID = value;
    }

    /**
     * Gets the value of the escrowID property.
     * 
     */
    public long getEscrowID() {
        return escrowID;
    }

    /**
     * Sets the value of the escrowID property.
     * 
     */
    public void setEscrowID(long value) {
        this.escrowID = value;
    }

    /**
     * Gets the value of the unitTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitTotal() {
        return unitTotal;
    }

    /**
     * Sets the value of the unitTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitTotal(BigDecimal value) {
        this.unitTotal = value;
    }

    /**
     * Gets the value of the unitAssessments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransUnitAssessments }
     *     
     */
    public ArrayOfTransUnitAssessments getUnitAssessments() {
        return unitAssessments;
    }

    /**
     * Sets the value of the unitAssessments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransUnitAssessments }
     *     
     */
    public void setUnitAssessments(ArrayOfTransUnitAssessments value) {
        this.unitAssessments = value;
    }

}
