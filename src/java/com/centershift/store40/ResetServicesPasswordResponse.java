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
 *         &lt;element name="ResetServicesPasswordResult" type="{http://www.centershift.com/STORE40/}ResetServicesPassword_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "resetServicesPasswordResult"
})
@XmlRootElement(name = "ResetServicesPasswordResponse")
public class ResetServicesPasswordResponse {

    @XmlElement(name = "ResetServicesPasswordResult", required = true)
    protected ResetServicesPasswordResponse2 resetServicesPasswordResult;

    /**
     * Gets the value of the resetServicesPasswordResult property.
     *
     * @return possible object is
     *         {@link ResetServicesPasswordResponse2 }
     */
    public ResetServicesPasswordResponse2 getResetServicesPasswordResult() {
        return resetServicesPasswordResult;
    }

    /**
     * Sets the value of the resetServicesPasswordResult property.
     *
     * @param value allowed object is
     *              {@link ResetServicesPasswordResponse2 }
     */
    public void setResetServicesPasswordResult(ResetServicesPasswordResponse2 value) {
        this.resetServicesPasswordResult = value;
    }

}
