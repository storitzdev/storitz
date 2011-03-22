package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for SOA_UNIT_FEATURES complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SOA_UNIT_FEATURES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSOA_UNIT_FEATURESColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DEPTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="HEIGHT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ATTRIBUTE01" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ATTRIBUTE01_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE02" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ATTRIBUTE02_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLIMATE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CLIMATE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOOR" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DOOR_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCESS_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACCESS_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEATURES" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FEATURES_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOA_UNIT_FEATURES", propOrder = {
        "siteid",
        "width",
        "depth",
        "height",
        "attribute01",
        "attribute01VAL",
        "attribute02",
        "attribute02VAL",
        "climate",
        "climateval",
        "door",
        "doorval",
        "accesstype",
        "accesstypeval",
        "features",
        "featuresval"
})
public class SOAUNITFEATURES
        extends BaseEntityOfCollectionSOAUNITFEATURESColumnIndexes {

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "WIDTH", required = true, nillable = true)
    protected BigDecimal width;
    @XmlElement(name = "DEPTH", required = true, nillable = true)
    protected BigDecimal depth;
    @XmlElement(name = "HEIGHT", required = true, nillable = true)
    protected BigDecimal height;
    @XmlElement(name = "ATTRIBUTE01")
    protected int attribute01;
    @XmlElement(name = "ATTRIBUTE01_VAL")
    protected String attribute01VAL;
    @XmlElement(name = "ATTRIBUTE02", required = true, type = Integer.class, nillable = true)
    protected Integer attribute02;
    @XmlElement(name = "ATTRIBUTE02_VAL")
    protected String attribute02VAL;
    @XmlElement(name = "CLIMATE", required = true, type = Integer.class, nillable = true)
    protected Integer climate;
    @XmlElement(name = "CLIMATE_VAL")
    protected String climateval;
    @XmlElement(name = "DOOR", required = true, type = Integer.class, nillable = true)
    protected Integer door;
    @XmlElement(name = "DOOR_VAL")
    protected String doorval;
    @XmlElement(name = "ACCESS_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer accesstype;
    @XmlElement(name = "ACCESS_TYPE_VAL")
    protected String accesstypeval;
    @XmlElement(name = "FEATURES", required = true, type = Integer.class, nillable = true)
    protected Integer features;
    @XmlElement(name = "FEATURES_VAL")
    protected String featuresval;

    /**
     * Gets the value of the siteid property.
     */
    public long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     */
    public void setSITEID(long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getWIDTH() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setWIDTH(BigDecimal value) {
        this.width = value;
    }

    /**
     * Gets the value of the depth property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDEPTH() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDEPTH(BigDecimal value) {
        this.depth = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getHEIGHT() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setHEIGHT(BigDecimal value) {
        this.height = value;
    }

    /**
     * Gets the value of the attribute01 property.
     */
    public int getATTRIBUTE01() {
        return attribute01;
    }

    /**
     * Sets the value of the attribute01 property.
     */
    public void setATTRIBUTE01(int value) {
        this.attribute01 = value;
    }

    /**
     * Gets the value of the attribute01VAL property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getATTRIBUTE01VAL() {
        return attribute01VAL;
    }

    /**
     * Sets the value of the attribute01VAL property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setATTRIBUTE01VAL(String value) {
        this.attribute01VAL = value;
    }

    /**
     * Gets the value of the attribute02 property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getATTRIBUTE02() {
        return attribute02;
    }

    /**
     * Sets the value of the attribute02 property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setATTRIBUTE02(Integer value) {
        this.attribute02 = value;
    }

    /**
     * Gets the value of the attribute02VAL property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getATTRIBUTE02VAL() {
        return attribute02VAL;
    }

    /**
     * Sets the value of the attribute02VAL property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setATTRIBUTE02VAL(String value) {
        this.attribute02VAL = value;
    }

    /**
     * Gets the value of the climate property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getCLIMATE() {
        return climate;
    }

    /**
     * Sets the value of the climate property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCLIMATE(Integer value) {
        this.climate = value;
    }

    /**
     * Gets the value of the climateval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCLIMATEVAL() {
        return climateval;
    }

    /**
     * Sets the value of the climateval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCLIMATEVAL(String value) {
        this.climateval = value;
    }

    /**
     * Gets the value of the door property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getDOOR() {
        return door;
    }

    /**
     * Sets the value of the door property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDOOR(Integer value) {
        this.door = value;
    }

    /**
     * Gets the value of the doorval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDOORVAL() {
        return doorval;
    }

    /**
     * Sets the value of the doorval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDOORVAL(String value) {
        this.doorval = value;
    }

    /**
     * Gets the value of the accesstype property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getACCESSTYPE() {
        return accesstype;
    }

    /**
     * Sets the value of the accesstype property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setACCESSTYPE(Integer value) {
        this.accesstype = value;
    }

    /**
     * Gets the value of the accesstypeval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCESSTYPEVAL() {
        return accesstypeval;
    }

    /**
     * Sets the value of the accesstypeval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCESSTYPEVAL(String value) {
        this.accesstypeval = value;
    }

    /**
     * Gets the value of the features property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getFEATURES() {
        return features;
    }

    /**
     * Sets the value of the features property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setFEATURES(Integer value) {
        this.features = value;
    }

    /**
     * Gets the value of the featuresval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFEATURESVAL() {
        return featuresval;
    }

    /**
     * Sets the value of the featuresval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFEATURESVAL(String value) {
        this.featuresval = value;
    }

}
