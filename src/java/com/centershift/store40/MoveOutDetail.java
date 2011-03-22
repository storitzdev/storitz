package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for MoveOutDetail complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MoveOutDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssessmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalCharge" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PaidAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UnappliedAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DueAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MoveOutDetail", propOrder = {
        "assessmentDate",
        "description",
        "originalCharge",
        "paidAmount",
        "unappliedAmount",
        "dueAmount"
})
public class MoveOutDetail {

    @XmlElement(name = "AssessmentDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assessmentDate;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "OriginalCharge", required = true)
    protected BigDecimal originalCharge;
    @XmlElement(name = "PaidAmount", required = true)
    protected BigDecimal paidAmount;
    @XmlElement(name = "UnappliedAmount", required = true)
    protected BigDecimal unappliedAmount;
    @XmlElement(name = "DueAmount", required = true)
    protected BigDecimal dueAmount;

    /**
     * Gets the value of the assessmentDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getAssessmentDate() {
        return assessmentDate;
    }

    /**
     * Sets the value of the assessmentDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setAssessmentDate(XMLGregorianCalendar value) {
        this.assessmentDate = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the originalCharge property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getOriginalCharge() {
        return originalCharge;
    }

    /**
     * Sets the value of the originalCharge property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setOriginalCharge(BigDecimal value) {
        this.originalCharge = value;
    }

    /**
     * Gets the value of the paidAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    /**
     * Sets the value of the paidAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPaidAmount(BigDecimal value) {
        this.paidAmount = value;
    }

    /**
     * Gets the value of the unappliedAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getUnappliedAmount() {
        return unappliedAmount;
    }

    /**
     * Sets the value of the unappliedAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setUnappliedAmount(BigDecimal value) {
        this.unappliedAmount = value;
    }

    /**
     * Gets the value of the dueAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDueAmount() {
        return dueAmount;
    }

    /**
     * Sets the value of the dueAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDueAmount(BigDecimal value) {
        this.dueAmount = value;
    }

}
