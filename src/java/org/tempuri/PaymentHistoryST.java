
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PaymentHistory_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentHistory_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tTRANSDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="tPAIDTO" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dAMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dBALANCE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TRANSKIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentHistory_ST", propOrder = {
    "ttransdate",
    "tpaidto",
    "damount",
    "dbalance",
    "transkind",
    "csUnit"
})
public class PaymentHistoryST {

    @XmlElement(name = "tTRANSDATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ttransdate;
    @XmlElement(name = "tPAIDTO", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tpaidto;
    @XmlElement(name = "dAMOUNT", required = true)
    protected BigDecimal damount;
    @XmlElement(name = "dBALANCE", required = true)
    protected BigDecimal dbalance;
    @XmlElement(name = "TRANSKIND")
    protected String transkind;
    protected String csUnit;

    /**
     * Gets the value of the ttransdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTTRANSDATE() {
        return ttransdate;
    }

    /**
     * Sets the value of the ttransdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTTRANSDATE(XMLGregorianCalendar value) {
        this.ttransdate = value;
    }

    /**
     * Gets the value of the tpaidto property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTPAIDTO() {
        return tpaidto;
    }

    /**
     * Sets the value of the tpaidto property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTPAIDTO(XMLGregorianCalendar value) {
        this.tpaidto = value;
    }

    /**
     * Gets the value of the damount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDAMOUNT() {
        return damount;
    }

    /**
     * Sets the value of the damount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDAMOUNT(BigDecimal value) {
        this.damount = value;
    }

    /**
     * Gets the value of the dbalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDBALANCE() {
        return dbalance;
    }

    /**
     * Sets the value of the dbalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDBALANCE(BigDecimal value) {
        this.dbalance = value;
    }

    /**
     * Gets the value of the transkind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSKIND() {
        return transkind;
    }

    /**
     * Sets the value of the transkind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSKIND(String value) {
        this.transkind = value;
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

}
