package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for scheduledLetter_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="scheduledLetter_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PdfTemplateID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ScheduledDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SendTo" type="{http://www.centershift.com/STORE40/}LTR_CONTACT_TYPES"/>
 *         &lt;element name="MailLocal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CertifiedType" type="{http://www.centershift.com/STORE40/}certifiedVals"/>
 *         &lt;element name="CertificateOfMail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scheduledLetter_Request", propOrder = {
        "siteID",
        "acctID",
        "rentalID",
        "pdfTemplateID",
        "scheduledDate",
        "sendTo",
        "mailLocal",
        "certifiedType",
        "certificateOfMail"
})
public class ScheduledLetterRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AcctID")
    protected long acctID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "PdfTemplateID")
    protected long pdfTemplateID;
    @XmlElement(name = "ScheduledDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar scheduledDate;
    @XmlElement(name = "SendTo", required = true)
    protected LTRCONTACTTYPES sendTo;
    @XmlElement(name = "MailLocal")
    protected boolean mailLocal;
    @XmlElement(name = "CertifiedType", required = true)
    protected CertifiedVals certifiedType;
    @XmlElement(name = "CertificateOfMail")
    protected boolean certificateOfMail;

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
     * Gets the value of the acctID property.
     */
    public long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     */
    public void setAcctID(long value) {
        this.acctID = value;
    }

    /**
     * Gets the value of the rentalID property.
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the pdfTemplateID property.
     */
    public long getPdfTemplateID() {
        return pdfTemplateID;
    }

    /**
     * Sets the value of the pdfTemplateID property.
     */
    public void setPdfTemplateID(long value) {
        this.pdfTemplateID = value;
    }

    /**
     * Gets the value of the scheduledDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getScheduledDate() {
        return scheduledDate;
    }

    /**
     * Sets the value of the scheduledDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setScheduledDate(XMLGregorianCalendar value) {
        this.scheduledDate = value;
    }

    /**
     * Gets the value of the sendTo property.
     *
     * @return possible object is
     *         {@link LTRCONTACTTYPES }
     */
    public LTRCONTACTTYPES getSendTo() {
        return sendTo;
    }

    /**
     * Sets the value of the sendTo property.
     *
     * @param value allowed object is
     *              {@link LTRCONTACTTYPES }
     */
    public void setSendTo(LTRCONTACTTYPES value) {
        this.sendTo = value;
    }

    /**
     * Gets the value of the mailLocal property.
     */
    public boolean isMailLocal() {
        return mailLocal;
    }

    /**
     * Sets the value of the mailLocal property.
     */
    public void setMailLocal(boolean value) {
        this.mailLocal = value;
    }

    /**
     * Gets the value of the certifiedType property.
     *
     * @return possible object is
     *         {@link CertifiedVals }
     */
    public CertifiedVals getCertifiedType() {
        return certifiedType;
    }

    /**
     * Sets the value of the certifiedType property.
     *
     * @param value allowed object is
     *              {@link CertifiedVals }
     */
    public void setCertifiedType(CertifiedVals value) {
        this.certifiedType = value;
    }

    /**
     * Gets the value of the certificateOfMail property.
     */
    public boolean isCertificateOfMail() {
        return certificateOfMail;
    }

    /**
     * Sets the value of the certificateOfMail property.
     */
    public void setCertificateOfMail(boolean value) {
        this.certificateOfMail = value;
    }

}
