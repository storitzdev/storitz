
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefundData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefundData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TranID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RefundType" type="{http://www.centershift.com/STORE40/}RefundTypes"/>
 *         &lt;element name="RefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="IsDenied" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DenialReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsRentalTerminated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ApplyRefundRentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefundData", propOrder = {
    "tranID",
    "refundType",
    "refundAmount",
    "isDenied",
    "denialReason",
    "isRentalTerminated",
    "applyRefundRentalID"
})
public class RefundData {

    @XmlElement(name = "TranID")
    protected long tranID;
    @XmlElement(name = "RefundType", required = true)
    protected RefundTypes refundType;
    @XmlElement(name = "RefundAmount", required = true)
    protected BigDecimal refundAmount;
    @XmlElement(name = "IsDenied")
    protected boolean isDenied;
    @XmlElement(name = "DenialReason")
    protected String denialReason;
    @XmlElement(name = "IsRentalTerminated")
    protected boolean isRentalTerminated;
    @XmlElement(name = "ApplyRefundRentalID", required = true, type = Long.class, nillable = true)
    protected Long applyRefundRentalID;

    /**
     * Gets the value of the tranID property.
     * 
     */
    public long getTranID() {
        return tranID;
    }

    /**
     * Sets the value of the tranID property.
     * 
     */
    public void setTranID(long value) {
        this.tranID = value;
    }

    /**
     * Gets the value of the refundType property.
     * 
     * @return
     *     possible object is
     *     {@link RefundTypes }
     *     
     */
    public RefundTypes getRefundType() {
        return refundType;
    }

    /**
     * Sets the value of the refundType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundTypes }
     *     
     */
    public void setRefundType(RefundTypes value) {
        this.refundType = value;
    }

    /**
     * Gets the value of the refundAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * Sets the value of the refundAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRefundAmount(BigDecimal value) {
        this.refundAmount = value;
    }

    /**
     * Gets the value of the isDenied property.
     * 
     */
    public boolean isIsDenied() {
        return isDenied;
    }

    /**
     * Sets the value of the isDenied property.
     * 
     */
    public void setIsDenied(boolean value) {
        this.isDenied = value;
    }

    /**
     * Gets the value of the denialReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenialReason() {
        return denialReason;
    }

    /**
     * Sets the value of the denialReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenialReason(String value) {
        this.denialReason = value;
    }

    /**
     * Gets the value of the isRentalTerminated property.
     * 
     */
    public boolean isIsRentalTerminated() {
        return isRentalTerminated;
    }

    /**
     * Sets the value of the isRentalTerminated property.
     * 
     */
    public void setIsRentalTerminated(boolean value) {
        this.isRentalTerminated = value;
    }

    /**
     * Gets the value of the applyRefundRentalID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApplyRefundRentalID() {
        return applyRefundRentalID;
    }

    /**
     * Sets the value of the applyRefundRentalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApplyRefundRentalID(Long value) {
        this.applyRefundRentalID = value;
    }

}
