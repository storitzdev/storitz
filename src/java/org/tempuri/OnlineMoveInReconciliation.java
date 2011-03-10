
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
 *         &lt;element name="sProcessor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sUnitID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dfee" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    "sProcessor",
    "sUnitID",
    "dAmount",
    "dfee"
})
@XmlRootElement(name = "OnlineMoveInReconciliation")
public class OnlineMoveInReconciliation {

    protected String csUser;
    protected String csPassword;
    protected String csSiteName;
    protected String sProcessor;
    protected String sUnitID;
    @XmlElement(required = true)
    protected BigDecimal dAmount;
    @XmlElement(required = true)
    protected BigDecimal dfee;

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
     * Gets the value of the sProcessor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSProcessor() {
        return sProcessor;
    }

    /**
     * Sets the value of the sProcessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSProcessor(String value) {
        this.sProcessor = value;
    }

    /**
     * Gets the value of the sUnitID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUnitID() {
        return sUnitID;
    }

    /**
     * Sets the value of the sUnitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUnitID(String value) {
        this.sUnitID = value;
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
     * Gets the value of the dfee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDfee() {
        return dfee;
    }

    /**
     * Sets the value of the dfee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDfee(BigDecimal value) {
        this.dfee = value;
    }

}
