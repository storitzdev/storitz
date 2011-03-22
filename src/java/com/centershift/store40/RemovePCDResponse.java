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
 *         &lt;element name="RemovePCDResult" type="{http://www.centershift.com/STORE40/}RemovePCD_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "removePCDResult"
})
@XmlRootElement(name = "RemovePCDResponse")
public class RemovePCDResponse {

    @XmlElement(name = "RemovePCDResult", required = true)
    protected RemovePCDResponse2 removePCDResult;

    /**
     * Gets the value of the removePCDResult property.
     *
     * @return possible object is
     *         {@link RemovePCDResponse2 }
     */
    public RemovePCDResponse2 getRemovePCDResult() {
        return removePCDResult;
    }

    /**
     * Sets the value of the removePCDResult property.
     *
     * @param value allowed object is
     *              {@link RemovePCDResponse2 }
     */
    public void setRemovePCDResult(RemovePCDResponse2 value) {
        this.removePCDResult = value;
    }

}
