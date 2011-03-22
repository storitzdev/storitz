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
 *         &lt;element name="GetOrgListResult" type="{http://www.centershift.com/STORE40/}GetOrgList_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getOrgListResult"
})
@XmlRootElement(name = "GetOrgListResponse")
public class GetOrgListResponse {

    @XmlElement(name = "GetOrgListResult", required = true)
    protected GetOrgListResponse2 getOrgListResult;

    /**
     * Gets the value of the getOrgListResult property.
     *
     * @return possible object is
     *         {@link GetOrgListResponse2 }
     */
    public GetOrgListResponse2 getGetOrgListResult() {
        return getOrgListResult;
    }

    /**
     * Sets the value of the getOrgListResult property.
     *
     * @param value allowed object is
     *              {@link GetOrgListResponse2 }
     */
    public void setGetOrgListResult(GetOrgListResponse2 value) {
        this.getOrgListResult = value;
    }

}
