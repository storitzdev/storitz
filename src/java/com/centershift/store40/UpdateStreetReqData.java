package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for UpdateStreetReqData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateStreetReqData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Depth" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Attribute01" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Attribute02" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Climate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Door" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Access" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Features" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NewRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateStreetReqData", propOrder = {
        "width",
        "depth",
        "height",
        "attribute01",
        "attribute02",
        "climate",
        "door",
        "access",
        "features",
        "newRate"
})
public class UpdateStreetReqData {

    @XmlElement(name = "Width", required = true, nillable = true)
    protected BigDecimal width;
    @XmlElement(name = "Depth", required = true, nillable = true)
    protected BigDecimal depth;
    @XmlElement(name = "Height", required = true, nillable = true)
    protected BigDecimal height;
    @XmlElement(name = "Attribute01", required = true, type = Integer.class, nillable = true)
    protected Integer attribute01;
    @XmlElement(name = "Attribute02", required = true, type = Integer.class, nillable = true)
    protected Integer attribute02;
    @XmlElement(name = "Climate", required = true, type = Integer.class, nillable = true)
    protected Integer climate;
    @XmlElement(name = "Door", required = true, type = Integer.class, nillable = true)
    protected Integer door;
    @XmlElement(name = "Access", required = true, type = Integer.class, nillable = true)
    protected Integer access;
    @XmlElement(name = "Features", required = true, type = Integer.class, nillable = true)
    protected Integer features;
    @XmlElement(name = "NewRate", required = true, nillable = true)
    protected BigDecimal newRate;

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setWidth(BigDecimal value) {
        this.width = value;
    }

    /**
     * Gets the value of the depth property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDepth(BigDecimal value) {
        this.depth = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setHeight(BigDecimal value) {
        this.height = value;
    }

    /**
     * Gets the value of the attribute01 property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getAttribute01() {
        return attribute01;
    }

    /**
     * Sets the value of the attribute01 property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setAttribute01(Integer value) {
        this.attribute01 = value;
    }

    /**
     * Gets the value of the attribute02 property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getAttribute02() {
        return attribute02;
    }

    /**
     * Sets the value of the attribute02 property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setAttribute02(Integer value) {
        this.attribute02 = value;
    }

    /**
     * Gets the value of the climate property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getClimate() {
        return climate;
    }

    /**
     * Sets the value of the climate property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setClimate(Integer value) {
        this.climate = value;
    }

    /**
     * Gets the value of the door property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getDoor() {
        return door;
    }

    /**
     * Sets the value of the door property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDoor(Integer value) {
        this.door = value;
    }

    /**
     * Gets the value of the access property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getAccess() {
        return access;
    }

    /**
     * Sets the value of the access property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setAccess(Integer value) {
        this.access = value;
    }

    /**
     * Gets the value of the features property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getFeatures() {
        return features;
    }

    /**
     * Sets the value of the features property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setFeatures(Integer value) {
        this.features = value;
    }

    /**
     * Gets the value of the newRate property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getNewRate() {
        return newRate;
    }

    /**
     * Sets the value of the newRate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setNewRate(BigDecimal value) {
        this.newRate = value;
    }

}
