package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for AvailableInsurance_ST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AvailableInsurance_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TypeDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dCoverageAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dCoveragePercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dMonthlyFee" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailableInsurance_ST", propOrder = {
        "typeID",
        "typeDesc",
        "dCoverageAmount",
        "dCoveragePercentage",
        "dMonthlyFee"
})
public class AvailableInsuranceST {

    @XmlElement(name = "TypeID")
    protected String typeID;
    @XmlElement(name = "TypeDesc")
    protected String typeDesc;
    @XmlElement(required = true)
    protected BigDecimal dCoverageAmount;
    @XmlElement(required = true)
    protected BigDecimal dCoveragePercentage;
    @XmlElement(required = true)
    protected BigDecimal dMonthlyFee;

    /**
     * Gets the value of the typeID property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getTypeID() {
        return typeID;
    }

    /**
     * Sets the value of the typeID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTypeID(String value) {
        this.typeID = value;
    }

    /**
     * Gets the value of the typeDesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getTypeDesc() {
        return typeDesc;
    }

    /**
     * Sets the value of the typeDesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTypeDesc(String value) {
        this.typeDesc = value;
    }

    /**
     * Gets the value of the dCoverageAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDCoverageAmount() {
        return dCoverageAmount;
    }

    /**
     * Sets the value of the dCoverageAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDCoverageAmount(BigDecimal value) {
        this.dCoverageAmount = value;
    }

    /**
     * Gets the value of the dCoveragePercentage property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDCoveragePercentage() {
        return dCoveragePercentage;
    }

    /**
     * Sets the value of the dCoveragePercentage property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDCoveragePercentage(BigDecimal value) {
        this.dCoveragePercentage = value;
    }

    /**
     * Gets the value of the dMonthlyFee property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDMonthlyFee() {
        return dMonthlyFee;
    }

    /**
     * Sets the value of the dMonthlyFee property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDMonthlyFee(BigDecimal value) {
        this.dMonthlyFee = value;
    }

}
