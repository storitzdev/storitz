package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddUpdateAutoPaySettings_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AddUpdateAutoPaySettings_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AutoPayInfo" type="{http://www.centershift.com/STORE40/}AutoPayData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddUpdateAutoPaySettings_Request", propOrder = {
        "autoPayInfo"
})
public class AddUpdateAutoPaySettingsRequest {

    @XmlElement(name = "AutoPayInfo")
    protected AutoPayData autoPayInfo;

    /**
     * Gets the value of the autoPayInfo property.
     *
     * @return possible object is
     *         {@link AutoPayData }
     */
    public AutoPayData getAutoPayInfo() {
        return autoPayInfo;
    }

    /**
     * Sets the value of the autoPayInfo property.
     *
     * @param value allowed object is
     *              {@link AutoPayData }
     */
    public void setAutoPayInfo(AutoPayData value) {
        this.autoPayInfo = value;
    }

}
