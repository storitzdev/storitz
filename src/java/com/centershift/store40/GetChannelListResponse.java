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
 *         &lt;element name="GetChannelListResult" type="{http://www.centershift.com/STORE40/}GetChannelList_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getChannelListResult"
})
@XmlRootElement(name = "GetChannelListResponse")
public class GetChannelListResponse {

    @XmlElement(name = "GetChannelListResult", required = true)
    protected GetChannelListResponse2 getChannelListResult;

    /**
     * Gets the value of the getChannelListResult property.
     *
     * @return possible object is
     *         {@link GetChannelListResponse2 }
     */
    public GetChannelListResponse2 getGetChannelListResult() {
        return getChannelListResult;
    }

    /**
     * Sets the value of the getChannelListResult property.
     *
     * @param value allowed object is
     *              {@link GetChannelListResponse2 }
     */
    public void setGetChannelListResult(GetChannelListResponse2 value) {
        this.getChannelListResult = value;
    }

}
