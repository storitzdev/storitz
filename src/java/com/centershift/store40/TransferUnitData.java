package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransferUnitData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TransferUnitData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalData" type="{http://www.centershift.com/STORE40/}ArrayOfTransOldRentalData" minOccurs="0"/>
 *         &lt;element name="NewUnitData" type="{http://www.centershift.com/STORE40/}ArrayOfTransNewRentalData" minOccurs="0"/>
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransferUnitData", propOrder = {
        "rentalData",
        "newUnitData",
        "transactionID"
})
public class TransferUnitData {

    @XmlElement(name = "RentalData")
    protected ArrayOfTransOldRentalData rentalData;
    @XmlElement(name = "NewUnitData")
    protected ArrayOfTransNewRentalData newUnitData;
    @XmlElement(name = "TransactionID")
    protected long transactionID;

    /**
     * Gets the value of the rentalData property.
     *
     * @return possible object is
     *         {@link ArrayOfTransOldRentalData }
     */
    public ArrayOfTransOldRentalData getRentalData() {
        return rentalData;
    }

    /**
     * Sets the value of the rentalData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfTransOldRentalData }
     */
    public void setRentalData(ArrayOfTransOldRentalData value) {
        this.rentalData = value;
    }

    /**
     * Gets the value of the newUnitData property.
     *
     * @return possible object is
     *         {@link ArrayOfTransNewRentalData }
     */
    public ArrayOfTransNewRentalData getNewUnitData() {
        return newUnitData;
    }

    /**
     * Sets the value of the newUnitData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfTransNewRentalData }
     */
    public void setNewUnitData(ArrayOfTransNewRentalData value) {
        this.newUnitData = value;
    }

    /**
     * Gets the value of the transactionID property.
     */
    public long getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     */
    public void setTransactionID(long value) {
        this.transactionID = value;
    }

}
