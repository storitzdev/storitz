
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="iCustomerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="csUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csOldAccessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csNewAccessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ST" type="{http://tempuri.org/}UserAccount_ST"/>
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
    "iCustomerID",
    "csUnit",
    "csOldAccessCode",
    "csNewAccessCode",
    "st"
})
@XmlRootElement(name = "UpdateAccount")
public class UpdateAccount {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    protected int iCustomerID;
    protected String csUnit;
    protected String csOldAccessCode;
    protected String csNewAccessCode;
    @XmlElement(name = "ST", required = true)
    protected UserAccountST st;

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
     * Gets the value of the csUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsUnit() {
        return csUnit;
    }

    /**
     * Sets the value of the csUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsUnit(String value) {
        this.csUnit = value;
    }

    /**
     * Gets the value of the csOldAccessCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsOldAccessCode() {
        return csOldAccessCode;
    }

    /**
     * Sets the value of the csOldAccessCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsOldAccessCode(String value) {
        this.csOldAccessCode = value;
    }

    /**
     * Gets the value of the csNewAccessCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsNewAccessCode() {
        return csNewAccessCode;
    }

    /**
     * Sets the value of the csNewAccessCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsNewAccessCode(String value) {
        this.csNewAccessCode = value;
    }

    /**
     * Gets the value of the st property.
     * 
     * @return
     *     possible object is
     *     {@link UserAccountST }
     *     
     */
    public UserAccountST getST() {
        return st;
    }

    /**
     * Sets the value of the st property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAccountST }
     *     
     */
    public void setST(UserAccountST value) {
        this.st = value;
    }

}
