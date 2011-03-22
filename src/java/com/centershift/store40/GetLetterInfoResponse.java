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
 *         &lt;element name="GetLetterInfoResult" type="{http://www.centershift.com/STORE40/}GetLetterInfo_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getLetterInfoResult"
})
@XmlRootElement(name = "GetLetterInfoResponse")
public class GetLetterInfoResponse {

    @XmlElement(name = "GetLetterInfoResult", required = true)
    protected GetLetterInfoResponse2 getLetterInfoResult;

    /**
     * Gets the value of the getLetterInfoResult property.
     *
     * @return possible object is
     *         {@link GetLetterInfoResponse2 }
     */
    public GetLetterInfoResponse2 getGetLetterInfoResult() {
        return getLetterInfoResult;
    }

    /**
     * Sets the value of the getLetterInfoResult property.
     *
     * @param value allowed object is
     *              {@link GetLetterInfoResponse2 }
     */
    public void setGetLetterInfoResult(GetLetterInfoResponse2 value) {
        this.getLetterInfoResult = value;
    }

}
