package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetNotes_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetNotes_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NoteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetNotes_Request", propOrder = {
        "accountID",
        "rentalID",
        "noteID"
})
public class GetNotesRequest {

    @XmlElement(name = "AccountID", required = true, type = Long.class, nillable = true)
    protected Long accountID;
    @XmlElement(name = "RentalID", required = true, type = Long.class, nillable = true)
    protected Long rentalID;
    @XmlElement(name = "NoteID", required = true, type = Long.class, nillable = true)
    protected Long noteID;

    /**
     * Gets the value of the accountID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setAccountID(Long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the rentalID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRentalID(Long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the noteID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getNoteID() {
        return noteID;
    }

    /**
     * Sets the value of the noteID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setNoteID(Long value) {
        this.noteID = value;
    }

}
