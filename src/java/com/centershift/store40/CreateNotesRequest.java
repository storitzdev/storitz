
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CreateNotes_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateNotes_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Subject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HighPriority" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Expires" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateNotes_Request", propOrder = {
    "subject",
    "note",
    "highPriority",
    "accountID",
    "rentalID",
    "expires"
})
public class CreateNotesRequest {

    @XmlElement(name = "Subject")
    protected String subject;
    @XmlElement(name = "Note")
    protected String note;
    @XmlElement(name = "HighPriority", required = true, type = Boolean.class, nillable = true)
    protected Boolean highPriority;
    @XmlElement(name = "AccountID", required = true, type = Long.class, nillable = true)
    protected Long accountID;
    @XmlElement(name = "RentalID", required = true, type = Long.class, nillable = true)
    protected Long rentalID;
    @XmlElement(name = "Expires", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expires;

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the highPriority property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHighPriority() {
        return highPriority;
    }

    /**
     * Sets the value of the highPriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHighPriority(Boolean value) {
        this.highPriority = value;
    }

    /**
     * Gets the value of the accountID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountID(Long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the rentalID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRentalID(Long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the expires property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpires(XMLGregorianCalendar value) {
        this.expires = value;
    }

}
