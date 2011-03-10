
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnitInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NewInsurance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EmailInvoice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MailInvoice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PerEndDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnitInfo", propOrder = {
    "unitID",
    "version",
    "newInsurance",
    "emailInvoice",
    "mailInvoice",
    "perEndDay"
})
public class UnitInfo {

    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "Version")
    protected int version;
    @XmlElement(name = "NewInsurance", required = true, type = Integer.class, nillable = true)
    protected Integer newInsurance;
    @XmlElement(name = "EmailInvoice", required = true, type = Integer.class, nillable = true)
    protected Integer emailInvoice;
    @XmlElement(name = "MailInvoice", required = true, type = Integer.class, nillable = true)
    protected Integer mailInvoice;
    @XmlElement(name = "PerEndDay", required = true, type = Integer.class, nillable = true)
    protected Integer perEndDay;

    /**
     * Gets the value of the unitID property.
     * 
     */
    public long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     * 
     */
    public void setUnitID(long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the newInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNewInsurance() {
        return newInsurance;
    }

    /**
     * Sets the value of the newInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNewInsurance(Integer value) {
        this.newInsurance = value;
    }

    /**
     * Gets the value of the emailInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEmailInvoice() {
        return emailInvoice;
    }

    /**
     * Sets the value of the emailInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEmailInvoice(Integer value) {
        this.emailInvoice = value;
    }

    /**
     * Gets the value of the mailInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMailInvoice() {
        return mailInvoice;
    }

    /**
     * Sets the value of the mailInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMailInvoice(Integer value) {
        this.mailInvoice = value;
    }

    /**
     * Gets the value of the perEndDay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPerEndDay() {
        return perEndDay;
    }

    /**
     * Sets the value of the perEndDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPerEndDay(Integer value) {
        this.perEndDay = value;
    }

}
