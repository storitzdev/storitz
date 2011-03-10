
package com.centershift.store40;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MakeMiscPayment_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MakeMiscPayment_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ClassID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ClassRef" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MiscellaneousClassID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxGroupID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TotalAmtPaid" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CreditCardInfo" type="{http://www.centershift.com/STORE40/}CreditCardData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CheckInfo" type="{http://www.centershift.com/STORE40/}CheckData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CashInfo" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeMiscPayment_Request", propOrder = {
    "siteID",
    "classID",
    "classRef",
    "miscellaneousClassID",
    "description",
    "taxGroupID",
    "totalAmtPaid",
    "creditCardInfo",
    "checkInfo",
    "cashInfo"
})
public class MakeMiscPaymentRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "ClassID")
    protected long classID;
    @XmlElement(name = "ClassRef")
    protected long classRef;
    @XmlElement(name = "MiscellaneousClassID")
    protected long miscellaneousClassID;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "TaxGroupID")
    protected long taxGroupID;
    @XmlElement(name = "TotalAmtPaid", required = true)
    protected BigDecimal totalAmtPaid;
    @XmlElement(name = "CreditCardInfo")
    protected List<CreditCardData> creditCardInfo;
    @XmlElement(name = "CheckInfo")
    protected List<CheckData> checkInfo;
    @XmlElement(name = "CashInfo", required = true)
    protected BigDecimal cashInfo;

    /**
     * Gets the value of the siteID property.
     * 
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     * 
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the classID property.
     * 
     */
    public long getClassID() {
        return classID;
    }

    /**
     * Sets the value of the classID property.
     * 
     */
    public void setClassID(long value) {
        this.classID = value;
    }

    /**
     * Gets the value of the classRef property.
     * 
     */
    public long getClassRef() {
        return classRef;
    }

    /**
     * Sets the value of the classRef property.
     * 
     */
    public void setClassRef(long value) {
        this.classRef = value;
    }

    /**
     * Gets the value of the miscellaneousClassID property.
     * 
     */
    public long getMiscellaneousClassID() {
        return miscellaneousClassID;
    }

    /**
     * Sets the value of the miscellaneousClassID property.
     * 
     */
    public void setMiscellaneousClassID(long value) {
        this.miscellaneousClassID = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the taxGroupID property.
     * 
     */
    public long getTaxGroupID() {
        return taxGroupID;
    }

    /**
     * Sets the value of the taxGroupID property.
     * 
     */
    public void setTaxGroupID(long value) {
        this.taxGroupID = value;
    }

    /**
     * Gets the value of the totalAmtPaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmtPaid() {
        return totalAmtPaid;
    }

    /**
     * Sets the value of the totalAmtPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmtPaid(BigDecimal value) {
        this.totalAmtPaid = value;
    }

    /**
     * Gets the value of the creditCardInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditCardInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditCardInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditCardData }
     * 
     * 
     */
    public List<CreditCardData> getCreditCardInfo() {
        if (creditCardInfo == null) {
            creditCardInfo = new ArrayList<CreditCardData>();
        }
        return this.creditCardInfo;
    }

    /**
     * Gets the value of the checkInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckData }
     * 
     * 
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
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCashInfo() {
        return cashInfo;
    }

    /**
     * Sets the value of the cashInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCashInfo(BigDecimal value) {
        this.cashInfo = value;
    }

}
