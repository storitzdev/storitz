package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddDeposit_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AddDeposit_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DepositData" type="{http://www.centershift.com/STORE40/}ORG_SECURITY_DEPOSITS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddDeposit_Request", propOrder = {
        "rentalID",
        "depositData"
})
public class AddDepositRequest {

    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "DepositData")
    protected ORGSECURITYDEPOSITS depositData;

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
     * Gets the value of the depositData property.
     *
     * @return possible object is
     *         {@link ORGSECURITYDEPOSITS }
     */
    public ORGSECURITYDEPOSITS getDepositData() {
        return depositData;
    }

    /**
     * Sets the value of the depositData property.
     *
     * @param value allowed object is
     *              {@link ORGSECURITYDEPOSITS }
     */
    public void setDepositData(ORGSECURITYDEPOSITS value) {
        this.depositData = value;
    }

}
