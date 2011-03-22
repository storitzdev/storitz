package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for RentRateReqData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RentRateReqData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitVersion" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="NewRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SendLetter" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LetterDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AcctId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentRateReqData", propOrder = {
        "orgID",
        "siteID",
        "unitID",
        "unitVersion",
        "newRate",
        "effectiveDate",
        "sendLetter",
        "letterDate",
        "acctId",
        "rentalId"
})
public class RentRateReqData {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "UnitID")
    protected long unitID;
    @XmlElement(name = "UnitVersion", required = true)
    protected BigDecimal unitVersion;
    @XmlElement(name = "NewRate", required = true)
    protected BigDecimal newRate;
    @XmlElement(name = "EffectiveDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    @XmlElement(name = "SendLetter")
    protected boolean sendLetter;
    @XmlElement(name = "LetterDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar letterDate;
    @XmlElement(name = "AcctId")
    protected long acctId;
    @XmlElement(name = "RentalId")
    protected long rentalId;

    /**
     * Gets the value of the orgID property.
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the siteID property.
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the unitID property.
     */
    public long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     */
    public void setUnitID(long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the unitVersion property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getUnitVersion() {
        return unitVersion;
    }

    /**
     * Sets the value of the unitVersion property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setUnitVersion(BigDecimal value) {
        this.unitVersion = value;
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

    /**
     * Gets the value of the effectiveDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the sendLetter property.
     */
    public boolean isSendLetter() {
        return sendLetter;
    }

    /**
     * Sets the value of the sendLetter property.
     */
    public void setSendLetter(boolean value) {
        this.sendLetter = value;
    }

    /**
     * Gets the value of the letterDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLetterDate() {
        return letterDate;
    }

    /**
     * Sets the value of the letterDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLetterDate(XMLGregorianCalendar value) {
        this.letterDate = value;
    }

    /**
     * Gets the value of the acctId property.
     */
    public long getAcctId() {
        return acctId;
    }

    /**
     * Sets the value of the acctId property.
     */
    public void setAcctId(long value) {
        this.acctId = value;
    }

    /**
     * Gets the value of the rentalId property.
     */
    public long getRentalId() {
        return rentalId;
    }

    /**
     * Sets the value of the rentalId property.
     */
    public void setRentalId(long value) {
        this.rentalId = value;
    }

}
