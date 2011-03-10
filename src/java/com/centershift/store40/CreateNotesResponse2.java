
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateNotes_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateNotes_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NoteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateNotes_Response", propOrder = {
    "noteID"
})
public class CreateNotesResponse2 {

    @XmlElement(name = "NoteID")
    protected long noteID;

    /**
     * Gets the value of the noteID property.
     * 
     */
    public long getNoteID() {
        return noteID;
    }

    /**
     * Sets the value of the noteID property.
     * 
     */
    public void setNoteID(long value) {
        this.noteID = value;
    }

}
