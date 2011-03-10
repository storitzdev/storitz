
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransferReturn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransferReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EscrowID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TnxID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalDetails" type="{http://www.centershift.com/STORE40/}ArrayOfNewRental" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransferReturn", propOrder = {
    "escrowID",
    "tnxID",
    "rentalDetails"
})
public class TransferReturn {

    @XmlElement(name = "EscrowID")
    protected long escrowID;
    @XmlElement(name = "TnxID")
    protected long tnxID;
    @XmlElement(name = "RentalDetails")
    protected ArrayOfNewRental rentalDetails;

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
     * Gets the value of the tnxID property.
     * 
     */
    public long getTnxID() {
        return tnxID;
    }

    /**
     * Sets the value of the tnxID property.
     * 
     */
    public void setTnxID(long value) {
        this.tnxID = value;
    }

    /**
     * Gets the value of the rentalDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfNewRental }
     *     
     */
    public ArrayOfNewRental getRentalDetails() {
        return rentalDetails;
    }

    /**
     * Sets the value of the rentalDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfNewRental }
     *     
     */
    public void setRentalDetails(ArrayOfNewRental value) {
        this.rentalDetails = value;
    }

}
