package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for MakePayment_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MakePayment_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalIDs" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Cycles" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalAmtDue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalAmtPaid" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CreditCardInfo" type="{http://www.centershift.com/STORE40/}CreditCardData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CheckInfo" type="{http://www.centershift.com/STORE40/}CheckData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CashInfo" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CashCreditID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IsRetail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MoveOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IsRetailAndRental" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CashCreditAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PayAssessData" type="{http://www.centershift.com/STORE40/}AssessmentData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakePayment_Request", propOrder = {
        "siteID",
        "acctID",
        "rentalIDs",
        "cycles",
        "totalAmtDue",
        "totalAmtPaid",
        "creditCardInfo",
        "checkInfo",
        "cashInfo",
        "cashCreditID",
        "isRetail",
        "moveOutDate",
        "isRetailAndRental",
        "cashCreditAmount",
        "payAssessData"
})
public class MakePaymentRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AcctID")
    protected long acctID;
    @XmlElement(name = "RentalIDs", type = Long.class)
    protected List<Long> rentalIDs;
    @XmlElement(name = "Cycles", type = Integer.class)
    protected List<Integer> cycles;
    @XmlElement(name = "TotalAmtDue", required = true)
    protected BigDecimal totalAmtDue;
    @XmlElement(name = "TotalAmtPaid", required = true)
    protected BigDecimal totalAmtPaid;
    @XmlElement(name = "CreditCardInfo")
    protected List<CreditCardData> creditCardInfo;
    @XmlElement(name = "CheckInfo")
    protected List<CheckData> checkInfo;
    @XmlElement(name = "CashInfo", required = true)
    protected BigDecimal cashInfo;
    @XmlElement(name = "CashCreditID")
    protected long cashCreditID;
    @XmlElement(name = "IsRetail", required = true, type = Boolean.class, nillable = true)
    protected Boolean isRetail;
    @XmlElement(name = "MoveOutDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar moveOutDate;
    @XmlElement(name = "IsRetailAndRental", required = true, type = Boolean.class, nillable = true)
    protected Boolean isRetailAndRental;
    @XmlElement(name = "CashCreditAmount", required = true, nillable = true)
    protected BigDecimal cashCreditAmount;
    @XmlElement(name = "PayAssessData")
    protected List<AssessmentData> payAssessData;

    /**
     * Gets the value of the siteID property.
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the acctID property.
     */
    public long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     */
    public void setAcctID(long value) {
        this.acctID = value;
    }

    /**
     * Gets the value of the rentalIDs property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalIDs property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalIDs().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     */
    public List<Long> getRentalIDs() {
        if (rentalIDs == null) {
            rentalIDs = new ArrayList<Long>();
        }
        return this.rentalIDs;
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
     * Gets the value of the totalAmtDue property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTotalAmtDue() {
        return totalAmtDue;
    }

    /**
     * Sets the value of the totalAmtDue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalAmtDue(BigDecimal value) {
        this.totalAmtDue = value;
    }

    /**
     * Gets the value of the totalAmtPaid property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTotalAmtPaid() {
        return totalAmtPaid;
    }

    /**
     * Sets the value of the totalAmtPaid property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalAmtPaid(BigDecimal value) {
        this.totalAmtPaid = value;
    }

    /**
     * Gets the value of the creditCardInfo property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditCardInfo property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditCardInfo().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditCardData }
     */
    public List<CreditCardData> getCreditCardInfo() {
        if (creditCardInfo == null) {
            creditCardInfo = new ArrayList<CreditCardData>();
        }
        return this.creditCardInfo;
    }

    /**
     * Gets the value of the checkInfo property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkInfo property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckInfo().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckData }
     */
    public List<CheckData> getCheckInfo() {
        if (checkInfo == null) {
            checkInfo = new ArrayList<CheckData>();
        }
        return this.checkInfo;
    }

    /**
     * Gets the value of the cashInfo property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getCashInfo() {
        return cashInfo;
    }

    /**
     * Sets the value of the cashInfo property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setCashInfo(BigDecimal value) {
        this.cashInfo = value;
    }

    /**
     * Gets the value of the cashCreditID property.
     */
    public long getCashCreditID() {
        return cashCreditID;
    }

    /**
     * Sets the value of the cashCreditID property.
     */
    public void setCashCreditID(long value) {
        this.cashCreditID = value;
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

    /**
     * Gets the value of the cashCreditAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getCashCreditAmount() {
        return cashCreditAmount;
    }

    /**
     * Sets the value of the cashCreditAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setCashCreditAmount(BigDecimal value) {
        this.cashCreditAmount = value;
    }

    /**
     * Gets the value of the payAssessData property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payAssessData property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayAssessData().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link AssessmentData }
     */
    public List<AssessmentData> getPayAssessData() {
        if (payAssessData == null) {
            payAssessData = new ArrayList<AssessmentData>();
        }
        return this.payAssessData;
    }

}
