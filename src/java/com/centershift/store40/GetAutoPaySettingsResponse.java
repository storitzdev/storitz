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
 *         &lt;element name="GetAutoPaySettingsResult" type="{http://www.centershift.com/STORE40/}ArrayOfGetAutoPaySettings_Response" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAutoPaySettingsResult"
})
@XmlRootElement(name = "GetAutoPaySettingsResponse")
public class GetAutoPaySettingsResponse {

    @XmlElement(name = "GetAutoPaySettingsResult")
    protected ArrayOfGetAutoPaySettingsResponse getAutoPaySettingsResult;

    /**
     * Gets the value of the getAutoPaySettingsResult property.
     *
     * @return possible object is
     *         {@link ArrayOfGetAutoPaySettingsResponse }
     */
    public ArrayOfGetAutoPaySettingsResponse getGetAutoPaySettingsResult() {
        return getAutoPaySettingsResult;
    }

    /**
     * Sets the value of the getAutoPaySettingsResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfGetAutoPaySettingsResponse }
     */
    public void setGetAutoPaySettingsResult(ArrayOfGetAutoPaySettingsResponse value) {
        this.getAutoPaySettingsResult = value;
    }

}
