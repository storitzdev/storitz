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
 *         &lt;element name="GetUnitStatusResult" type="{http://www.centershift.com/STORE40/}GetUnitStatus_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getUnitStatusResult"
})
@XmlRootElement(name = "GetUnitStatusResponse")
public class GetUnitStatusResponse {

    @XmlElement(name = "GetUnitStatusResult", required = true)
    protected GetUnitStatusResponse2 getUnitStatusResult;

    /**
     * Gets the value of the getUnitStatusResult property.
     *
     * @return possible object is
     *         {@link GetUnitStatusResponse2 }
     */
    public GetUnitStatusResponse2 getGetUnitStatusResult() {
        return getUnitStatusResult;
    }

    /**
     * Sets the value of the getUnitStatusResult property.
     *
     * @param value allowed object is
     *              {@link GetUnitStatusResponse2 }
     */
    public void setGetUnitStatusResult(GetUnitStatusResponse2 value) {
        this.getUnitStatusResult = value;
    }

}
