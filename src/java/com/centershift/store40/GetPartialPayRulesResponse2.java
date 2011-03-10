
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetPartialPayRules_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPartialPayRules_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PriorityList" type="{http://www.centershift.com/STORE40/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="AllowsPartialPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AllowsPartialRentPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPartialPayRules_Response", propOrder = {
    "priorityList",
    "allowsPartialPay",
    "allowsPartialRentPay"
})
public class GetPartialPayRulesResponse2 {

    @XmlElement(name = "PriorityList")
    protected ArrayOfString priorityList;
    @XmlElement(name = "AllowsPartialPay")
    protected String allowsPartialPay;
    @XmlElement(name = "AllowsPartialRentPay")
    protected String allowsPartialRentPay;

    /**
     * Gets the value of the priorityList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getPriorityList() {
        return priorityList;
    }

    /**
     * Sets the value of the priorityList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setPriorityList(ArrayOfString value) {
        this.priorityList = value;
    }

    /**
     * Gets the value of the allowsPartialPay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowsPartialPay() {
        return allowsPartialPay;
    }

    /**
     * Sets the value of the allowsPartialPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowsPartialPay(String value) {
        this.allowsPartialPay = value;
    }

    /**
     * Gets the value of the allowsPartialRentPay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowsPartialRentPay() {
        return allowsPartialRentPay;
    }

    /**
     * Sets the value of the allowsPartialRentPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowsPartialRentPay(String value) {
        this.allowsPartialRentPay = value;
    }

}
