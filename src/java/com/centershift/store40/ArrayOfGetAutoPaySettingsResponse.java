package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfGetAutoPaySettings_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfGetAutoPaySettings_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetAutoPaySettings_Response" type="{http://www.centershift.com/STORE40/}GetAutoPaySettings_Response" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGetAutoPaySettings_Response", propOrder = {
        "getAutoPaySettingsResponse"
})
public class ArrayOfGetAutoPaySettingsResponse {

    @XmlElement(name = "GetAutoPaySettings_Response")
    protected List<GetAutoPaySettingsResponse2> getAutoPaySettingsResponse;

    /**
     * Gets the value of the getAutoPaySettingsResponse property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getAutoPaySettingsResponse property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetAutoPaySettingsResponse().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link GetAutoPaySettingsResponse2 }
     */
    public List<GetAutoPaySettingsResponse2> getGetAutoPaySettingsResponse() {
        if (getAutoPaySettingsResponse == null) {
            getAutoPaySettingsResponse = new ArrayList<GetAutoPaySettingsResponse2>();
        }
        return this.getAutoPaySettingsResponse;
    }

}
