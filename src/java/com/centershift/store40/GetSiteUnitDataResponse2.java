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
 *         &lt;element name="GetSiteUnitDataResult" type="{http://www.centershift.com/STORE40/}GetSiteUnitData_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getSiteUnitDataResult"
})
@XmlRootElement(name = "GetSiteUnitDataResponse")
public class GetSiteUnitDataResponse2 {

    @XmlElement(name = "GetSiteUnitDataResult", required = true)
    protected GetSiteUnitDataResponse getSiteUnitDataResult;

    /**
     * Gets the value of the getSiteUnitDataResult property.
     *
     * @return possible object is
     *         {@link GetSiteUnitDataResponse }
     */
    public GetSiteUnitDataResponse getGetSiteUnitDataResult() {
        return getSiteUnitDataResult;
    }

    /**
     * Sets the value of the getSiteUnitDataResult property.
     *
     * @param value allowed object is
     *              {@link GetSiteUnitDataResponse }
     */
    public void setGetSiteUnitDataResult(GetSiteUnitDataResponse value) {
        this.getSiteUnitDataResult = value;
    }

}
