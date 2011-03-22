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
 *         &lt;element name="GetSiteUnitDataFilteredResult" type="{http://www.centershift.com/STORE40/}GetSiteUnitData_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getSiteUnitDataFilteredResult"
})
@XmlRootElement(name = "GetSiteUnitDataFilteredResponse")
public class GetSiteUnitDataFilteredResponse {

    @XmlElement(name = "GetSiteUnitDataFilteredResult", required = true)
    protected GetSiteUnitDataResponse getSiteUnitDataFilteredResult;

    /**
     * Gets the value of the getSiteUnitDataFilteredResult property.
     *
     * @return possible object is
     *         {@link GetSiteUnitDataResponse }
     */
    public GetSiteUnitDataResponse getGetSiteUnitDataFilteredResult() {
        return getSiteUnitDataFilteredResult;
    }

    /**
     * Sets the value of the getSiteUnitDataFilteredResult property.
     *
     * @param value allowed object is
     *              {@link GetSiteUnitDataResponse }
     */
    public void setGetSiteUnitDataFilteredResult(GetSiteUnitDataResponse value) {
        this.getSiteUnitDataFilteredResult = value;
    }

}
