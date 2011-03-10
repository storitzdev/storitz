
package org.tempuri;

import java.math.BigDecimal;
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
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iCustomerNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ST" type="{http://tempuri.org/}Payment_ST"/>
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
    "itemId",
    "iCustomerNum",
    "dAmount",
    "st"
})
@XmlRootElement(name = "BuyInventory")
public class BuyInventory {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    protected int itemId;
    protected int iCustomerNum;
    @XmlElement(required = true)
    protected BigDecimal dAmount;
    @XmlElement(name = "ST", required = true)
    protected PaymentST st;

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
     * Gets the value of the itemId property.
     * 
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     */
    public void setItemId(int value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the iCustomerNum property.
     * 
     */
    public int getICustomerNum() {
        return iCustomerNum;
    }

    /**
     * Sets the value of the iCustomerNum property.
     * 
     */
    public void setICustomerNum(int value) {
        this.iCustomerNum = value;
    }

    /**
     * Gets the value of the dAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDAmount() {
        return dAmount;
    }

    /**
     * Sets the value of the dAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDAmount(BigDecimal value) {
        this.dAmount = value;
    }

    /**
     * Gets the value of the st property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentST }
     *     
     */
    public PaymentST getST() {
        return st;
    }

    /**
     * Sets the value of the st property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentST }
     *     
     */
    public void setST(PaymentST value) {
        this.st = value;
    }

}
