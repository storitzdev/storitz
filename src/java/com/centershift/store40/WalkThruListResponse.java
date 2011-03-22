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
 *         &lt;element name="WalkThruListResult" type="{http://www.centershift.com/STORE40/}WalkThruList_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "walkThruListResult"
})
@XmlRootElement(name = "WalkThruListResponse")
public class WalkThruListResponse {

    @XmlElement(name = "WalkThruListResult", required = true)
    protected WalkThruListResponse2 walkThruListResult;

    /**
     * Gets the value of the walkThruListResult property.
     *
     * @return possible object is
     *         {@link WalkThruListResponse2 }
     */
    public WalkThruListResponse2 getWalkThruListResult() {
        return walkThruListResult;
    }

    /**
     * Sets the value of the walkThruListResult property.
     *
     * @param value allowed object is
     *              {@link WalkThruListResponse2 }
     */
    public void setWalkThruListResult(WalkThruListResponse2 value) {
        this.walkThruListResult = value;
    }

}
