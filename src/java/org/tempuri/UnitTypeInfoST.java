package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for UnitTypeInfo_ST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UnitTypeInfo_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dWidth" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dLength" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dHeight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="iFloor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="csUnitType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csInside" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csDoorType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnitTypeInfo_ST", propOrder = {
        "dWidth",
        "dLength",
        "dHeight",
        "iFloor",
        "csUnitType",
        "csInside",
        "csDoorType"
})
public class UnitTypeInfoST {

    @XmlElement(required = true)
    protected BigDecimal dWidth;
    @XmlElement(required = true)
    protected BigDecimal dLength;
    @XmlElement(required = true)
    protected BigDecimal dHeight;
    protected int iFloor;
    protected String csUnitType;
    protected String csInside;
    protected String csDoorType;

    /**
     * Gets the value of the dWidth property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDWidth() {
        return dWidth;
    }

    /**
     * Sets the value of the dWidth property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDWidth(BigDecimal value) {
        this.dWidth = value;
    }

    /**
     * Gets the value of the dLength property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDLength() {
        return dLength;
    }

    /**
     * Sets the value of the dLength property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDLength(BigDecimal value) {
        this.dLength = value;
    }

    /**
     * Gets the value of the dHeight property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDHeight() {
        return dHeight;
    }

    /**
     * Sets the value of the dHeight property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDHeight(BigDecimal value) {
        this.dHeight = value;
    }

    /**
     * Gets the value of the iFloor property.
     */
    public int getIFloor() {
        return iFloor;
    }

    /**
     * Sets the value of the iFloor property.
     */
    public void setIFloor(int value) {
        this.iFloor = value;
    }

    /**
     * Gets the value of the csUnitType property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsUnitType() {
        return csUnitType;
    }

    /**
     * Sets the value of the csUnitType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsUnitType(String value) {
        this.csUnitType = value;
    }

    /**
     * Gets the value of the csInside property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsInside() {
        return csInside;
    }

    /**
     * Sets the value of the csInside property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsInside(String value) {
        this.csInside = value;
    }

    /**
     * Gets the value of the csDoorType property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsDoorType() {
        return csDoorType;
    }

    /**
     * Sets the value of the csDoorType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsDoorType(String value) {
        this.csDoorType = value;
    }

}
