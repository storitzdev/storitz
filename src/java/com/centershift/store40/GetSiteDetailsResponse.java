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
 *         &lt;element name="GetSiteDetailsResult" type="{http://www.centershift.com/STORE40/}GetSiteDetails_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getSiteDetailsResult"
})
@XmlRootElement(name = "GetSiteDetailsResponse")
public class GetSiteDetailsResponse {

    @XmlElement(name = "GetSiteDetailsResult", required = true)
    protected GetSiteDetailsResponse2 getSiteDetailsResult;

    /**
     * Gets the value of the getSiteDetailsResult property.
     *
     * @return possible object is
     *         {@link GetSiteDetailsResponse2 }
     */
    public GetSiteDetailsResponse2 getGetSiteDetailsResult() {
        return getSiteDetailsResult;
    }

    /**
     * Sets the value of the getSiteDetailsResult property.
     *
     * @param value allowed object is
     *              {@link GetSiteDetailsResponse2 }
     */
    public void setGetSiteDetailsResult(GetSiteDetailsResponse2 value) {
        this.getSiteDetailsResult = value;
    }

}
