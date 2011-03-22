package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GetInsuranceInfo_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetInsuranceInfo_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ClaimDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AccountOrContactName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInsuranceInfo_Request", propOrder = {
        "siteID",
        "claimDate",
        "accountOrContactName"
})
public class GetInsuranceInfoRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "ClaimDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar claimDate;
    @XmlElement(name = "AccountOrContactName")
    protected String accountOrContactName;

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
     * Gets the value of the claimDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getClaimDate() {
        return claimDate;
    }

    /**
     * Sets the value of the claimDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setClaimDate(XMLGregorianCalendar value) {
        this.claimDate = value;
    }

    /**
     * Gets the value of the accountOrContactName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAccountOrContactName() {
        return accountOrContactName;
    }

    /**
     * Sets the value of the accountOrContactName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountOrContactName(String value) {
        this.accountOrContactName = value;
    }

}
