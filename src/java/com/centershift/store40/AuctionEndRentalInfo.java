
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionEndRentalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuctionEndRentalInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Status" type="{http://www.centershift.com/STORE40/}AuctionObjsStatusValues"/>
 *         &lt;element name="SoldAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Tax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TaxExempt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TaxExemptInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuyerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuyerAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuyerPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentData" type="{http://www.centershift.com/STORE40/}MakePayment_Request"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionEndRentalInfo", propOrder = {
    "acctID",
    "rentalID",
    "status",
    "soldAmount",
    "tax",
    "taxExempt",
    "taxExemptInfo",
    "buyerName",
    "buyerAddress",
    "buyerPhone",
    "notes",
    "paymentData"
})
public class AuctionEndRentalInfo {

    @XmlElement(name = "AcctID")
    protected long acctID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "Status", required = true)
    protected AuctionObjsStatusValues status;
    @XmlElement(name = "SoldAmount", required = true)
    protected BigDecimal soldAmount;
    @XmlElement(name = "Tax", required = true)
    protected BigDecimal tax;
    @XmlElement(name = "TaxExempt")
    protected boolean taxExempt;
    @XmlElement(name = "TaxExemptInfo")
    protected String taxExemptInfo;
    @XmlElement(name = "BuyerName")
    protected String buyerName;
    @XmlElement(name = "BuyerAddress")
    protected String buyerAddress;
    @XmlElement(name = "BuyerPhone")
    protected String buyerPhone;
    @XmlElement(name = "Notes")
    protected String notes;
    @XmlElement(name = "PaymentData", required = true)
    protected MakePaymentRequest paymentData;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionObjsStatusValues }
     *     
     */
    public AuctionObjsStatusValues getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionObjsStatusValues }
     *     
     */
    public void setStatus(AuctionObjsStatusValues value) {
        this.status = value;
    }

    /**
     * Gets the value of the soldAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSoldAmount() {
        return soldAmount;
    }

    /**
     * Sets the value of the soldAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSoldAmount(BigDecimal value) {
        this.soldAmount = value;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTax(BigDecimal value) {
        this.tax = value;
    }

    /**
     * Gets the value of the taxExempt property.
     * 
     */
    public boolean isTaxExempt() {
        return taxExempt;
    }

    /**
     * Sets the value of the taxExempt property.
     * 
     */
    public void setTaxExempt(boolean value) {
        this.taxExempt = value;
    }

    /**
     * Gets the value of the taxExemptInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxExemptInfo() {
        return taxExemptInfo;
    }

    /**
     * Sets the value of the taxExemptInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxExemptInfo(String value) {
        this.taxExemptInfo = value;
    }

    /**
     * Gets the value of the buyerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * Sets the value of the buyerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerName(String value) {
        this.buyerName = value;
    }

    /**
     * Gets the value of the buyerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerAddress() {
        return buyerAddress;
    }

    /**
     * Sets the value of the buyerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerAddress(String value) {
        this.buyerAddress = value;
    }

    /**
     * Gets the value of the buyerPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerPhone() {
        return buyerPhone;
    }

    /**
     * Sets the value of the buyerPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerPhone(String value) {
        this.buyerPhone = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the paymentData property.
     * 
     * @return
     *     possible object is
     *     {@link MakePaymentRequest }
     *     
     */
    public MakePaymentRequest getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MakePaymentRequest }
     *     
     */
    public void setPaymentData(MakePaymentRequest value) {
        this.paymentData = value;
    }

}
