package org.tempuri;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;


/**
 * <p>Java class for AvailableUnitTypes_ST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AvailableUnitTypes_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iTypeId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="csTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Availability" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="csLastUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailableUnitTypes_ST", propOrder = {
        "iTypeId",
        "csTypeDescription",
        "dPrice",
        "availability",
        "csLastUnit"
})
public class AvailableUnitTypesST {

    @XmlSchemaType(name = "unsignedInt")
    protected long iTypeId;
    protected String csTypeDescription;
    @XmlElement(required = true)
    protected BigDecimal dPrice;
    @XmlElement(name = "Availability")
    @XmlSchemaType(name = "unsignedInt")
    protected long availability;
    protected String csLastUnit;

    /**
     * Gets the value of the iTypeId property.
     */
    public long getITypeId() {
        return iTypeId;
    }

    /**
     * Sets the value of the iTypeId property.
     */
    public void setITypeId(long value) {
        this.iTypeId = value;
    }

    /**
     * Gets the value of the csTypeDescription property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsTypeDescription() {
        return csTypeDescription;
    }

    /**
     * Sets the value of the csTypeDescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsTypeDescription(String value) {
        this.csTypeDescription = value;
    }

    /**
     * Gets the value of the dPrice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDPrice() {
        return dPrice;
    }

    /**
     * Sets the value of the dPrice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDPrice(BigDecimal value) {
        this.dPrice = value;
    }

    /**
     * Gets the value of the availability property.
     */
    public long getAvailability() {
        return availability;
    }

    /**
     * Sets the value of the availability property.
     */
    public void setAvailability(long value) {
        this.availability = value;
    }

    /**
     * Gets the value of the csLastUnit property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsLastUnit() {
        return csLastUnit;
    }

    /**
     * Sets the value of the csLastUnit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsLastUnit(String value) {
        this.csLastUnit = value;
    }

}
