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
 *         &lt;element name="GetBaseFeesResult" type="{http://www.centershift.com/STORE40/}GetBaseFees_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getBaseFeesResult"
})
@XmlRootElement(name = "GetBaseFeesResponse")
public class GetBaseFeesResponse {

    @XmlElement(name = "GetBaseFeesResult", required = true)
    protected GetBaseFeesResponse2 getBaseFeesResult;

    /**
     * Gets the value of the getBaseFeesResult property.
     *
     * @return possible object is
     *         {@link GetBaseFeesResponse2 }
     */
    public GetBaseFeesResponse2 getGetBaseFeesResult() {
        return getBaseFeesResult;
    }

    /**
     * Sets the value of the getBaseFeesResult property.
     *
     * @param value allowed object is
     *              {@link GetBaseFeesResponse2 }
     */
    public void setGetBaseFeesResult(GetBaseFeesResponse2 value) {
        this.getBaseFeesResult = value;
    }

}
