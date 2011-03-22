package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreateNotesResult" type="{http://www.centershift.com/STORE40/}CreateNotes_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "createNotesResult"
})
@XmlRootElement(name = "CreateNotesResponse")
public class CreateNotesResponse {

    @XmlElement(name = "CreateNotesResult", required = true)
    protected CreateNotesResponse2 createNotesResult;

    /**
     * Gets the value of the createNotesResult property.
     *
     * @return possible object is
     *         {@link CreateNotesResponse2 }
     */
    public CreateNotesResponse2 getCreateNotesResult() {
        return createNotesResult;
    }

    /**
     * Sets the value of the createNotesResult property.
     *
     * @param value allowed object is
     *              {@link CreateNotesResponse2 }
     */
    public void setCreateNotesResult(CreateNotesResponse2 value) {
        this.createNotesResult = value;
    }

}
