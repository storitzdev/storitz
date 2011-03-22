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
 *         &lt;element name="UpdateEcommPasswordResult" type="{http://www.centershift.com/STORE40/}UpdateEcommPassword_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updateEcommPasswordResult"
})
@XmlRootElement(name = "UpdateEcommPasswordResponse")
public class UpdateEcommPasswordResponse {

    @XmlElement(name = "UpdateEcommPasswordResult", required = true)
    protected UpdateEcommPasswordResponse2 updateEcommPasswordResult;

    /**
     * Gets the value of the updateEcommPasswordResult property.
     *
     * @return possible object is
     *         {@link UpdateEcommPasswordResponse2 }
     */
    public UpdateEcommPasswordResponse2 getUpdateEcommPasswordResult() {
        return updateEcommPasswordResult;
    }

    /**
     * Sets the value of the updateEcommPasswordResult property.
     *
     * @param value allowed object is
     *              {@link UpdateEcommPasswordResponse2 }
     */
    public void setUpdateEcommPasswordResult(UpdateEcommPasswordResponse2 value) {
        this.updateEcommPasswordResult = value;
    }

}
