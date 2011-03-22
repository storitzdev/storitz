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
 *         &lt;element name="UpdateAddressResult" type="{http://www.centershift.com/STORE40/}Address_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updateAddressResult"
})
@XmlRootElement(name = "UpdateAddressResponse")
public class UpdateAddressResponse {

    @XmlElement(name = "UpdateAddressResult", required = true)
    protected AddressResponse updateAddressResult;

    /**
     * Gets the value of the updateAddressResult property.
     *
     * @return possible object is
     *         {@link AddressResponse }
     */
    public AddressResponse getUpdateAddressResult() {
        return updateAddressResult;
    }

    /**
     * Sets the value of the updateAddressResult property.
     *
     * @param value allowed object is
     *              {@link AddressResponse }
     */
    public void setUpdateAddressResult(AddressResponse value) {
        this.updateAddressResult = value;
    }

}
