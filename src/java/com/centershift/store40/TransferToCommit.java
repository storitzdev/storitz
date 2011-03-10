
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransferToCommit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransferToCommit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EscrowID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TnxID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FromRentals" type="{http://www.centershift.com/STORE40/}ArrayOfRentalInfo" minOccurs="0"/>
 *         &lt;element name="ToRentals" type="{http://www.centershift.com/STORE40/}ArrayOfRentalInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransferToCommit", propOrder = {
    "personID",
    "escrowID",
    "tnxID",
    "fromRentals",
    "toRentals"
})
public class TransferToCommit {

    @XmlElement(name = "PersonID")
    protected long personID;
    @XmlElement(name = "EscrowID")
    protected long escrowID;
    @XmlElement(name = "TnxID")
    protected long tnxID;
    @XmlElement(name = "FromRentals")
    protected ArrayOfRentalInfo fromRentals;
    @XmlElement(name = "ToRentals")
    protected ArrayOfRentalInfo toRentals;

    /**
     * Gets the value of the personID property.
     * 
     */
    public long getPersonID() {
        return personID;
    }

    /**
     * Sets the value of the personID property.
     * 
     */
    public void setPersonID(long value) {
        this.personID = value;
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
     * Gets the value of the fromRentals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRentalInfo }
     *     
     */
    public ArrayOfRentalInfo getFromRentals() {
        return fromRentals;
    }

    /**
     * Sets the value of the fromRentals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRentalInfo }
     *     
     */
    public void setFromRentals(ArrayOfRentalInfo value) {
        this.fromRentals = value;
    }

    /**
     * Gets the value of the toRentals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRentalInfo }
     *     
     */
    public ArrayOfRentalInfo getToRentals() {
        return toRentals;
    }

    /**
     * Sets the value of the toRentals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRentalInfo }
     *     
     */
    public void setToRentals(ArrayOfRentalInfo value) {
        this.toRentals = value;
    }

}
