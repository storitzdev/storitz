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
 *         &lt;element name="getLeaseGroupTemplateInfoResult" type="{http://www.centershift.com/STORE40/}getLeaseGroupTemplateInfo_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getLeaseGroupTemplateInfoResult"
})
@XmlRootElement(name = "getLeaseGroupTemplateInfoResponse")
public class GetLeaseGroupTemplateInfoResponse {

    @XmlElement(required = true)
    protected GetLeaseGroupTemplateInfoResponse2 getLeaseGroupTemplateInfoResult;

    /**
     * Gets the value of the getLeaseGroupTemplateInfoResult property.
     *
     * @return possible object is
     *         {@link GetLeaseGroupTemplateInfoResponse2 }
     */
    public GetLeaseGroupTemplateInfoResponse2 getGetLeaseGroupTemplateInfoResult() {
        return getLeaseGroupTemplateInfoResult;
    }

    /**
     * Sets the value of the getLeaseGroupTemplateInfoResult property.
     *
     * @param value allowed object is
     *              {@link GetLeaseGroupTemplateInfoResponse2 }
     */
    public void setGetLeaseGroupTemplateInfoResult(GetLeaseGroupTemplateInfoResponse2 value) {
        this.getLeaseGroupTemplateInfoResult = value;
    }

}
