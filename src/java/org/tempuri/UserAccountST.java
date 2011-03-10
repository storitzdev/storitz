
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UserAccount_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAccount_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iCustomerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="csLastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAutoBilling" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csBillingLName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csBillingFName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csBillingAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csBillingCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csBillingState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csBillingZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csHomePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csWorkPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csCellphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csFax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAltName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAltAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAltAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAltCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAltState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csAltZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSOCSEC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csDriverLicenseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bNFS" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PAIDTO" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="tAVAIL" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dTolalBal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dRent" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dTotalCharge" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="sDocDestinations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccount_ST", propOrder = {
    "iCustomerID",
    "csLastname",
    "csFirstName",
    "csAddress",
    "csAddress2",
    "csCompany",
    "csCity",
    "csState",
    "csZip",
    "csAutoBilling",
    "csBillingLName",
    "csBillingFName",
    "csBillingAddress",
    "csBillingCity",
    "csBillingState",
    "csBillingZip",
    "csHomePhone",
    "csWorkPhone",
    "csCellphone",
    "csEmail",
    "csFax",
    "csAltName",
    "csAltAddress",
    "csAltAddress2",
    "csAltCity",
    "csAltState",
    "csAltZip",
    "csSOCSEC",
    "csDriverLicenseNumber",
    "bnfs",
    "paidto",
    "tavail",
    "dTolalBal",
    "dRent",
    "dTotalCharge",
    "sDocDestinations"
})
public class UserAccountST {

    protected int iCustomerID;
    protected String csLastname;
    protected String csFirstName;
    protected String csAddress;
    protected String csAddress2;
    protected String csCompany;
    protected String csCity;
    protected String csState;
    protected String csZip;
    protected String csAutoBilling;
    protected String csBillingLName;
    protected String csBillingFName;
    protected String csBillingAddress;
    protected String csBillingCity;
    protected String csBillingState;
    protected String csBillingZip;
    protected String csHomePhone;
    protected String csWorkPhone;
    protected String csCellphone;
    protected String csEmail;
    protected String csFax;
    protected String csAltName;
    protected String csAltAddress;
    protected String csAltAddress2;
    protected String csAltCity;
    protected String csAltState;
    protected String csAltZip;
    protected String csSOCSEC;
    protected String csDriverLicenseNumber;
    @XmlElement(name = "bNFS")
    protected boolean bnfs;
    @XmlElement(name = "PAIDTO", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paidto;
    @XmlElement(name = "tAVAIL", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tavail;
    @XmlElement(required = true)
    protected BigDecimal dTolalBal;
    @XmlElement(required = true)
    protected BigDecimal dRent;
    @XmlElement(required = true)
    protected BigDecimal dTotalCharge;
    protected String sDocDestinations;

    /**
     * Gets the value of the iCustomerID property.
     * 
     */
    public int getICustomerID() {
        return iCustomerID;
    }

    /**
     * Sets the value of the iCustomerID property.
     * 
     */
    public void setICustomerID(int value) {
        this.iCustomerID = value;
    }

    /**
     * Gets the value of the csLastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsLastname() {
        return csLastname;
    }

    /**
     * Sets the value of the csLastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsLastname(String value) {
        this.csLastname = value;
    }

    /**
     * Gets the value of the csFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsFirstName() {
        return csFirstName;
    }

    /**
     * Sets the value of the csFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsFirstName(String value) {
        this.csFirstName = value;
    }

    /**
     * Gets the value of the csAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAddress() {
        return csAddress;
    }

    /**
     * Sets the value of the csAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAddress(String value) {
        this.csAddress = value;
    }

    /**
     * Gets the value of the csAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAddress2() {
        return csAddress2;
    }

    /**
     * Sets the value of the csAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAddress2(String value) {
        this.csAddress2 = value;
    }

    /**
     * Gets the value of the csCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCompany() {
        return csCompany;
    }

    /**
     * Sets the value of the csCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCompany(String value) {
        this.csCompany = value;
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
     * Gets the value of the csZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsZip() {
        return csZip;
    }

    /**
     * Sets the value of the csZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsZip(String value) {
        this.csZip = value;
    }

    /**
     * Gets the value of the csAutoBilling property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAutoBilling() {
        return csAutoBilling;
    }

    /**
     * Sets the value of the csAutoBilling property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAutoBilling(String value) {
        this.csAutoBilling = value;
    }

    /**
     * Gets the value of the csBillingLName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsBillingLName() {
        return csBillingLName;
    }

    /**
     * Sets the value of the csBillingLName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsBillingLName(String value) {
        this.csBillingLName = value;
    }

    /**
     * Gets the value of the csBillingFName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsBillingFName() {
        return csBillingFName;
    }

    /**
     * Sets the value of the csBillingFName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsBillingFName(String value) {
        this.csBillingFName = value;
    }

    /**
     * Gets the value of the csBillingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsBillingAddress() {
        return csBillingAddress;
    }

    /**
     * Sets the value of the csBillingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsBillingAddress(String value) {
        this.csBillingAddress = value;
    }

    /**
     * Gets the value of the csBillingCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsBillingCity() {
        return csBillingCity;
    }

    /**
     * Sets the value of the csBillingCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsBillingCity(String value) {
        this.csBillingCity = value;
    }

    /**
     * Gets the value of the csBillingState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsBillingState() {
        return csBillingState;
    }

    /**
     * Sets the value of the csBillingState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsBillingState(String value) {
        this.csBillingState = value;
    }

    /**
     * Gets the value of the csBillingZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsBillingZip() {
        return csBillingZip;
    }

    /**
     * Sets the value of the csBillingZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsBillingZip(String value) {
        this.csBillingZip = value;
    }

    /**
     * Gets the value of the csHomePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsHomePhone() {
        return csHomePhone;
    }

    /**
     * Sets the value of the csHomePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsHomePhone(String value) {
        this.csHomePhone = value;
    }

    /**
     * Gets the value of the csWorkPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsWorkPhone() {
        return csWorkPhone;
    }

    /**
     * Sets the value of the csWorkPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsWorkPhone(String value) {
        this.csWorkPhone = value;
    }

    /**
     * Gets the value of the csCellphone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCellphone() {
        return csCellphone;
    }

    /**
     * Sets the value of the csCellphone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCellphone(String value) {
        this.csCellphone = value;
    }

    /**
     * Gets the value of the csEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsEmail() {
        return csEmail;
    }

    /**
     * Sets the value of the csEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsEmail(String value) {
        this.csEmail = value;
    }

    /**
     * Gets the value of the csFax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsFax() {
        return csFax;
    }

    /**
     * Sets the value of the csFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsFax(String value) {
        this.csFax = value;
    }

    /**
     * Gets the value of the csAltName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAltName() {
        return csAltName;
    }

    /**
     * Sets the value of the csAltName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAltName(String value) {
        this.csAltName = value;
    }

    /**
     * Gets the value of the csAltAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAltAddress() {
        return csAltAddress;
    }

    /**
     * Sets the value of the csAltAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAltAddress(String value) {
        this.csAltAddress = value;
    }

    /**
     * Gets the value of the csAltAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAltAddress2() {
        return csAltAddress2;
    }

    /**
     * Sets the value of the csAltAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAltAddress2(String value) {
        this.csAltAddress2 = value;
    }

    /**
     * Gets the value of the csAltCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAltCity() {
        return csAltCity;
    }

    /**
     * Sets the value of the csAltCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAltCity(String value) {
        this.csAltCity = value;
    }

    /**
     * Gets the value of the csAltState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAltState() {
        return csAltState;
    }

    /**
     * Sets the value of the csAltState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAltState(String value) {
        this.csAltState = value;
    }

    /**
     * Gets the value of the csAltZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsAltZip() {
        return csAltZip;
    }

    /**
     * Sets the value of the csAltZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsAltZip(String value) {
        this.csAltZip = value;
    }

    /**
     * Gets the value of the csSOCSEC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsSOCSEC() {
        return csSOCSEC;
    }

    /**
     * Sets the value of the csSOCSEC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsSOCSEC(String value) {
        this.csSOCSEC = value;
    }

    /**
     * Gets the value of the csDriverLicenseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsDriverLicenseNumber() {
        return csDriverLicenseNumber;
    }

    /**
     * Sets the value of the csDriverLicenseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsDriverLicenseNumber(String value) {
        this.csDriverLicenseNumber = value;
    }

    /**
     * Gets the value of the bnfs property.
     * 
     */
    public boolean isBNFS() {
        return bnfs;
    }

    /**
     * Sets the value of the bnfs property.
     * 
     */
    public void setBNFS(boolean value) {
        this.bnfs = value;
    }

    /**
     * Gets the value of the paidto property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPAIDTO() {
        return paidto;
    }

    /**
     * Sets the value of the paidto property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPAIDTO(XMLGregorianCalendar value) {
        this.paidto = value;
    }

    /**
     * Gets the value of the tavail property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTAVAIL() {
        return tavail;
    }

    /**
     * Sets the value of the tavail property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTAVAIL(XMLGregorianCalendar value) {
        this.tavail = value;
    }

    /**
     * Gets the value of the dTolalBal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDTolalBal() {
        return dTolalBal;
    }

    /**
     * Sets the value of the dTolalBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDTolalBal(BigDecimal value) {
        this.dTolalBal = value;
    }

    /**
     * Gets the value of the dRent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDRent() {
        return dRent;
    }

    /**
     * Sets the value of the dRent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDRent(BigDecimal value) {
        this.dRent = value;
    }

    /**
     * Gets the value of the dTotalCharge property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDTotalCharge() {
        return dTotalCharge;
    }

    /**
     * Sets the value of the dTotalCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDTotalCharge(BigDecimal value) {
        this.dTotalCharge = value;
    }

    /**
     * Gets the value of the sDocDestinations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDocDestinations() {
        return sDocDestinations;
    }

    /**
     * Sets the value of the sDocDestinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDocDestinations(String value) {
        this.sDocDestinations = value;
    }

}
