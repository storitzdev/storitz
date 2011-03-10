
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GetCustomerAccountBalance_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCustomerAccountBalance_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Charge" type="{http://tempuri.org/}ArrayOfCharge_ST" minOccurs="0"/>
 *         &lt;element name="csUnitID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csLASTACTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tMovein" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="tLastPaidDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dSECDEP" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerAccountBalance_ST", propOrder = {
    "charge",
    "csUnitID",
    "csLASTACTION",
    "tMovein",
    "tLastPaidDate",
    "dsecdep"
})
public class GetCustomerAccountBalanceST {

    @XmlElement(name = "Charge")
    protected ArrayOfChargeST charge;
    protected String csUnitID;
    protected String csLASTACTION;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tMovein;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tLastPaidDate;
    @XmlElement(name = "dSECDEP", required = true)
    protected BigDecimal dsecdep;

    /**
     * Gets the value of the charge property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfChargeST }
     *     
     */
    public ArrayOfChargeST getCharge() {
        return charge;
    }

    /**
     * Sets the value of the charge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfChargeST }
     *     
     */
    public void setCharge(ArrayOfChargeST value) {
        this.charge = value;
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
     * Gets the value of the csLASTACTION property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsLASTACTION() {
        return csLASTACTION;
    }

    /**
     * Sets the value of the csLASTACTION property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsLASTACTION(String value) {
        this.csLASTACTION = value;
    }

    /**
     * Gets the value of the tMovein property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTMovein() {
        return tMovein;
    }

    /**
     * Sets the value of the tMovein property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTMovein(XMLGregorianCalendar value) {
        this.tMovein = value;
    }

    /**
     * Gets the value of the tLastPaidDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTLastPaidDate() {
        return tLastPaidDate;
    }

    /**
     * Sets the value of the tLastPaidDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTLastPaidDate(XMLGregorianCalendar value) {
        this.tLastPaidDate = value;
    }

    /**
     * Gets the value of the dsecdep property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDSECDEP() {
        return dsecdep;
    }

    /**
     * Sets the value of the dsecdep property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDSECDEP(BigDecimal value) {
        this.dsecdep = value;
    }

}
