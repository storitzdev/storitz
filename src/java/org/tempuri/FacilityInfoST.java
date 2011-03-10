
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FacilityInfo_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacilityInfo_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Success" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="csSiteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSiteAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSiteCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSiteState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSiteZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSitePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSiteEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSMTPName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSMTPUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSMTPPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSMTPNeedAuth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAllowPaymentOneWeekBeforeAuction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAllowRentUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAllowReserve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAllowEditTenantInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAdvertising" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iAdvertisingDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ST_ProcessorInfo" type="{http://tempuri.org/}ProcessorInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityInfo_ST", propOrder = {
    "success",
    "csSiteName",
    "csSiteAddress",
    "csSiteCity",
    "csSiteState",
    "csSiteZip",
    "csSitePhone",
    "csSiteEmail",
    "csSMTPName",
    "csSMTPUser",
    "csSMTPPassword",
    "csSMTPNeedAuth",
    "csAllowPaymentOneWeekBeforeAuction",
    "csAllowRentUnit",
    "csAllowReserve",
    "csAllowEditTenantInfo",
    "csAdvertising",
    "iAdvertisingDays",
    "stProcessorInfo"
})
public class FacilityInfoST {

    @XmlElement(name = "Success")
    protected boolean success;
    protected String csSiteName;
    protected String csSiteAddress;
    protected String csSiteCity;
    protected String csSiteState;
    protected String csSiteZip;
    protected String csSitePhone;
    protected String csSiteEmail;
    protected String csSMTPName;
    protected String csSMTPUser;
    protected String csSMTPPassword;
    protected String csSMTPNeedAuth;
    protected String csAllowPaymentOneWeekBeforeAuction;
    protected String csAllowRentUnit;
    protected String csAllowReserve;
    protected String csAllowEditTenantInfo;
    protected String csAdvertising;
    protected int iAdvertisingDays;
    @XmlElement(name = "ST_ProcessorInfo", required = true)
    protected ProcessorInfo stProcessorInfo;

    /**
     * Gets the value of the success property.
     * 
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

    /**
     * Gets the value of the csSiteName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSiteName() {
        return csSiteName;
    }

    /**
     * Sets the value of the csSiteName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSiteName(String value) {
        this.csSiteName = value;
    }

    /**
     * Gets the value of the csSiteAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSiteAddress() {
        return csSiteAddress;
    }

    /**
     * Sets the value of the csSiteAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSiteAddress(String value) {
        this.csSiteAddress = value;
    }

    /**
     * Gets the value of the csSiteCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSiteCity() {
        return csSiteCity;
    }

    /**
     * Sets the value of the csSiteCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSiteCity(String value) {
        this.csSiteCity = value;
    }

    /**
     * Gets the value of the csSiteState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSiteState() {
        return csSiteState;
    }

    /**
     * Sets the value of the csSiteState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSiteState(String value) {
        this.csSiteState = value;
    }

    /**
     * Gets the value of the csSiteZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSiteZip() {
        return csSiteZip;
    }

    /**
     * Sets the value of the csSiteZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSiteZip(String value) {
        this.csSiteZip = value;
    }

    /**
     * Gets the value of the csSitePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSitePhone() {
        return csSitePhone;
    }

    /**
     * Sets the value of the csSitePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSitePhone(String value) {
        this.csSitePhone = value;
    }

    /**
     * Gets the value of the csSiteEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSiteEmail() {
        return csSiteEmail;
    }

    /**
     * Sets the value of the csSiteEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSiteEmail(String value) {
        this.csSiteEmail = value;
    }

    /**
     * Gets the value of the csSMTPName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSMTPName() {
        return csSMTPName;
    }

    /**
     * Sets the value of the csSMTPName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSMTPName(String value) {
        this.csSMTPName = value;
    }

    /**
     * Gets the value of the csSMTPUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSMTPUser() {
        return csSMTPUser;
    }

    /**
     * Sets the value of the csSMTPUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSMTPUser(String value) {
        this.csSMTPUser = value;
    }

    /**
     * Gets the value of the csSMTPPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSMTPPassword() {
        return csSMTPPassword;
    }

    /**
     * Sets the value of the csSMTPPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSMTPPassword(String value) {
        this.csSMTPPassword = value;
    }

    /**
     * Gets the value of the csSMTPNeedAuth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSMTPNeedAuth() {
        return csSMTPNeedAuth;
    }

    /**
     * Sets the value of the csSMTPNeedAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSMTPNeedAuth(String value) {
        this.csSMTPNeedAuth = value;
    }

    /**
     * Gets the value of the csAllowPaymentOneWeekBeforeAuction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAllowPaymentOneWeekBeforeAuction() {
        return csAllowPaymentOneWeekBeforeAuction;
    }

    /**
     * Sets the value of the csAllowPaymentOneWeekBeforeAuction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAllowPaymentOneWeekBeforeAuction(String value) {
        this.csAllowPaymentOneWeekBeforeAuction = value;
    }

    /**
     * Gets the value of the csAllowRentUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAllowRentUnit() {
        return csAllowRentUnit;
    }

    /**
     * Sets the value of the csAllowRentUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAllowRentUnit(String value) {
        this.csAllowRentUnit = value;
    }

    /**
     * Gets the value of the csAllowReserve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAllowReserve() {
        return csAllowReserve;
    }

    /**
     * Sets the value of the csAllowReserve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAllowReserve(String value) {
        this.csAllowReserve = value;
    }

    /**
     * Gets the value of the csAllowEditTenantInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAllowEditTenantInfo() {
        return csAllowEditTenantInfo;
    }

    /**
     * Sets the value of the csAllowEditTenantInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAllowEditTenantInfo(String value) {
        this.csAllowEditTenantInfo = value;
    }

    /**
     * Gets the value of the csAdvertising property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAdvertising() {
        return csAdvertising;
    }

    /**
     * Sets the value of the csAdvertising property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAdvertising(String value) {
        this.csAdvertising = value;
    }

    /**
     * Gets the value of the iAdvertisingDays property.
     * 
     */
    public int getIAdvertisingDays() {
        return iAdvertisingDays;
    }

    /**
     * Sets the value of the iAdvertisingDays property.
     * 
     */
    public void setIAdvertisingDays(int value) {
        this.iAdvertisingDays = value;
    }

    /**
     * Gets the value of the stProcessorInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessorInfo }
     *     
     */
    public ProcessorInfo getSTProcessorInfo() {
        return stProcessorInfo;
    }

    /**
     * Sets the value of the stProcessorInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessorInfo }
     *     
     */
    public void setSTProcessorInfo(ProcessorInfo value) {
        this.stProcessorInfo = value;
    }

}
