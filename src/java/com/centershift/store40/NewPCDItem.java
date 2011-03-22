package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for NewPCDItem complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="NewPCDItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PCD_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EffDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DiscountAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ReasonCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ReasonDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RevenueCategory" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsPromoDiscCredit" type="{http://www.centershift.com/STORE40/}PCDType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewPCDItem", propOrder = {
        "pcdid",
        "effDate",
        "endDate",
        "discountAmount",
        "reasonCode",
        "reasonDescription",
        "revenueCategory",
        "isPromoDiscCredit"
})
public class NewPCDItem {

    @XmlElement(name = "PCD_ID")
    protected long pcdid;
    @XmlElement(name = "EffDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effDate;
    @XmlElement(name = "EndDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "DiscountAmount", required = true)
    protected BigDecimal discountAmount;
    @XmlElement(name = "ReasonCode", required = true, type = Integer.class, nillable = true)
    protected Integer reasonCode;
    @XmlElement(name = "ReasonDescription")
    protected String reasonDescription;
    @XmlElement(name = "RevenueCategory")
    protected int revenueCategory;
    @XmlElement(name = "IsPromoDiscCredit", required = true)
    protected PCDType isPromoDiscCredit;

    /**
     * Gets the value of the pcdid property.
     */
    public long getPCDID() {
        return pcdid;
    }

    /**
     * Sets the value of the pcdid property.
     */
    public void setPCDID(long value) {
        this.pcdid = value;
    }

    /**
     * Gets the value of the effDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEffDate() {
        return effDate;
    }

    /**
     * Sets the value of the effDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEffDate(XMLGregorianCalendar value) {
        this.effDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the discountAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Sets the value of the discountAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDiscountAmount(BigDecimal value) {
        this.discountAmount = value;
    }

    /**
     * Gets the value of the reasonCode property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setReasonCode(Integer value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the reasonDescription property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getReasonDescription() {
        return reasonDescription;
    }

    /**
     * Sets the value of the reasonDescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReasonDescription(String value) {
        this.reasonDescription = value;
    }

    /**
     * Gets the value of the revenueCategory property.
     */
    public int getRevenueCategory() {
        return revenueCategory;
    }

    /**
     * Sets the value of the revenueCategory property.
     */
    public void setRevenueCategory(int value) {
        this.revenueCategory = value;
    }

    /**
     * Gets the value of the isPromoDiscCredit property.
     *
     * @return possible object is
     *         {@link PCDType }
     */
    public PCDType getIsPromoDiscCredit() {
        return isPromoDiscCredit;
    }

    /**
     * Sets the value of the isPromoDiscCredit property.
     *
     * @param value allowed object is
     *              {@link PCDType }
     */
    public void setIsPromoDiscCredit(PCDType value) {
        this.isPromoDiscCredit = value;
    }

}
