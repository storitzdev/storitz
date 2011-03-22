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
 *         &lt;element name="GetContactPhoneNumbersResult" type="{http://www.centershift.com/STORE40/}GetContactPhoneNumbers_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getContactPhoneNumbersResult"
})
@XmlRootElement(name = "GetContactPhoneNumbersResponse")
public class GetContactPhoneNumbersResponse {

    @XmlElement(name = "GetContactPhoneNumbersResult", required = true)
    protected GetContactPhoneNumbersResponse2 getContactPhoneNumbersResult;

    /**
     * Gets the value of the getContactPhoneNumbersResult property.
     *
     * @return possible object is
     *         {@link GetContactPhoneNumbersResponse2 }
     */
    public GetContactPhoneNumbersResponse2 getGetContactPhoneNumbersResult() {
        return getContactPhoneNumbersResult;
    }

    /**
     * Sets the value of the getContactPhoneNumbersResult property.
     *
     * @param value allowed object is
     *              {@link GetContactPhoneNumbersResponse2 }
     */
    public void setGetContactPhoneNumbersResult(GetContactPhoneNumbersResponse2 value) {
        this.getContactPhoneNumbersResult = value;
    }

}
