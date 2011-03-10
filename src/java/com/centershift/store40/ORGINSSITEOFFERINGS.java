
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_INS_SITE_OFFERINGS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ORG_INS_SITE_OFFERINGS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_INS_SITE_OFFERINGSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="INS_PROVIDER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PROVIDER_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROVIDER_NOTES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GROUP_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_INS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_REF_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INS_OPTION_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="COVERAGE_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COVERAGE_PERC" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CANCEL_AFTER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COMMENTS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESC1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESC2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEFAULT_OPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROVIDER_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GROUP_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OPTION_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DISP_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_INS_SITE_OFFERINGS", propOrder = {
    "orgid",
    "insproviderid",
    "providername",
    "providernotes",
    "groupname",
    "siteid",
    "siteinsid",
    "siterefid",
    "insoptionid",
    "coverageamount",
    "coverageperc",
    "rate",
    "cancelafter",
    "comments",
    "desc1",
    "desc2",
    "defaultoption",
    "provideractive",
    "groupactive",
    "optionactive",
    "siteactive",
    "dispactive"
})
public class ORGINSSITEOFFERINGS
    extends BaseEntityOfCollectionORGINSSITEOFFERINGSColumnIndexes
{

    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "INS_PROVIDER_ID")
    protected long insproviderid;
    @XmlElement(name = "PROVIDER_NAME")
    protected String providername;
    @XmlElement(name = "PROVIDER_NOTES")
    protected String providernotes;
    @XmlElement(name = "GROUP_NAME")
    protected String groupname;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "SITE_INS_ID")
    protected long siteinsid;
    @XmlElement(name = "SITE_REF_ID")
    protected String siterefid;
    @XmlElement(name = "INS_OPTION_ID")
    protected long insoptionid;
    @XmlElement(name = "COVERAGE_AMOUNT")
    protected int coverageamount;
    @XmlElement(name = "COVERAGE_PERC")
    protected int coverageperc;
    @XmlElement(name = "RATE", required = true)
    protected BigDecimal rate;
    @XmlElement(name = "CANCEL_AFTER")
    protected int cancelafter;
    @XmlElement(name = "COMMENTS")
    protected String comments;
    @XmlElement(name = "DESC1")
    protected String desc1;
    @XmlElement(name = "DESC2")
    protected String desc2;
    @XmlElement(name = "DEFAULT_OPTION")
    protected String defaultoption;
    @XmlElement(name = "PROVIDER_ACTIVE")
    protected String provideractive;
    @XmlElement(name = "GROUP_ACTIVE")
    protected String groupactive;
    @XmlElement(name = "OPTION_ACTIVE")
    protected String optionactive;
    @XmlElement(name = "SITE_ACTIVE")
    protected String siteactive;
    @XmlElement(name = "DISP_ACTIVE")
    protected String dispactive;

    /**
     * Gets the value of the orgid property.
     * 
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     * 
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the insproviderid property.
     * 
     */
    public long getINSPROVIDERID() {
        return insproviderid;
    }

    /**
     * Sets the value of the insproviderid property.
     * 
     */
    public void setINSPROVIDERID(long value) {
        this.insproviderid = value;
    }

    /**
     * Gets the value of the providername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVIDERNAME() {
        return providername;
    }

    /**
     * Sets the value of the providername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVIDERNAME(String value) {
        this.providername = value;
    }

    /**
     * Gets the value of the providernotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVIDERNOTES() {
        return providernotes;
    }

    /**
     * Sets the value of the providernotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVIDERNOTES(String value) {
        this.providernotes = value;
    }

    /**
     * Gets the value of the groupname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUPNAME() {
        return groupname;
    }

    /**
     * Sets the value of the groupname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUPNAME(String value) {
        this.groupname = value;
    }

    /**
     * Gets the value of the siteid property.
     * 
     */
    public long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     */
    public void setSITEID(long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the siteinsid property.
     * 
     */
    public long getSITEINSID() {
        return siteinsid;
    }

    /**
     * Sets the value of the siteinsid property.
     * 
     */
    public void setSITEINSID(long value) {
        this.siteinsid = value;
    }

    /**
     * Gets the value of the siterefid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEREFID() {
        return siterefid;
    }

    /**
     * Sets the value of the siterefid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEREFID(String value) {
        this.siterefid = value;
    }

    /**
     * Gets the value of the insoptionid property.
     * 
     */
    public long getINSOPTIONID() {
        return insoptionid;
    }

    /**
     * Sets the value of the insoptionid property.
     * 
     */
    public void setINSOPTIONID(long value) {
        this.insoptionid = value;
    }

    /**
     * Gets the value of the coverageamount property.
     * 
     */
    public int getCOVERAGEAMOUNT() {
        return coverageamount;
    }

    /**
     * Sets the value of the coverageamount property.
     * 
     */
    public void setCOVERAGEAMOUNT(int value) {
        this.coverageamount = value;
    }

    /**
     * Gets the value of the coverageperc property.
     * 
     */
    public int getCOVERAGEPERC() {
        return coverageperc;
    }

    /**
     * Sets the value of the coverageperc property.
     * 
     */
    public void setCOVERAGEPERC(int value) {
        this.coverageperc = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRATE() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRATE(BigDecimal value) {
        this.rate = value;
    }

    /**
     * Gets the value of the cancelafter property.
     * 
     */
    public int getCANCELAFTER() {
        return cancelafter;
    }

    /**
     * Sets the value of the cancelafter property.
     * 
     */
    public void setCANCELAFTER(int value) {
        this.cancelafter = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMMENTS() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMMENTS(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the desc1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESC1() {
        return desc1;
    }

    /**
     * Sets the value of the desc1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESC1(String value) {
        this.desc1 = value;
    }

    /**
     * Gets the value of the desc2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESC2() {
        return desc2;
    }

    /**
     * Sets the value of the desc2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESC2(String value) {
        this.desc2 = value;
    }

    /**
     * Gets the value of the defaultoption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEFAULTOPTION() {
        return defaultoption;
    }

    /**
     * Sets the value of the defaultoption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEFAULTOPTION(String value) {
        this.defaultoption = value;
    }

    /**
     * Gets the value of the provideractive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVIDERACTIVE() {
        return provideractive;
    }

    /**
     * Sets the value of the provideractive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVIDERACTIVE(String value) {
        this.provideractive = value;
    }

    /**
     * Gets the value of the groupactive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUPACTIVE() {
        return groupactive;
    }

    /**
     * Sets the value of the groupactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUPACTIVE(String value) {
        this.groupactive = value;
    }

    /**
     * Gets the value of the optionactive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPTIONACTIVE() {
        return optionactive;
    }

    /**
     * Sets the value of the optionactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPTIONACTIVE(String value) {
        this.optionactive = value;
    }

    /**
     * Gets the value of the siteactive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEACTIVE() {
        return siteactive;
    }

    /**
     * Sets the value of the siteactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEACTIVE(String value) {
        this.siteactive = value;
    }

    /**
     * Gets the value of the dispactive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISPACTIVE() {
        return dispactive;
    }

    /**
     * Sets the value of the dispactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISPACTIVE(String value) {
        this.dispactive = value;
    }

}
