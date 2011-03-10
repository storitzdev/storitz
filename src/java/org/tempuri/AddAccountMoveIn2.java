
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csSiteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PST" type="{http://tempuri.org/}Payment_ST"/>
 *         &lt;element name="UST" type="{http://tempuri.org/}UserAccount_ST"/>
 *         &lt;element name="csUnitID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iCustomerID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="dInsurance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="iUnitTypeID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="csCoupon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "csUser",
    "csPassword",
    "csSiteName",
    "pst",
    "ust",
    "csUnitID",
    "iCustomerID",
    "dInsurance",
    "iUnitTypeID",
    "csCoupon"
})
@XmlRootElement(name = "AddAccountMoveIn2")
public class AddAccountMoveIn2 {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    @XmlElement(name = "PST", required = true)
    protected PaymentST pst;
    @XmlElement(name = "UST", required = true)
    protected UserAccountST ust;
    protected String csUnitID;
    @XmlSchemaType(name = "unsignedInt")
    protected long iCustomerID;
    @XmlElement(required = true)
    protected BigDecimal dInsurance;
    @XmlSchemaType(name = "unsignedInt")
    protected long iUnitTypeID;
    protected String csCoupon;

    /**
     * Gets the value of the csUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsUser() {
        return csUser;
    }

    /**
     * Sets the value of the csUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsUser(String value) {
        this.csUser = value;
    }

    /**
     * Gets the value of the csPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsPassword() {
        return csPassword;
    }

    /**
     * Sets the value of the csPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsPassword(String value) {
        this.csPassword = value;
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
     * Gets the value of the pst property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentST }
     *     
     */
    public PaymentST getPST() {
        return pst;
    }

    /**
     * Sets the value of the pst property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentST }
     *     
     */
    public void setPST(PaymentST value) {
        this.pst = value;
    }

    /**
     * Gets the value of the ust property.
     * 
     * @return
     *     possible object is
     *     {@link UserAccountST }
     *     
     */
    public UserAccountST getUST() {
        return ust;
    }

    /**
     * Sets the value of the ust property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAccountST }
     *     
     */
    public void setUST(UserAccountST value) {
        this.ust = value;
    }

    /**
     * Gets the value of the csUnitID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsUnitID() {
        return csUnitID;
    }

    /**
     * Sets the value of the csUnitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsUnitID(String value) {
        this.csUnitID = value;
    }

    /**
     * Gets the value of the iCustomerID property.
     * 
     */
    public long getICustomerID() {
        return iCustomerID;
    }

    /**
     * Sets the value of the iCustomerID property.
     * 
     */
    public void setICustomerID(long value) {
        this.iCustomerID = value;
    }

    /**
     * Gets the value of the dInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDInsurance() {
        return dInsurance;
    }

    /**
     * Sets the value of the dInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDInsurance(BigDecimal value) {
        this.dInsurance = value;
    }

    /**
     * Gets the value of the iUnitTypeID property.
     * 
     */
    public long getIUnitTypeID() {
        return iUnitTypeID;
    }

    /**
     * Sets the value of the iUnitTypeID property.
     * 
     */
    public void setIUnitTypeID(long value) {
        this.iUnitTypeID = value;
    }

    /**
     * Gets the value of the csCoupon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsCoupon() {
        return csCoupon;
    }

    /**
     * Sets the value of the csCoupon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsCoupon(String value) {
        this.csCoupon = value;
    }

}
