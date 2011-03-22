package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TransactionData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TransactionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VacateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Units" type="{http://www.centershift.com/STORE40/}Unit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalRefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RefundType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SitePerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegionalApprovedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TodaysDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionData", propOrder = {
        "vacateDate",
        "transactionNumber",
        "units",
        "totalRefundAmount",
        "refundType",
        "sitePerson",
        "regionalApprovedBy",
        "todaysDate"
})
public class TransactionData {

    @XmlElement(name = "VacateDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar vacateDate;
    @XmlElement(name = "TransactionNumber")
    protected long transactionNumber;
    @XmlElement(name = "Units")
    protected List<Unit> units;
    @XmlElement(name = "TotalRefundAmount", required = true)
    protected BigDecimal totalRefundAmount;
    @XmlElement(name = "RefundType")
    protected String refundType;
    @XmlElement(name = "SitePerson")
    protected String sitePerson;
    @XmlElement(name = "RegionalApprovedBy")
    protected String regionalApprovedBy;
    @XmlElement(name = "TodaysDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar todaysDate;

    /**
     * Gets the value of the vacateDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getVacateDate() {
        return vacateDate;
    }

    /**
     * Sets the value of the vacateDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setVacateDate(XMLGregorianCalendar value) {
        this.vacateDate = value;
    }

    /**
     * Gets the value of the transactionNumber property.
     */
    public long getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * Sets the value of the transactionNumber property.
     */
    public void setTransactionNumber(long value) {
        this.transactionNumber = value;
    }

    /**
     * Gets the value of the units property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the units property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnits().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Unit }
     */
    public List<Unit> getUnits() {
        if (units == null) {
            units = new ArrayList<Unit>();
        }
        return this.units;
    }

    /**
     * Gets the value of the totalRefundAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTotalRefundAmount() {
        return totalRefundAmount;
    }

    /**
     * Sets the value of the totalRefundAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalRefundAmount(BigDecimal value) {
        this.totalRefundAmount = value;
    }

    /**
     * Gets the value of the refundType property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getRefundType() {
        return refundType;
    }

    /**
     * Sets the value of the refundType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRefundType(String value) {
        this.refundType = value;
    }

    /**
     * Gets the value of the sitePerson property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSitePerson() {
        return sitePerson;
    }

    /**
     * Sets the value of the sitePerson property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSitePerson(String value) {
        this.sitePerson = value;
    }

    /**
     * Gets the value of the regionalApprovedBy property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getRegionalApprovedBy() {
        return regionalApprovedBy;
    }

    /**
     * Sets the value of the regionalApprovedBy property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRegionalApprovedBy(String value) {
        this.regionalApprovedBy = value;
    }

    /**
     * Gets the value of the todaysDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTodaysDate() {
        return todaysDate;
    }

    /**
     * Sets the value of the todaysDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setTodaysDate(XMLGregorianCalendar value) {
        this.todaysDate = value;
    }

}
