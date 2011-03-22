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
 *         &lt;element name="GetNotesResult" type="{http://www.centershift.com/STORE40/}GetNotes_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getNotesResult"
})
@XmlRootElement(name = "GetNotesResponse")
public class GetNotesResponse {

    @XmlElement(name = "GetNotesResult", required = true)
    protected GetNotesResponse2 getNotesResult;

    /**
     * Gets the value of the getNotesResult property.
     *
     * @return possible object is
     *         {@link GetNotesResponse2 }
     */
    public GetNotesResponse2 getGetNotesResult() {
        return getNotesResult;
    }

    /**
     * Sets the value of the getNotesResult property.
     *
     * @param value allowed object is
     *              {@link GetNotesResponse2 }
     */
    public void setGetNotesResult(GetNotesResponse2 value) {
        this.getNotesResult = value;
    }

}
