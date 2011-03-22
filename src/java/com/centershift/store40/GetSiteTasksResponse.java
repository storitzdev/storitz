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
 *         &lt;element name="GetSiteTasksResult" type="{http://www.centershift.com/STORE40/}GetSiteTasks_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getSiteTasksResult"
})
@XmlRootElement(name = "GetSiteTasksResponse")
public class GetSiteTasksResponse {

    @XmlElement(name = "GetSiteTasksResult", required = true)
    protected GetSiteTasksResponse2 getSiteTasksResult;

    /**
     * Gets the value of the getSiteTasksResult property.
     *
     * @return possible object is
     *         {@link GetSiteTasksResponse2 }
     */
    public GetSiteTasksResponse2 getGetSiteTasksResult() {
        return getSiteTasksResult;
    }

    /**
     * Sets the value of the getSiteTasksResult property.
     *
     * @param value allowed object is
     *              {@link GetSiteTasksResponse2 }
     */
    public void setGetSiteTasksResult(GetSiteTasksResponse2 value) {
        this.getSiteTasksResult = value;
    }

}
