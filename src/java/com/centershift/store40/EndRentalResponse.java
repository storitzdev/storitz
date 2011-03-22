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
 *         &lt;element name="EndRentalResult" type="{http://www.centershift.com/STORE40/}EndRental_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "endRentalResult"
})
@XmlRootElement(name = "EndRentalResponse")
public class EndRentalResponse {

    @XmlElement(name = "EndRentalResult", required = true)
    protected EndRentalResponse2 endRentalResult;

    /**
     * Gets the value of the endRentalResult property.
     *
     * @return possible object is
     *         {@link EndRentalResponse2 }
     */
    public EndRentalResponse2 getEndRentalResult() {
        return endRentalResult;
    }

    /**
     * Sets the value of the endRentalResult property.
     *
     * @param value allowed object is
     *              {@link EndRentalResponse2 }
     */
    public void setEndRentalResult(EndRentalResponse2 value) {
        this.endRentalResult = value;
    }

}
