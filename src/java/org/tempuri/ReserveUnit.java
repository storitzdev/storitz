
package org.tempuri;

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
 *         &lt;element name="itypeId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
    "itypeId"
})
@XmlRootElement(name = "ReserveUnit")
public class ReserveUnit {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    @XmlElement(name = "PST", required = true)
    protected PaymentST pst;
    @XmlElement(name = "UST", required = true)
    protected UserAccountST ust;
    protected String csUnitID;
    @XmlSchemaType(name = "unsignedInt")
    protected long itypeId;

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
     * Gets the value of the itypeId property.
     * 
     */
    public long getItypeId() {
        return itypeId;
    }

    /**
     * Sets the value of the itypeId property.
     * 
     */
    public void setItypeId(long value) {
        this.itypeId = value;
    }

}
