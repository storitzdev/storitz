
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AvailableUnits_ST complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AvailableUnits_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="csUnitID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dRent" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailableUnits_ST", propOrder = {
    "csUnitID",
    "dRent"
})
public class AvailableUnitsST {

    protected String csUnitID;
    @XmlElement(required = true)
    protected BigDecimal dRent;

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
     * Gets the value of the dRent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDRent() {
        return dRent;
    }

    /**
     * Sets the value of the dRent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDRent(BigDecimal value) {
        this.dRent = value;
    }

}
