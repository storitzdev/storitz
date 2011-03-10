
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RULE_VALUES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RULE_VALUES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionRULE_VALUESColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="DISP_ORDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ENTITY_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RULE_LEVEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RULE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DEP_RULE_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DEP_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RULE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_VALUE_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NEG_ONE_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONFIG_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LOOKUP_USED" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LOOKUP_SET" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LOOKUP_IS_VIRTUAL" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RULE_CLASS" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CLASS_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUE_DEFAULT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUE_DEFAULT_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUE_DATATYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VALUE_LEN" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VALUE_MAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VALUE_MIN" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VALUE_IS_REFERENCE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RULE_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ABLE_INVOKED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PARENT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DISPLAY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RULE_VALUES" type="{http://www.centershift.com/STORE40/}ArrayOfRULE_VALUES" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RULE_VALUES", propOrder = {
    "disporder",
    "entityname",
    "rulelevel",
    "ruleid",
    "depruleid",
    "depvalue",
    "rulename",
    "sitevalue",
    "sitevaluemeaning",
    "negonemeaning",
    "configid",
    "lookupused",
    "lookupset",
    "lookupisvirtual",
    "ruleclass",
    "classvalue",
    "valuedefault",
    "valuedefaultmeaning",
    "valuedatatype",
    "valuelen",
    "valuemax",
    "valuemin",
    "valueisreference",
    "description",
    "ruletype",
    "ableinvoked",
    "active",
    "createdby",
    "updatedby",
    "parentid",
    "display",
    "rulevalues"
})
public class RULEVALUES
    extends BaseEntityOfCollectionRULEVALUESColumnIndexes
{

    @XmlElement(name = "DISP_ORDER", required = true, type = Integer.class, nillable = true)
    protected Integer disporder;
    @XmlElement(name = "ENTITY_NAME")
    protected String entityname;
    @XmlElement(name = "RULE_LEVEL")
    protected String rulelevel;
    @XmlElement(name = "RULE_ID", required = true, type = Long.class, nillable = true)
    protected Long ruleid;
    @XmlElement(name = "DEP_RULE_ID", required = true, nillable = true)
    protected BigDecimal depruleid;
    @XmlElement(name = "DEP_VALUE")
    protected String depvalue;
    @XmlElement(name = "RULE_NAME")
    protected String rulename;
    @XmlElement(name = "SITE_VALUE")
    protected String sitevalue;
    @XmlElement(name = "SITE_VALUE_MEANING")
    protected String sitevaluemeaning;
    @XmlElement(name = "NEG_ONE_MEANING")
    protected String negonemeaning;
    @XmlElement(name = "CONFIG_ID", required = true, nillable = true)
    protected BigDecimal configid;
    @XmlElement(name = "LOOKUP_USED", required = true, type = Boolean.class, nillable = true)
    protected Boolean lookupused;
    @XmlElement(name = "LOOKUP_SET", required = true, nillable = true)
    protected BigDecimal lookupset;
    @XmlElement(name = "LOOKUP_IS_VIRTUAL", required = true, type = Boolean.class, nillable = true)
    protected Boolean lookupisvirtual;
    @XmlElement(name = "RULE_CLASS", required = true, nillable = true)
    protected BigDecimal ruleclass;
    @XmlElement(name = "CLASS_VALUE")
    protected String classvalue;
    @XmlElement(name = "VALUE_DEFAULT")
    protected String valuedefault;
    @XmlElement(name = "VALUE_DEFAULT_MEANING")
    protected String valuedefaultmeaning;
    @XmlElement(name = "VALUE_DATATYPE", required = true, type = Integer.class, nillable = true)
    protected Integer valuedatatype;
    @XmlElement(name = "VALUE_LEN", required = true, type = Integer.class, nillable = true)
    protected Integer valuelen;
    @XmlElement(name = "VALUE_MAX", required = true, nillable = true)
    protected BigDecimal valuemax;
    @XmlElement(name = "VALUE_MIN", required = true, nillable = true)
    protected BigDecimal valuemin;
    @XmlElement(name = "VALUE_IS_REFERENCE", required = true, type = Boolean.class, nillable = true)
    protected Boolean valueisreference;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElement(name = "RULE_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer ruletype;
    @XmlElement(name = "ABLE_INVOKED")
    protected String ableinvoked;
    @XmlElement(name = "ACTIVE")
    protected String active;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "PARENT_ID", required = true, type = Long.class, nillable = true)
    protected Long parentid;
    @XmlElement(name = "DISPLAY")
    protected String display;
    @XmlElement(name = "RULE_VALUES")
    protected ArrayOfRULEVALUES rulevalues;

    /**
     * Gets the value of the disporder property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDISPORDER() {
        return disporder;
    }

    /**
     * Sets the value of the disporder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDISPORDER(Integer value) {
        this.disporder = value;
    }

    /**
     * Gets the value of the entityname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITYNAME() {
        return entityname;
    }

    /**
     * Sets the value of the entityname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITYNAME(String value) {
        this.entityname = value;
    }

    /**
     * Gets the value of the rulelevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRULELEVEL() {
        return rulelevel;
    }

    /**
     * Sets the value of the rulelevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRULELEVEL(String value) {
        this.rulelevel = value;
    }

    /**
     * Gets the value of the ruleid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRULEID() {
        return ruleid;
    }

    /**
     * Sets the value of the ruleid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRULEID(Long value) {
        this.ruleid = value;
    }

    /**
     * Gets the value of the depruleid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDEPRULEID() {
        return depruleid;
    }

    /**
     * Sets the value of the depruleid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDEPRULEID(BigDecimal value) {
        this.depruleid = value;
    }

    /**
     * Gets the value of the depvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPVALUE() {
        return depvalue;
    }

    /**
     * Sets the value of the depvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPVALUE(String value) {
        this.depvalue = value;
    }

    /**
     * Gets the value of the rulename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRULENAME() {
        return rulename;
    }

    /**
     * Sets the value of the rulename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRULENAME(String value) {
        this.rulename = value;
    }

    /**
     * Gets the value of the sitevalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEVALUE() {
        return sitevalue;
    }

    /**
     * Sets the value of the sitevalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEVALUE(String value) {
        this.sitevalue = value;
    }

    /**
     * Gets the value of the sitevaluemeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEVALUEMEANING() {
        return sitevaluemeaning;
    }

    /**
     * Sets the value of the sitevaluemeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEVALUEMEANING(String value) {
        this.sitevaluemeaning = value;
    }

    /**
     * Gets the value of the negonemeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEGONEMEANING() {
        return negonemeaning;
    }

    /**
     * Sets the value of the negonemeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEGONEMEANING(String value) {
        this.negonemeaning = value;
    }

    /**
     * Gets the value of the configid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCONFIGID() {
        return configid;
    }

    /**
     * Sets the value of the configid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCONFIGID(BigDecimal value) {
        this.configid = value;
    }

    /**
     * Gets the value of the lookupused property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLOOKUPUSED() {
        return lookupused;
    }

    /**
     * Sets the value of the lookupused property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLOOKUPUSED(Boolean value) {
        this.lookupused = value;
    }

    /**
     * Gets the value of the lookupset property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLOOKUPSET() {
        return lookupset;
    }

    /**
     * Sets the value of the lookupset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLOOKUPSET(BigDecimal value) {
        this.lookupset = value;
    }

    /**
     * Gets the value of the lookupisvirtual property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLOOKUPISVIRTUAL() {
        return lookupisvirtual;
    }

    /**
     * Sets the value of the lookupisvirtual property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLOOKUPISVIRTUAL(Boolean value) {
        this.lookupisvirtual = value;
    }

    /**
     * Gets the value of the ruleclass property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRULECLASS() {
        return ruleclass;
    }

    /**
     * Sets the value of the ruleclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRULECLASS(BigDecimal value) {
        this.ruleclass = value;
    }

    /**
     * Gets the value of the classvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLASSVALUE() {
        return classvalue;
    }

    /**
     * Sets the value of the classvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLASSVALUE(String value) {
        this.classvalue = value;
    }

    /**
     * Gets the value of the valuedefault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUEDEFAULT() {
        return valuedefault;
    }

    /**
     * Sets the value of the valuedefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUEDEFAULT(String value) {
        this.valuedefault = value;
    }

    /**
     * Gets the value of the valuedefaultmeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUEDEFAULTMEANING() {
        return valuedefaultmeaning;
    }

    /**
     * Sets the value of the valuedefaultmeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUEDEFAULTMEANING(String value) {
        this.valuedefaultmeaning = value;
    }

    /**
     * Gets the value of the valuedatatype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVALUEDATATYPE() {
        return valuedatatype;
    }

    /**
     * Sets the value of the valuedatatype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVALUEDATATYPE(Integer value) {
        this.valuedatatype = value;
    }

    /**
     * Gets the value of the valuelen property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVALUELEN() {
        return valuelen;
    }

    /**
     * Sets the value of the valuelen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVALUELEN(Integer value) {
        this.valuelen = value;
    }

    /**
     * Gets the value of the valuemax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVALUEMAX() {
        return valuemax;
    }

    /**
     * Sets the value of the valuemax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVALUEMAX(BigDecimal value) {
        this.valuemax = value;
    }

    /**
     * Gets the value of the valuemin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVALUEMIN() {
        return valuemin;
    }

    /**
     * Sets the value of the valuemin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVALUEMIN(BigDecimal value) {
        this.valuemin = value;
    }

    /**
     * Gets the value of the valueisreference property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVALUEISREFERENCE() {
        return valueisreference;
    }

    /**
     * Sets the value of the valueisreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVALUEISREFERENCE(Boolean value) {
        this.valueisreference = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIPTION() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the ruletype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRULETYPE() {
        return ruletype;
    }

    /**
     * Sets the value of the ruletype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRULETYPE(Integer value) {
        this.ruletype = value;
    }

    /**
     * Gets the value of the ableinvoked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getABLEINVOKED() {
        return ableinvoked;
    }

    /**
     * Sets the value of the ableinvoked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setABLEINVOKED(String value) {
        this.ableinvoked = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVE() {
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
    public void setACTIVE(String value) {
        this.active = value;
    }

    /**
     * Gets the value of the createdby property.
     * 
     */
    public long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     */
    public void setCREATEDBY(long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the updatedby property.
     * 
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     * 
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
    }

    /**
     * Gets the value of the parentid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPARENTID() {
        return parentid;
    }

    /**
     * Sets the value of the parentid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPARENTID(Long value) {
        this.parentid = value;
    }

    /**
     * Gets the value of the display property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISPLAY() {
        return display;
    }

    /**
     * Sets the value of the display property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISPLAY(String value) {
        this.display = value;
    }

    /**
     * Gets the value of the rulevalues property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRULEVALUES }
     *     
     */
    public ArrayOfRULEVALUES getRULEVALUES() {
        return rulevalues;
    }

    /**
     * Sets the value of the rulevalues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRULEVALUES }
     *     
     */
    public void setRULEVALUES(ArrayOfRULEVALUES value) {
        this.rulevalues = value;
    }

}
