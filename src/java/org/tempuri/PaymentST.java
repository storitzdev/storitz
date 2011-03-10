
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Payment_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Payment_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="csPaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCCType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCCNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csRoutingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csExpirationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCCStreetAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCCZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCVV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csTrack1Data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCCFName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCCLName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payment_ST", propOrder = {
    "dPaymentAmount",
    "csPaymentMethod",
    "csCCType",
    "csCCNumber",
    "csRoutingNumber",
    "csExpirationDate",
    "csCCStreetAddress",
    "csCCZip",
    "csCVV",
    "csTrack1Data",
    "csCity",
    "csState",
    "csCountry",
    "csCCFName",
    "csCCLName"
})
public class PaymentST {

    @XmlElement(required = true)
    protected BigDecimal dPaymentAmount;
    protected String csPaymentMethod;
    protected String csCCType;
    protected String csCCNumber;
    protected String csRoutingNumber;
    protected String csExpirationDate;
    protected String csCCStreetAddress;
    protected String csCCZip;
    protected String csCVV;
    protected String csTrack1Data;
    protected String csCity;
    protected String csState;
    protected String csCountry;
    protected String csCCFName;
    protected String csCCLName;

    /**
     * Gets the value of the dPaymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDPaymentAmount() {
        return dPaymentAmount;
    }

    /**
     * Sets the value of the dPaymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDPaymentAmount(BigDecimal value) {
        this.dPaymentAmount = value;
    }

    /**
     * Gets the value of the csPaymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsPaymentMethod() {
        return csPaymentMethod;
    }

    /**
     * Sets the value of the csPaymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsPaymentMethod(String value) {
        this.csPaymentMethod = value;
    }

    /**
     * Gets the value of the csCCType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCCType() {
        return csCCType;
    }

    /**
     * Sets the value of the csCCType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCCType(String value) {
        this.csCCType = value;
    }

    /**
     * Gets the value of the csCCNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCCNumber() {
        return csCCNumber;
    }

    /**
     * Sets the value of the csCCNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCCNumber(String value) {
        this.csCCNumber = value;
    }

    /**
     * Gets the value of the csRoutingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsRoutingNumber() {
        return csRoutingNumber;
    }

    /**
     * Sets the value of the csRoutingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsRoutingNumber(String value) {
        this.csRoutingNumber = value;
    }

    /**
     * Gets the value of the csExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsExpirationDate() {
        return csExpirationDate;
    }

    /**
     * Sets the value of the csExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsExpirationDate(String value) {
        this.csExpirationDate = value;
    }

    /**
     * Gets the value of the csCCStreetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCCStreetAddress() {
        return csCCStreetAddress;
    }

    /**
     * Sets the value of the csCCStreetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCCStreetAddress(String value) {
        this.csCCStreetAddress = value;
    }

    /**
     * Gets the value of the csCCZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCCZip() {
        return csCCZip;
    }

    /**
     * Sets the value of the csCCZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCCZip(String value) {
        this.csCCZip = value;
    }

    /**
     * Gets the value of the csCVV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCVV() {
        return csCVV;
    }

    /**
     * Sets the value of the csCVV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCVV(String value) {
        this.csCVV = value;
    }

    /**
     * Gets the value of the csTrack1Data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsTrack1Data() {
        return csTrack1Data;
    }

    /**
     * Sets the value of the csTrack1Data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsTrack1Data(String value) {
        this.csTrack1Data = value;
    }

    /**
     * Gets the value of the csCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCity() {
        return csCity;
    }

    /**
     * Sets the value of the csCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCity(String value) {
        this.csCity = value;
    }

    /**
     * Gets the value of the csState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsState() {
        return csState;
    }

    /**
     * Sets the value of the csState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsState(String value) {
        this.csState = value;
    }

    /**
     * Gets the value of the csCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCountry() {
        return csCountry;
    }

    /**
     * Sets the value of the csCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCountry(String value) {
        this.csCountry = value;
    }

    /**
     * Gets the value of the csCCFName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCCFName() {
        return csCCFName;
    }

    /**
     * Sets the value of the csCCFName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCCFName(String value) {
        this.csCCFName = value;
    }

    /**
     * Gets the value of the csCCLName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCCLName() {
        return csCCLName;
    }

    /**
     * Sets the value of the csCCLName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCCLName(String value) {
        this.csCCLName = value;
    }

}
