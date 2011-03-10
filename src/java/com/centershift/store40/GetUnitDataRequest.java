
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetUnitData_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUnitData_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Depth" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ClassType" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Attribute01" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Attribute02" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Climate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Door" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccessType" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Features" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MinRentRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MaxRentRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UnitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitIDs" type="{http://www.centershift.com/STORE40/}ArrayOfLong2" minOccurs="0"/>
 *         &lt;element name="WidthDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DepthDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="HeightDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUnitData_Request", propOrder = {
    "unitID",
    "siteID",
    "width",
    "depth",
    "height",
    "classType",
    "active",
    "status",
    "attribute01",
    "attribute02",
    "climate",
    "door",
    "accessType",
    "features",
    "minRentRate",
    "maxRentRate",
    "unitNumber",
    "unitIDs",
    "widthDecimal",
    "depthDecimal",
    "heightDecimal"
})
public class GetUnitDataRequest {

    @XmlElement(name = "UnitID", required = true, type = Long.class, nillable = true)
    protected Long unitID;
    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "Width", required = true, type = Long.class, nillable = true)
    protected Long width;
    @XmlElement(name = "Depth", required = true, type = Long.class, nillable = true)
    protected Long depth;
    @XmlElement(name = "Height", required = true, type = Long.class, nillable = true)
    protected Long height;
    @XmlElement(name = "ClassType", required = true, type = Long.class, nillable = true)
    protected Long classType;
    @XmlElement(name = "Active")
    protected String active;
    @XmlElement(name = "Status", required = true, type = Integer.class, nillable = true)
    protected Integer status;
    @XmlElement(name = "Attribute01", required = true, type = Long.class, nillable = true)
    protected Long attribute01;
    @XmlElement(name = "Attribute02", required = true, type = Long.class, nillable = true)
    protected Long attribute02;
    @XmlElement(name = "Climate", required = true, type = Long.class, nillable = true)
    protected Long climate;
    @XmlElement(name = "Door", required = true, type = Long.class, nillable = true)
    protected Long door;
    @XmlElement(name = "AccessType", required = true, type = Long.class, nillable = true)
    protected Long accessType;
    @XmlElement(name = "Features", required = true, type = Long.class, nillable = true)
    protected Long features;
    @XmlElement(name = "MinRentRate", required = true, nillable = true)
    protected BigDecimal minRentRate;
    @XmlElement(name = "MaxRentRate", required = true, nillable = true)
    protected BigDecimal maxRentRate;
    @XmlElement(name = "UnitNumber")
    protected String unitNumber;
    @XmlElement(name = "UnitIDs")
    protected ArrayOfLong2 unitIDs;
    @XmlElement(name = "WidthDecimal", required = true, nillable = true)
    protected BigDecimal widthDecimal;
    @XmlElement(name = "DepthDecimal", required = true, nillable = true)
    protected BigDecimal depthDecimal;
    @XmlElement(name = "HeightDecimal", required = true, nillable = true)
    protected BigDecimal heightDecimal;

    /**
     * Gets the value of the unitID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUnitID(Long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the siteID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSiteID(Long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWidth(Long value) {
        this.width = value;
    }

    /**
     * Gets the value of the depth property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDepth(Long value) {
        this.depth = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHeight(Long value) {
        this.height = value;
    }

    /**
     * Gets the value of the classType property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getClassType() {
        return classType;
    }

    /**
     * Sets the value of the classType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setClassType(Long value) {
        this.classType = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActive(String value) {
        this.active = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the attribute01 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttribute01() {
        return attribute01;
    }

    /**
     * Sets the value of the attribute01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttribute01(Long value) {
        this.attribute01 = value;
    }

    /**
     * Gets the value of the attribute02 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttribute02() {
        return attribute02;
    }

    /**
     * Sets the value of the attribute02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttribute02(Long value) {
        this.attribute02 = value;
    }

    /**
     * Gets the value of the climate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getClimate() {
        return climate;
    }

    /**
     * Sets the value of the climate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setClimate(Long value) {
        this.climate = value;
    }

    /**
     * Gets the value of the door property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDoor() {
        return door;
    }

    /**
     * Sets the value of the door property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDoor(Long value) {
        this.door = value;
    }

    /**
     * Gets the value of the accessType property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccessType() {
        return accessType;
    }

    /**
     * Sets the value of the accessType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccessType(Long value) {
        this.accessType = value;
    }

    /**
     * Gets the value of the features property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeatures() {
        return features;
    }

    /**
     * Sets the value of the features property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeatures(Long value) {
        this.features = value;
    }

    /**
     * Gets the value of the minRentRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinRentRate() {
        return minRentRate;
    }

    /**
     * Sets the value of the minRentRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinRentRate(BigDecimal value) {
        this.minRentRate = value;
    }

    /**
     * Gets the value of the maxRentRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxRentRate() {
        return maxRentRate;
    }

    /**
     * Sets the value of the maxRentRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxRentRate(BigDecimal value) {
        this.maxRentRate = value;
    }

    /**
     * Gets the value of the unitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * Sets the value of the unitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitNumber(String value) {
        this.unitNumber = value;
    }

    /**
     * Gets the value of the unitIDs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong2 }
     *     
     */
    public ArrayOfLong2 getUnitIDs() {
        return unitIDs;
    }

    /**
     * Sets the value of the unitIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong2 }
     *     
     */
    public void setUnitIDs(ArrayOfLong2 value) {
        this.unitIDs = value;
    }

    /**
     * Gets the value of the widthDecimal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWidthDecimal() {
        return widthDecimal;
    }

    /**
     * Sets the value of the widthDecimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWidthDecimal(BigDecimal value) {
        this.widthDecimal = value;
    }

    /**
     * Gets the value of the depthDecimal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDepthDecimal() {
        return depthDecimal;
    }

    /**
     * Sets the value of the depthDecimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDepthDecimal(BigDecimal value) {
        this.depthDecimal = value;
    }

    /**
     * Gets the value of the heightDecimal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeightDecimal() {
        return heightDecimal;
    }

    /**
     * Sets the value of the heightDecimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeightDecimal(BigDecimal value) {
        this.heightDecimal = value;
    }

}
