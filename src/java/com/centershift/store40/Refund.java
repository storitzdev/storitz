
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Refund complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Refund">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionData" type="{http://www.centershift.com/STORE40/}TransactionData" minOccurs="0"/>
 *         &lt;element name="TenantData" type="{http://www.centershift.com/STORE40/}TenantData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Refund", propOrder = {
    "siteNumber",
    "transactionData",
    "tenantData"
})
public class Refund {

    @XmlElement(name = "SiteNumber")
    protected String siteNumber;
    @XmlElement(name = "TransactionData")
    protected TransactionData transactionData;
    @XmlElement(name = "TenantData")
    protected TenantData tenantData;

    /**
     * Gets the value of the siteNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteNumber() {
        return siteNumber;
    }

    /**
     * Sets the value of the siteNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteNumber(String value) {
        this.siteNumber = value;
    }

    /**
     * Gets the value of the transactionData property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionData }
     *     
     */
    public TransactionData getTransactionData() {
        return transactionData;
    }

    /**
     * Sets the value of the transactionData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionData }
     *     
     */
    public void setTransactionData(TransactionData value) {
        this.transactionData = value;
    }

    /**
     * Gets the value of the tenantData property.
     * 
     * @return
     *     possible object is
     *     {@link TenantData }
     *     
     */
    public TenantData getTenantData() {
        return tenantData;
    }

    /**
     * Sets the value of the tenantData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TenantData }
     *     
     */
    public void setTenantData(TenantData value) {
        this.tenantData = value;
    }

}
