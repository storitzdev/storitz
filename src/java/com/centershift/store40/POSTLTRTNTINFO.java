package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for POST_LTR_TNT_INFO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="POST_LTR_TNT_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionPOST_LTR_TNT_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="LTR_NUM" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LTR_TYPE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LTR_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CERTIFIED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAIL_LOCAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPORT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="WHO_CREATED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LTR_TYPE_GROUP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GROUP_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRINT_SPECIAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PRINT_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POST_LTR_TNT_INFO", propOrder = {
        "ltrnum",
        "siteid",
        "acctid",
        "rentalid",
        "unitnumber",
        "ltrtypeid",
        "ltrname",
        "version",
        "certified",
        "maillocal",
        "exportid",
        "whocreated",
        "created",
        "ltrtypegroup",
        "groupmeaning",
        "printspecial",
        "printmeaning"
})
public class POSTLTRTNTINFO
        extends BaseEntityOfCollectionPOSTLTRTNTINFOColumnIndexes {

    @XmlElement(name = "LTR_NUM")
    protected long ltrnum;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long rentalid;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "LTR_TYPE_ID")
    protected long ltrtypeid;
    @XmlElement(name = "LTR_NAME")
    protected String ltrname;
    @XmlElement(name = "VERSION")
    protected int version;
    @XmlElement(name = "CERTIFIED")
    protected String certified;
    @XmlElement(name = "MAIL_LOCAL")
    protected String maillocal;
    @XmlElement(name = "EXPORT_ID", required = true, type = Long.class, nillable = true)
    protected Long exportid;
    @XmlElement(name = "WHO_CREATED")
    protected String whocreated;
    @XmlElement(name = "CREATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "LTR_TYPE_GROUP")
    protected int ltrtypegroup;
    @XmlElement(name = "GROUP_MEANING")
    protected String groupmeaning;
    @XmlElement(name = "PRINT_SPECIAL")
    protected int printspecial;
    @XmlElement(name = "PRINT_MEANING")
    protected String printmeaning;

    /**
     * Gets the value of the ltrnum property.
     */
    public long getLTRNUM() {
        return ltrnum;
    }

    /**
     * Sets the value of the ltrnum property.
     */
    public void setLTRNUM(long value) {
        this.ltrnum = value;
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
     * Gets the value of the acctid property.
     */
    public long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     */
    public void setACCTID(long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the rentalid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRENTALID(Long value) {
        this.rentalid = value;
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
     * Gets the value of the ltrtypeid property.
     */
    public long getLTRTYPEID() {
        return ltrtypeid;
    }

    /**
     * Sets the value of the ltrtypeid property.
     */
    public void setLTRTYPEID(long value) {
        this.ltrtypeid = value;
    }

    /**
     * Gets the value of the ltrname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLTRNAME() {
        return ltrname;
    }

    /**
     * Sets the value of the ltrname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLTRNAME(String value) {
        this.ltrname = value;
    }

    /**
     * Gets the value of the version property.
     */
    public int getVERSION() {
        return version;
    }

    /**
     * Sets the value of the version property.
     */
    public void setVERSION(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the certified property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCERTIFIED() {
        return certified;
    }

    /**
     * Sets the value of the certified property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCERTIFIED(String value) {
        this.certified = value;
    }

    /**
     * Gets the value of the maillocal property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMAILLOCAL() {
        return maillocal;
    }

    /**
     * Sets the value of the maillocal property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMAILLOCAL(String value) {
        this.maillocal = value;
    }

    /**
     * Gets the value of the exportid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getEXPORTID() {
        return exportid;
    }

    /**
     * Sets the value of the exportid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setEXPORTID(Long value) {
        this.exportid = value;
    }

    /**
     * Gets the value of the whocreated property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getWHOCREATED() {
        return whocreated;
    }

    /**
     * Sets the value of the whocreated property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWHOCREATED(String value) {
        this.whocreated = value;
    }

    /**
     * Gets the value of the created property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCREATED() {
        return created;
    }

    /**
     * Sets the value of the created property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCREATED(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the ltrtypegroup property.
     */
    public int getLTRTYPEGROUP() {
        return ltrtypegroup;
    }

    /**
     * Sets the value of the ltrtypegroup property.
     */
    public void setLTRTYPEGROUP(int value) {
        this.ltrtypegroup = value;
    }

    /**
     * Gets the value of the groupmeaning property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGROUPMEANING() {
        return groupmeaning;
    }

    /**
     * Sets the value of the groupmeaning property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGROUPMEANING(String value) {
        this.groupmeaning = value;
    }

    /**
     * Gets the value of the printspecial property.
     */
    public int getPRINTSPECIAL() {
        return printspecial;
    }

    /**
     * Sets the value of the printspecial property.
     */
    public void setPRINTSPECIAL(int value) {
        this.printspecial = value;
    }

    /**
     * Gets the value of the printmeaning property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPRINTMEANING() {
        return printmeaning;
    }

    /**
     * Sets the value of the printmeaning property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPRINTMEANING(String value) {
        this.printmeaning = value;
    }

}
