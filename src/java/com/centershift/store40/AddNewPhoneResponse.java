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
 *         &lt;element name="AddNewPhoneResult" type="{http://www.centershift.com/STORE40/}Phone_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "addNewPhoneResult"
})
@XmlRootElement(name = "AddNewPhoneResponse")
public class AddNewPhoneResponse {

    @XmlElement(name = "AddNewPhoneResult", required = true)
    protected PhoneResponse addNewPhoneResult;

    /**
     * Gets the value of the addNewPhoneResult property.
     *
     * @return possible object is
     *         {@link PhoneResponse }
     */
    public PhoneResponse getAddNewPhoneResult() {
        return addNewPhoneResult;
    }

    /**
     * Sets the value of the addNewPhoneResult property.
     *
     * @param value allowed object is
     *              {@link PhoneResponse }
     */
    public void setAddNewPhoneResult(PhoneResponse value) {
        this.addNewPhoneResult = value;
    }

}
