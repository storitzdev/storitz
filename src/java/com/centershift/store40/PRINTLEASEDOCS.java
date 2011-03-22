package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRINT_LEASE_DOCS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PRINT_LEASE_DOCS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionPRINT_LEASE_DOCSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LEASE_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="GROUP_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GROUP_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="GROUP_DOC_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LEASE_DEF_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="COPIES" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DOC_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LEASE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LANGUAGE_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATE_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LANG_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRINT_LEASE_DOCS", propOrder = {
        "orgid",
        "leasegroupid",
        "groupname",
        "description",
        "groupactive",
        "groupdocid",
        "leasedefid",
        "copies",
        "docactive",
        "leasename",
        "languageid",
        "stateid",
        "stateval",
        "langval",
        "siteid",
        "unitid",
        "unitnumber",
        "rentalid",
        "acctid",
        "status"
})
public class PRINTLEASEDOCS
        extends BaseEntityOfCollectionPRINTLEASEDOCSColumnIndexes {

    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "LEASE_GROUP_ID")
    protected long leasegroupid;
    @XmlElement(name = "GROUP_NAME")
    protected String groupname;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElement(name = "GROUP_ACTIVE")
    protected boolean groupactive;
    @XmlElement(name = "GROUP_DOC_ID")
    protected long groupdocid;
    @XmlElement(name = "LEASE_DEF_ID")
    protected long leasedefid;
    @XmlElement(name = "COPIES")
    protected int copies;
    @XmlElement(name = "DOC_ACTIVE")
    protected boolean docactive;
    @XmlElement(name = "LEASE_NAME")
    protected String leasename;
    @XmlElement(name = "LANGUAGE_ID")
    protected int languageid;
    @XmlElement(name = "STATE_ID")
    protected int stateid;
    @XmlElement(name = "STATE_VAL")
    protected String stateval;
    @XmlElement(name = "LANG_VAL")
    protected String langval;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "UNIT_ID")
    protected long unitid;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "RENTAL_ID")
    protected long rentalid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "STATUS")
    protected int status;

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
     * Gets the value of the leasegroupid property.
     */
    public long getLEASEGROUPID() {
        return leasegroupid;
    }

    /**
     * Sets the value of the leasegroupid property.
     */
    public void setLEASEGROUPID(long value) {
        this.leasegroupid = value;
    }

    /**
     * Gets the value of the groupname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGROUPNAME() {
        return groupname;
    }

    /**
     * Sets the value of the groupname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGROUPNAME(String value) {
        this.groupname = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDESCRIPTION() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the groupactive property.
     */
    public boolean isGROUPACTIVE() {
        return groupactive;
    }

    /**
     * Sets the value of the groupactive property.
     */
    public void setGROUPACTIVE(boolean value) {
        this.groupactive = value;
    }

    /**
     * Gets the value of the groupdocid property.
     */
    public long getGROUPDOCID() {
        return groupdocid;
    }

    /**
     * Sets the value of the groupdocid property.
     */
    public void setGROUPDOCID(long value) {
        this.groupdocid = value;
    }

    /**
     * Gets the value of the leasedefid property.
     */
    public long getLEASEDEFID() {
        return leasedefid;
    }

    /**
     * Sets the value of the leasedefid property.
     */
    public void setLEASEDEFID(long value) {
        this.leasedefid = value;
    }

    /**
     * Gets the value of the copies property.
     */
    public int getCOPIES() {
        return copies;
    }

    /**
     * Sets the value of the copies property.
     */
    public void setCOPIES(int value) {
        this.copies = value;
    }

    /**
     * Gets the value of the docactive property.
     */
    public boolean isDOCACTIVE() {
        return docactive;
    }

    /**
     * Sets the value of the docactive property.
     */
    public void setDOCACTIVE(boolean value) {
        this.docactive = value;
    }

    /**
     * Gets the value of the leasename property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLEASENAME() {
        return leasename;
    }

    /**
     * Sets the value of the leasename property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLEASENAME(String value) {
        this.leasename = value;
    }

    /**
     * Gets the value of the languageid property.
     */
    public int getLANGUAGEID() {
        return languageid;
    }

    /**
     * Sets the value of the languageid property.
     */
    public void setLANGUAGEID(int value) {
        this.languageid = value;
    }

    /**
     * Gets the value of the stateid property.
     */
    public int getSTATEID() {
        return stateid;
    }

    /**
     * Sets the value of the stateid property.
     */
    public void setSTATEID(int value) {
        this.stateid = value;
    }

    /**
     * Gets the value of the stateval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTATEVAL() {
        return stateval;
    }

    /**
     * Sets the value of the stateval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTATEVAL(String value) {
        this.stateval = value;
    }

    /**
     * Gets the value of the langval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLANGVAL() {
        return langval;
    }

    /**
     * Sets the value of the langval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLANGVAL(String value) {
        this.langval = value;
    }

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
     * Gets the value of the unitid property.
     */
    public long getUNITID() {
        return unitid;
    }

    /**
     * Sets the value of the unitid property.
     */
    public void setUNITID(long value) {
        this.unitid = value;
    }

    /**
     * Gets the value of the unitnumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITNUMBER() {
        return unitnumber;
    }

    /**
     * Sets the value of the unitnumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITNUMBER(String value) {
        this.unitnumber = value;
    }

    /**
     * Gets the value of the rentalid property.
     */
    public long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     */
    public void setRENTALID(long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the acctid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setACCTID(Long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the status property.
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

}
