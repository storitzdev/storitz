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
 *         &lt;element name="AddUpdateAutoPaySettingsResult" type="{http://www.centershift.com/STORE40/}AddUpdateAutoPaySettings_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "addUpdateAutoPaySettingsResult"
})
@XmlRootElement(name = "AddUpdateAutoPaySettingsResponse")
public class AddUpdateAutoPaySettingsResponse {

    @XmlElement(name = "AddUpdateAutoPaySettingsResult", required = true)
    protected AddUpdateAutoPaySettingsResponse2 addUpdateAutoPaySettingsResult;

    /**
     * Gets the value of the addUpdateAutoPaySettingsResult property.
     *
     * @return possible object is
     *         {@link AddUpdateAutoPaySettingsResponse2 }
     */
    public AddUpdateAutoPaySettingsResponse2 getAddUpdateAutoPaySettingsResult() {
        return addUpdateAutoPaySettingsResult;
    }

    /**
     * Sets the value of the addUpdateAutoPaySettingsResult property.
     *
     * @param value allowed object is
     *              {@link AddUpdateAutoPaySettingsResponse2 }
     */
    public void setAddUpdateAutoPaySettingsResult(AddUpdateAutoPaySettingsResponse2 value) {
        this.addUpdateAutoPaySettingsResult = value;
    }

}
