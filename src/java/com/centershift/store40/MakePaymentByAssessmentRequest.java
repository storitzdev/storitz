package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for MakePaymentByAssessment_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MakePaymentByAssessment_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AssessmentIDs" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalAmtDue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalAmtPaid" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CreditCardInfo" type="{http://www.centershift.com/STORE40/}CreditCardData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CheckInfo" type="{http://www.centershift.com/STORE40/}CheckData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CashInfo" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CashCreditID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IsRetail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsRetailAndRental" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakePaymentByAssessment_Request", propOrder = {
        "siteID",
        "acctID",
        "assessmentIDs",
        "totalAmtDue",
        "totalAmtPaid",
        "creditCardInfo",
        "checkInfo",
        "cashInfo",
        "cashCreditID",
        "isRetail",
        "isRetailAndRental"
})
public class MakePaymentByAssessmentRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AcctID")
    protected long acctID;
    @XmlElement(name = "AssessmentIDs", type = Long.class)
    protected List<Long> assessmentIDs;
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
    @XmlElement(name = "IsRetailAndRental", required = true, type = Boolean.class, nillable = true)
    protected Boolean isRetailAndRental;

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
     * Gets the value of the assessmentIDs property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assessmentIDs property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssessmentIDs().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     */
    public List<Long> getAssessmentIDs() {
        if (assessmentIDs == null) {
            assessmentIDs = new ArrayList<Long>();
        }
        return this.assessmentIDs;
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

}
