package org.tempuri;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;


/**
 * <p>Java class for AvailableUnitTypesSpecial_ST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AvailableUnitTypesSpecial_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iTypeId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="sTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Availability" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="sLastUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sSpecialID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sSpecialXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sPriceLevelID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailableUnitTypesSpecial_ST", propOrder = {
        "iTypeId",
        "sTypeDescription",
        "dPrice",
        "availability",
        "sLastUnit",
        "sSpecialID",
        "sTitle",
        "sSpecialXML",
        "sPriceLevelID"
})
public class AvailableUnitTypesSpecialST {

    @XmlSchemaType(name = "unsignedInt")
    protected long iTypeId;
    protected String sTypeDescription;
    @XmlElement(required = true)
    protected BigDecimal dPrice;
    @XmlElement(name = "Availability")
    @XmlSchemaType(name = "unsignedInt")
    protected long availability;
    protected String sLastUnit;
    protected String sSpecialID;
    protected String sTitle;
    protected String sSpecialXML;
    protected String sPriceLevelID;

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
     * Gets the value of the sTypeDescription property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTypeDescription() {
        return sTypeDescription;
    }

    /**
     * Sets the value of the sTypeDescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTypeDescription(String value) {
        this.sTypeDescription = value;
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
     * Gets the value of the sLastUnit property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSLastUnit() {
        return sLastUnit;
    }

    /**
     * Sets the value of the sLastUnit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSLastUnit(String value) {
        this.sLastUnit = value;
    }

    /**
     * Gets the value of the sSpecialID property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSSpecialID() {
        return sSpecialID;
    }

    /**
     * Sets the value of the sSpecialID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSSpecialID(String value) {
        this.sSpecialID = value;
    }

    /**
     * Gets the value of the sTitle property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTitle() {
        return sTitle;
    }

    /**
     * Sets the value of the sTitle property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTitle(String value) {
        this.sTitle = value;
    }

    /**
     * Gets the value of the sSpecialXML property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSSpecialXML() {
        return sSpecialXML;
    }

    /**
     * Sets the value of the sSpecialXML property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSSpecialXML(String value) {
        this.sSpecialXML = value;
    }

    /**
     * Gets the value of the sPriceLevelID property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSPriceLevelID() {
        return sPriceLevelID;
    }

    /**
     * Sets the value of the sPriceLevelID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSPriceLevelID(String value) {
        this.sPriceLevelID = value;
    }

}
