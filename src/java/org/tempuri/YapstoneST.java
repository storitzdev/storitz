
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Yapstone_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Yapstone_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="csCCNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csPaymentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csRefrenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Yapstone_ST", propOrder = {
    "csUnit",
    "dAmount",
    "csCCNumber",
    "csPaymentType",
    "csRefrenceNumber",
    "csGUID"
})
public class YapstoneST {

    protected String csUnit;
    @XmlElement(required = true)
    protected BigDecimal dAmount;
    protected String csCCNumber;
    protected String csPaymentType;
    protected String csRefrenceNumber;
    protected String csGUID;

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
     * Gets the value of the csPaymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsPaymentType() {
        return csPaymentType;
    }

    /**
     * Sets the value of the csPaymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsPaymentType(String value) {
        this.csPaymentType = value;
    }

    /**
     * Gets the value of the csRefrenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsRefrenceNumber() {
        return csRefrenceNumber;
    }

    /**
     * Sets the value of the csRefrenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsRefrenceNumber(String value) {
        this.csRefrenceNumber = value;
    }

    /**
     * Gets the value of the csGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsGUID() {
        return csGUID;
    }

    /**
     * Sets the value of the csGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsGUID(String value) {
        this.csGUID = value;
    }

}
