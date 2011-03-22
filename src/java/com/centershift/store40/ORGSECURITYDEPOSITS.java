package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for ORG_SECURITY_DEPOSITS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_SECURITY_DEPOSITS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_SECURITY_DEPOSITSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="DEP_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DEP_FIX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DEP_PERC" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DEP_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DEP_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DEP_GROUP_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEP_GROUP_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEP_METHOD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DEP_METHOD_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMT_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEP_AMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_SECURITY_DEPOSITS", propOrder = {
        "depgroupid",
        "orgid",
        "depfix",
        "depperc",
        "deptype",
        "deptypeval",
        "active",
        "depgroupname",
        "depgroupdesc",
        "depmethod",
        "depmethodval",
        "amtdesc",
        "depamt"
})
public class ORGSECURITYDEPOSITS
        extends BaseEntityOfCollectionORGSECURITYDEPOSITSColumnIndexes {

    @XmlElement(name = "DEP_GROUP_ID")
    protected long depgroupid;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "DEP_FIX", required = true)
    protected BigDecimal depfix;
    @XmlElement(name = "DEP_PERC", required = true)
    protected BigDecimal depperc;
    @XmlElement(name = "DEP_TYPE")
    protected int deptype;
    @XmlElement(name = "DEP_TYPE_VAL")
    protected String deptypeval;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "DEP_GROUP_NAME")
    protected String depgroupname;
    @XmlElement(name = "DEP_GROUP_DESC")
    protected String depgroupdesc;
    @XmlElement(name = "DEP_METHOD")
    protected int depmethod;
    @XmlElement(name = "DEP_METHOD_VAL")
    protected String depmethodval;
    @XmlElement(name = "AMT_DESC")
    protected String amtdesc;
    @XmlElement(name = "DEP_AMT")
    protected String depamt;

    /**
     * Gets the value of the depgroupid property.
     */
    public long getDEPGROUPID() {
        return depgroupid;
    }

    /**
     * Sets the value of the depgroupid property.
     */
    public void setDEPGROUPID(long value) {
        this.depgroupid = value;
    }

    /**
     * Gets the value of the orgid property.
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the depfix property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDEPFIX() {
        return depfix;
    }

    /**
     * Sets the value of the depfix property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDEPFIX(BigDecimal value) {
        this.depfix = value;
    }

    /**
     * Gets the value of the depperc property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDEPPERC() {
        return depperc;
    }

    /**
     * Sets the value of the depperc property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDEPPERC(BigDecimal value) {
        this.depperc = value;
    }

    /**
     * Gets the value of the deptype property.
     */
    public int getDEPTYPE() {
        return deptype;
    }

    /**
     * Sets the value of the deptype property.
     */
    public void setDEPTYPE(int value) {
        this.deptype = value;
    }

    /**
     * Gets the value of the deptypeval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDEPTYPEVAL() {
        return deptypeval;
    }

    /**
     * Sets the value of the deptypeval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDEPTYPEVAL(String value) {
        this.deptypeval = value;
    }

    /**
     * Gets the value of the active property.
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     */
    public void setACTIVE(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the depgroupname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDEPGROUPNAME() {
        return depgroupname;
    }

    /**
     * Sets the value of the depgroupname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDEPGROUPNAME(String value) {
        this.depgroupname = value;
    }

    /**
     * Gets the value of the depgroupdesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDEPGROUPDESC() {
        return depgroupdesc;
    }

    /**
     * Sets the value of the depgroupdesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDEPGROUPDESC(String value) {
        this.depgroupdesc = value;
    }

    /**
     * Gets the value of the depmethod property.
     */
    public int getDEPMETHOD() {
        return depmethod;
    }

    /**
     * Sets the value of the depmethod property.
     */
    public void setDEPMETHOD(int value) {
        this.depmethod = value;
    }

    /**
     * Gets the value of the depmethodval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDEPMETHODVAL() {
        return depmethodval;
    }

    /**
     * Sets the value of the depmethodval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDEPMETHODVAL(String value) {
        this.depmethodval = value;
    }

    /**
     * Gets the value of the amtdesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAMTDESC() {
        return amtdesc;
    }

    /**
     * Sets the value of the amtdesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAMTDESC(String value) {
        this.amtdesc = value;
    }

    /**
     * Gets the value of the depamt property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDEPAMT() {
        return depamt;
    }

    /**
     * Sets the value of the depamt property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDEPAMT(String value) {
        this.depamt = value;
    }

}
