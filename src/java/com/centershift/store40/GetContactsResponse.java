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
 *         &lt;element name="GetContactsResult" type="{http://www.centershift.com/STORE40/}GetContacts_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getContactsResult"
})
@XmlRootElement(name = "GetContactsResponse")
public class GetContactsResponse {

    @XmlElement(name = "GetContactsResult", required = true)
    protected GetContactsResponse2 getContactsResult;

    /**
     * Gets the value of the getContactsResult property.
     *
     * @return possible object is
     *         {@link GetContactsResponse2 }
     */
    public GetContactsResponse2 getGetContactsResult() {
        return getContactsResult;
    }

    /**
     * Sets the value of the getContactsResult property.
     *
     * @param value allowed object is
     *              {@link GetContactsResponse2 }
     */
    public void setGetContactsResult(GetContactsResponse2 value) {
        this.getContactsResult = value;
    }

}
